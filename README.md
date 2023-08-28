# AccountSystem 설명
## 프로젝트 엔티티
![image](https://github.com/HanSeulChung/AccountSystem/assets/94779505/dd4d9c16-a653-429b-900d-2f99ed784b09)


## 제공하는 기능(API)
### 계좌(Account) 관련 기능
<ol>
  <li>계좌 생성</li>
  <li>계좌 해지</li>
  <li>계좌 확인</li>
</ol>

### 거래(Transaction) 관련 기능
<ol>
  <li>잔액 사용(거래 생성)</li>
  <li>잔액 사용 취소(거래 취소)</li>
  <li>거래 확인</li>
</ol>

> 구현의 편의를 위해 사용자 생성 등의 관리는 API로 제공하지 않고 프로젝트 시작 시 자동으로 데이터가 입력되도록 하며, 계좌 추가/해지/확인, 거래 생성/거래 취소/거래 확인의 6가지 API만 제공

## 활용 기술 
<li> Spring boot 2.6.8 </li>
<li> SDK : temurin-11</li>
<li> Gradle </li>
<li> Junit5 </li>
<li> H2 Database </li>
<li> JPA </li>
<li> Redis </li>
<li> Mockito </li>
<li> Lombok </li>
