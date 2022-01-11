package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//세션
		HttpSession session = request.getSession();//세션생성
		String id=(String)session.getAttribute("memId");
		String name=(String)session.getAttribute("memName");
		String email=(String)session.getAttribute("memEmail");
		
		//근데 DTO만들면 너무 과함 그래서 MAP으로 만들꺼임
		Map<String, String> map=new HashMap<String,String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		return "/board/boardWrite.jsp";
	}

}
