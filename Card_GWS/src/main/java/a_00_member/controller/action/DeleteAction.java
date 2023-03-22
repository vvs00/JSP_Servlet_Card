package a_00_member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import a_00_member.DAO.MemberDAO;
import a_01_main.controller.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		System.out.println();
		System.out.println(userid);
		System.out.println(pwd);
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(userid, pwd);
		String url = "member?command=deleteform";
		
		if(result == 1) {
			dao.deleteMember(userid);
			url = "member?command=login";
			HttpSession session =request.getSession();
			session.invalidate();
			
		}else if(result == 0){
			request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
		}else if(result == -1){
			request.setAttribute("msg", "다시입력하세요.");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}




