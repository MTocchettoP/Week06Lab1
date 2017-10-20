<%-- 
    Document   : mainPage
    Created on : Sep 19, 2017, 8:49:45 AM
    Author     : 733196
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        
        <sait:debug>
            <h1>Debug Info</h1>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
        
        <h1>Home Page</h1>
        Hello, ${username}   
        <a href= "login?action=logout">Log Out</a>
    </body>
</html>
