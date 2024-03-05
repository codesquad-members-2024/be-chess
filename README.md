# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

## 기능 구현

- Pawn: 가장 기본이 되는 Pawn 클래스 생성
    - 색상을 멤버변수로 갖고있음
    - 색상은 static final로 지정
- PawnTest: 올바른 색상의 Pawn 객체가 생성됐는지
    - @ParameterizedTest 랑 @ValueSource 사용
- Board: 체스판 클래스
    - initialize()를 추가해 검은색 폰과 흰색 폰을 각각 8개씩 가지도록 초기화한다.
    - print()를 추가해 현재 체스판의 결과를 출력한다.
    - 체스판은 8*8로 구성되어 있음
    - 검은색 Pawn은 대문자 P, 흰색 Pawn은 소문자 p로 표시
- BoardTest: