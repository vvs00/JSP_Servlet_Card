package a_03_card.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;

public class CardWriteFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "03_card/1-3_cardWriteForm.jsp";

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	
	
}
}
