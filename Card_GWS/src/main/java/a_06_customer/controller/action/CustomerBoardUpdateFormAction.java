package a_06_customer.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;
import a_06_customer.DTO.CustomerBoardVO;

public class CustomerBoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
		CustomerBoardVO cbVO = cbDAO.selectOneByNum(num);
		request.setAttribute("cbVO", cbVO);
		RequestDispatcher dis = request.getRequestDispatcher("06_customer/customerBoardUpdateForm.jsp");
		dis.forward(request, response);
	}

}
