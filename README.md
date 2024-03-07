# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

## step4 : 모든 기물 배치하기
### 기능 구현 목록
- [x] 리팩토링 진행
  - [x] 개행 문자 반복되는 부분 삭제
  - [x] 개행 문자 붙여주는 유틸 추가
- [x] 모든 기물들의 종류를 만들기 위해 생성자 부분 팩토리 메서드로 변경
- [x] 보드에 모든 기물이 올바른 위치에 올라가도록 세팅

### 삽질 & 고민 기록
- 기존에 만들어놓았던 enum끼리의 연결이 애매해졌다. 일단 우선적으로 서로 관련이 있는 상수 데이터들을
묶는다는 것을 우선적으로 생각해서 정리해보았다. &rarr; enum을 합쳐서 정리했다.


- 윷놀이 미션에서 했던 방법을 떠올려서 이번에 각 말들이 좌표를 가지기 때문에, map으로 좌표와 말 객체를 연결해서 관리하려고 생각했다.


- 초기화 할 때 말이 놓이지 않는 공간을 null로 설정했더니, Map의 값으로 넘길 때 예외가 발생한다..
게다가 supplier 를 사용할 때도 null 인 경우 get()을 하면 오류가 나기 때문에 따로 처리가 필요했고, 이래저래 null을
사용해서는 안 되겠다는 생각이 들었다.

```
 // enum에서 이런 식으로 Supplier<Piece> 필드가 설정되어 있다.
 E7(Piece::createBlackPawn),F7(Piece::createBlackPawn),G7(Piece::createBlackPawn),H7(Piece::createBlackPawn),

 A6(null),B6(null),C6(null),D6(null),E6(null),F6(null),G6(null),H6(null),
    
```
해당 필드에서 get으로 함수 값을 가져오는 과정에서도 처리가 필요했다.
```
    public Piece initBoard() {
        return init == null ? null : init.get();
    }
```
하지만 결정적으로 Map의 값으로 null이 저장되게 되면 예외가 발생하는 문제가 있다.
```
    public void initialize() {
        chessBoard = Arrays.stream(Square.values())
               .collect(Collectors.toMap(
                        square -> square,
                       // 여기서 NullPointerException 발생 중
                       Square::initBoard
                ));
    }
```
일반적으로 Map의 vlaue에는 null 값이 들어갈 수 있지만
Collectors.toMap은 null 값을 허용하지 않는다. 왜냐하면 해당 함수가 내부적으로 merge를 사용해서 Map을 만든하고 하는데, 해당 메서드는 내부에 value가 null이면
NullPointer예외를 던지고 있다. 그렇기 때문에 값이 null일 경우에는 마찬가지로 예외가 났었던 것

```
public V merge(K key, V value,
                   BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        if (value == null || remappingFunction == null)
            throw new NullPointerException();
            // 이하 생략
            }
```

그래서 아래와 같이 forEach로 돌면서 추가하는 것으로 수정했다. 이렇게 하니까 오류는 일단 해결
```
       Arrays.stream(Square.values())
                .forEach(square -> chessBoard.put(square, square.initBoard()));
```

하지만 여전히 비어있는 것을 의미하는 것을 null로 할지, 아니면 Piece에 비어있는 상태의 기물을 만들어야 하는지?
잘 모르겠다.

### 알아볼 점
System.getProperty("line.separator");
