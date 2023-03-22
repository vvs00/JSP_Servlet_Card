package a_03_card.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_03_card.DAO.CardDAO;
import a_03_card.VO.CardVO;

public class CardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "03_card/1-1_cardList.jsp";
		
		CardDAO dao = CardDAO.getInstance();
		List<CardVO> list = dao.selectAllBoards();
		
		request.setAttribute("cardlist", list);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
