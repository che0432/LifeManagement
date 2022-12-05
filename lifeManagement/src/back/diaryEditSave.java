package back;

import db.diaryModel;
import db.lifeDAO;

public class diaryEditSave {
	diaryModel dm = new diaryModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public diaryEditSave(String a, String b, String c, int d) {
		try{
			dm.setTitle(a);
			dm.setDiaryContents(b);
			dm.setDiaryDate(c);
			dm.setDiary_no(d);
			ldao.diaryUpdate(dm); //lifeDAO.diaryUpdate()
		}catch(Exception ex){System.out.println("diaryEditSave.java 수정에러 " + ex);}
	}
}