package Control;

import DAO.StudentInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SaveStudentInfo extends HttpServlet {

    private StudentInfoDAO DAO = new StudentInfoDAO("db");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        Cookie[] cookies = req.getCookies();
        req.getSession().setAttribute("a","b");
        PrintWriter pw = resp.getWriter();
        for(int i=0;cookies!=null && i<cookies.length;i++) {
            if(cookies[i].getName().equals("lastAccessTime")){
                Long mTime = Long.parseLong(cookies[i].getValue());
                String lastAccessTime = new Date(mTime).toLocaleString();
                pw.write(lastAccessTime);
            }

            if(cookies[i].getName().equals("STATUS")){
                pw.write(cookies[i].getValue());
            }

            System.out.println(cookies[i].getName());
        }

        Cookie status = new Cookie("STATUS","000");

        Cookie timeCookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
        timeCookie.setMaxAge(1*24*60*60);
        resp.addCookie(timeCookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
