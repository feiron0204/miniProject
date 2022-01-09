package member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//DB
		//이제 싱글톤으로 받을꺼임
		//MemberDAO memberDAO = new MemberDAO();
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.login(id,pwd);//호출
		//응답
		
		
		if(memberDTO==null)
			return "/member/loginFail.jsp";
		else {
				
			//세션
			HttpSession session = request.getSession();//세션생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			return "/";
		}
	}

}
