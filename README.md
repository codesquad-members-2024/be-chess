# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

# 기능 구현 리스트
## Piece(기물)
- [x] 폰은 색상을 구별할 수 있다
[//]: # (- [x] 색상을 지정하지 않으면 하얀색 기물로 생성할 수 있다 )
- [x] 출력용 폰의 모양을 나타낼 수 있다
- [x] 팩토리 메서드로만 기물을 생성할 수 있다
- [x] 자신의 색상이 흰색인지 검정색인지 알 수 있다
- [x] 자신의 타입과 같은지 알 수 있다

## Board(체스판)
- [x] 체스판 위에 기물을 추가할 수 있다
- [x] 체스판에 놓여있는 특정 기물이 몇 번째에 있는지 알 수 있다
- [x] 체스 판을 초기화 할 수 있다
- [x] 체스 판 초기화 결과를 콘솔에 출력할 수 있다
- [x] 체스 판 위에 있는 기물의 개수를 셀 수 있다

[//]: # (## PieceShape&#40;기물 모양&#41;)
[//]: # (- [x] 기물의 타입과 색상에 따라 매핑될 수 있다)

## Position(위치)
- [x] 문자열로 된 위치 정보를 정수 타입의 행과 열로 변환할 수 있다
- [x] 정수 타입의 행과 열을 문자열로 된 체스판의 위치로 변환할 수 있다
- [x] 한 Postion에 있는 기물을 다른 Position에 옮길 수 있다
- [x] 문자열로 된 위치 정보와 같은 위치인지 확인할 수 있다

## ChessSimulator(메인 실행)
- [x] 사용자 입력을 계속해서 받을 수 있다
- [x] 사용자 입력이 `start`이면 현재 체스 판의 상태를 출력할 수 있다
- [x] 사용자 입력이 `end`이면 실행을 종료한다

## StringUtils
- [x] 문자열에 개행 문자를 추가할 수 있다

## CreateCommand
- [x] 허용된 이름으로 기물을 생성할 수 있다

---

# 실행 흐름
## `end` 명령어를 입력하기 전까지 `start` 명령어를 입력받을 수 있다
### 폰 초기화 결과
<img width="264" alt="backend1-chess-1" src="https://gist.github.com/assets/87357932/e40f3e33-b805-401a-8df9-23a4b3f56354">

### 체스판 전체 초기화 결과
<img width="263" alt="backend1-chess-2" src="https://gist.github.com/assets/87357932/42d31602-b0fc-42ab-bdec-fadd7de6694a">
