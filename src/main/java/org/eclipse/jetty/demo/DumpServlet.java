package org.eclipse.jetty.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DumpServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dump</title>");
        out.println("<style>table td { font-family: monospace; }</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>DumpServlet</h1>");
        out.println("<table cellpadding=\"4\" cellspacing=\"0\">");
        
        dumpRow(out, "getHeader('User-Agent')", req.getHeader("User-Agent"));
        dumpRow(out, "getRequestURI()", req.getRequestURI());
        dumpRow(out, "getRequestURL().toString()", req.getRequestURL().toString());
        dumpRow(out, "getPathInfo()", req.getPathInfo());
        dumpRow(out, "getPathTranslated()", req.getPathTranslated());
        dumpRow(out, "getQueryString()", req.getQueryString());
        dumpRow(out, "getServletPath()", req.getServletPath());
        
        out.println("</table>");
        out.println("</body></html>");
    }

    private void dumpRow(PrintWriter out, String key, String value)
    {
        out.printf("<tr><td>%s</td><td>%s</td></tr>", key, value);
    }
}
