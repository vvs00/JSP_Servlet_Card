package a_07_wishlist.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import a_00_member.DTO.MemberVO;
import a_01_main.controller.action.Action;
import a_07_wishlist.DAO.WishlistDAO;
import a_07_wishlist.DTO.VO;

public class WishlistAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "07_wishlist/wishlist.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String userid = "";
		if(mvo != null) {
			userid = mvo.getUserid();
			WishlistDAO dao = WishlistDAO.getInstance();
			List<VO> list = dao.selectWishlist(userid);
			
			request.setAttribute("cardlist", list);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	
	}

}
