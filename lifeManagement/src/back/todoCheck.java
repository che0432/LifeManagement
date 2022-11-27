package back;

import db.lifeDAO;
import db.todoModel;

public class todoCheck {
	todoModel tm = new todoModel();
	lifeDAO ldao = new lifeDAO();
	
	public todoCheck(boolean a,int b){
		
		try{
			ldao.msg = "UPDATE todo SET todoCheck=? WHERE todo_no=?";
			ldao.PST = ldao.CN.prepareStatement(ldao.msg);
			ldao.PST.setBoolean(1, a);
			ldao.PST.setInt(2, b);
				
			ldao.PST.executeUpdate();
				System.out.println(" check변경  성공했습니다 "); 
			 }catch(Exception ex){System.out.println("todoCheck.java 수정에러 " + ex);}
	}
}
