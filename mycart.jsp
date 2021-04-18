<%@include file="package.jsp" %>
<%@page errorPage="errorF.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%
ResultSet rs1=st.executeQuery("select * from cart where id='"+id+"' and email='"+email+"' and photo='"+photo+"' and address is NULL");
%>
ResultSet rs=st.executeQuery("select * from food where id='"+id+"' and photo='"+photo+"'");
