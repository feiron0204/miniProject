package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String seq=request.getParameter("seq");
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.boardDelete(seq);
		
		request.setAttribute("display", "/board/boardList.jsp");
		return "/index.jsp";
	}

}
