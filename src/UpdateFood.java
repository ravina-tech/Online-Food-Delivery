

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateFood
 */
@WebServlet("/UpdateFood")
@MultipartConfig
public class UpdateFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String price = request.getParameter("price");
	//String iname= request.getParameter("image");
	//Part file = request.getPart("image");
	// String iname = file.getSubmittedFileName();
	out.println("<input type=hidden name=name value ="+name+" />");
	//<%=name %>
	//<input type = "hidden" name = "name" value="<%=name %>">
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food","root","ravina");
		String qr = "update food set price=?,name = ? where id=?";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setString(1,price);
		ps.setString(2,name);
		//ps.setString(3,iname);
		ps.setString(3,id);
		int i = ps.executeUpdate();
		if(i>0)
		{
			//RequestDispatcher rd = request.getRequestDispatcher("UserMenu.jsp");
			//rd.include(request, response);
			out.println("<script>window.alert('Food info updated')</script>");
		}
		else
		{
			out.println("Food Price not updated");
		}
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		out.println(e);
	}
	
	
		// TODO Auto-generated method stub
	}

}
