import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class Info extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        request.getSession().setAttribute("Name", name);
        request.getSession().setAttribute("Surname", surname);

        response.sendRedirect("Adress.jsp");
    }
}
