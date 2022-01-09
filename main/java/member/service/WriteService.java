package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		MemberDTO dto = new MemberDTO();
//		dto.setName(request.getParameter("name"));
//		dto.setId(request.getParameter("id"));
//		dto.setPwd(request.getParameter("pwd"));
//		dto.setGender(request.getParameter("gender"));
//		dto.setEmail1(request.getParameter("email1"));
//		dto.setEmail2(request.getParameter("email2"));
//		dto.setTel1(request.getParameter("tel1"));
//		dto.setTel2(request.getParameter("tel2"));
//		dto.setTel3(request.getParameter("tel3"));
//		dto.setZipcode(request.getParameter("zipcode"));
//		dto.setAddr1(request.getParameter("addr1"));
//		dto.setAddr2(request.getParameter("addr2"));
//		
//		MemberDAO memberDAO = MemberDAO.getInstance();
//		boolean result=memberDAO.write(dto);
//		if(result)
//			return "/member/writeOk.jsp";
//		else
//			return "/member/writeFail.jsp";
		//데이터
		  String name = request.getParameter("name");
	      String id = request.getParameter("id");
	      String pwd = request.getParameter("pwd");
	      String gender = request.getParameter("gender");
	      String email1 = request.getParameter("email1");
	      String email2 = request.getParameter("email2");
	      String tel1 = request.getParameter("tel1");
	      String tel2 = request.getParameter("tel2");
	      String tel3 = request.getParameter("tel3");
	      String zipcode = request.getParameter("zipcode");
	      String addr1 = request.getParameter("addr1");
	      String addr2 = request.getParameter("addr2");
	      
	      MemberDTO memberDTO = new MemberDTO();
	      memberDTO.setName(name);
	      memberDTO.setId(id);
	      memberDTO.setPwd(pwd);
	      memberDTO.setGender(gender);
	      memberDTO.setEmail1(email1);
	      memberDTO.setEmail2(email2);
	      memberDTO.setTel1(tel1);
	      memberDTO.setTel2(tel2);
	      memberDTO.setTel3(tel3);
	      memberDTO.setZipcode(zipcode);
	      memberDTO.setAddr1(addr1);
	      memberDTO.setAddr2(addr2);
	      
	      //DB
	      MemberDAO memberDAO=MemberDAO.getInstance();
	      memberDAO.write(memberDTO);
	      
	      //응답
	      return "/member/write.jsp";
		
	}

}
