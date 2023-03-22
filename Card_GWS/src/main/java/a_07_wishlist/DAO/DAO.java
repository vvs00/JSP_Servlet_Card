package a_07_wishlist.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import a_07_wishlist.DTO.VO;
import util.DBManager;

public class DAO {
	private DAO() {
	}

	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	public List<VO> selectAllBoards() {
		List<VO> list = new ArrayList<VO>();

		String sql = "select * from card";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
  
	public List<VO> CardView(String num) {
		List<VO> list = new ArrayList<VO>();

		String sql = "select num, img, name, notice, dues, performance, benefits from card where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				VO vo = new VO();

				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setImg(rs.getString("img"));
				vo.setDues(rs.getString("dues"));
				vo.setNotice(rs.getString("notice"));
				vo.setPerformance(rs.getString("performance"));
				vo.setBenefits(rs.getString("benefits"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<VO> selectEventBoards() {
		List<VO> list = new ArrayList<VO>();

		String sql = "select * from event";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				VO vo = new VO();

				vo.setEventnum(rs.getInt("eventnum"));
				vo.setEventname(rs.getString("eventname"));
				vo.setEventinfo(rs.getString("eventinfo"));
				vo.setEventimg(rs.getString("eventimg"));
				vo.setEventcal(rs.getString("eventcal"));
				vo.setEventben(rs.getString("eventben"));
				vo.setEventtar(rs.getString("eventtar"));
				vo.setEventpay(rs.getString("eventpay"));


				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<VO> EventView(String num) {
		List<VO> list = new ArrayList<VO>();

		String sql ="select * from event where eventnum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO vo = new VO();

				vo.setEventnum(rs.getInt("eventnum"));
				vo.setEventname(rs.getString("eventname"));
				vo.setEventinfo(rs.getString("eventinfo"));
				vo.setEventimg(rs.getString("eventimg"));
				vo.setEventcal(rs.getString("eventcal"));
				vo.setEventben(rs.getString("eventben"));
				vo.setEventtar(rs.getString("eventtar"));
				vo.setEventpay(rs.getString("eventpay"));
				System.out.print(vo);

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void CardDelete(String num) {
		
		String sql ="delete card where num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void CardUpdate(VO vo) {
		
		String sql = "update card set name=?, notice=?, info=? , dues=?, benefits=?, Performance=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNotice());
			pstmt.setString(3, vo.getInfo());
			pstmt.setString(4, vo.getDues());
			pstmt.setString(5, vo.getBenefits());
			pstmt.setString(6, vo.getPerformance());
			pstmt.setInt(7, vo.getNum());
			
			

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public VO selectOneCardByNum(String num) {
		String sql = "select * from card where num = ?";

		VO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				cVo = new VO();

				cVo.setNum(rs.getInt("num"));
				cVo.setImg(rs.getString("img"));
				cVo.setName(rs.getString("name"));
				cVo.setNotice(rs.getString("notice"));
				cVo.setInfo(rs.getString("info"));
				cVo.setDues(rs.getString("dues"));
				cVo.setPerformance(rs.getString("performance"));
				cVo.setBenefits(rs.getString("benefits"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cVo;
	}
	
	public void CardWrite(VO vo) {
		
		String sql = "insert into card values(card_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getImg());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNotice());
			pstmt.setString(4, vo.getInfo());
			pstmt.setString(5, vo.getDues());
			pstmt.setString(6, vo.getBenefits());
			pstmt.setString(7, vo.getPerformance());
			
			

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
