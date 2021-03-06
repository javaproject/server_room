package room.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowTempHum
 */
@WebServlet("/ShowTempHum")
public class ShowTempHum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTempHum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Showing temperature and humidity of the room");
		response.setContentType("text/html");
	    PrintWriter writer= response.getWriter();
	    writer.println("<html>"
	    		+ "<head>"
	    		+ "<meta charset=\"ISO-8859-1\">"
	    		+ "<title>Temperature and Humidity</title>"
	    		+ "</head>"
	    		+ "<body>"
	    		+ "<table style=\" border:2px solid black; border-radius:25px; margin-left:100px; margin-top:100px;width:500px; \">"
	    		+ "<tr><td rowspan=2><img src=\" C:\\Users\\admin\\Desktop\\download.jpg\" width=250 height=250 style=\" margin-left:40px; \" /></td><td style=\" font-size:50;font-family:\"Times New Roman \";margin-left:300px\">Here is temperature</td></tr> "
	    		+"<tr><td style=\" font-size:50;font-family:\"Times New Roman \";margin-left:300px; \">Here is humidity</td></tr> "
	    		
	    		+ "</table>"
	    		+ "<p style=\" color: white; background-color:black; margin-left:100px;width:500px; font-size:20px;font-family:\"Times New Roman\";border:20px solid black; border-radius:70px;margin-top:50px;   \" > Temperature is normal and humidity is in a high level. </p>      "
	    		
	    		
	    		
	    		+ "</body>"
	    		+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
