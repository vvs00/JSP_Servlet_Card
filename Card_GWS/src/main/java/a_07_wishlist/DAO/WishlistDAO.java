package a_07_wishlist.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import a_07_wishlist.DTO.VO;
import a_07_wishlist.DTO.WishlistVO;
import util.DBManager;


public class WishlistDAO {
	private WishlistDAO() {
	}

	private static WishlistDAO instance = new WishlistDAO();

	public static WishlistDAO getInstance() {
		return instance;
	}	

	public List<VO> selectWishlist(String id) {
		
		List<VO> list = new ArrayList<VO>();
		
		String sql = "select A.* from card A, wishlist B where A.num = B.cardnum and B.userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //쿼리를 실행시킨 결과를 rs에 담아준다.
			
			while(rs.next()) {
				VO vo = new VO();

				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setImg(rs.getString("img"));
				vo.setInfo(rs.getString("info"));
				vo.setDues(rs.getString("dues"));
				vo.setNotice(rs.getString("notice"));
				vo.setPerformance(rs.getString("performance"));
				vo.setBenefits(rs.getString("benefits"));

				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void addWishlist(WishlistVO vo) {

		String sql = "insert into wishlist(userid, cardnum)" + " values(?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;   
		
		try {
			conn = DBManager.getConnection();   
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, vo.getUserid()); 
			pstmt.setInt(2, vo.getCardnum()); 
			pstmt.executeUpdate(); // 실행
		} catch (Exception e) { //예외처리
			e.printStackTrace();
		} finally { 
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteWishlist(WishlistVO vo) {
		
		String sql = "delete from wishlist where userid = ? and cardnum = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;   
		
		try {
			conn = DBManager.getConnection();   
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, vo.getUserid()); 
			pstmt.setInt(2, vo.getCardnum()); 
			pstmt.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { 
			DBManager.close(conn, pstmt);
		}
	}
	
	public int duplicateCheck(WishlistVO vo) {
		int checkResult = -1;
		String sql = "select count(1) AS cnt from wishlist where userid = ? and cardnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setInt(2, vo.getCardnum());
			rs = pstmt.executeQuery(); //쿼리를 실행시킨 결과를 rs에 담아준다.
			
			while(rs.next()) {
				if(rs.getInt("cnt") == 0) {
					checkResult = 1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return checkResult;
	}
	
}
	
