package guestbook.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import guestbook.bean.GuestbookDTO;
import guestbook.bean.GuestbookPaging;
import guestbook.dao.GuestbookDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetGuestbookListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg*3;
		int startNum = endNum-2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		GuestbookDAO guestbookDAO=GuestbookDAO.getInstance();
		List<GuestbookDTO> list=guestbookDAO.getGuestbookList(map);
		
		//페이징처리
		int totalA=guestbookDAO.getTotalA();//총글수
		
		GuestbookPaging guestbookPaging = new GuestbookPaging();
		guestbookPaging.setCurrentPage(pg);
		guestbookPaging.setPageBlock(3);
		guestbookPaging.setPageSize(3);
		guestbookPaging.setTotalA(totalA);
		
		guestbookPaging.makePagingHTML();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
				
		//System.out.println(list);
		//List -> JSON으로 변환해야함
		JSONObject json = new JSONObject();
		if(list!=null) {
			JSONArray array = new JSONArray();
			for(GuestbookDTO guestbookDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", guestbookDTO.getSeq());
				temp.put("name", guestbookDTO.getName());
				temp.put("email", guestbookDTO.getEmail());
				temp.put("homepage", guestbookDTO.getHomepage());
				temp.put("subject", guestbookDTO.getSubject());
				temp.put("content", guestbookDTO.getContent());
				temp.put("logtime", sdf.format(guestbookDTO.getLogtime()));
				
				array.add(temp);
			}
			
			json.put("list", array);
			json.put("guestbookPaging", guestbookPaging.getPagingHTML().toString());
		}
		request.setAttribute("list", json);
		return "/guestbook/getGuestbookList.jsp";
	}

}
