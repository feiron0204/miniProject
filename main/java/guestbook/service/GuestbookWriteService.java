package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

public class GuestbookWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String homepage=request.getParameter("homepage");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		System.out.println(guestbookDTO);
		
		GuestbookDAO guestbookDAO=GuestbookDAO.getInstance();
		guestbookDAO.guestbookWrite(guestbookDTO);
		
		return "/guestbook/guestbookWrite.jsp";
	}

}
