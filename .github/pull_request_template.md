## 구현 내용
- pieces 패키지
  - Pawn 클래스
    - static final 이 아닌 enum 을 사용해서 구현했습니다.
    - 생성자 내에 예외 처리할 메소드를 사용하여 예외 처리 설정했습니다.
  - PawnTest
    - 색이 없는 Pawn을 생성하는 부분의 테스트 코드를 구현했습니다.
    - Public이 었던 테스트 메소드의 접근제어자를 모두 default로 변경했습니다.

- chess 패키지
  - Board 클래스
    - BoardTest 테스트 클래스 관련 체스 보드에 대한 메소드와 요구 사항을 구현했습니다.
  - BoardTest 클래스
    - 중복되는 부분을 제거해서 리팩토링 했습니다.
    - @Before 애노테이션을 활용해 중복을 제거했습니다.
    - 보드 리스트의 처음 초깃값이 0인지 확인하는 테스트 코드를 작성했습니다.

## 고민 사항
- 왜 이렇게 코드를 작성했는지 상대방이 질문했을때 대답할 수 있는 근거를 항상 생각하자.
- 자바 컬렉션 프레임워크를 공부해보자
- 객체지향 프로그래밍을 왜 사용하는게 좋은가
  - 데이터와 기능을 한 클래스에 넣어서 하나의 완전한 객체를 만든다.
- 테스트 코드는 static 을 쓰지 않는 이유는? -> JK 세나 리뷰
  - 의존성 주입(Dependency Injection)의 어려움: 정적 메소드는 상태가 공유되므로 의존성 주입을 사용하여 모의(Mock) 객체를 주입하는 것이 더 어려울 수 있습니다. 모의 객체를 주입하려면 정적 메소드를 모의화할 수 있는 방법이 필요합니다.
  - 테스트 불가능성(Testability): 정적 메소드는 목 객체(Mocking)를 사용하여 테스트하기 어려울 수 있습니다. 모의(Mock) 객체를 사용하여 정적 메소드의 반환 값을 조작하는 것이 더 어려울 수 있습니다.
  - 테스트의 불안정성: 정적 메소드는 전역적으로 상태를 변경할 수 있으므로 여러 테스트 간에 상태가 공유될 수 있습니다. 이는 테스트의 일관성과 안정성을 감소시킬 수 있습니다.
  - 확장성의 어려움: 정적 메소드는 상속을 통해 재정의할 수 없습니다. 따라서 하위 클래스에서 행동을 변경하거나 확장하기 어려울 수 있습니다.
- enum 과 static final 의 차이는?
  - https://forums.oracle.com/ords/apexds/post/enum-vs-static-final-string-3804

```java
public class PawnTest {
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}
```
- 이 테스트는 왜 컴파일 에러를 발생 시키는가?
  - 현재 Pawn에 매개변수가 있는 생성자가 있지만 기본 생성자는 없는 상태이다. 자바는 매개변수가 있는 생성자를 유저가 만들면 기본 생성자를 자동으로 만들어주지 않는다.
- 색깔을 상수로
  - 중복이 계속해서 발생해서 상수로 만든다. 상수로 만든 뒤 Pawn 클래스로 옮기는 이유는 데이터와 기능을 함께 한 클래스에 구현하기 위해서인가?
  - final static 을 쓰는 방법과 enum으로 쓰는 방법은 어떤 차이가 있을까?
    - enum 자료형은 컴파일 시점 형 안전성을 보장한다.
    - enum 자료형은 같은 이름의 상수가 평화롭게 공존할 수 있도록 해준다.
      - namespace가 각각 분리되기 때문이다.
  - JK -> 준마이 리뷰 중 : 런타임에 어떤 값을 넣어주느냐 판단하고 예외처리하는 코드는 계속 추가될 수 있지만 100% 안전하지는 않습니다. 그래서 매개변수 pawnColor (결국은 속성 pawnColor에) 실수할 수 있는 여지를 주는 String 타입을 두기 보다는 아예 타입으로 선언해서 매개변수로 넘기는 게 컴파일 단계에서 오류를 확인할 수 있으니까 더 안전합니다. 그래서 값의 범위가 넓은 String 보다는 enum 타입으로 색상을 지정하는 것도 좋을 수 있습니다
    - 근거 부분 
      - enum으로 선언
        compile 단계에서 그냥 Pawn(RAINBOW) 해버리면 아예 컴파일 에러!
      - String으로 선언
        Pawn("RAINBOW")가 들어감
        Pawn 객체 내부에서 예외 처리 판단
        예외를 던지고, caller에서 예외 처리
- 테스트 코드는 얼마나 작은 단위로 쪼개야하는가? 기준이 있을까?

## 기타
- 1단계 리뷰 반영
- white와 black 에 대한 상수 enum 적용하자
  <img alt="스크린샷 2024-03-05 오후 4.32.50.png" src="..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fct%2Fkb66zp2935s49_k_gv4bmtfm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_BYDV4Q%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-05%20%EC%98%A4%ED%9B%84%204.32.50.png"/>
- @valuesource 어노테이션을 알아보기
  <img alt="스크린샷 2024-03-05 오후 4.32.17.png" src="..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fct%2Fkb66zp2935s49_k_gv4bmtfm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_xEfjsG%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-03-05%20%EC%98%A4%ED%9B%84%204.32.17.png"/>
  - 여러 번의 파라미터를 던질 수 있도록 하는 어노테이션 중 하나이다. 단 하나의 타입만 던질 수 있다.
```java
class ParameterizedTestTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("일반_반복테스트")
    @Test
    void 일반_반복테스트() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        for (int num : numbers) {
            System.out.println("일반 반복 테스트 : " + num);
        }
    }

    @DisplayName("반복_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 반복_테스트(int intArg) {
        assertThat(numbers.contains(intArg)).isTrue();
    }
}
```
- @Before 어노테이션 알아보기
  - @BeforeEach 어노테이션이 달린 메서드가 현재 클래스의 각각 @Test, @RepeatedTest, @ParameterizedTest 또는 @TestFactory 어노테이션이 달린 메서드 전에 실행된다.
- @BeforeAll 어노테이션 알아보기
  - @BeforeAll 어노테이션이 달린 메서드가 현재 클래스의 모든 @Test, @RepeatedTest, @ParameterizedTest 및 @TestFactory 어노테이션이 달린 메서드보다 먼저 실행된다.
    https://thisiswoo.github.io/development/junit5-annotations-frequently-used.html


