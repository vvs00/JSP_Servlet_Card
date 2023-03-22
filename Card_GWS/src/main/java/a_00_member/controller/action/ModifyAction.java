package a_00_member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_00_member.DAO.MemberDAO;
import a_00_member.DTO.MemberVO;
import a_01_main.controller.action.Action;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(request.getParameter("gender"));
		
		System.out.println(vo);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.memberModify(vo);
		
		String url = "index.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}