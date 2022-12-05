package back;

import db.lifeDAO;
import db.todoModel;

public class todoCheck {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public todoCheck(boolean a,int b){
		try{
			tm.setTodoCheck(a);
			tm.setTodo_no(b);
			ldao.todoCheck(tm); //lifeDAO.todoCheck()
		}catch(Exception ex){System.out.println("todoCheck.java 수정에러 " + ex);}
	}
}