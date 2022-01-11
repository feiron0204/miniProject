package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import net.sf.json.JSONObject;

public class GetBoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		BoardDTO boardDTO=boardDAO.selectOne(seq);
		
		JSONObject json = new JSONObject();
		if(boardDTO!=null) {
			json.put("boardDTO", boardDTO);
		}
		request.setAttribute("boardDTO", json);
		return "/board/getBoardView.jsp";
	}

}
