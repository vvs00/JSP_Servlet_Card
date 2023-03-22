package a_00_member.controller.action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;

public class DeleteFormAction implements Action {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "00_member/SGW_Delete.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}
	}
