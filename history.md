#프로젝트 변경내역을 기록하는 파일입니다.

###2021년 1월 12일
1. 검색 전에 모든 사용자의 정보를 보여주는 것에서 아무 데이터도 보여주지 않게 변경했습니다.

2. 기존에 모든 사용자의 데이터를 불러오는 API의 URI를 /api/get-list에서 /api/user/get-list로 변경했습니다.

3. UserApiController에 새롭게 searchByName(User user) 메소드를 추가했습니다. user.getName()으로 검색한 이름 정보를 꺼낼 수 있으며, 이를 이용해 DB에서 해당 이름을 가진 사용자의 정보를 리스트의 형태로 반환합니다. URI는 /api/user/search입니다.
4. user.html에서 ajax를 이용해 이 URI로 요청을 보내 리스트를 받고, grid의 resetData() 메소드에 리스트를 넣어 그리드에 정보를 표시하는 방식입니다.

5. 검색버튼을 누르면 페이지가 새로고침되어 검색내용이 초기화되는 현상이 발생했습니다. 이를 해결하기 위해 user.html의 search-form을 제거하고, 검색 버튼의 타입을 button, onclick에 go_search() 함수를 넣었습니다.
