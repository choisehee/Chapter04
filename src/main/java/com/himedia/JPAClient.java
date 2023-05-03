package com.himedia;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.himedia.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			// Transaction 시작
			tx.begin();
			
			//글등록을 위한거 Board클래스에 테이블 확인할거 테이블 비활성 상태에서는 Board테이블에 있던게 다 지워짐
//	         Board board=new Board();
//	         board.setTitle("JPA제목4");
//	         board.setWriter("관리자");
//	         board.setContent("글 등록");
//	         board.setCreateDate(new Date());
//	         board.setCnt(1L);


			// 수정할 게시글 조회
//			Board board = em.find(Board.class, 1L);
//			board.setTitle("검색한 게시글의 제목 수정");
		
	        //글등록
//	        em.persist(board);
			// Transaction commit
//			tx.commit();	
			
			//상세조회
			 Board searchBoard=em.find(Board.class,1L); //첫번째 줄
	         System.out.println("--->"+searchBoard.toString());
	         Board searchBoard2=em.find(Board.class,2L);
	         System.out.println("--->"+searchBoard2.toString());

		} catch (Exception e) {
			e.printStackTrace();			
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}		
	}
}
