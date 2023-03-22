package a_03_card.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import a_03_card.VO.CardVO;
import util.DBManager;

public class CardDAO {
	private CardDAO() {
	}

	private static CardDAO instance = new CardDAO();

	public static CardDAO getInstance() {
		return instance;
	}

	public List<CardVO> selectAllBoards() {
		List<CardVO> list = new ArrayList<CardVO>();

		String sql = "select * from card";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CardVO vo = new CardVO();

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

	public List<CardVO> CardView(String num) {
		List<CardVO> list = new ArrayList<CardVO>();

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
				CardVO vo = new CardVO();

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

	public void CardDelete(String num) {

		String sql = "delete card where num = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void CardUpdate(CardVO vo) {

		String sql = "update card set img=?, name=?, notice=?, info=? , dues=?, benefits=?, Performance=? where num=?";

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
			pstmt.setInt(8, vo.getNum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public CardVO selectOneCardByNum(String num) {
		String sql = "select * from card where num = ?";

		CardVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				cVo = new CardVO();

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

	public void CardWrite(CardVO vo) {

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

	public void EventDelete(String num) {

		String sql = "delete event where eventnum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
