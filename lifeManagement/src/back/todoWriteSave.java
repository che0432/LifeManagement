package back;

import db.lifeDAO;
import db.todoModel;

public class todoWriteSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public todoWriteSave(String a, String b){
		try{
			tm.setTodoContents(a);
			tm.setTodoDate(b);
			ldao.todoCreate(tm); //lifeDAO.todoCreate()
		}catch(Exception ex){
			System.out.println("todoWriteSave.java 저장에러 " + ex);
		};
	}
}