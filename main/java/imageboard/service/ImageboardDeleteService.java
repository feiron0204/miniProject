package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String[] seqArr=request.getParameterValues("check");
		
		ImageboardDAO imageboardDAO=ImageboardDAO.getInstance();
		for(String seq : seqArr) {
			imageboardDAO.delete(Integer.parseInt(seq));			
		}
		
		return "/imageboard/imageboardDelete.jsp";
	}

}
