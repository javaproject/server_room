var chart;
var chartSeries = {};
var latestTimeReported = {};

function requestData() {

    $.ajax({
        url: 'https://dcc53lmg1c.execute-api.us-west-2.amazonaws.com/beta',
        success: function(seriesUpdate) {
            //in case initializer of highcharts is too quick - skip the update
            if (!chart) {
                setTimeout(requestData, 1000);
                return;
            }
            console.log(seriesUpdate['Items'][0]['payload']);
            $.each(seriesUpdate['Items'], function (serieIndex, serieUpdate) {
                console.log(serieUpdate['timestamp']);
            });
           // return false;
            $.each(seriesUpdate['Items'], function (serieIndex, serieUpdate) {
                var existingSerie = chartSeries[serieIndex];
                var newPoint = serieUpdate['timestamp'];
                var lastInsertedTime = latestTimeReported[serieUpdate['payload']['temperature']];

                if (lastInsertedTime  && lastInsertedTime < newPoint[0]) {
                    console.log('Attempt inserting old data!!!!');
                    return;
                }

                latestTimeReported[serieUpdate.name] = newPoint[0];

                if (existingSerie) {
                    var shift = existingSerie.data.length > 20;
                    existingSerie.addPoint(newPoint , true, shift);
                } else {
                    var newSerie = chart.addSeries({
                        name: serieUpdate.name,
                        data: serieUpdate.data
                    }, true);
                    chartSeries[serieUpdate.name] = newSerie;
                }

            });

            // call it again after one second
       //     setTimeout(requestData, 1000);
        },
        cache: false
    });
}

$(document).ready(function() {
    chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            defaultSeriesType: 'spline',
            events: {
                load: requestData
            }
        },
        title: {
            text: 'Live random data'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150,
            maxZoom: 20 * 1000
        },
        yAxis: {
            minPadding: 0.2,
            maxPadding: 0.2,
            title: {
                text: 'Value',
                margin: 80
            }
        },
        series: []
    });
});
