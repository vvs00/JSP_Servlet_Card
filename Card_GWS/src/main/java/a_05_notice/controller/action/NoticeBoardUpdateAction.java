package a_05_notice.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_05_notice.DAO.NoticeBoardDAO;
import a_05_notice.DTO.NoticeBoardVO;

public class NoticeBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("UTF-8");
		
		NoticeBoardVO nbVO = new NoticeBoardVO();
		nbVO.setNum(Integer.parseInt(request.getParameter("num")));
		nbVO.setTitle(request.getParameter("title"));
		nbVO.setContent(request.getParameter("content"));

		NoticeBoardDAO nbDAO = NoticeBoardDAO.getInstance();
		nbDAO.customerBoardUpdate(nbVO);

		new NoticeBoardListAction().execute(request, response);
	}

}
