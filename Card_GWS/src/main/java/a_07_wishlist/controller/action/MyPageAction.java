package a_07_wishlist.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_07_wishlist.DAO.DAO;
import a_07_wishlist.DTO.VO;

public class MyPageAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {
	   
      String url = "07_wishlist/myPage.jsp";
      
      DAO dao = DAO.getInstance();
      List<VO> list = dao.selectAllBoards();
      
      request.setAttribute("cardlist", list);
      
      RequestDispatcher dis = request.getRequestDispatcher(url);
      dis.forward(request, response);
   }

}