package db;

public class todoModel {
	int todo_no;
	String todoContents;
	String todoDate;
	boolean todoCheck;
	
	public todoModel(){
	}
	
	//읽기 함수에서 사용 하는 ArrayList
	public todoModel(int todo_no, boolean todoCheck, String todoContents, String todoDate) {
        this.todo_no = todo_no;
        this.todoCheck = todoCheck;
        this.todoContents = todoContents;
        this.todoDate = todoDate;
    }
	
	//getter&setter
	public String getTodoContents() {
		return todoContents;
	}

	public void setTodoContents(String todoContents) {
		this.todoContents = todoContents;
	}

	public String getTodoDate() {
		return todoDate;
	}

	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}

	public boolean isTodoCheck() {
		return todoCheck;
	}

	public void setTodoCheck(boolean todoCheck) {
		this.todoCheck = todoCheck;
	}

	public void setTodo_no(int todo_no) {
		this.todo_no = todo_no;
	}

	public int getTodo_no() {
		return todo_no;
	}
}