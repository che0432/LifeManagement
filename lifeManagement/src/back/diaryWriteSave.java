package back;

import db.lifeDAO;
import db.diaryModel;

public class diaryWriteSave {
	diaryModel dm = new diaryModel();
	lifeDAO ldao = new lifeDAO();
	
	public diaryWriteSave(String a, String b, String c){
		
		try{
			dm.setTitle(a);
			dm.setDiaryContents(b);
			dm.setDiaryDate(c);
			ldao.diaryCreate(dm); //lifeDAO.java자바문서
		}catch(Exception ex){
			System.out.println("diaryWriteSave.java 저장에러 " + ex);
			//입력창 닫기 구현 필요
		};
	}
}
