# LifeManagement
자바 일상관리 애플리케이션 구현  
To-do List, Memo, Diary  
DB없이 JSON 파일로 읽기 쓰기 구현 예정  

사용 언어: Java, swing  
IDE: 이클립스  
개발 플랫폼: 윈도우

# 기능
-캘린더  
-오늘 날짜 표시  
-투두리스트 목록  
-투두리스트 생성  
-투두리스트 수정  
-투두리스트 삭제  
-투두리스트 체크박스 표시 시 완료 탭으로 옮겨감

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
diaryList.java - 일기 JPanel  
toTable.java - (DB 연결 예정) 할 일 목록 Tap에 들어갈 테이블  
doTable.java - (DB 연결 예정) 완료 목록 Tap에 들어갈 테이블  
diaryTable.java - (DB 연결 예정) 일기 목록 테이블  
diaryDetail.java - (구현 예정) 일기 상세 페이지  
diaryEdit.java - (구현 예정) 일기 수정 페이지  
memo.java - (memo.text 파일 읽기 함수 구현 필요) 메모 페이지

# back
--추가 예정  
todoWriteSave.java - todo 항목 추가  
todoEditSave.java - todo 내용 수정(체크박스, 내용, 날짜)  
diaryWriteSave.java - (구현 예정) diary 항목 추가  
diaryEditSave.java - diary 내용 수정(제목, 내용, 날짜)  
memoSave.java - (구현 예정) memo.txt 파일 수정

#db
lifeDAO.java - DB 연결, 쿼리문 전달(Create, Detail, Select, delete)  
lifeDTO.java - getter&setter 값 가져오고 변경하기
