package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static MemberDAO instance;
	
	private DataSource ds;

	public static MemberDAO getInstance() {
		// 동기화처리를하면서 쓰레드처리
		synchronized (MemberDAO.class) {
			if (instance == null) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public MemberDAO() {
		/*커넥션풀 하기 이전
		 * try { // driver loading Class.forName("oracle.jdbc.driver.OracleDriver");
		 * System.out.println("driver loading"); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 */
		try {
			Context context = new InitialContext();
//			ds=(DataSource)context.lookup("jdbc/oracle");
			ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우에만 구역까지넣어야함
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/*커넥션풀 하기 이전
	 * public void getConnection() { try { conn =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser",
	 * "1004"); System.out.println("connection success"); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */

	public MemberDTO login(String id, String pwd) {
		MemberDTO memberDTO = null;
		String sql = "select * from member where id=? and pwd=?";
//		this.getConnection();// 호출
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);// 문장처리하는 가이드 생성
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			// 실행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDTO=new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	public void write(MemberDTO memberDTO) {
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";


		try {
			conn=ds.getConnection();// 접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());

			pstmt.executeUpdate();

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
	}

//	public boolean write(MemberDTO dto) {
//		int result=0;
//		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
//		this.getConnection();//호출
//		try {
//			pstmt=conn.prepareStatement(sql);//문장처리하는 가이드 생성
//			pstmt.setString(1, dto.getName());
//			pstmt.setString(2, dto.getId());
//			pstmt.setString(3, dto.getPwd());
//			pstmt.setString(4, dto.getGender());
//			pstmt.setString(5, dto.getEmail1());
//			pstmt.setString(6, dto.getEmail2());
//			pstmt.setString(7, dto.getTel1());
//			pstmt.setString(8, dto.getTel2());
//			pstmt.setString(9, dto.getTel3());
//			pstmt.setString(10, dto.getZipcode());
//			pstmt.setString(11, dto.getAddr1());
//			pstmt.setString(12, dto.getAddr2());
//			//실행
//			result=pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt!=null) pstmt.close();
//				if(conn!=null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result>0?true:false;
//	}
	public boolean checkById(String id) {
		boolean result=false;
		String sql="select * from member where id=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			result=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean isExistId(String id) {
		boolean exist=false;
		String sql="select * from member where id=?";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			exist=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exist;
	}
	
	/*강사님답
	   public MemberDTO modify(String id){
	   		MemberDTO memberDTO = null;
	   		String sql = "select * from member where id=?";
	   		try {
			conn=ds.getConnection();//접속
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();//실행
			if(rs.next()) {
				memberDTO=new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   		
	   		return memberDTO;
	   }
	 */

	public MemberDTO selectOne(String id) {
		MemberDTO memberDTO = null;
		String sql="select * from member where id=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberDTO=new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	public void modify(MemberDTO memberDTO) {
		String sql = "update member set name=?,pwd=?,gender=?,email1=?,email2=?,tel1=?,tel2=?,tel3=?,zipcode=?,addr1=?,addr2=?,logtime=sysdate where id=?";


		try {
			conn=ds.getConnection();// 접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());

			pstmt.executeUpdate();

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
	}
	/*강사님꺼돌릴라믄
	public void update(MemberDTO memberDTO) {
		String sql = "update member set name=?,pwd=?,gender=?,email1=?,email2=?,tel1=?,tel2=?,tel3=?,zipcode=?,addr1=?,addr2=?,logtime=sysdate where id=?";


		try {
			conn=ds.getConnection();// 접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());

			pstmt.executeUpdate();

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
	}
	*/
}
