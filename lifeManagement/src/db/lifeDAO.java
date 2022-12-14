package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import front.todoList;

public class lifeDAO {
	public Connection CN = null ;
	public Statement ST  = null ;
	public PreparedStatement PST = null;
	public ResultSet RS = null ;
	
	public int todo_no, diary_no;
	public String todoContents, title, diaryContents;
	String todoDate, diaryDate;
	public boolean todoCheck;
	
	public String msg = "";
	
	//todo 생성 함수
	public void todoCreate(todoModel tm){
		try {
			CN = new DBConnect().getCN();
			
			msg = "INSERT INTO todo(todoContents, todoDate) VALUES(?,?)";
			PST = CN.prepareStatement(msg);
				PST.setString(1, tm.getTodoContents());
			   	PST.setString(2, tm.getTodoDate());
		   	PST.executeUpdate();
		   	System.out.println("todoCreate((todoModel)저장성공");
		}catch(Exception ex){System.out.println(ex); }
		finally{
			 try {
					if(PST!=null)PST.close();
					if(CN!=null)CN.close();
			   } catch (Exception e2) {
				   e2.printStackTrace();
			   }
		}
	}
	
	//diary 생성 함수
	public void diaryCreate(diaryModel dm){
		try {
			CN = new DBConnect().getCN();
			
			msg = "INSERT INTO diary(title, diaryContents, diaryDate) VALUES(?,?,?)";
			PST = CN.prepareStatement(msg);
				PST.setString(1, dm.getTitle());
				PST.setString(2, dm.getDiaryContents());
			   	PST.setString(3, dm.getDiaryDate());
		   	PST.executeUpdate();
		   	System.out.println("diaryCreate(diaryModel)저장성공");
		   	System.out.println(PST.executeUpdate());
		}catch(Exception ex){System.out.println(ex); }
		finally{
			 try {
					if(PST!=null)PST.close();
					if(CN!=null)CN.close();
			   } catch (Exception e2) {
				   e2.printStackTrace();
			   }
		}
	}
	
