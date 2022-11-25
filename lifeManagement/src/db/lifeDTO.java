package db;

public class lifeDTO {
	int todo_no, diary_no;
	String todoContents, title, diaryContents;
	String todoDate, diaryDate;
	boolean check;
	
	public int getTodo_no() {
		return todo_no;
	}
	public void setTodo_no(int todo_no) {
		this.todo_no = todo_no;
	}
	public int getDiary_no() {
		return diary_no;
	}
	public void setDiary_no(int diary_no) {
		this.diary_no = diary_no;
	}
	public String getTodoContents() {
		return todoContents;
	}
	public void setTodoContents(String todoContents) {
		this.todoContents = todoContents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiaryContents() {
		return diaryContents;
	}
	public void setDiaryContents(String diaryContents) {
		this.diaryContents = diaryContents;
	}
	public String getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}
	public String getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
}
