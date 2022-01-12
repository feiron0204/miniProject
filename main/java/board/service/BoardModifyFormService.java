package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardModifyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq=Integer.parseInt(request.getParameter("seq"));
		String pg=request.getParameter("pg");
		
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		BoardDTO boardDTO=boardDAO.selectOne(seq);
		
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("pg", pg);
		
		request.setAttribute("display", "/board/boardModifyForm.jsp");
		return "/index.jsp";
	}

}
