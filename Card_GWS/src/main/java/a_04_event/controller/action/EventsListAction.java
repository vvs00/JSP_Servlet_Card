
package a_04_event.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_04_event.DAO.EventDAO;
import a_04_event.VO.EventVO;

public class EventsListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String url = "04_event/2-1_eventList.jsp";
			
			EventDAO dao = EventDAO.getInstance();
			List<EventVO> list = dao.selectEventBoards();
			
			request.setAttribute("eventlist", list);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
	}

}
