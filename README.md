# be-chess
2024 마스터즈 체스 프로젝트

## 주의할 점
- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

# 미션 구현
## Step 1 : 체스프로젝트 시작
### 1-1. Pawn 테스트 작성
- [x] JUnit과 AssertJ 의존성 추가 (Gradle)
- [x] 흰색(white)를 값으로 가지는 Pawn 인스턴스를 생성하는 테스트를 작성
  - [x] 이 테스트 메서드의 이름은 `create()`
  - [x] Display 어노테이션을 잘 활용한다

### 1-2. Pawn 클래스 구현
- [x] 1-1에서 작성한 테스트가 성공하도록 Pawn 클래스를 작성한다
  - [x] 생성자로 자신의 색상 정보를 받는다
  - [x] 해당 폰의 색상 정보를 반환받을 수 있는 `getColor` 메서드

### 1-3. 검은색 폰 인스턴스 생성 테스트 및 리팩토링
- [x] 앞서 작성한 PawnTest의 create 메서드에 검은색('black')을 넣었을 때 검은색 폰이 잘 생성되는지 확인하는 기능을 추가한다
- [x] "white", "black" 문자에 대한 중복을 제거하기 위해 create() 메소드에 local variable을 추가한다
- ~~[ ] verifyPawn(final String color)와 같은 메소드를 추가해 중복 코드를 제거해 본다~~
  - [x] ParameterizedTest를 통해 중복을 줄인다
  - [x] ParameterizedTest를 이용하지 않으면서도 지역변수를 이용한 중복 제거 방법 적용

## Step 2 : 체스판 생성
### 2-1. Pawn 클래스 변경
- [x] PawnTest에서 매개 변수 없는 Pawn 생성에서 왜 컴파일 에러가 나는지 확인해보기 (feat. 기본생성자)
- [x] 색이 없는 Pawn을 생성하는 경우 기본으로 흰색 말을 생성하도록 두 번쨰 생성자를 추가해 컴파일 에러를 피한다
- [x] 색깔을 상수로 만들기

### 2-2. BoardTest 추가
- 테스트 목록
  - [x] 빈 보드를 생성한다
  - [x] 빈 보드에 생성된 말을 추가한다
  - [x] 말을 추가할 때마다 pawn의 갯수가 맞는지 확인한다
  - [x] pawn을 추가할 때마다 목록을 얻어와 추가한 pawn을 정상적으로 가지는 것을 확인한다

### 2-3. 패키지 분리
- [x] 전체 패키지를 chess라는 패키지로 묶고
  - [x] Pawn 클래스와 PawnTest 클래스는 pieces라는 패키지를 만들어 관리한다
- [x] 패키지가 달라졌음에도 불구하고 잘 빌드되고 실행되는지 확인한다

### 2-4. 추가 테스트 구현
- [x] 체스 판에 Pawn 이외의 객체가 추가되지 않도록 한다
  - [x] Pawn 이외의 다른 객체가 추가되면 컴파일 에러 발생

### 2-5. 리팩토링
- [x] step 2에서 구현한 부분 중 중복되는 부분이 있는지 확인 후 제거
- [x] 테스트 코드에서도 중복을 확인하고, 만약 있다면 @Before 애노테이션을 활용해 중복 제거


## Step 3 : 체스판 초기화
### 3-1. 보드 초기화 기능 구현
- [x] 보드를 초기화화 하고 초기화한 결과를 화면에 출력한다 
  - [x] 체스판은 8*8로 구성
  - [x] 지금 단계에는 폰(Pawn) 기물만 추가한다
  - [x] 검은색 기물(♟)과 흰색 기물(♙)을 구분한다
    ```text
    ........
    PPPPPPPP
    ........
    ........
    ........
    ........
    pppppppp
    ........
    ```
#### Pawn
- [x] 출력 상황에서 자신의 콘솔에서 어떻게 출력될 것인가에 대한 정보를 지니고 있다

#### Board::initialize()
- ~~[ ] 흰색 piece 열과 검은색 piece 열을 구분해서 구현한다 (ArrayList)~~
  - 하나의 열에서 모두 관리
- [x] 기물의 열을 하나로 합쳐야 하는 상황에서는 StringBuilder를 활용하여 합친다

#### Board::print()
- [x] initialize() 된 체스 판의 결과를 콘솔 화면에 출력할 수 있다.
- [x] 화면에 출력할 결과를 StringBuilder에 저장한 후 String으로 반환한다
- [x] 테스트 코드에서 반환 값을 System.out.println으로 출력한다

### 3-2. 게임 시작 및 종료 기능 구현
- [x] 콘솔에 명령어를 입력하면 게임의 시작과 종료가 실행된다
  - [x] start 명령을 입력하면 게임이 시작한다
  - [x] end라는 명령을 입력하면 게임이 종료된다

#### main 메서드 구현
- [x] main() 메서드를 가지는 새로운 클래스를 추가하여 시작과 종료 기능을 제공
- [x] Scanner를 이용해 사용자 입력 값을 받는다
- [x] while을 통해 사용자 입력 값을 받을 수 있도록 한다


## Step 4 : 모든 기물 배치하기
### StringUtils 클래스
- [x] `utils.StringUtils` 클래스를 추가한다
  - [x] 상수값으로 NEWLINE을 `System.getProperty("line.separator")`으로 가진다 (운영체제 독립적으로 작동시키기 위해)
  - [x] `appendNewLine("문자열")` 메서드 구현
    - [x] 인자로 전달한 메서드에 개행 문자를 추가하는 기능을 지님
    - [x] static import를 통해 구현한다
  - [x] 생성자를 private으로 선언하여 직접적으로 인스턴스를 생성하지 못하도록 막는다

### Pawn -> Piece (리팩토링)
- [x] 색상과 이름을 속성으로 지닌다
  - [x] 이름은 기물의 종류를 의미하며 pawn, knight, rook, bishop, queen, king 으로 구분 가능
- [x] 값(value) 객체여야 한다
  - [x] private 생성자를 가지며, 인스턴스 생성한 이후 인스턴스의 상태값을 변경 불가하다
- [x] 색과 이름을 받아 Piece 객체를 생성하는 팩토리 메서드를 구현
- [x] 기본 말을 생성하는 생성자는 없앤다
- [x] 검은색 말과 흰색 말을 구분할 수 있는 메서드를 추가한다
  - ex. isBlack(), isWhite()

### 팩토리 메서드 생성
- [x] 각 Piece별로 흰색 말과 검은 색 말을 생성하는 팩토리 메소드를 추가한다

### 전체 기물의 상태를 볼 수 있는 체스판 구현 및 테스트
- [x] 다음 테스트를 만족하는 Board를 구현한다
```java
import static utils.StringUtils.appendNewLine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;
    
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void create() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard());        
    }
}
```

