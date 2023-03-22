package a_05_notice.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_05_notice.DAO.NoticeBoardDAO;

public class NoticeBoardwriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeBoardDAO nbDAO = NoticeBoardDAO.getInstance();
		nbDAO.insertBoard(userid,title,content);
		
		new NoticeBoardListAction().execute(request, response);
	}

}
