package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제폴더경로 잡아주기
		String realFolder=request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		//파일업로드
		MultipartRequest multi = new MultipartRequest(request, realFolder,5*1024*1024,"UTF-8",new DefaultFileRenamePolicy());//요거 cos.jar에 있는거임 (요청,경로,파일크기,인코딩,같은파일올라갈시)
		//데이터
		
		//String imageId = request.getParameter("imageId");//이거 더이상못함 리퀘를 멀티가먹어서
		String imageId=multi.getParameter("imageId");
		String imageName=multi.getParameter("imageName");
		int imagePrice=Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty=Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent=multi.getParameter("imageContent");
		String image1=multi.getOriginalFileName("image1");//이름이같아서 원본이 덮어씌어질경우
		//String image11=multi.getFilesystemName("image1");//이름같을때 새로운이름이 붙어졌을경우
		
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImage1(image1);
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardWrite(imageboardDTO);
		//응답
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		return "/index.jsp";
	}

}
