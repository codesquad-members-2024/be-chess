# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

## step-3
### 구현 내용
#### Main.java
start 또는 end라는 입력을 기다리고, 해당 입력이 아닌 경우 재입력을 요청
start 입력시 체스판 출력 후 다시 입력을 대기, end면 게임 종료

#### Board.java
initialize에서 흰색 폰과 검정색 폰을 각각 리스트 멤버변수에 추가함으로서 초기화하는데, pawnsInit 메서드로 중복되는 부분을 처리함
색상과 대표 아이콘을 입력으로 받아 step2에서 구현했던 add 메서드로 pawns에 추가, 해당 리스트의 복사본을 반환함.

getWhitePawnsResult()와 getBlackPawnsResult()는 initialize에서 초기화한 리스트를 stream의 reduce를 활용, 각 폰들의 배치 결과를 반환함

print()에서는 앞서 설명한 두 메서드를 활용해 1번 인덱스의 줄에 검정 폰, 6번 인덱스의 줄에 흰색 폰, 그 외에는 빈 칸 문자열 목록을 출력함.
매 줄마다 개행 문자를 추가하나, 마지막 줄에서는 개행 문자를 삭제해 출력.

#### Pawn.java
WHITE_COLOR...등과 같은 상수를 PIECES라는 enum class에서 관리하려 했으나 현재 기능에서는 몇 개 필요하지 않아 Pawn에 종속되도록 상수를 추가함
이전 스텝과 달리 대표 이이콘을 출력해야 하므로 representation이라는 final 멤버변수를 추가해 생성자에서도 초기화하도록 함.

#### 테스트 코드
최대한 요구사항에서 주어진 그대로 옮겨 작성하였음.
다만, Assertions 부분은 assertJ 사용으로 통일하였다.

### 고민한 부분
- 이전 step에서 사용된 코드들을 삭제하지 않고 그대로 사용하려고 했다.
- Board 클래스에서 이차원 배열로 보드판을 표현할까 고민했으나, test 통과를 위해서만 whitePawns, blackPawns와 같은 리스트 멤버변수를 추가함.
- 테스트 코드에서는 initialize를 별도로 호출하고 있어서, 생성자 내부에 initialize를 추가해야 하는가에 대한 고민. 해당 메소드를 호출하지 않고 print() 등을 호출하면 NPE가 발생한다.
- 위 모든 고민한 부분은 다음 step에서 해결할 것임.

### 실행 및 동작 예시
![image](https://github.com/codesquad-members-2024/be-chess/assets/71365547/f2f8de4a-3b60-4961-9424-24341e9c9f29)
