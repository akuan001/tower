<%@ page language="java" session="false"%>
<%
    final String url = request.getContextPath() + "/rest/index";
    response.sendRedirect(response.encodeURL(url));
%>