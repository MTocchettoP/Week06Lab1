<%-- 
    Document   : loginForm
    Created on : Oct 19, 2017, 3:43:59 PM
    Author     : 733196
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="userName"%>
<%@attribute name="password"%>
<%@attribute name="checked"%>
<%@attribute name="errorMessage"%>

<%-- any content can be specified here e.g.: --%>
<h1>Login</h1>
        <div>
            <form action="login" method="post">
               Username: <input type="text" name="username" value= ${userName}><br>
               Password: <input type="password" name="password"  value= ${password}><br>
               <input type="checkbox" name="remme" value ="remme" ${checked}>Remember me<br>
                <input type="submit" value="login">
            </form>
            
        </div>
        ${errorMessage}