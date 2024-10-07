<%@page import="java.util.ArrayList"%>
<%@page import="com.daodto2.java.DAO"%>
<%@page import="com.daodto2.java.DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pageNum = request.getParameter("page");
		if(pageNum == null){
			pageNum = "1";
		}
		String serchword = request.getParameter("word");
		ArrayList<DTO> d = null;
		DAO dao = new DAO();
		
		int count = dao.getPostCount();
		
		int totalpage = 0;
		
		if(serchword ==null || serchword.equals("null")){
			d= dao.list(pageNum);
			totalpage = dao.getTotalpage();
		}else{
			d= dao.serchlist(serchword, pageNum);
			totalpage = dao.getTotalpage(serchword);
		}
		
		
		for(int i =0 ; i<d.size() ; i++){
		%>
			<%=d.get(i).no %> . <a href="read.jsp?no=<%=d.get(i).no %>"><%=d.get(i).title %></a>  | 작성자 :<%=d.get(i).id %> |추천수 :<%=d.get(i).hit %> |작성일 :<%=d.get(i).datetime %><br>
		<% 	
		}
		
		for(int i =1 ; i<= totalpage ; i++){
			
		%>
		int nPageNum = pageNum;
		
		<a href="list.jsp?page=<%=i %>&word<%=serchword %>"><%=i %></a>
		<%
		}
		
		//검색 및 페이징 완료
	%>
	<form action="list.jsp" >
		<input name="word">
		<input type="submit" value="검색"> 
	</form>
	
</body>
</html>