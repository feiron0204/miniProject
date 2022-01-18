package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String pseq = request.getParameter("seq");//원글번호
		String pg = request.getParameter("pg");//원글이 있는 페이지 번호
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("pseq", pseq);
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		return "/index.jsp";
	}
}
