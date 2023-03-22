package a_01_main.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_03_card.DAO.CardDAO;
import a_03_card.VO.CardVO;
import a_04_event.DAO.EventDAO;
import a_04_event.VO.EventVO;
import a_05_notice.DAO.NoticeBoardDAO;
import a_05_notice.DTO.NoticeBoardVO;
import a_06_customer.DAO.CustomerBoardDAO;
import a_06_customer.DTO.CustomerBoardVO;

public class MainPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		
		CustomerBoardDAO customerdao = CustomerBoardDAO.getInstance();
		List<CustomerBoardVO> customerlist = customerdao.selectAllBoard();
		
		NoticeBoardDAO noticedao = NoticeBoardDAO.getInstance();
		List<NoticeBoardVO> noticelist = noticedao.listboard();
		
		CardDAO carddao = CardDAO.getInstance();
		List<CardVO> cardlist = carddao.selectAllBoards();
		
		EventDAO eventdao = EventDAO.getInstance();
		List<EventVO> eventlist = eventdao.selectEventBoards();
		
		request.setAttribute("customerList", customerlist);
		request.setAttribute("noticeList", noticelist);
		request.setAttribute("cardList", cardlist);
		request.setAttribute("eventList", eventlist);
		
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
