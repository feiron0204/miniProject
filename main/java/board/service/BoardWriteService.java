package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		boolean result=false;
		
		HttpSession httpSession=request.getSession();
		String id=(String) httpSession.getAttribute("memId");
		String name=(String) httpSession.getAttribute("memName");
		String email=(String) httpSession.getAttribute("memEmail");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		result=boardDAO.boardWrite(boardDTO);
		
		if(result) return "/board/boardWriteOk.jsp";
		else return "/board/boardWriteFail.jsp";
	}

}
