package a_05_notice.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_05_notice.DAO.NoticeBoardDAO;
import a_05_notice.DTO.NoticeBoardVO;

public class NoticeBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeBoardDAO nbDAO = NoticeBoardDAO.getInstance();
		List<NoticeBoardVO> list = nbDAO.listboard();
		request.setAttribute("list", list);
		
		String url = "05_notice/noticeBoard.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
