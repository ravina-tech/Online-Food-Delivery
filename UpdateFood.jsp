<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String price = request.getParameter("price");
		
		%>
		<form action="UpdateFood">
		<%=name %>
<input type = "hidden" name = "name" value="<%=name %>"/>
<pre>
		ID<input type="number" name= "id" value = "<%=id %>" />
Price<input type = "number" name = "price" value = "<%=price %>" />
<input type = "submit" value = "Update" />
</pre>
		</form>