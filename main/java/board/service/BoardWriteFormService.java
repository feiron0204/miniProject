package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class BoardWriteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession httpSession=request.getSession();
		if(httpSession.getAttribute("id")==null) {
			return "/board/loginPlz.jsp";
		}
		return "/board/boardWriteForm.jsp";
	}

}
