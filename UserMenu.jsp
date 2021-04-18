<%@include file="package.jsp" %>

 <center><h2 class="text-center mb-5">Menu</h2></center>

<table align="center"  class="table table-striped" border "1">
<thead>
<tr>
<th>Food Id</th>
<th>Food Name</th>
<th>Food Price</th>
<th>Food Image</th>
<th>Action</th>
</tr>
</thead>
<%
String qr = "select * from food";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(qr);
	if(rs.next())
	{
		do
		{
			 String id = rs.getString("id");
			 String name = rs.getString("name");
			 String price = rs.getString("price");
			 String photo = rs.getString("photo");
			 %>

		<tr>
		<pre>
		<td><%=id %></td>
		<td><%=name %></td>
		<td><%=price %></td>
		</pre>
		</div>
		
		<td align="center"><img src="images/<%=photo %>" style="width:300px;height=250px"></td>
		<td><a href="DeleteFood?id=<%=id %>">Delete</a></td>
		<td><a href="UpdateFood.jsp?name=<%=name %>&id=<%=id %>">Update</a></td>
		</tr>
		<%
	}
	
	while(rs.next());
	
}
else
{
	out.println("no record Found");
}
	con.close();
%>

</table>
</div>
