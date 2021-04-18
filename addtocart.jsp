<%@include file="package.jsp" %>
<%@page errorPage="errorF.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%
String email = (String)session.getAttribute("email");
String photo = (String)session.getAttribute("photo");
//String price = (String)session.getAttribute("price");

String id=request.getParameter("id");

int quantity=1;
int price=0;
int total=0;
//int total=price;
int cart_total=0;
int z=0;
try
{
	Statement st= con.createStatement();
	ResultSet rs=st.executeQuery("select * from food where id='"+id+"' and photo='"+photo+"'");
	while(rs.next())
	{
		price=rs.getInt(4);
		total = price;
		//photo=rs.getString(14);
	}
	ResultSet rs1=st.executeQuery("select * from cart where id='"+id+"' and email='"+email+"' and photo='"+photo+"' and address is NULL");
	while(rs1.next())
	{
		cart_total = rs1.getInt(5);
		cart_total = cart_total + total;
		quantity = rs1.getInt(3);
		quantity = quantity + 1;
		z=1;
	}
	if(z==1)
	{
		st.executeUpdate("update cart set total='"+cart_total+"',quantity='"+quantity+"' where id='"+id+"' and email = '"+email+"' and address is NULL");
		response.sendRedirect("UhomeF.jsp?msg=exist");
	}
	if(z==0)
	{
		PreparedStatement ps = con.prepareStatement("insert into cart(email,id,quantity,price,total,photo)values(?,?,?,?,?,?)");
		ps.setString(1,email);
		ps.setString(2,id);
		ps.setInt(3,quantity);
		ps.setInt(4,price);
		ps.setInt(5,total);
		ps.setString(6,photo);
		ps.executeUpdate();
		
	}
	
}
catch(Exception e)
{
	out.println(e);
}


con.close();
%>
