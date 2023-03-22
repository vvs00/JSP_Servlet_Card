package a_05_notice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import a_05_notice.DTO.NoticeBoardVO;
import util.DBManager;

public class NoticeBoardDAO {
	private NoticeBoardDAO() {
	}

	private static NoticeBoardDAO instance = new NoticeBoardDAO();

	public static NoticeBoardDAO getInstance() {
		return instance;
	}

	public List<NoticeBoardVO> listboard() {
		String sql = "select * from noticeboard order by num desc";
		List<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NoticeBoardVO vo = new NoticeBoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setUserid(rs.getString("userid"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(NoticeBoardVO vo) {
		String sql = "insert into board(num, title, content)" + "values(noticeboard_seq.nextval, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(int num) {
		String sql = "update noticeboard set readcount=readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateBoard(NoticeBoardVO vo) {
		String sql = "update board set title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertBoard(String userid, String title, String content) {
		String sql = "insert into noticeBoard(num,userid,title,content) " + " values(noticeboard_seq.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public NoticeBoardVO selectOneByNum(int num) {
		NoticeBoardVO nbVO = new NoticeBoardVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from noticeBoard where num = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				nbVO.setNum(rs.getInt("num"));
				nbVO.setTitle(rs.getString("title"));
				nbVO.setContent(rs.getString("content"));
				nbVO.setUserid(rs.getString("userid"));
				nbVO.setReadcount(rs.getInt("readcount"));
				nbVO.setWritedate(rs.getTimestamp("writedate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return nbVO;
	}

	public void customerBoardUpdate(NoticeBoardVO nbVO) {
		String sql = "update noticeBoard set title=?, content=?,WRITEDATE=sysdate  where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nbVO.getTitle());
			pstmt.setString(2, nbVO.getContent());
			pstmt.setInt(3, nbVO.getNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void deleteByNum(int num) {
		String sql = "delete from noticeboard where num =?";
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
}
