## Safe Food REST Release

 Safe Food 게시판의 CRUD 기능의 REST API 입니다.

 제가 담당하였습니다.

### 사용된 기술

- 백엔드: **Spring** Boot 와 Legacy
- DB: **MyBatis**를 사용한 **CRUD**

### 프로젝트 상세 기술

- GET : selectAll, select(id), pageSelect(page),  selectByTitle(title),  selectByContent(content),  selectByWriter(wirter)
- POST :  insert(Board)
- PUT :  update(id, Board), hitUp(id)
- DELETE :  delete(id)

