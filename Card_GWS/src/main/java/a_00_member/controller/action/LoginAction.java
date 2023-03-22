package a_00_member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import a_00_member.DAO.MemberDAO;
import a_00_member.DTO.MemberVO;
import a_01_main.controller.action.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid,pwd);
		
		String url ="00_member/SGW_Login.jsp";
		
		if(result == 1) {
			MemberVO vo = dao.getSelectOneById(userid);
			HttpSession session = request.getSession();
			System.out.print("로그인체크 : "+vo);
			session.setAttribute("loginUser", vo);
			request.setAttribute("message", "회원가입에 성공하였습니다.");
		    url = "index.jsp";
		
		}else if(result==0) {
			request.setAttribute("message", "비밀번호가 틀립니다.");
		}else if(result == -1){
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}