<%@include file="package.jsp" %>
<style>
img{
    display: block;
    margin-left: auto;
    margin-right: auto
     }
     .main
     {
     	text-align:center;
     	background:#F0A830;
     }
     main.a
     {
     float:right;
     }
    

</style>
<%
String email = (String)session.getAttribute("email");
%>
<div class = main>
<h1>WELCOME : <%=email %></h1>
<a href = "viewcart.jsp">VIEW CART</a>
<a href ="logout">Logout</a>
</div>
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
		<div style= "height:300px;width:100%;font-size:150%;background-color:#cc3333;text-align:center; float:left;">
		NAME : <%=name %><br>
		PRICE : <%=price %><br>
		CATEGORY : <%=id %><br>
		<img src="images/<%=photo %>" width="350px" height="160px">
		<br>
		<button class="GFG" 
    onclick="window.location.href = '"https://www.paypal.com/in/signin"'>
        BUY NOW
    </button>
    <a href="addtocart.jsp?name=<%=name %>&price=<%=price %>&id=<%=id %>&email=<%=email %>&photo=<%=photo %>">ADD TO CART</a>
    		
		</div>
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
		
		
			