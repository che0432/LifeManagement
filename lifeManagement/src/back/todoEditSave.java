package back;

import db.lifeDAO;
import db.todoModel;

public class todoEditSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public todoEditSave(String a, int b){
		try{
			tm.setTodoContents(a);
			tm.setTodo_no(b);
			ldao.todoUpdate(tm); //lifeDAO.todoUpdate()
		}catch(Exception ex){System.out.println("todoEditSave.java 수정에러 " + ex);}
	}
}