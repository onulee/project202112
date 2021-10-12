package com.site.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex.dto.BoardDto;

public class BoardDao {

	private Context context=null;  // context에서 context객체 가져오는 오브젝트
	private DataSource ds=null;    // DataSource연결 오브젝트
	private Connection conn=null;  // db연결 오브젝트
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private int result=0;          // 결과값을 리턴하는 변수
	private String sql="";
	private ArrayList<BoardDto> list=null;
	private BoardDto bDto=null;
	private int bid,bhit,bgroup,bstep,bindent;
	private String bname,btitle,bcontent,bupload;
	private Timestamp bdate;
	
	//게시글 저장
	public void insertBoardWrite(String ch_bname, String ch_btitle, String ch_bcontent) {

		System.out.println("dao : "+ch_bname);
		try {
			conn = getConnection();
			sql="insert into board values(b_seq.nextval,"
					+ "?,?,?,sysdate,0,b_seq.currval,0,0,'1.jpg')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ch_bname);
			pstmt.setString(2, ch_btitle);
			pstmt.setString(3, ch_bcontent);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//insertBoardWrite
	
	
	// bid 게시글 조회수 1증가
	public void updateBhit(int ch_bid) {
		try {
			conn = getConnection();
			sql="update board set bhit=bhit+1 where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ch_bid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//updateBhit
	
	
	// 1개 게시글 가져오기
	public BoardDto selectBoardView(int ch_bid) {
		try {
			conn = getConnection();
			sql="select * from board where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ch_bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bupload = rs.getString("bupload");
				bDto = new BoardDto(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent,bupload);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bDto;
	}//selectBoardView
	
	
	//전체 게시글 가져오기
	public ArrayList<BoardDto> selectBoardList(){
		list = new ArrayList<BoardDto>();
		
		try {
			//connection객체 가져오기
			conn = getConnection();
			sql = "select * from board order by bid desc";
			pstmt = conn.prepareStatement(sql);
			// board의 모든 정보를 가져옴.
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bid = rs.getInt("bid");
				bname = rs.getString("bname");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bdate = rs.getTimestamp("bdate");
				bhit = rs.getInt("bhit");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bupload = rs.getString("bupload");
				//ArrayList에 추가
				list.add(new BoardDto(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent,bupload));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//selectBoardList
	
	
	
	// 커넥션 객체 1개 가져오기
	public Connection getConnection() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}// getConnection


	

}
