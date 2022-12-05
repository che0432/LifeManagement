package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection CN;
	
	//DB연결
	public DBConnect(){
		String url = "jdbc:mysql://localhost:3306/lifeManagement?serverTimezone=UTC";
		String user = "root";
		String password = "Lifemanagement1234!";
		String driverName = "com.mysql.cj.jdbc.Driver";
		try {
			// ① 로드
			Class.forName(driverName);
			// ② 연결
			CN = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// 'com.mysql.cj.jdbc.Driver' 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[연결 오류]\n" + e.getStackTrace());
		}
	}
	
	// Connection 객체의 참조값을 리턴
	public Connection getCN() {
		return CN;
	}
}