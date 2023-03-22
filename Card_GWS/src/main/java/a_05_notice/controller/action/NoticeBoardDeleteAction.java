package a_05_notice.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_05_notice.DAO.NoticeBoardDAO;

public class NoticeBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeBoardDAO nbDAO = NoticeBoardDAO.getInstance();

		int num = Integer.parseInt(request.getParameter("num"));
		nbDAO.deleteByNum(num);

		new NoticeBoardListAction().execute(request, response);
	}

}
