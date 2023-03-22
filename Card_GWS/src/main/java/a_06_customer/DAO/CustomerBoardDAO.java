package a_06_customer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import a_06_customer.DTO.CustomerBoardVO;
import util.DBManager;

public class CustomerBoardDAO {
	private CustomerBoardDAO() {};
	private static CustomerBoardDAO instance = new CustomerBoardDAO();
	public static CustomerBoardDAO getInstance() {
		return instance;
	}
	public List<CustomerBoardVO> selectAllBoard() {
		
		List<CustomerBoardVO> list = new ArrayList<CustomerBoardVO>();
		
		String sql = "select * from customerBoard ORDER BY bgroup desc, bsequence asc";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CustomerBoardVO cbVO = new CustomerBoardVO();
//				NUM TITLE CONTENT userid READCOUNT WRITEDATE 
				cbVO.setNum(rs.getInt("num"));
				cbVO.setTitle(rs.getString("title"));
				cbVO.setContent(rs.getString("content"));
				cbVO.setUserid(rs.getString("userid"));
				cbVO.setReadcount(rs.getInt("readcount"));
				cbVO.setDate(rs.getTimestamp("writedate"));
				cbVO.setBgroup(rs.getInt("bgroup"));
				cbVO.setBsequence(rs.getInt("bsequence"));
				cbVO.setBlevel(rs.getInt("blevel"));
				cbVO.setBlind(rs.getString("blind"));
				cbVO.setDeleted(rs.getString("deleted"));
				
				list.add(cbVO);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	public CustomerBoardVO selectOneByNum(int num) {
		CustomerBoardVO cbVO = new CustomerBoardVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from customerBoard where num = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
			//NUM TITLE CONTENT userid READCOUNT WRITEDATE 
			cbVO.setNum(rs.getInt("num"));
			cbVO.setTitle(rs.getString("title"));
			cbVO.setContent(rs.getString("content"));
			cbVO.setUserid(rs.getString("userid"));
			cbVO.setReadcount(rs.getInt("readcount"));
			cbVO.setDate(rs.getTimestamp("writedate"));
			cbVO.setBgroup(rs.getInt("bgroup"));
			cbVO.setBsequence(rs.getInt("bsequence"));
			cbVO.setBlevel(rs.getInt("blevel"));
			cbVO.setBlind(rs.getString("blind"));
			cbVO.setDeleted(rs.getString("deleted"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return cbVO; 
	
	}
	public void insertBoard(String userid, String title, String content) {

		String sql = "insert into customerBoard(num,userid,title,content,Bgroup,bsequence,blevel) "
				+ " values(customerboard_seq.nextval,?,?,?,(select nvl((max(BGROUP)+1),0) from customerboard),0,0)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void updateReadCount(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update customerBoard set readcount=readcount+1 where num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public void deleteByNum(int num) {
		String sql = "update customerboard set deleted='y' where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
			
	}
	public void customerBoardUpdate(CustomerBoardVO cbVO) {
		String sql = "update customerBoard set title=?, content=?,WRITEDATE=sysdate  where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cbVO.getTitle());
			pstmt.setString(2, cbVO.getContent());
			pstmt.setInt(3, cbVO.getNum());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void replySeqUpdate(CustomerBoardVO cbVO) {
		String sql = "update customerboard set bsequence = bsequence+1 where bgroup =? and bsequence>?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cbVO.getBgroup());
			pstmt.setInt(2, cbVO.getBsequence());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void insertBoardReply(CustomerBoardVO cbVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into customerboard(num,userid,title,content, BGROUP, BSEQUENCE, BLEVEL)"
	            + "values(board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cbVO.getUserid());
			pstmt.setString(2, cbVO.getTitle());
			pstmt.setString(3, cbVO.getContent());
			pstmt.setInt(4, cbVO.getBgroup());
			pstmt.setInt(5, cbVO.getBsequence());
			pstmt.setInt(6, cbVO.getBlevel());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void blind(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update customerBoard set blind='y' where num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	public void blindRelease(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update customerBoard set blind='n' where num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
