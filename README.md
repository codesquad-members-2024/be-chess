# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

## step3 : 체스판 초기화
### 기능 구현 목록
- [x] 각 플레이어별로 폰을 8개씩 가지도록 보드를 초기화하는 기능
- [x] 현재 체스판의 결과를 출력해주는 기능
- [x] 각 폰의 출력 모양을 color 별로 다르게 만들어주는 기능
- [x] 사용자에게 시작 / 종료 여부 입력 받는 기능

### 삽질 & 고민 기록

- 기존 코드를 잘 활용해서 구현해보고 싶었는데, 생각보다 이 부분이 어려웠습니다.

- 출력 모양과 색을 각각 enum으로 관리 중입니다. 여기서 폰의 출력 모양이 색에 따라 변경되어야 하기 때문에,
두 값을 연결해 보려고 시도했습니다. 그런데 이렇게 하니까 현재 테스트 코드에서 어떻게 출력 모양을 검증해야 할지 난감해졌습니다.
```
void verifyPawn(final Colors color) {
    Pawn pawn = new Pawn(color);

    assertThat(pawn)
        .extracting("representation")
        .isEqualTo(비교값 필요);
    }
```
파라미터로 넘겨받은 color에 따라서 폰의 representation 필드가 결정되기 때문에 여기서 `isEqualTo()` 내부에 넣는 값으로
Colors enum과 Representation enum을 연결한 것을 활용해 보고 싶었습니다.
하지만 이를 위해서는 따로 체크하는 코드가 필요하고, 제가 원하는 대로 extracting이 잘 작동하지 않아 고민 끝에 방법을 변경해서 해결하였습니다.

```
void verifyPawn(final Colors color, final Representation representation) {
    Pawn pawn = new Pawn(color);
        
    assertThat(pawn.getColor()).isEqualTo(color.getColorName());
    assertThat(pawn.toString()).isEqualTo(representation.getMark());
    }
```

파라미터로 Representation 정답지를 넘겨받아서 해당 값과 비교해주도록 했습니다. 폰은 Representation의 내용을 출력할 때
사용하므로, `toString()` 을 오버로딩하여 출력 시 사용하도록 일단 구현했습니다.