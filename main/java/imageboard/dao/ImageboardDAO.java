package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public static ImageboardDAO getInstance() {
		synchronized (ImageboardDAO.class) {
			if (instance == null) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<ImageboardDTO> getImageboardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.getImageboardList", map);
		sqlSession.close();
		System.out.println(list);
		return list;
	}
	public int getTotalA() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int totalA=sqlSession.selectOne("imageboardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	
}
