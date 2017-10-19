/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sait.services.User;
import sait.services.UserServices;

/**
 *
 * @author 733196
 */
@WebServlet(name = "LogingServlet", urlPatterns = {"/LogingServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sess = request.getSession();

        Cookie[] cookies = request.getCookies();
        String cookieName = "userIdCookie";
        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        if (!cookieValue.equals("")) {
            request.setAttribute("userName", cookieValue);
            request.setAttribute("checked", "checked");
        }

        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            sess.removeAttribute("username");
            // request.removeAttribute("action");
            request.setAttribute("errorMessage", "Sucessfuly logout");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        String sessUser = (String) sess.getAttribute("username");
        if (sessUser != null) {
            response.sendRedirect("/home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "Please enter both value.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        UserServices us = new UserServices();
        User user = us.loging(userName, password);

        if (user == null) {
            request.setAttribute("errorMessage", "User name or Password is invalid!");
            request.setAttribute("userName", userName);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("remme") == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userIdCookie")) {
                    cookie.setMaxAge(0); //delete the cookie
                    cookie.setPath("/"); //allow the download application to access it
                    response.addCookie(cookie);
                }
            }
        } else {
            //checkbox checked
            Cookie c = new Cookie("userIdCookie", userName);
            c.setMaxAge(60 * 30); //30 mins
            c.setPath("/");
            response.addCookie(c);
        }
        
        HttpSession sess = request.getSession();
        sess.setAttribute("username", userName);
        response.sendRedirect("/home");
    }

}
