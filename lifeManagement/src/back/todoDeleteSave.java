package back;

import db.lifeDAO;
import db.todoModel;

public class todoDeleteSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public todoDeleteSave(int todoNo) {
		try{
			tm.setTodo_no(todoNo);
			ldao.todoDelete(tm); //lifeDAO.todoDelete()
		}catch(Exception ex){System.out.println("todoDeleteSave.java 수정에러 " + ex); }
	}
}