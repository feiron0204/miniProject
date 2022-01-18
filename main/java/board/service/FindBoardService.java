package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class FindBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pseq=request.getParameter("pseq");
		BoardDAO boardDAO=BoardDAO.getInstance();
		
		boolean yesNo=false;
		if(pseq.equals("0")) {
			yesNo=true;
		}
		BoardDTO boardDTO=boardDAO.selectOne(Integer.parseInt(pseq));
		if(boardDTO!=null) {
			yesNo=true;
		}
		request.setAttribute("yesNo", yesNo);
		return "/board/findBoard.jsp";
	}

}
