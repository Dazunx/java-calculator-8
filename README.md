# java-calculator-precourse

## **1주차 프리코스 학습 목표**

- Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
- 교육 분야에 맞는 프로그래밍 언어(Java)를 사용하여 간단한 문제를 해결한다.

---
# [문자열 덧셈 계산기]

2025.10.14 (TUE) ~ 2025.10.20 (MON)

## Description

입력된 문자열을 분석해 각 숫자의 합을 계산하는 프로그램이다.
기본 구분자(쉼표, 콜론)과 "//"와 "\n" 사이에 정의된 커스텀 구분자를 사용하여 숫자를 추출하고 합을 구한다.
잘못된 입력이 들어오면 예외를 발생시키고 프로그램을 종료한다.

### 동작 방식

1. Console.readLine()을 사용하여 문자열을 입력받는다.
2. 문자열의 앞부분에서 ”//”와 ”\n” 사이에 커스텀 구분자가 존재하는지 확인하고, 없으면 기본 구분자를 사용한다.
3. 설정된 구분자를 기준으로 문자열을 분리하고 각 숫자를 추출한다.
4. 추출된 숫자들을 모두 더해 합계를 계산하고 출력한다.
5. 잘못된 입력이 들어오면 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.


## **Class Design**

### **Application**

`camp.nextstep.edu.missionutils.Console`의  `readLine()` 을 활용하여 입력을 받아 전체 로직을 실행시킨다. 잘못된 입력으로 인해 `IllegalArgumentException`이 발생되면 애플리케이션은 종료한다.

### **Separator (Interface)**

구분자 추출과 문자열 분리 메서드를 정의한다.

### **SeparatorExecutor**

입력된 문자열을 계산할 `DefaultSeparator`와 `CustomSeparator`를 실행한다.

### **DefaultSeparator**

기본 구분자(쉼표, 콜론)를 기준으로 문자열에서 숫자를 분리한다.

### **CustomSeparator**

문자열 앞부분의 ”//”와 ”\n” 사이에서 추출한 커스텀 구분자를 기준으로 문자열에서 숫자를 분리한다.

### **TotalSum**

분리된 숫자들을 더해 합계를 계산하고 잘못된 입력 시 `IllegalArgumentException`를 발생시킨다.


## **Testing**

`camp.nextstep.edu.missionutils.test` 라이브러리를 이용하여 아래 항목들을 테스트한다.

- 입력이 비어 있을 때 0을 반환하는지
- 기본 구분자(쉼표, 콜론)가 정상적으로 동작하는지
- 커스텀 구분자가 올바르게 인식되는지
- 여러 문자나 “\n”를 포함한 커스텀 구분자가 처리되는지
- 잘못된 입력(음수, 구분자 이외의 문자, 구분자만 존재 등)에서 예외가 발생하는지

### 테스트 실행 방법

```bash
./gradlew clean test   # macOS / Linux
gradlew.bat clean test # Windows
```

- 테스트 성공 시

    ```
    BUILD SUCCESSFUL in 0s
    ```


## **Additional Information**

- Java 21 environment