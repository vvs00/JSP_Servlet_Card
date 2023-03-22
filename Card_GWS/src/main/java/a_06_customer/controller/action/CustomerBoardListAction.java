package a_06_customer.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;
import a_06_customer.DTO.CustomerBoardVO;

public class CustomerBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
			List<CustomerBoardVO> list = cbDAO.selectAllBoard();
		
			String url = "06_customer/customerBoard.jsp";
		
			request.setAttribute("CustomerBoardlist", list);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
	}

}
