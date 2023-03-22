package a_04_event.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_04_event.DAO.EventDAO;
import a_04_event.VO.EventVO;

public class EventsUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub card_page
		String url = "04_event/2-6_eventUpdate.jsp";
							

		EventVO cVo = new EventVO();

		String newCardImg = request.getParameter("newCardImg");
		if (newCardImg.equals("")) {
			cVo.setEventCardImg(request.getParameter("eventCardImg"));
		} else {
			cVo.setEventCardImg(newCardImg);
		}

		String newSpotImg = request.getParameter("newSpotImg");
		
		if (newSpotImg.equals("")) {
			cVo.setEventSpotImg(request.getParameter("eventSpotImg"));
		} else {
			cVo.setEventSpotImg(newSpotImg);
		}

		cVo.setEventNum(Integer.parseInt(request.getParameter("num")));
		cVo.setEventName(request.getParameter("eventName"));
		cVo.setEventInfo(request.getParameter("eventInfo"));
		cVo.setEventCal(request.getParameter("eventCal"));
		cVo.setEventBen(request.getParameter("eventBen"));
		cVo.setEventTar(request.getParameter("eventTar"));
		cVo.setEventPay(request.getParameter("eventPay"));

		EventDAO cDao = EventDAO.getInstance();
		cDao.EventUpdate(cVo);
		
		System.out.println("여기까지 됨");

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
