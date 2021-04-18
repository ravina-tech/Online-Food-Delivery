

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMenu
 */
@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	/*out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<title>");
	out.println("<style>");
	out.println("<body>");
	out.println("{");
	out.println("background-image: url("food2.jpg");
	out.println(height: 100%;
	  width: 100%;
	  background-size: cover;
	  color: Black;
	  font-family: "sans-serif";
	  font-size: 40px;
	}
	/*out.println(".table{");
	out.println("th{");
	out.println("background-color: #4ACF50");
	out.println("color:white}");
	//out.println("background-color : yellow");*/
	out.println("</html>");
	out.println("</head>");
	out.println("</title>");
	out.println("</style>");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food","root","ravina");
		String qr = "select * from food";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qr);
		if(rs.next())
		{
			out.println("<center><h2>Menu Card</h2></center>");
			out.println("<table align = center border = 2px>");
			out.println("<tr><th>FOOD ID</th><th>FOOD NAME</th><th>PRICE</th></tr>");
			do
			{
				 String id = rs.getString("id");
				 String name = rs.getString("name");
				 String price = rs.getString("price");
				 out.println("<tr>");
				 out.println("<td>");
				 out.println(id);
				 out.println("</td>");
				 out.println("<td>");
				 out.println(name);
				 out.println("</td>");
				 out.println("<td>");
				 out.println(price);
				 out.println("</td>");
				 out.println("</tr>");
				 
				
			}
			while(rs.next());
			out.println("</table>");
			}
		else
		{
			out.println("No Record Found");
		}
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		out.println(e);
	}
	
		// TODO Auto-generated method stub
	}

}
