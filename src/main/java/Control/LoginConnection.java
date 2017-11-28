package Control;

import verify.VerifyRootUser;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>用post方式登陆，屏蔽了get方法</h1>");
    }


    /*
        444 r--r--r--
        666 rw-rw-rw-
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        String value = null;
        if (account.equals(VerifyRootUser.account)||account.equals(VerifyRootUser.account01)) {
            int level = VerifyRootUser.login(password);
            PrintWriter pw = resp.getWriter();
            switch (level){
                case 0:
                    value = VerifyRootUser.ALL_LIMIT;
                    pw.write(VerifyRootUser.ALL_LIMIT);
                    break;
                case 1:
                    value = VerifyRootUser.ALL_LIMIT;
                    pw.write(VerifyRootUser.ALL_LIMIT);
                    break;
                case -1:
                    value = VerifyRootUser.NO_LIMIT;
                    pw.write(VerifyRootUser.NO_LIMIT);
                    break;
                default:
                    value = VerifyRootUser.READ_LIMIT;
                    pw.write(VerifyRootUser.READ_LIMIT);
            }

        }
        req.getSession().setAttribute("a","b");
        Cookie cookie = new Cookie("STATUS",value);
        cookie.setMaxAge(7*24*60*60);
        resp.addCookie(cookie);
    }
}
