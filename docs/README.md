# 개요

자동 로또 시뮬레이션 애플리케이션.

# 요구사항 

## 기능 요구사항

- 입력  
  1. [x] 금액을 입력받는다.
  2. [x] 당첨 번호를 입력받는다.
  3. [x] 보너스 볼을 입력받는다.
- 출력
  1. [x] 구매한 로또 장수를 출력한다.
  2. [x] 구매한 로또 티켓을 출력한다.
  3. [x] 당첨 통계를 출력한다.
  4. [x] 수익률을 출력한다.

- 도메인
 1. 로또 생성기
    1. [x] 랜덤으로 로또 번호를 생성한다.
    2. [x] 오름차순으로 정렬
 2. 로또 번호   
    1. [x] 로또 숫자는 1~45 까지의 범위이다.
 3. 로또 티켓
    1. [x] 로또 번호는 중복될 수 없다.
    2. [x] 로또 번호는 6개이다.
 4. 금액
    1. [x] 1000 단위의 양의 숫자여야한다.
 5. 당첨
    1. [x] 로또 규칙에 따라 당첨된 로또 번호를 찾는다.
    2. [x] 당첨 번호와 보너스 볼 중복 확인
 6. 로또 순위
     3. [x] 일치하는 로또 번호 개수와 보너스볼을 기준으로 순위를 생성한다.
 7. 로또 티켓 그룹
    1. [x] 돈을 받아서 로또 티켓들을 생성한다.
    2. [x] 천원당 로또를 한 장 구매할 수 있다.
    3. [x] 로또 당첨자들을 구한다.
 8. 로또 통계
    1. [x] 수익률을 계산한다.
    2. [x] 등수 별 통계를 구한다.

## 프로그래밍 요구 사항
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] 기본적으로 Google Java Style Guide을 원칙으로 한다. 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- [x] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] else 예약어를 쓰지 않는다.

## 추가된 요구 사항
- [ ] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [x] 배열 대신 컬렉션을 사용한다.
- [x] Java Enum을 적용한다.
- [ ] 모든 원시 값과 문자열을 포장한다
- [x] 줄여 쓰지 않는다(축약 금지).
- [x] 일급 컬렉션을 쓴다.

## 과제 진행 요구 사항
- [x] README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.   
  AngularJS Git Commit Message Conventions 참고해 커밋 메시지를 작성한다.
