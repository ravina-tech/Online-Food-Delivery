

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UregsF
 */
@WebServlet("/UregsF")
public class UregsF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UregsF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text");
		String name = request.getParameter("name");
		String id = request.getParameter("email");
		String number = request.getParameter("number");
		String pwd = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food","root","ravina");
			String qr = "insert into user value(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, number);
			ps.setString(4, pwd);
			int i = ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("uregs.html");
				rd.include(request,response);
				out.println("<script>window.alert('Registration Successfully')</script>");
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("user.html");
				rd.include(request,response);
				out.println("<script>window.alert('Registraion Failed')</script>");
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
		// TODO Auto-generated method stub
	}

}
