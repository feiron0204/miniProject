package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class GuestbookWriteFromService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession httpSession=request.getSession();
		String memId=(String)httpSession.getAttribute("memId");
		String memName=(String)httpSession.getAttribute("memName");
		String memEmail=(String)httpSession.getAttribute("memEmail");
		
		request.setAttribute("memId", memId);
		request.setAttribute("memName", memName);
		request.setAttribute("memEmail", memEmail);
		request.setAttribute("display", "/guestbook/guestbookWriteForm.jsp");
		return "/index.jsp";
	}

}
