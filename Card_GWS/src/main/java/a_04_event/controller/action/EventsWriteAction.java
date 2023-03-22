package a_04_event.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_04_event.DAO.EventDAO;
import a_04_event.VO.EventVO;

public class EventsWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "04_event/2-4_eventWrite.jsp";
		EventVO cVo = new EventVO();
		
		cVo.setEventCardImg(request.getParameter("eventCardImg"));
		cVo.setEventSpotImg(request.getParameter("eventSpotImg"));
		cVo.setEventName(request.getParameter("eventName"));
		cVo.setEventInfo(request.getParameter("eventInfo"));
		cVo.setEventCal(request.getParameter("eventCal"));
		cVo.setEventBen(request.getParameter("eventBen"));
		cVo.setEventTar(request.getParameter("eventTar"));
		cVo.setEventPay(request.getParameter("eventPay"));

		EventDAO cDao = EventDAO.getInstance();
		cDao.EventWrite(cVo);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
