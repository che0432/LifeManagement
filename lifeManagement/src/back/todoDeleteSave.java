package back;

import db.lifeDAO;
import db.todoModel;

public class todoDeleteSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	public todoDeleteSave(int todoNo) {
		try{
			ldao.msg = "DELETE FROM todo WHERE todo_no = " + todoNo;
			ldao.ST = ldao.CN.createStatement();
			ldao.ST.executeUpdate(ldao.msg);
			System.out.println("삭제처리 성공");
		}catch(Exception ex){System.out.println(ex); }
	}
}
