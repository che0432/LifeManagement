# LifeManagement
자바 일상관리 애플리케이션 구현  
To-do List, Memo, Diary  

사용 언어: Java, swing  
DB: MySQL  
IDE: 이클립스  
개발 플랫폼: 윈도우  
--memo는 txt파일 저장으로 구현 예정

# 기능
-캘린더  
-오늘 날짜 표시  
-투두리스트 목록  
-투두리스트 생성  
-투두리스트 수정  
-투두리스트 삭제  
-투두리스트 체크박스 표시 시 완료 탭으로 옮겨감 (구현 예정)

-메모 작성  
-메모 수정  

-일기 목록  
-일기 작성  
-일기 수정  
-일기 삭제

# front 
Main.java - JFrame 컨테이너 제작/실행 파일  
tapMenu.java - 사이드메뉴바와 기타 공통 요소를 묶어둔 JPanel  
todoList.java - todo, 캘린더를 담은 JPanel  
calendar.java - 캘린더 구현  
DateLabelFormatter.java - JDatePicker 사용을 위해 구현  
diaryList.java - 일기 JPanel  
toTable.java - 할 일 목록 Tap에 들어갈 테이블  
doTable.java - 완료 목록 Tap에 들어갈 테이블  
diaryTable.java - (DB 연결 예정) 일기 목록 테이블  
diaryWrite.java - 일기 입력 페이지 
diaryDetail.java - 일기 상세 페이지  
diaryEdit.java - 일기 수정 페이지  
memo.java - 메모 JFrame

# back  
todoWriteSave.java - todo 항목 추가  
todoEditSave.java - todo 내용 수정  
todoDeleteSave.java - todo 항목 삭제  
todoCheck.java - todo 상태 변경(true, false)
diaryWriteSave.java - diary 항목 추가  
diaryEditSave.java - diary 내용 수정(제목, 내용, 날짜)  

# db  
lifeDAO.java - DB 연결, 쿼리문 전달(Create, Detail, Select, delete)  
diaryModel.java - diary테이블 getter&setter 값 가져오고 변경하기  
todoModel.java - todo테이블 getter&setter 값 가져오고 변경하기
