package kr.ac.sogang.selab.finitrc.dcp.potal_prototype;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DCP_potal_prototypeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
