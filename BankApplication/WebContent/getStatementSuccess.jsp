<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success page</title>
</head>
<body>

<h1>Dear,Customer, </h1><br/>
<h2>your transaction are:</h2><br/>

<h2>Money Credited:</h2>


<ol>

<%
ArrayList<Integer> arrayList = (ArrayList<Integer>) session.getAttribute("arrayList");
for(Integer x : arrayList)
{
 if(x>0)
	 out.println("<li>"+x+"</li>");
}
%>

</ol>

<h2>Money Debited:</h2>


<ol>

<%

for(Integer x : arrayList)
{
 if(x<0)
	 out.println("<li>"+x+"</li>");
}
%>

</ol>


</body>
</html>