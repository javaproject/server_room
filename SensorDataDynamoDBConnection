import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class SensorDataDynamoDBConnection {

    static AmazonDynamoDBClient dynamoDBClient ;
    static DynamoDB dynamoDB;
    static String tableName = "serverRoomSensor";

    public static void main(String[] args) throws Exception {
        AWSCredentials credentials = new ProfileCredentialsProvider("default").getCredentials();
        
        dynamoDBClient = new AmazonDynamoDBClient(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        dynamoDBClient.setRegion(usWest2);
        
        
        dynamoDB = new DynamoDB(dynamoDBClient);
        
        String forumName = "Amazon DynamoDB";
        String threadSubject = "DynamoDB Thread 1";

        findRepliesForAThread(forumName, threadSubject);
//        findRepliesForAThreadSpecifyOptionalLimit(forumName, threadSubject);
//        findRepliesInLast15DaysWithConfig(forumName, threadSubject);
//        findRepliesPostedWithinTimePeriod(forumName, threadSubject);
//        findRepliesUsingAFilterExpression(forumName, threadSubject);
    }
    
    private static void findRepliesForAThread(String forumName, String threadSubject) {
    	
        Table table = dynamoDB.getTable(tableName);

        HashMap<String, String> nameMap = new HashMap<String, String>();
        nameMap.put("#key", "key");
        
        HashMap<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put(":key", "sensordata");
        
        QuerySpec spec=new QuerySpec();
        spec.withKeyConditionExpression("#key = :key");
        spec.withNameMap(nameMap);
        spec.withValueMap(valueMap);
        
        ItemCollection<QueryOutcome> items = table.query(spec);
        
        System.out.println("\nfindRepliesForAThread results:");

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toJSONPretty());
        }
        
    }

//    private static void findRepliesForAThreadSpecifyOptionalLimit(String forumName, String threadSubject) {
//
//        Table table = dynamoDB.getTable(tableName);
//        
//        String replyId = forumName + "#" + threadSubject;   
//               
//        QuerySpec spec = new QuerySpec()
//            .withKeyConditionExpression("Id = :v_id")
//            .withValueMap(new ValueMap()
//                .withString(":v_id", replyId))
//            .withMaxPageSize(1);
//
//        ItemCollection<QueryOutcome> items = table.query(spec);
//        
//        System.out.println("\nfindRepliesForAThreadSpecifyOptionalLimit results:");
//
//        // Process each page of results
//        int pageNum = 0;
//        for (Page<Item, QueryOutcome> page : items.pages()) {
//            
//            System.out.println("\nPage: " + ++pageNum);
//
//            // Process each item on the current page
//            Iterator<Item> item = page.iterator();
//            while (item.hasNext()) {
//                System.out.println(item.next().toJSONPretty());
//            }
//        }
//    }
//    
//    private static void findRepliesInLast15DaysWithConfig(String forumName, String threadSubject) {
//
//        Table table = dynamoDB.getTable(tableName);
//
//        long twoWeeksAgoMilli = (new Date()).getTime() - (15L*24L*60L*60L*1000L);
//        Date twoWeeksAgo = new Date();
//        twoWeeksAgo.setTime(twoWeeksAgoMilli);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        String twoWeeksAgoStr = df.format(twoWeeksAgo);
//        
//        String replyId = forumName + "#" + threadSubject;
//
//        QuerySpec spec = new QuerySpec()
//            .withProjectionExpression("Message, ReplyDateTime, PostedBy")
//            .withKeyConditionExpression("Id = :v_id and ReplyDateTime <= :v_reply_dt_tm")
//            .withValueMap(new ValueMap()
//                .withString(":v_id", replyId)
//                .withString(":v_reply_dt_tm", twoWeeksAgoStr));
//        
//        ItemCollection<QueryOutcome> items = table.query(spec);
//
//        System.out.println("\nfindRepliesInLast15DaysWithConfig results:");
//        Iterator<Item> iterator = items.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toJSONPretty());
//        }
//
//    }
//    
//    private static void findRepliesPostedWithinTimePeriod(String forumName, String threadSubject) {
//
//        Table table = dynamoDB.getTable(tableName);
//
//        long startDateMilli = (new Date()).getTime() - (15L*24L*60L*60L*1000L); 
//        long endDateMilli = (new Date()).getTime() - (5L*24L*60L*60L*1000L);    
//        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        String startDate = df.format(startDateMilli);
//        String endDate = df.format(endDateMilli);
//
//        String replyId = forumName + "#" + threadSubject;
//
//        QuerySpec spec = new QuerySpec()
//            .withProjectionExpression("Message, ReplyDateTime, PostedBy")
//            .withKeyConditionExpression("Id = :v_id and ReplyDateTime between :v_start_dt and :v_end_dt")
//            .withValueMap(new ValueMap()
//                .withString(":v_id", replyId)
//                .withString(":v_start_dt", startDate)
//                .withString(":v_end_dt", endDate));
//        
//        ItemCollection<QueryOutcome> items = table.query(spec);
//
//        System.out.println("\nfindRepliesPostedWithinTimePeriod results:");
//        Iterator<Item> iterator = items.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toJSONPretty());
//        }    
//    }
//
//    private static void findRepliesUsingAFilterExpression(String forumName, String threadSubject) {
//
//        Table table = dynamoDB.getTable(tableName);
//        
//        String replyId = forumName + "#" + threadSubject;
//
//        QuerySpec spec = new QuerySpec()
//            .withProjectionExpression("Message, ReplyDateTime, PostedBy")
//            .withKeyConditionExpression("Id = :v_id")
//            .withFilterExpression("PostedBy = :v_postedby")
//            .withValueMap(new ValueMap()
//                .withString(":v_id", replyId)
//                .withString(":v_postedby", "User B"));
//        
//        ItemCollection<QueryOutcome> items = table.query(spec);
//
//        System.out.println("\nfindRepliesUsingAFilterExpression results:");
//        Iterator<Item> iterator = items.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toJSONPretty());
//        }    
//     }
    
}
