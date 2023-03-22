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
import a_07_wishlist.DTO.WishlistVO;

public class WishlistDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WishlistVO vo = new WishlistVO();
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo != null) {
			String userid = mvo.getUserid();
			
			vo.setUserid(userid);
			WishlistDAO dao = WishlistDAO.getInstance();
			if(request.getParameter("num") != null) {
				//장바구니 선택한 카드 삭제
				vo.setCardnum(Integer.parseInt(request.getParameter("num")));
				dao.deleteWishlist(vo);
				request.setAttribute("alertMessage", "장바구니에서 카드가 삭제되었습니다.");
			}else {
				request.setAttribute("alertMessage", "올바르지 않은 요청입니다. 다시시도해주세요.");
			}
			
			//갱신된 카드리스트 가져오기
			List<VO> list = dao.selectWishlist(userid);
			request.setAttribute("cardlist", list);
		}

		String url = "07_wishlist/wishlist.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
