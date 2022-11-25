package back;

import db.lifeDAO;
import db.lifeDTO;

public class todoWriteSave {
	lifeDTO ldto = new lifeDTO();
	lifeDAO ldao = new lifeDAO();
	
	public todoWriteSave(String a, String b){

		try{
			ldto.setTodoContents(a);
			ldto.setTodoDate(b);
			ldao.todoCreate(ldto); //lifeDAO.java자바문서
		}catch(Exception ex){
			System.out.println("todoWriteSave.java 저장에러 " + ex);
			//입력창 닫기 구현 필요
		};
	}
}
