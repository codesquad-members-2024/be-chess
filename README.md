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
