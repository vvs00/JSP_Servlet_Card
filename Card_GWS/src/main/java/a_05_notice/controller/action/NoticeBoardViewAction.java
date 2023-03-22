package a_05_notice.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_05_notice.DAO.NoticeBoardDAO;
import a_05_notice.DTO.NoticeBoardVO;

public class NoticeBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));

		NoticeBoardDAO nbDAO = NoticeBoardDAO.getInstance();
		NoticeBoardVO nbVO = nbDAO.selectOneByNum(num);
		nbDAO.updateReadCount(num);

		request.setAttribute("nbVO", nbVO);
		RequestDispatcher dis = request.getRequestDispatcher("05_notice/noticeBoardView.jsp");
		dis.forward(request, response);
	}

}
