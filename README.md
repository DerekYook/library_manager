# 도서 관리 API 제작

## Index
- [Overview](#overview)
- [Getting Started](#getting-started)
- [Documentation](#documentation)
- [Testing](#testing)
- [Authors](#authors)
- [License](#license)

## About Project
이 프로젝트는 도서 대출 관리 API제작 프로젝트 입니다.

## Overview
- Object : 도서 관리용 프로젝트
- Language : Java 11
- FrameWork : Sping Boot 2.7.11
- Service : REST API
- Databese : H2
- Additional Tool : Query DSL 5.0.0
- DevTool : IntelliJ, 


## Getting Started
### 사용자 요구사항
1. 사용자 등록
- 하나의 도서관에는 동일한 사용자명 + 휴대전화번호는 존재할 수 없다.
- 하나의 도서관에는 동일한 사용자명 + 휴대전화번호는 유일해야 하지만 동일한 사용자명 + 휴대전화번호로 다른 도서관에서는 등록할 수 있다.
2. 사용자 삭제
- 사용자가 대출중인 책이 있을 경우 삭제 할 수 없다.
- 사용자를 삭제하면 사용자의 대출 기록도 모두 삭제해야 한다.
3. 도서 대출
- 사용자의 대출 히스토리를 저장해야 한다.
- 도서의 기본 대출 기간은 14일이다.
- 사용자가 대출 가능한지 여부를 반단해서 대출을 해야 한다.
- 제한사항
  <p>(1) 대출은 5권 까지 가능
  <p>(2) 도서관 별로 5권 까지 가능
  <p>(3) 도서관 별로 연체 중인 책이 1권이라도 있으면 책 추가 대출 불가능
  <p>(4) 연체된 일수 동안 대출 불가능
  <p>(예시 : 5월 5일 기준 연체 3일(반납 마감일 5월 2일)인 책을 반납 => 5월 8일부터 대출 가능)
4. 도서 반납
- 도서가 반납되면 사용자의 대출목록에서 없어져야 한다.
- 반납된 도서는 대출 가능하여야 한다.
- 도서 반납 시 연체일수를 확인해야 한다.
5. 사용자의 대출 히스토리 조회
- 사용자의 대출 기록은 조회가 가능해야 한다.
- 대출 기록 조회 기간은 회원 정보가 유지되는 기간과 동일해야 한다.
6. 도서 검색
- 도서 조회 항목은 책 제목, 저자, 출판사로 하며 기본 정렬은 오름차순으로 한다.
- 도서 목록은 페이징 처리하며 페이징 갯수는 10개로 한다.
    
## Documentation
<a href="https://drive.google.com/drive/folders/1ADAvIToiEl6eJv-lHRXVnPVXkr9qCVKR?usp=sharing" target="_blank">GoogleDrive</a>
    
## Testing
Postman과 Swagger를 이용한 테스트 진행 및 API 문서 작성

## Authors
- [DerekYook](https://github.com/DerekYook) - KyungDeuk Yook (wowykd@gmail.com)

## License

© 2022. Codestates All rights reserved.
