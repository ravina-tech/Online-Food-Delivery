<style>
.main
{
	text-align:center; 
}
.topnav-right a.active {
	
  background-color: #4CAF50;
  color: white;
}

.topnav-right a {
	top:10;
  float: right;
  /*color: #f2f2f2;*/
  color :#ff0040;
  text-align: center;
  padding: 20px 20px;
  text-decoration: none;
  font-family: "sans-serif";
  font-size: 20px;
}
.topnav-right a:hover {
  background-color: #ddd;
  color: black;
}

body
{
  background-image: url("i3.jpg");
  height: 100%;
  width: 100%;
  margin :0;
  background-size: cover;
  color: Blue;
  font-family: "sans-serif";
  font-size: 40px;
}
.topnav-right {
    background-color: #333;
    overflow: hidden;
}
</style>
<div class="main">
    <h1>Welcome To User Home</h1>
    </div>
  <div class =" topnav-right">
    
    <a href = LogoutF>Logout</a>
	<a href = "">Contact Us</a>
	<a href = "">Payment</a>
	<a href = "">View Cart</a>
	<a href = "">About</a>
	<a class="active" href = "practice.jsp">View Menu</a>
	</div>
<%
String email = (String)session.getAttribute("email");
%>
<center><h3>Welcome <%=email %></h3></center>
<center><img src="r1.jpg" alt="r1" width="600" height="250"></center>
