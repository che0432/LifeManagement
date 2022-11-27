package back;

import db.lifeDAO;
import db.todoModel;

public class todoEditSave {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	public todoEditSave(String a, int b){
		
		try{
			ldao.msg = "UPDATE todo SET todoContents=? WHERE todo_no=?";
			ldao.PST = ldao.CN.prepareStatement(ldao.msg);
			ldao.PST.setString(1, a);
			ldao.PST.setInt(2, b);
				
			ldao.PST.executeUpdate();
				System.out.println(" 수정  성공했습니다 "); 
			 }catch(Exception ex){System.out.println("todoEditSave.java 수정에러 " + ex);}
	}
}
