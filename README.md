# jjeopjjeopRecipeの紹介



# 概要

---


### members

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
### Tools

```
Backend: Java 11, Spring boot 2.7.2, Gradle, MyBatis, thymeleaf, Ajax
DB : Oracle 11.2
Front : HTML5, CSS, JavaScript, JQuery, Bootstrap
Tool : IntelliJ, VS Code, GitHub
```

機能紹介
---
### ショッピング
```
農産物の販売·購入ができます。 
フィルタリング（野菜、果物等の商品種類）とソート（販売量、レビュー評点等）機能があります。
詳細画面で商品の詳細情報と購入した会員のレビューを確認することができ、数量を選択してショッピングカートに入れたり決済することができます。
お支払いはカカオペイ(バーコード決済)を通じて行われます。 
マイページで買い物かごの項目と決済内訳を確認できます。
```
- 投稿  
![totalsearch](https://im4.ezgif.com/tmp/ezgif-4-ff89dfc240.gif)  

- フィルタリングとソート  
![totalsearch](https://im4.ezgif.com/tmp/ezgif-4-5774351228.gif)  

- カートに追加と決済  
![totalsearch](https://im4.ezgif.com/tmp/ezgif-4-64baa9f0ab.gif)
![totalsearch](https://im4.ezgif.com/tmp/ezgif-4-0ebdfde9c8.gif)


<br>
<br>

---


### Index,　総合検索

```
インデックスページです。 材料やレシピ名でレシピと商品統合検索に進みます。 
ページにはスクラップ順、販売量順に並べられたレシピと商品を見ることができ、それぞれの詳細ページとつながっています。
```

![image](https://user-images.githubusercontent.com/96387509/187108033-b7a94b25-0476-4ac4-a145-4c8223e9fe3f.png)

![image](https://user-images.githubusercontent.com/96387509/187108076-ddc30e07-4470-4e8e-a42f-4f8b62f43a47.png)

![totalsearch](https://user-images.githubusercontent.com/96387509/187107594-cc21a5a4-f2d1-46e9-9ca4-774d64b6236a.gif)

<br>
<br>
```
レシピを作成して、他の人のレシピを見ることができるレシピ掲示板です。
レシピを分類別に閲覧することができ、作成日、スクラップ、照会数を基準に整列して閲覧することができます。
検索ページでも同じ機能が提供されます。
レシピ本文照会ページでは、スクラップ、クリップボードへのリンクコピー、申告、コメント作成および修正が可能です。
レシピを作成するときは、好きなだけレシピ分類を追加したり、料理段階を追加したりできます。```

  
  ![list인덱스](https://user-images.githubusercontent.com/101542378/188267504-b63a69ff-1208-4186-9d6d-4a945050d3d7.png)
  <br>
  <br>

 
  <img src="https://user-images.githubusercontent.com/101542378/188267560-4b54d3a5-80ce-4644-b89a-60e11be7252b.gif" width="70%" />
  <br>
  <br>


  <img src="https://user-images.githubusercontent.com/101542378/188267631-e5c4c2dd-2000-484c-8883-312e3db0712c.gif" width="70%" />
  <br>
  <br>

  
  <img src="https://user-images.githubusercontent.com/101542378/188267637-7e34a73f-bf36-47c0-9d90-7003e913adff.gif" width="70%" />
  <br>
  <br>
  
  <img src="https://user-images.githubusercontent.com/101542378/188267645-bc750ab6-3ca2-4530-9fda-f58816ace965.gif" width="70%" />
  <br>
  <br>

  <img src="https://user-images.githubusercontent.com/101542378/188267660-989c3016-9730-40a3-aeb2-492384d8fee2.gif" width="70%" />
  <br>
  <br>


### コミュニティ掲示板

```
カテゴリごとにライティング様式が異なるのが、この掲示板の中核機能です。
その他に詳細検索、いいね、コメント機能があります
```

- 掲示板 index

  ![image](https://user-images.githubusercontent.com/96387509/187107964-d46ef565-df77-4bd7-96a7-0cff70a388fb.png)
  <br>
  <br>


  ![communityform](https://user-images.githubusercontent.com/96387509/187107512-dddabc56-4b8b-49b9-afda-9154eae8e982.gif)
  <br>
  <br>

  ![communityformDetialSearch](https://user-images.githubusercontent.com/96387509/187107660-24b067df-7ccf-4bdc-a585-a469e451e97e.gif)
  <br>
  <br>

  ![communityComment](https://user-images.githubusercontent.com/96387509/187107765-746cbcf5-39e5-4a91-b9e6-064e630ba517.gif)

<br>
<br>

---
### 会員
```
レシピの作成やショッピングなどを利用するためには会員登録が必須です。無効な値を記入した場合、会員登録はできません。
ID/パスワード検索を通じて登録時に記載したIDとパスワードを探すことができます。DBに保存されたID、パスワードと同じ値の場合、ログインすることができます。
```

  ![signup](https://user-images.githubusercontent.com/105467839/188056426-d89996c9-98be-4069-9598-38a1ae8957d1.gif)

  ![findId](https://user-images.githubusercontent.com/105467839/188068581-953f39fb-0cdd-4761-a251-cb702c2cf4b0.gif)

  ![login](https://user-images.githubusercontent.com/105467839/188068163-30beb130-daea-4312-80ad-d44533e21377.gif)

---
### マイページ
```
ログイン後、マイページでパスワード及び個人情報を修正することが、できます。また、マイページで自身のスクラップ、自身のレシピ、自身の投稿、カート、購入履歴を閲覧することができ、リンクを通じてその投稿に移動することができます。IDとパスワードを入力して会員退会ができます。
```
  ![mypageEdit](https://user-images.githubusercontent.com/105467839/188057279-0b885436-df50-4fe4-9a87-68beb67ece7c.gif)

  ![myPages](https://user-images.githubusercontent.com/105467839/188058764-4e7c41c8-e393-4351-a691-5dcdd7b9d467.gif)

  ![myAccount](https://user-images.githubusercontent.com/105467839/188057583-10e2b73d-56a3-4342-aba8-6b9a45e43d62.gif)
  <br>
  <br>

---
### 管理者

```
- 会員管理
  全会員リスト、会員詳細表示、会員退会
- レシピ管理
  全レシピリスト(違反の報告順)、レシピ削除、レシピ詳細を見る
- 販売者管理
  販売者申請リスト、販売者承認、販売者承認取り消し
- 掲示板管理
  掲示物全体リスト(違反の報告順)、掲示物詳細表示、掲示物削除
- 販売者登録
  出品者登録ページ
```


  ![메인](https://user-images.githubusercontent.com/104446775/187861254-35e6ce54-bdd1-4808-ba35-7165601de7d7.PNG)


  ![회원관리페이지](https://user-images.githubusercontent.com/104446775/187858549-9923b987-19ca-483c-9e4e-a23d115ce018.PNG)
  ![회원상세페이지](https://user-images.githubusercontent.com/104446775/187858943-ac621238-15e3-4908-aca1-f69749f8559f.PNG)
  ![아이디 검색결과](https://user-images.githubusercontent.com/104446775/187859202-3766608e-c0cb-4fcd-a2d0-4d46e2799f3a.PNG)


  ![레시피관리1](https://user-images.githubusercontent.com/104446775/187859457-59469cf1-50ef-45b4-9f6b-06496a1b4a1d.PNG)


  ![판매자관리 승인목록](https://user-images.githubusercontent.com/104446775/187859907-4c4bc289-f7c0-4e40-a163-71e509c5b417.PNG)
  ![판매자관리 승인취소](https://user-images.githubusercontent.com/104446775/187860013-35a2c2ed-a07a-4b64-a3fb-63c003925a1e.PNG)


  ![게시판 목록](https://user-images.githubusercontent.com/104446775/187860596-84e1b102-8ebf-4eb7-a3db-866a56be9fb4.PNG)


  ![판매자 등록](https://user-images.githubusercontent.com/104446775/187862654-8468e730-5f0e-4320-a0c2-0f07a869da66.PNG)