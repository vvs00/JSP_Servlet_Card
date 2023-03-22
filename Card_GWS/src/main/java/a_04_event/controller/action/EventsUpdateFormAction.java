package a_04_event.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_04_event.DAO.EventDAO;
import a_04_event.VO.EventVO;


public class EventsUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "04_event/2-5_eventUpdateForm.jsp";
		
		EventDAO dao = EventDAO.getInstance();

		EventVO vo = dao.selectOneEventByNum(request.getParameter("num"));
		request.setAttribute("list", vo);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
}
