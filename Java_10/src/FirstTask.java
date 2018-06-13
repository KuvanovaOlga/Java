import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/FirstTask")
public class FirstTask extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Current date:" + new Date().toString());
        printWriter.println("protocol: " + request.getProtocol());
        printWriter.println("client IP: " + request.getRemoteAddr());
        printWriter.println("client name: " + request.getRemoteUser());
        printWriter.println("method: " + request.getMethod());
        printWriter.println("URL: " + request.getRequestURL());
        printWriter.println("information about header");
        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            String value = request.getHeader(name);
            printWriter.println(name + ":  " + value);
        }
    }
}
