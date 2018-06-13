import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( name="Auth", urlPatterns = "/Authorization")
public class Auth extends HttpServlet {
    private String passw = "admin";
    private String login = "admin";
    private String passw2 = "user";
    private String login2 = "user";
    private static int count = 0;
    private static int count2 = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html>");
        printWriter.println(request.getSession().getLastAccessedTime());
        if (request.getParameter("pass").equals(passw) && request.getParameter("login").equals(login)) {
            count++;
            Cookie cookie = new Cookie(request.getParameter("login"),"admin " + count + " " + request.getSession().getLastAccessedTime());
            response.addCookie(cookie);
            response.sendRedirect("Home");
        }
        else    if (request.getParameter("pass").equals(passw2) && request.getParameter("login").equals(login2)) {
            count2++;
            Cookie cookie = new Cookie(request.getParameter("login"),"user " + count2 + " " + request.getSession().getLastAccessedTime());
            response.addCookie(cookie);
            response.sendRedirect("Home");
        }
  else
            printWriter.print("</html>");
        printWriter.close();
    }



}
