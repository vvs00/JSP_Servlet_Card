package a_06_customer.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;

public class CustomerBoardBlindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
		
		cbDAO.blind(num);
		
		new CustomerBoardListAction().execute(request, response);
	}

}
