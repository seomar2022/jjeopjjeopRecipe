# jjeopjjeopRecipeの紹介



# 概要

---

![팀프로젝트 역할분담](https://user-images.githubusercontent.com/96387509/187103328-3288ff52-5982-4b4a-8ca1-e06a535321c7.png)

<br>
<br>


###担当

<hr>

ソ・ジョンア・・・ショッピング

メンバー１・・・
コミュニティボード、総合検索、インデックス

メンバー２・・・
会員管理

メンバー３・・・
管理者機能

メンバー４・・・レシピ


<br>
<br>

### ERD
![파이널 프로젝트](https://user-images.githubusercontent.com/105467839/188069078-1b7e0755-9fef-4309-9451-e626806ac409.png)


<br>
<br>

### WBS
![image](https://user-images.githubusercontent.com/96387509/194100473-5a76aad5-233c-4465-8c0e-01ac86f52a4a.png)

<br>
<br>
### 技術

```
Backend: Java 11, Spring boot 2.7.2, Gradle, MyBatis, thymeleaf, Ajax
DB : Oracle 11.2
Front : HTML5, CSS, JavaScript, JQuery, Bootstrap
Tool : IntelliJ, VS Code, GitHub
```

<br>
<br>

# 機能の紹介

---

### 인덱스, 통합검색

```
처음 방문하면 나오는 페이지. 재료나 레시피 이름을 통해 레시피와 상품 통합검색으로 넘어갑니다. 페이지에는 스크랩 순, 판매량 순으로 정렬된 레시피와 상품을 볼 수 있고 더보기를 통해 각각 페이지에 들어갈 수 있습니다.
```

![image](https://user-images.githubusercontent.com/96387509/187108033-b7a94b25-0476-4ac4-a145-4c8223e9fe3f.png)

![image](https://user-images.githubusercontent.com/96387509/187108076-ddc30e07-4470-4e8e-a42f-4f8b62f43a47.png)

![totalsearch](https://user-images.githubusercontent.com/96387509/187107594-cc21a5a4-f2d1-46e9-9ca4-774d64b6236a.gif)

<br>
<br>
```
레시피를 작성하고, 다른 사람의 레시피를 볼 수 있는 레시피 게시판입니다.
레시피를 분류별로 열람할 수 있으며 작성일, 스크랩, 조회수를 기준으로 정렬하여 열람할 수 있습니다.
검색 페이지에서도 같은 기능이 제공됩니다.
레시피 본문 조회 페이지에서는 스크랩, 클립보드에 링크 복사, 신고, 덧글 작성 및 수정이 가능합니다.
레시피를 작성할 때에는 원하는 만큼 레시피 분류를 추가하거나 요리 단계를 추가할 수 있습니다.
```

- 레시피 index   
  ![list인덱스](https://user-images.githubusercontent.com/101542378/188267504-b63a69ff-1208-4186-9d6d-4a945050d3d7.png)
  <br>
  <br>

- 분류별 열람 / 정렬   
  <img src="https://user-images.githubusercontent.com/101542378/188267560-4b54d3a5-80ce-4644-b89a-60e11be7252b.gif" width="70%" />
  <br>
  <br>

- 검색   
  <img src="https://user-images.githubusercontent.com/101542378/188267631-e5c4c2dd-2000-484c-8883-312e3db0712c.gif" width="70%" />
  <br>
  <br>

- 레시피 작성   
  <img src="https://user-images.githubusercontent.com/101542378/188267637-7e34a73f-bf36-47c0-9d90-7003e913adff.gif" width="70%" />
  <br>
  <br>

- 본문    
  <img src="https://user-images.githubusercontent.com/101542378/188267645-bc750ab6-3ca2-4530-9fda-f58816ace965.gif" width="70%" />
  <br>
  <br>

- 레시피 덧글   
  <img src="https://user-images.githubusercontent.com/101542378/188267660-989c3016-9730-40a3-aeb2-492384d8fee2.gif" width="70%" />
  <br>
  <br>

---
### 쇼핑
```
농산물 판매글을 올리고, 농산물을 구매할 수 있는 쇼핑마당입니다. 
필터링(채소, 과일 등의 상품 종류)과 정렬(판매량, 리뷰평점 등) 기능이 있습니다.
상세화면에서 상품의 자세한 정보와 구매한 회원의 리뷰를 확인할 수 있으며, 수량을 선택해 장바구니에 넣거나 결제할 수 있습니다.
결제는 카카오페이를 통해 이뤄집니다. 
마이페이지에서 장바구니항목과 결제내역을 확인할 수 있습니다.
```
<br>
<br>

---
### 커뮤니티 게시판

```
자유글과 레시피 후기를 남길 수 있는 커뮤니티 게시판.
카테고리마다 글쓰기 양식이 다른 것이 이 게시판의 핵심 기능입니다.
그외에 상세검색, 좋아요, 댓글 기능이 있습니다.
```

- 게시판 index

  ![image](https://user-images.githubusercontent.com/96387509/187107964-d46ef565-df77-4bd7-96a7-0cff70a388fb.png)
  <br>
  <br>

- 게시판 글쓰기
  ![communityform](https://user-images.githubusercontent.com/96387509/187107512-dddabc56-4b8b-49b9-afda-9154eae8e982.gif)
  <br>
  <br>
- 상세검색
  ![communityformDetialSearch](https://user-images.githubusercontent.com/96387509/187107660-24b067df-7ccf-4bdc-a585-a469e451e97e.gif)
  <br>
  <br>
- 댓글
  ![communityComment](https://user-images.githubusercontent.com/96387509/187107765-746cbcf5-39e5-4a91-b9e6-064e630ba517.gif)

<br>
<br>

---
### 회원
```
레시피 작성 및 쇼핑 등 사이트를 이용하기 위해서는 회원가입이 필수입니다.
유효하지 않은 값을 기입한 경우 회원가입을 할 수 없습니다.
아이디/비밀번호 찾기를 통해 가입 시 기재한 아이디와 비밀번호를 찾을 수 있습니다.
DB에 저장된 아이디, 비밀번호와 동일한 값인 경우 로그인할 수 있습니다.
```
- 회원가입
  ![signup](https://user-images.githubusercontent.com/105467839/188056426-d89996c9-98be-4069-9598-38a1ae8957d1.gif)
- 아이디 찾기
  ![findId](https://user-images.githubusercontent.com/105467839/188068581-953f39fb-0cdd-4761-a251-cb702c2cf4b0.gif)
- 로그인
  ![login](https://user-images.githubusercontent.com/105467839/188068163-30beb130-daea-4312-80ad-d44533e21377.gif)

---
### 마이페이지
```
로그인 후 마이페이지에서 비밀번호를 비롯한 내 정보를 수정할 수 있습니다.
마이페이지에서 내 스크랩, 내 레시피, 내 게시글, 내 장바구니, 내 구매내역을 조회할 수 있으며 링크를 통해 해당 게시글로 이동할 수 있습니다.
아이디와 비밀번호를 입력하여 회원탈퇴를 할 수 있습니다. 다만 실제 데이터가 삭제되지 않고 별도로 구분되어 관리됩니다.
```
- 내 정보 수정
  ![mypageEdit](https://user-images.githubusercontent.com/105467839/188057279-0b885436-df50-4fe4-9a87-68beb67ece7c.gif)
- 내 스크랩, 내 레시피, 내 게시글, 내 장바구니, 내 구매내역
  ![myPages](https://user-images.githubusercontent.com/105467839/188058764-4e7c41c8-e393-4351-a691-5dcdd7b9d467.gif)
- 회원탈퇴
  ![myAccount](https://user-images.githubusercontent.com/105467839/188057583-10e2b73d-56a3-4342-aba8-6b9a45e43d62.gif)
  <br>
  <br>

---
### 관리자

```
- 회원 관리
  전체 회원목록, 회원 상세보기, 회원 탈퇴
- 레시피 관리
  전체 레시피 목록(신고순), 레시피 삭제, 레시피 상세보기
- 판매자 관리
  판매자 신청 목록, 판매자 승인, 판매자 승인취소
- 게시판 관리
  게시물 전체 목록(신고순), 게시물 상세보기, 게시물 삭제
- 판매자 등록
  판매자 등록 페이지
```

- 관리자 메인
  ![메인](https://user-images.githubusercontent.com/104446775/187861254-35e6ce54-bdd1-4808-ba35-7165601de7d7.PNG)

- 회원 관리
  ![회원관리페이지](https://user-images.githubusercontent.com/104446775/187858549-9923b987-19ca-483c-9e4e-a23d115ce018.PNG)
  ![회원상세페이지](https://user-images.githubusercontent.com/104446775/187858943-ac621238-15e3-4908-aca1-f69749f8559f.PNG)
  ![아이디 검색결과](https://user-images.githubusercontent.com/104446775/187859202-3766608e-c0cb-4fcd-a2d0-4d46e2799f3a.PNG)

- 레시피 관리
  ![레시피관리1](https://user-images.githubusercontent.com/104446775/187859457-59469cf1-50ef-45b4-9f6b-06496a1b4a1d.PNG)

- 판매자 관리
  ![판매자관리 승인목록](https://user-images.githubusercontent.com/104446775/187859907-4c4bc289-f7c0-4e40-a163-71e509c5b417.PNG)
  ![판매자관리 승인취소](https://user-images.githubusercontent.com/104446775/187860013-35a2c2ed-a07a-4b64-a3fb-63c003925a1e.PNG)

- 게시판 관리
  ![게시판 목록](https://user-images.githubusercontent.com/104446775/187860596-84e1b102-8ebf-4eb7-a3db-866a56be9fb4.PNG)

- 판매자 등록
  ![판매자 등록](https://user-images.githubusercontent.com/104446775/187862654-8468e730-5f0e-4320-a0c2-0f07a869da66.PNG)