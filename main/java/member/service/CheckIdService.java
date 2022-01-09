package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		String id=request.getParameter("id");
//		MemberDAO memberDAO=MemberDAO.getInstance();
//		request.setAttribute("result", memberDAO.checkById(id)?"사용하실수 없습니다.":"사용하실수 있습니다.");
//		return "/member/checkId.jsp";
		//데이터
		String id = request.getParameter("id");
		
		//DB
		MemberDAO memberDAO=MemberDAO.getInstance();
		boolean exist = memberDAO.isExistId(id);
		request.setAttribute("id", id);
		//응답
		if(exist)
			return "/member/checkIdFail.jsp";//사용 불가능
		else
			return "/member/checkIdOk.jsp";//사용 가능
	}

}
