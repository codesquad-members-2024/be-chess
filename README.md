# be-chess

## 2024 마스터즈 체스 프로젝트


### 2단계 체스판 생성
- 4.추가테스트 : Pawn 이외의 객체를 Board에 추가 시 컴파일 에러 발생하도록
  - 애초에 Board 의 `add()`가 매개변수로 Pawn 만 받게 하여서 따로 테스트 작성 할 필요를 못느꼈다.

- 5.중복제거: 프로덕션 코드에서 중복제거, 테스트 코드에서 중복제거와 `@Before` 활용
  - 적용할 부분을 당장에는 찾지 못해 패스

### 4단계 모든 기물 배치하기
- 현재 상태 
  - `List<Piece>` 형태로 `Piece`의 이름에 관계 없이 모든 `Piece`를 하나의 리스트에 다 저장하는 방식
- 문제 
  - 초기화된 보드를 출력해야 하는 요구 사항을 구현하기 어려움
- 힌트를 얻은 포인트 
  - 체스판은 행과 열로 이루어져있다. 모든 칸은 각각의 좌표를 갖고 `열 = File`, `행 = Rank` 의 조합으로 표현된다.
- 변경 하려는 지점 
  - 보드에서 모든 기물을 저장하는 자료구조를 List<List<Piece>> 형태로 변경한다.
  - 내부의 List<Piece> 는 각 Rank 를 표현한다.
  - 단계적 구현을 위해, 현재는 4단계의 요구사항인 `초기화된 보드 '출력'` 부분만 구현 하기 위해 단순하게 출력되어야 하는 순서대로 저장해보려한다.