	//todo의 현재 날짜 할 일 항목 읽기 함수(할 일 탭)
	public ArrayList<todoModel> readTo(){
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		try{
			CN = new DBConnect().getCN();
		
			String whereDate = "DATE(todoDate) = \'" + todoList.todoPickDate + "\'";
			msg = "SELECT todo_no, todoCheck, todoContents, todoDate FROM todo WHERE todoCheck = 0 && " + whereDate
				+ "ORDER BY todo_no asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new todoModel(RS.getInt(1), RS.getBoolean(2), RS.getString(3), RS.getString(4)));
			}
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//todo의 현재 날짜 완료 항목 읽기 함수(완료 탭)
	public ArrayList<todoModel> readDo(){
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		try{
			CN = new DBConnect().getCN();
			
			String whereDate = "DATE(todoDate) = \'" + todoList.todoPickDate + "\'";
			msg = "SELECT todo_no, todoCheck, todoContents, todoDate FROM todo WHERE todoCheck = 1 && " + whereDate
				+ "ORDER BY todo_no asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new todoModel(RS.getInt(1), RS.getBoolean(2), RS.getString(3), RS.getString(4)));
			}
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//todo의 toTable 날짜로 항목 읽기 함수(할 일 탭)
	public ArrayList<todoModel> readTo(String Date){
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		try{
			CN = new DBConnect().getCN();
			
			String whereDate = " DATE(todoDate) = \'" + Date + "\'";
			msg = "SELECT todo_no, todoCheck, todoContents, todoDate FROM todo WHERE todoCheck = 0 && "  + whereDate
				+ "ORDER BY todo_no asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new todoModel(RS.getInt(1), RS.getBoolean(2), RS.getString(3), RS.getString(4)));
			}
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//todo의 doTable 날짜로 항목 읽기 함수(완료 탭)
	public ArrayList<todoModel> readDo(String Date){
		ArrayList<todoModel> arr = new ArrayList<todoModel>();
		try{
			CN = new DBConnect().getCN();
			
			String whereDate = " DATE(todoDate) = \'" + Date + "\'";
			msg = "SELECT todo_no, todoCheck, todoContents, todoDate FROM todo WHERE todoCheck = 1 &&" + whereDate
				+ "ORDER BY todo_no asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new todoModel(RS.getInt(1), RS.getBoolean(2), RS.getString(3), RS.getString(4)));
			}
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//diary 날짜 모든 항목 읽기 함수
	public ArrayList<diaryModel> readDiary(){
		ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
		try{
			CN = new DBConnect().getCN();
			
			msg = "SELECT diary_no, title, diaryContents, diaryDate FROM diary " 
				+ "ORDER BY diaryDate asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new diaryModel(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4)));
			}
			
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//diary 날짜로 항목 읽기 함수
	public ArrayList<diaryModel> readDiary(int year, int month){
		ArrayList<diaryModel> arr = new ArrayList<diaryModel>();
		try{
			CN = new DBConnect().getCN();
			int endDay = 0;
				
			//달(month)에 따라 마지막 날짜를 조정
			switch (month) {
				case 1: endDay = 31; break;		
				case 2:
					if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 )
						endDay = 29;
					else
						endDay = 28;
					break;
				case 3: endDay = 31; break;
				case 4: endDay = 30; break;
				case 5: endDay = 31; break;
				case 6: endDay = 30; break;
				case 7: 
				case 8: endDay = 31; break;
				case 9: endDay = 30; break;
				case 10: endDay = 31; break;
				case 11: endDay = 30; break;
				case 12: endDay = 31; break;
				default: break;
			}
			
			String whereDate = "WHERE DATE(diaryDate) between \'" + year + "-" + month + "-01\' and \'" 
					+ year + "-" + month + "-" + endDay  + "\' ";
			msg = "SELECT diary_no, title, diaryContents, diaryDate FROM diary " + whereDate
				+ "ORDER BY diaryDate asc";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			while (RS.next()==true) {
                arr.add(new diaryModel(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4)));
			}
			
		}catch(Exception e){System.out.println("출력연결에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
	}
	
	//diary 상세 읽기 함수
	public diaryModel readDiaryDetail(String diaryDate){
		diaryModel dm = new diaryModel();
		try{
			CN = new DBConnect().getCN();
			msg = "SELECT * FROM diary where DATE(diaryDate) = \'" + diaryDate + "\'"; 
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			if (RS.next()==true) {
                dm.setDiary_no(RS.getInt("diary_no"));
                dm.setTitle(RS.getString("title"));
                dm.setDiaryContents(RS.getString("diaryContents"));
                dm.setDiaryDate(RS.getString("diaryDate"));
			}
			
		}catch(Exception e){System.out.println("일기 상세 에러 " + e);
		}finally {
            try {
            	if(RS!=null)RS.close();
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return dm;
	}
	
	//todo 수정 함수
	public void todoUpdate(todoModel tm){
		try {
			CN = new DBConnect().getCN();
			
			msg = "UPDATE todo SET todoContents=? WHERE todo_no=?";
			PST = CN.prepareStatement(msg);
				PST.setString(1, tm.getTodoContents());
				PST.setInt(2, tm.getTodo_no());
		   	PST.executeUpdate();
		   	System.out.println("todoUpdate(todoModel)수정성공");
		   	System.out.println(PST.executeUpdate());
		}catch(Exception ex){System.out.println(ex); }
		finally{
			 try {
					if(PST!=null)PST.close();
					if(CN!=null)CN.close();
			   } catch (Exception e2) {
				   e2.printStackTrace();
			   }
		}
	}
	
	//todo 완료 상태 수정 함수
	public void todoCheck(todoModel tm){
		try {
			CN = new DBConnect().getCN();
			
			msg = "UPDATE todo SET todoCheck=? WHERE todo_no=?";
			PST = CN.prepareStatement(msg);
				PST.setBoolean(1, tm.isTodoCheck());
				PST.setInt(2, tm.getTodo_no());
		   	PST.executeUpdate();
		   	System.out.println("todoCheck(todoModel)수정성공");
		   	System.out.println(PST.executeUpdate());
		}catch(Exception ex){System.out.println(ex); }
		finally{
			 try {
					if(PST!=null)PST.close();
					if(CN!=null)CN.close();
			   } catch (Exception e2) {
				   e2.printStackTrace();
			   }
		}
	}
	
	//diary 수정 함수
	public void diaryUpdate(diaryModel dm){
		try {
			CN = new DBConnect().getCN();
			
			msg = "UPDATE diary SET title=?, diaryContents=?, diaryDate=? WHERE diary_no=?";
			PST = CN.prepareStatement(msg);
				PST.setString(1, dm.getTitle());
				PST.setString(2, dm.getDiaryContents());
				PST.setString(3, dm.getDiaryDate());
			   	PST.setInt(4, dm.getDiary_no());
		   	PST.executeUpdate();
		   	System.out.println("diaryUpdate(diaryModel)수정성공");
		   	System.out.println(PST.executeUpdate());
		}catch(Exception ex){System.out.println(ex); }
		finally{
			 try {
					if(PST!=null)PST.close();
					if(CN!=null)CN.close();
			   } catch (Exception e2) {
				   e2.printStackTrace();
			   }
		}
	}
	
	//todo 삭제 함수
	public void todoDelete(todoModel tm){
		try{
			CN = new DBConnect().getCN();
			msg = "DELETE FROM todo WHERE todo_no = " + tm.getTodo_no();
			ST = CN.createStatement();
			ST.executeUpdate(msg);
			System.out.println("todo 삭제처리 성공");
		}catch(Exception ex){System.out.println(ex); }
		finally {
            try {
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	
	//diary 삭제 함수
	public void diaryDelete(String diaryDate){
		try{
			CN = new DBConnect().getCN();
			msg = "DELETE FROM diary where DATE(diaryDate) = \'" + diaryDate + "\'";
			ST = CN.createStatement();
			ST.executeUpdate(msg);
			System.out.println("diary 삭제처리 성공");
		}catch(Exception ex){System.out.println(ex); }
		finally {
            try {
            	if(ST!=null)ST.close();
            	if(CN!=null)CN.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}