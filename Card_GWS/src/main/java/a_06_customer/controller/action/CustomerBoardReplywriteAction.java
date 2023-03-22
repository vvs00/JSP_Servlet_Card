package a_06_customer.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_01_main.controller.action.Action;
import a_06_customer.DAO.CustomerBoardDAO;
import a_06_customer.DTO.CustomerBoardVO;

public class CustomerBoardReplywriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//부모정보가져오기
		CustomerBoardDAO cbDAO = CustomerBoardDAO.getInstance();
		CustomerBoardVO pcbVO = cbDAO.selectOneByNum(Integer.parseInt(request.getParameter("num")));
		//댓글정보
		CustomerBoardVO cbVO = new CustomerBoardVO();
//		private int num;
//		private String title;
//		private String content;
//		private String userid;
//		private int readcount;
//		private Timestamp date;
//		private int bsequence;
//		private int bgroup;
//		private int blevel;
		cbVO.setTitle(request.getParameter("title"));
		cbVO.setContent(request.getParameter("content"));
		cbVO.setUserid(request.getParameter("userid"));
		
		//bgroup은 같고, Bsequnce,blevel은 +1
		cbVO.setBgroup(pcbVO.getBgroup());
		cbVO.setBsequence(pcbVO.getBsequence()+1);
		cbVO.setBlevel(pcbVO.getBlevel()+1);
		
		cbDAO.replySeqUpdate(pcbVO);
		cbDAO.insertBoardReply(cbVO);
		
		new CustomerBoardListAction().execute(request, response);
	}

}
