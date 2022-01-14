package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static BoardDAO getInstance() {
		synchronized (BoardDAO.class) {
			if (instance == null) {
				instance = new BoardDAO();
			}
		}

		return instance;
	}

	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<BoardDTO> list=sqlSession.selectList("boardSQL.getBoardList", map);
		sqlSession.close();
		return list;
	}

	public BoardDTO selectOne(int seq) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		BoardDTO boardDTO=sqlSession.selectOne("boardSQL.getBoardView",seq);
		sqlSession.close();
		return boardDTO;
	}
	
	public int getTotalA() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int totalA=sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}

	public int boardModify(BoardDTO boardDTO) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int result=sqlSession.update("boardSQL.boardModify",boardDTO);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
