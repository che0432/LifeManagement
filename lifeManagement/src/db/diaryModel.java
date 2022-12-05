package db;

public class diaryModel {
	int diary_no;
	String title, diaryContents;
	String diaryDate;
	
	public diaryModel(){
	}
	
	//읽기 함수에서 사용 하는 ArrayList
	public diaryModel(int diary_no, String title, String diaryContents, String diaryDate) {
        this.diary_no = diary_no;
        this.title = title;
        this.diaryContents = diaryContents;
        this.diaryDate = diaryDate;
    }

	//getter&setter
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

	public String getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}

	public int getDiary_no() {
		return diary_no;
	}

	public void setDiary_no(int diary_no) {
		this.diary_no = diary_no;
	}
}
