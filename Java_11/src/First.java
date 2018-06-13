import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "First", urlPatterns = "/First")
public class First extends HttpServlet {
    private static boolean count = true;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (count) {
            HttpSession ses = request.getSession();
            ses.setAttribute("send", request.getParameter("name").toString());
            response.sendRedirect("Second");
            count = false;
        }
        else {
            count = true;
            response.sendRedirect("Message.jsp");
        }
    }
}
