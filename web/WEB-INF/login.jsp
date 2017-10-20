<%-- 
    Document   : login
    Created on : Sep 19, 2017, 8:40:00 AM
    Author     : 733196
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Login</title>
    </head>
    <body>

        <sait:debug>
            <h1>Debug Info</h1>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>


        <ct:loginForm checked="${checked}" errorMessage="${errorMessage}" password="${password}" userName="${userName}" />

    </body>
</html>
