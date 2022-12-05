package back;

import db.lifeDAO;
import db.diaryModel;

public class diaryWriteSave {
	diaryModel dm = new diaryModel();
	lifeDAO ldao = new lifeDAO();
	
	//입력 값 전달
	public diaryWriteSave(String a, String b, String c){
		try{
			dm.setTitle(a);
			dm.setDiaryContents(b);
			dm.setDiaryDate(c);
			ldao.diaryCreate(dm); //lifeDAO.diaryCreate()
		}catch(Exception ex){
			System.out.println("diaryWriteSave.java 저장에러 " + ex);
		};
	}
}