package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	private DataSource ds;
	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO instance;
	
	
	public static MemberDAO getInstance() {
		synchronized(MemberDAO.class) {
			 if(instance == null) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	
	
	public MemberDAO() {		
		try {
//			Context context = new InitialContext();
//			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO login(String id, String pwd) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Map<String, String> map=new HashMap<String,String>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO memberDTO=sqlSession.selectOne("memberSQL.login",map);
		sqlSession.close();
		return memberDTO;
	}
	/*
	 * public MemberDTO login(String id, String pwd) { MemberDTO memberDTO=null;
	 * String sql = "select * from member where id=? and pwd=?";
	 * 
	 * try { //접속 conn = ds.getConnection();//호출
	 * 
	 * pstmt = conn.prepareStatement(sql);//생성 pstmt.setString(1, id);
	 * pstmt.setString(2, pwd);
	 * 
	 * rs = pstmt.executeQuery();//실행
	 * 
	 * if(rs.next()) { memberDTO = new MemberDTO();
	 * memberDTO.setName(rs.getString("name")); memberDTO.setId(rs.getString("id"));
	 * memberDTO.setPwd(rs.getString("pwd"));
	 * memberDTO.setGender(rs.getString("gender"));
	 * memberDTO.setEmail1(rs.getString("email1"));
	 * memberDTO.setEmail2(rs.getString("email2"));
	 * memberDTO.setTel1(rs.getString("tel1"));
	 * memberDTO.setTel2(rs.getString("tel2"));
	 * memberDTO.setTel3(rs.getString("tel3"));
	 * memberDTO.setZipcode(rs.getString("zipcode"));
	 * memberDTO.setAddr1(rs.getString("addr1"));
	 * memberDTO.setAddr2(rs.getString("addr2")); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * if(rs!=null) rs.close(); if(pstmt!=null) pstmt.close(); if(conn!=null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return memberDTO; }
	 */
	
	
	public void write(MemberDTO memberDTO) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("memberSQL.write", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/*
	 * public void write(MemberDTO memberDTO) { String sql =
	 * "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
	 * 
	 * 
	 * try { conn = ds.getConnection();//접속
	 * 
	 * pstmt = conn.prepareStatement(sql); //생성 pstmt.setString(1,
	 * memberDTO.getName()); pstmt.setString(2, memberDTO.getId());
	 * pstmt.setString(3, memberDTO.getPwd()); pstmt.setString(4,
	 * memberDTO.getGender()); pstmt.setString(5, memberDTO.getEmail1());
	 * pstmt.setString(6, memberDTO.getEmail2()); pstmt.setString(7,
	 * memberDTO.getTel1()); pstmt.setString(8, memberDTO.getTel2());
	 * pstmt.setString(9, memberDTO.getTel3());
	 * pstmt.setString(10,memberDTO.getZipcode());
	 * pstmt.setString(11,memberDTO.getAddr1());
	 * pstmt.setString(12,memberDTO.getAddr2());
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * if(pstmt!=null) pstmt.close(); if(conn!=null) conn.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	public boolean isExistId(String id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		boolean exist=sqlSession.selectOne("memberSQL.isExistId",id);
		sqlSession.close();
		return exist;
	}
	
	/*
	 * public boolean isExistId(String id) { boolean exist = false; String sql =
	 * "select * from member where id=?";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql);//생성 pstmt.setString(1, id);
	 * 
	 * rs = pstmt.executeQuery();//실행
	 * 
	 * if(rs.next()) exist = true;
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * if(rs!=null) rs.close(); if(pstmt!=null) pstmt.close(); if(conn!=null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return exist; }
	 */
	public MemberDTO modify(String id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.modify",id);
		sqlSession.close();
		return memberDTO;
	}
	/*
	 * public MemberDTO modify(String id) { MemberDTO memberDTO = null; String sql =
	 * "select * from member where id=?";
	 * 
	 * String sql2 = "select * from member";
	 * 
	 * try { conn = ds.getConnection(); //접속
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery(); //실행
	 * 
	 * if(rs.next()) { memberDTO = new MemberDTO();
	 * memberDTO.setName(rs.getString("name")); memberDTO.setId(rs.getString("id"));
	 * memberDTO.setPwd(rs.getString("pwd"));
	 * memberDTO.setGender(rs.getString("gender"));
	 * memberDTO.setEmail1(rs.getString("email1"));
	 * memberDTO.setEmail2(rs.getString("email2"));
	 * memberDTO.setTel1(rs.getString("tel1"));
	 * memberDTO.setTel2(rs.getString("tel2"));
	 * memberDTO.setTel3(rs.getString("tel3"));
	 * memberDTO.setZipcode(rs.getString("zipcode"));
	 * memberDTO.setAddr1(rs.getString("addr1"));
	 * memberDTO.setAddr2(rs.getString("addr2")); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * if(rs!=null) rs.close(); if(pstmt!=null) pstmt.close(); if(conn!=null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return memberDTO; }
	 */
	public void update(MemberDTO memberDTO) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("memberSQL.update", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/*
	 * public void update(MemberDTO memberDTO) { String sql =
	 * "update member set name=?" + ",pwd=?" + ",gender=?" + ",email1=?" +
	 * ",email2=?" + ",tel1=?" + ",tel2=?" + ",tel3=?" + ",zipcode=?" + ",addr1=?" +
	 * ",addr2=?" + ",logtime=sysdate where id=?";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, memberDTO.getName());
	 * pstmt.setString(2, memberDTO.getPwd()); pstmt.setString(3,
	 * memberDTO.getGender()); pstmt.setString(4, memberDTO.getEmail1());
	 * pstmt.setString(5, memberDTO.getEmail2()); pstmt.setString(6,
	 * memberDTO.getTel1()); pstmt.setString(7, memberDTO.getTel2());
	 * pstmt.setString(8, memberDTO.getTel3()); pstmt.setString(9,
	 * memberDTO.getZipcode()); pstmt.setString(10, memberDTO.getAddr1());
	 * pstmt.setString(11, memberDTO.getAddr2()); pstmt.setString(12,
	 * memberDTO.getId());
	 * 
	 * pstmt.executeUpdate();//실행
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
	 * if(pstmt!=null) pstmt.close(); if(conn!=null) conn.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } } }
	 */
}

















