package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class RAATable extends TagSupport {
    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();
        try {
            out.print("<table width=\"100%\" border=\"1\" align=\"center\">" +
                    "<tr bgcolor=\"#949494\">" +
                    "<th>Parameter</th><th>Value</th>" +
                    "</tr>");
            Enumeration params = pageContext.getRequest().getParameterNames();
            while(params.hasMoreElements()) {
                String paramName = (String)params.nextElement();
                out.print("<tr><td>" + paramName + "</td>");
                String paramValue = pageContext.getRequest().getParameter(paramName);
                out.println("<td> " + paramValue + "</td></tr>");
            }
        } catch (IOException e) {
            System.out.println("RAASubmit: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }
}
