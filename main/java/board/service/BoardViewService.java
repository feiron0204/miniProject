package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pg = request.getParameter("pg");

		// 응답
		request.setAttribute("seq", request.getParameter("seq"));
		request.setAttribute("pg", request.getParameter("pg"));
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
	}

}
