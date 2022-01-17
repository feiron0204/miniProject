package guestbook.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static GuestbookDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static GuestbookDAO getInstance() {
		synchronized (GuestbookDAO.class) {
			if (instance == null) {
				instance = new GuestbookDAO();
			}
		}

		return instance;
	}

	public GuestbookDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void guestbookWrite(GuestbookDTO guestbookDTO) {
		SqlSession session=sqlSessionFactory.openSession();
		session.insert("guestbookSQL.guestbookWrite", guestbookDTO);
		session.commit();
		session.close();
	}

	public List<GuestbookDTO> getGuestbookList(Map<String, Integer> map) {
		SqlSession session=sqlSessionFactory.openSession();
		List<GuestbookDTO> list=session.selectList("guestbookSQL.getGuestbookList",map);
		session.close();
		return list;
	}

	public int getTotalA() {
		SqlSession session=sqlSessionFactory.openSession();
		int totalA=session.selectOne("guestbookSQL.getTotalA");
		session.close();
		return totalA;
	}

	

}
