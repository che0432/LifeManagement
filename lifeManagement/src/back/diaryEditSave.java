package back;

import db.diaryModel;
import db.lifeDAO;

public class diaryEditSave {
	diaryModel dm = new diaryModel();
	lifeDAO ldao = new lifeDAO();
	public diaryEditSave(String a, String b, String c, int d) {
		try{
			ldao.msg = "UPDATE diary SET title=?, diaryContents=?, diaryDate=? WHERE diary_no=?";
			ldao.PST = ldao.CN.prepareStatement(ldao.msg);
			ldao.PST.setString(1, a);
			ldao.PST.setString(2, b);
			ldao.PST.setString(3, c);
			ldao.PST.setInt(4, d);
				
			ldao.PST.executeUpdate();
				System.out.println(" 수정  성공했습니다"); 
			 }catch(Exception ex){System.out.println("diaryEditSave.jsp 수정에러 " + ex);}
	}
}
