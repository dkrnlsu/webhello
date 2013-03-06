<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <title></title>
  </head>
  <body>
   <!--<%= request.getAttribute("result") %>-->

   <table border=1 width="500">
       <tr>
           <td width="20%" align=center>No.</td>
           <td width="50%" align=center>title</td>
           <td width="30%" align=center>writer</td>
       </tr>
  <%

      List<Board> boards = (List<Board>) request.getAttribute("boards");

      for (Board board : boards) {
  %><tr><%
           out.write("<td>"+board.getId()+"</td>\n");
           out.write("<td><a href=\"/board/detail?id=" + board.getId() + "\">"+board.getTitle()+"</a></td>\n");
           out.write("<td>"+board.getWriter()+"</td>\n");
  %></tr><%
      }


  %>
   </table>
   <br>
   <input type="button" value="등록" onclick="location.href='/board/insertForm'">
  </body>
</html>