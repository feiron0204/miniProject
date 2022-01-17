package imageboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg*3;
		int startNum = endNum-2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		HttpSession session=request.getSession();
		String memId = (String) session.getAttribute("memId");
		
		ImageboardDAO imageboardDAO=ImageboardDAO.getInstance();
		List<ImageboardDTO> list=imageboardDAO.getImageboardList(map);
		
		//페이징처리
				int totalA=imageboardDAO.getTotalA();//총글수
				//System.out.println(totalA);
				ImageboardPaging imageboardPaging = new ImageboardPaging();
				imageboardPaging.setCurrentPage(pg);
				imageboardPaging.setPageBlock(3);
				imageboardPaging.setPageSize(3);
				imageboardPaging.setTotalA(totalA);
				
				imageboardPaging.makePagingHTML();
		
		
		//request.setAttribute("realPath", request.getServletContext().getRealPath("/storage")+"\\" );
		request.setAttribute("list", list);
		request.setAttribute("imageboardPaging", imageboardPaging.getPagingHTML());
		request.setAttribute("display", "/imageboard/imageboardList.jsp");
		System.out.println(request.getServletContext().getRealPath("/storage")+"\\");
		return "/index.jsp";
	}

}
