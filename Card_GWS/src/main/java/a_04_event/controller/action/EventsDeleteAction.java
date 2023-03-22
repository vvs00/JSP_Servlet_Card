package a_04_event.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_04_event.DAO.EventDAO;

public class EventsDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "04_event/2-7_eventDelete.jsp";

		EventDAO dao = EventDAO.getInstance();
		String num = request.getParameter("num");
		dao.EventDelete(num);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
