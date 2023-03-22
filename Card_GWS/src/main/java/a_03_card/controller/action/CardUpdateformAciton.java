package a_03_card.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_03_card.DAO.CardDAO;
import a_03_card.VO.CardVO;

public class CardUpdateformAciton implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "03_card/1-5_cardUpdateform.jsp";
		String num = request.getParameter("num");

		CardDAO cDao = CardDAO.getInstance();

		CardVO cVo = cDao.selectOneCardByNum(num);

		request.setAttribute("card", cVo);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
