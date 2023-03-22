package a_06_customer.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;

public class CustomerBoardwriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		NUM TITLE CONTENT userid READCOUNT WRITEDATE 
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
		cbDAO.insertBoard(userid,title,content);
		
		new CustomerBoardListAction().execute(request, response);
	}

}
