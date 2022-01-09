package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;
import lombok.Cleanup;


public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDAO instance;
	
	private DataSource ds;

	public static BoardDAO getInstance() {
		// 동기화처리를하면서 쓰레드처리
		synchronized (BoardDAO.class) {
			if (instance == null) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우에만 구역까지넣어야함
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean boardWrite(BoardDTO boardDTO) {
		int result=0;
		String sql="insert into board (seq,id,name,email,subject,content,ref) "
				+ "values(board_num.nextval,?,?,?,?,?,board_num.currval)";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result==0?false:true;
	}
}
