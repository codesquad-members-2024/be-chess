# be-chess
## 구현 목록
**Pawn**
- 가장 기본 말인 폰 생성 클래스
- 폰을 생성할 때 어느 팀의 말인지 구분하기 위해 white, black 으로 생성할 수 있어야 한다.

**PawnTest**
- white , black 말이 잘 생성되는지 확인하는 테스트 코드

## 배운점 기록
**assertJ 라이브러리 추가**
- assertThat 사용하고 싶다면 assertJ 라이브러리 사용해야 함
- (JUnit5에서 직접 제공하지 않기 때문)
- assertJ.jar 파일 -> 라이브러리 추가해서 해결했다가 패키지를 분리하면 에러가 나는 것을 확인하고, gradle 에 추가