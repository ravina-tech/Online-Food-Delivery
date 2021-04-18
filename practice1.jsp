<%@include file="package.jsp" %>
<%
String email = (String)session.getAttribute("id");
%>
WELCOME : <%=email %>
<a href = "viewcart.jsp">VIEW CART</a>
<a href ="logout">Logout</a>
<br></br>
<%
String qr = "select * from food";
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(qr);
if(rs.next())
{
	do
	{
		
		String id = rs.getString("id");
	String name=rs.getString("name");
		String price=rs.getString("price");
		String photo = rs.getString("photo");
		
		%>
		NAME : <%=name %><br>
		PRICE : <%=price %><br>
		CATEGORY : <%=id %><br>
		<img src="images/<%=photo %>" width:"400px" height="140px">
		<br>
		<button class="GFG" 
    onclick="window.location.href = 'https://www.paypal.com/in/signin'>
        Buy Now
    </button>
        
    

	
			<hr>
		
		<%
	}while(rs.next());
}
else
{
	out.println("no record found");
}
con.close();
%>