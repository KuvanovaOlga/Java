import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println(new Date() + " <br>" + "Hello " + request.getRemoteUser());

        HttpSession httpSession = request.getSession(true);
        long time = httpSession.getCreationTime();

        long a = new Date().getTime();
        printWriter.println(request.getSession().getLastAccessedTime());
        printWriter.println("<br> Entry time: " + time + "<br> Duration: " + (a  - time)/1000 + " seconds");
        printWriter.println("</html>");
        printWriter.close();
    }

}
