package a_03_card.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_03_card.DAO.CardDAO;
import a_03_card.VO.CardVO;

public class CardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "03_card/1-4_cardWrite.jsp";
		CardVO cVo = new CardVO();
		
		cVo.setNum(Integer.parseInt(request.getParameter("num")));
		cVo.setImg(request.getParameter("img"));
		cVo.setName(request.getParameter("name"));
		cVo.setInfo(request.getParameter("info"));
		cVo.setNotice(request.getParameter("notice"));
		cVo.setDues(request.getParameter("dues"));
		cVo.setPerformance(request.getParameter("performance"));
		cVo.setBenefits(request.getParameter("benefits"));
		
		CardDAO cDao = CardDAO.getInstance();
		cDao.CardWrite(cVo);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
