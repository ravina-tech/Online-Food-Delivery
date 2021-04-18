<%@include file="package.jsp" %>
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
		String photo =rs.getString("photo");
	%>
	<div style="height:150px;width:100%">
		<div style="font-family:Times New Roman,Times,serif;
		font-size:13px;height:150px;width:50px;background-color:LightSlateGray;text-align:center;float:left">
		<pre>
		<%=id %>
		<%=name %>
		<%=price %>
		</pre>
		</div>
		<div style="height:150px;width:50px;background-color:LightSlateGray;float:left;">
		<img src="images/<%=photo %>" style="width:400px;height=140px">
<a href="DeleteFood?id=<%=id %>">Delete</a></td>
		<a href="UpdateFood?id=<%=id %>">Update</a>
		</div>
		</div>
		<hr>

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
	