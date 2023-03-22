package a_04_event.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import a_04_event.VO.EventVO;
import util.DBManager;

public class EventDAO {
	private EventDAO() {
	}

	private static EventDAO instance = new EventDAO();

	public static EventDAO getInstance() {
		return instance;
	}

	public List<EventVO> selectEventBoards() {
		List<EventVO> list = new ArrayList<EventVO>();

		String sql = "select * from event";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO vo = new EventVO();

				vo.setEventNum(rs.getInt("eventnum"));
				vo.setEventName(rs.getString("eventname"));
				vo.setEventInfo(rs.getString("eventinfo"));
				vo.setEventCardImg(rs.getString("eventcardimg"));
				vo.setEventSpotImg(rs.getString("eventspotimg"));
				vo.setEventCal(rs.getString("eventcal"));
				vo.setEventBen(rs.getString("eventben"));
				vo.setEventTar(rs.getString("eventtar"));
				vo.setEventPay(rs.getString("eventpay"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public EventVO EventView(String num) {

		EventVO vo = null;
		
		String sql = "select * from event where eventnum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 vo = new EventVO();

				vo.setEventNum(rs.getInt("eventnum"));
				vo.setEventName(rs.getString("eventname"));
				vo.setEventInfo(rs.getString("eventinfo"));
				vo.setEventSpotImg(rs.getString("eventspotimg"));
				vo.setEventCal(rs.getString("eventcal"));
				vo.setEventBen(rs.getString("eventben"));
				vo.setEventTar(rs.getString("eventtar"));
				vo.setEventPay(rs.getString("eventpay"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	public EventVO selectOneEventByNum(String num) {

		String sql = "select * from event where eventnum = ?";

		EventVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				cVo = new EventVO();

				cVo.setEventNum(rs.getInt("eventnum"));
				cVo.setEventCardImg(rs.getString("eventcardimg"));
				cVo.setEventSpotImg(rs.getString("eventspotimg"));
				cVo.setEventName(rs.getString("eventname"));
				cVo.setEventInfo(rs.getString("eventinfo"));
				cVo.setEventCal(rs.getString("eventcal"));
				cVo.setEventBen(rs.getString("eventben"));
				cVo.setEventTar(rs.getString("eventtar"));
				cVo.setEventPay(rs.getString("eventpay"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cVo;
	}

	public void EventUpdate(EventVO vo) {

		String sql = "update event set eventcardimg=?, eventspotimg=?, eventname=?, eventinfo=?, eventcal=?, eventben=?, eventtar=?, eventpay=? where eventnum=?";


		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getEventCardImg());
			pstmt.setString(2, vo.getEventSpotImg());
			pstmt.setString(3, vo.getEventName());
			pstmt.setString(4, vo.getEventInfo());
			pstmt.setString(5, vo.getEventCal());
			pstmt.setString(6, vo.getEventBen());
			pstmt.setString(7, vo.getEventTar());
			pstmt.setString(8, vo.getEventPay());
			pstmt.setInt(9, vo.getEventNum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void EventWrite(EventVO vo) {

		String sql = "insert into event values(event_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getEventCardImg());
			pstmt.setString(2, vo.getEventSpotImg());
			pstmt.setString(3, vo.getEventName());
			pstmt.setString(4, vo.getEventInfo());
			pstmt.setString(5, vo.getEventCal());
			pstmt.setString(6, vo.getEventBen());
			pstmt.setString(7, vo.getEventTar());
			pstmt.setString(8, vo.getEventPay());

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
