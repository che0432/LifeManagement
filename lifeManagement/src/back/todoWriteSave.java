package back;

import db.lifeDAO;
import db.todoModel;

public class todoWriteSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	public todoWriteSave(String a, String b){

		try{
			tm.setTodoContents(a);
			tm.setTodoDate(b);
			ldao.todoCreate(tm); //lifeDAO.java자바문서
		}catch(Exception ex){
			System.out.println("todoWriteSave.java 저장에러 " + ex);
			//입력창 닫기 구현 필요
		};
	}
}
