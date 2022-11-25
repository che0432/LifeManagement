package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class lifeDAO {
	Connection CN = null ;
	Statement ST  = null ;
	PreparedStatement PST = null;
	ResultSet RS = null ;
	
	int todo_no, diary_no;
	String todoContents, title, diaryContents;
	String todoDate, diaryDate;
	boolean check;
	
	String msg = "";
	

	//DB연결
	public lifeDAO(){
		String url = "jdbc:mysql://localhost:3306/lifeManagement?serverTimezone=UTC";
		String user = "root";
		String password = "Lifemanagement1234!";
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		System.out.println("lifeDAO() 기본 생성자");
		try {
			// ① 로드
			Class.forName(driverName);
			// ② 연결
			CN = DriverManager.getConnection(url, user, password);
			System.out.println("[연결 성공]");
		} catch (ClassNotFoundException e) {
			// `com.mysql.cj.jdbc.Driver` 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[연결 오류]\n" + e.getStackTrace());
		}
	}
	
	//todo 생성 함수
	public void todoCreate(lifeDTO ldto){
		try {
			msg = "INSERT INTO todo(todoContents, todoDate) VALUES(?,?)";
			PST = CN.prepareStatement(msg);
				PST.setString(1, ldto.getTodoContents());
			   	PST.setString(2, ldto.getTodoDate());
		   	PST.executeUpdate();
		   	System.out.println("todoCreate(lideDTO)저장성공");
		}catch(Exception ex){System.out.println(ex); }
	}
	
	//diary 생성 함수
	public void diaryCreate(lifeDTO ldto){
		try {
			//diary 날짜 중복 체크 함수 구현 필요
			msg = "INSERT INTO diary(title, diaryContents, diaryDate) VALUES(?,?,?)";
			PST = CN.prepareStatement(msg);
				PST.setString(1, ldto.getTitle());
				PST.setString(2, ldto.getDiaryContents());
			   	PST.setString(3, ldto.getDiaryDate());
		   	PST.executeUpdate();
		   	System.out.println("diaryCreate(lideDTO)저장성공");
		   	System.out.println(PST.executeUpdate());
		}catch(Exception ex){System.out.println(ex); }
	}
	
	
	
	//todo 삭제 함수
	public void todoDelete(String data){
		try{
			msg = "DELETE FROM todo WHERE todo_no = " + data;
			ST = CN.createStatement();
			ST.executeUpdate(msg);
			System.out.println("삭제처리 성공");
		}catch(Exception ex){System.out.println(ex); }
	}
	
	//diary 삭제 함수
	public void diaryDelete(String data){
		try{
			msg = "DELETE FROM diary WHERE diary_no = " + data;
			ST = CN.createStatement();
			ST.executeUpdate(msg);
			System.out.println("삭제처리 성공");
		}catch(Exception ex){System.out.println(ex); }
	}
}