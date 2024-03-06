# be-chess
## 구현 목록
**Pawn**
- 가장 기본 말인 폰 생성 클래스
- 폰을 생성할 때 어느 팀의 말인지 구분하기 위해 white, black 으로 생성할 수 있어야 한다.

**PawnTest**
- white , black 말이 잘 생성되는지 확인하는 테스트 코드

**Board**
- 체스판을 담당하는 Board 클래스 
- 체스판에 Pawn 이외의 객체가 추가되지 않도록 한다. add(Pawn pawn) {pawns.add(pawn)}

**BoardTest**
- 흰색 폰과 검은색 폰을 추가하고, 개수와 존재여부를 확인한다 


## 배운점 기록
**assertJ 라이브러리 추가**
- assertThat 사용하고 싶다면 assertJ 라이브러리 사용해야 함
- (JUnit5에서 직접 제공하지 않기 때문)
- assertJ.jar 파일 -> 라이브러리 추가해서 해결했다가 패키지를 분리하면 에러가 나는 것을 확인하고, gradle 에 추가

**github fork**
- fork 할 때, main은 디폴트로 따라오기 때문에 main 에 있는 commit 내역들은 그대로 딸려온다...
- 그냥 새로운 브랜치를 파서 작업해야함 
- 만약 원치 않는 commit 내역들을 감추는 효과(?)를 주고 싶다면 reset --hard 돌아가길원하는commit의 해시 로 돌아가서 작업한다...

**@BeforeEach**
- 이 어노테이션이 붙으면 테스트 메소드보다 먼저 실행 됨 

## 더 알아봐야 할 점
- 머지 되길 기다리며 새로운 브랜치를 파서 작업하다가 머지가 된다면? 내역을 문제 없이 가져온 후 이어서 작업하는 방법은...? rebase --onto 가 답일깡...?
- .gitignore 파일에 대하여 