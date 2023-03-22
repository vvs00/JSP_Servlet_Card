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
import a_07_wishlist.DAO.DAO;
import a_07_wishlist.DAO.WishlistDAO;
import a_07_wishlist.DTO.VO;
import a_07_wishlist.DTO.WishlistVO;

public class WishlistAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WishlistVO vo = new WishlistVO(); 
		
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if(mvo != null) {
			String userid = mvo.getUserid();
			
			vo.setUserid(userid);
			vo.setCardnum(Integer.parseInt(request.getParameter("num")));
			
			//장바구니 포함여부체크
			WishlistDAO wishdao = WishlistDAO.getInstance();  
			if(wishdao.duplicateCheck(vo) == 1) { // 장바구니 포함체크결과가 1인경우(장바구니에 등록되어있지않은 카드인 경우) 장바구니등록을 실행한다.
				//장바구니 등록
				wishdao.addWishlist(vo);
				request.setAttribute("alertMessage", "장바구니에 추가하였습니다.");
			}else {
				request.setAttribute("alertMessage", "이미 장바구니에 등록되어있는 카드입니다.");
			}
		}
		
		//카드 상세보기로 이동하기위한 데이터세팅 이부분이 없으면 장바구니추가후 카드상세보기 내용들이 사라짐
		DAO dao = DAO.getInstance();
		
		String num = request.getParameter("num");
		System.out.println(num);
		List<VO> list = dao.CardView(num);
		
		request.setAttribute("cardlist", list);
		request.setAttribute("cardnum", num);
		
		String url = "03_card/1-2_cardView.jsp"; 
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response); 
	
	}

}

