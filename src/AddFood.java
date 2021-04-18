

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class AddFood
 */
@WebServlet("/AddFood")
@MultipartConfig
public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		 String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");

		 Part file = request.getPart("image");
		 String iname = file.getSubmittedFileName();
		 out.println("Selected Images name" +iname);
		 String uploadPath = "D:/j2ee/Online Food Delivery/WebContent/images" +iname;
		 out.println("Upload Path" +uploadPath);
		 try{
		 FileOutputStream fos = new FileOutputStream(uploadPath);
		 InputStream is = file.getInputStream();
		 byte [] data = new byte[is.available()];
		 is.read(data);
		 fos.write(data);
		 fos.close();
		 
		 }
		 catch(Exception e)
		 {
			 out.println(e);
		 }
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food","root","ravina");
			String qr = "insert into food value(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qr);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,price);
			ps.setString(4,iname);
			int i = ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("UserMenu.jsp");
				rd.forward(request, response);
				out.println("Uploaded");
			}
			else
			{
				out.println("Error");
			}
			con.close();
			
			
			
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
		 
		// TODO Auto-generated method stub
	}

}
