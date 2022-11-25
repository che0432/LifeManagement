package back;

import db.lifeDAO;
import db.lifeDTO;

public class diaryWriteSave {
	lifeDTO ldto = new lifeDTO();
	lifeDAO ldao = new lifeDAO();
	
	public diaryWriteSave(String a, String b, String c){
		
		try{
			ldto.setTitle(a);
			ldto.setDiaryContents(b);
			ldto.setDiaryDate(c);
			ldao.todoCreate(ldto); //lifeDAO.java자바문서
		}catch(Exception ex){
			System.out.println("diaryWriteSave.java 저장에러 " + ex);
			//입력창 닫기 구현 필요
		};
	}
}
