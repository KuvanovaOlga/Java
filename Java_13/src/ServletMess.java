import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ServletMess", urlPatterns = "/ServletMess")
public class ServletMess extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyList list = new MyList();
        request.setAttribute("lst", list);
        request.getRequestDispatcher("jstl_forech.jsp").forward(request,response);
    }
}
