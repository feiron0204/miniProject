package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg=Integer.parseInt(request.getParameter("pg"));
		int seq=Integer.parseInt(request.getParameter("seq"));
		
		//DB
		ImageboardDAO imageboardDAO=ImageboardDAO.getInstance();
		ImageboardDTO imageboardDTO=imageboardDAO.imageboardView(seq);
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("imageboardDTO", imageboardDTO);
		request.setAttribute("display", "/imageboard/imageboardView.jsp");
		return "/index.jsp";
	}

}