package a_06_customer.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;
import a_06_customer.DTO.CustomerBoardVO;

public class CustomerBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CustomerBoardVO cbVO = new CustomerBoardVO();
		cbVO.setNum(Integer.parseInt(request.getParameter("num")));
		cbVO.setTitle(request.getParameter("title"));
		cbVO.setContent(request.getParameter("content"));

		CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
		cbDAO.customerBoardUpdate(cbVO);

		new CustomerBoardListAction().execute(request, response);
	}

}
