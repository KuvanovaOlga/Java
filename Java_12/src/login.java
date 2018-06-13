import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;


@WebServlet("/login")
public class login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("UsName").equals("Admin") && request.getParameter("UsPassword").equals("Admin"))
        {
            HttpSession session=request.getSession();
            if(3<=Calendar.getInstance().getTime().getHours() && Calendar.getInstance().getTime().getHours()<=9)
            {
                session.setAttribute("Welcome","Good morning");
            }
            if(9<=Calendar.getInstance().getTime().getHours() && Calendar.getInstance().getTime().getHours()<=15)
            {
                session.setAttribute("Welcome","Good afternoon");
            }
            if(15<=Calendar.getInstance().getTime().getHours() && Calendar.getInstance().getTime().getHours()<=23)
            {
                session.setAttribute("Welcome","Good evening");
            }
            if(0<=Calendar.getInstance().getTime().getHours() && Calendar.getInstance().getTime().getHours()<=3)
            {
                session.setAttribute("Welcome","Good night");
            }
            response.sendRedirect("Welcome.jsp");
        }
        else
        {
            response.sendRedirect("error.jsp");
        }
    }
}
