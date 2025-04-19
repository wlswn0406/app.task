# Task Server (Back-end)
: Task APP을 위한 API 서버

- [프로젝트 환경](#프로젝트-환경)
- [프로젝트 구조](#프로젝트-구조)
- [프로젝트 실행](#프로젝트-실행)


**기능 구현**
- Auth
  - [ ] 로그인
  - [ ] 회원가입
- Todo
  - [ ] 등록/수정/삭제
  - [ ] 완료, 중요 체크/해제
  - [ ] 알림
- Calendar
  - [ ] 등록/수정/삭제
  - [ ] 알림
- System
  - [ ] 로그
  - [ ] Todo 알림 처리
  - [ ] Calendar 알림 처리



## 프로젝트 환경

**기술 스택**

이름 | 버전 
---|---
java | 21 
spring boot | 3.4.4
gradle | 8.13


**주요 라이브러리**

이름 | 버전    | 설명
---|-------|---
spring-boot-starter-data-rest | 3.4.4 | REST API 자동 생성
spring-restdocs-mockmvc | 3.4.4 | REST API 문서화 도구
spring-restdocs-asciidoctor | 3.0.3 | 생성된 adoc 파일을 html 파일로 변환하는 도구

- 테스트 기반으로 API 동작을 검증하고 요청, 응답 등 스니펫 생성
- 스니펫이 adoc 문서로 생성되고 이 adoc 파일을 하나의 HTML 문서로 변환

```
검증된 테스트를 기반으로 API 문서를 생성해 신뢰성이 높으며
정적 파일로 빌드되어 운영 환경에서 안전한 사용 가능함
```


### 프로젝트 구조

**소스코드**
```bash
src.main.java/
├── common                   # 공통 유틸리티, 상수 등
├── config                   # 애플리케이션 설정 클래스
├── api                      # REST API 기능 클래스
├── domain                   # 비즈니스 모델, 엔티티 클래스
└── system                   # APP 공통 기능 클래스
```

**리소스**
```bash
src.main.resources/
├── mappers                  # 마이바티스 매퍼 파일
├── asciidoc                 # adoc 파일들
├── static                   # adoc 파일을 변환한 HTML 파일 위치
└── application.properties   # 공통 애플리케이션 설정 파일
```

**테스트**
```bash
src.test/
├── it                       # 통합 테스트
├── slice                    # 슬라이스 테스트
└── unit                     # 유닛 테스트
```

- 통합 테스트에 한해 API 문서 생성


API 문서  
http://localhost:9000/docs/index.html



## 프로젝트 실행

- git, java 설치 필요


**프로젝트 실행**
```bash
git clone https://github.com/wlswn0406/app.task.git
cd ./app.task/task-server

# 개발 서버 실행
./gradlew bootRun

## 프로파일 지정
./gradlew bootRun --args='--spring.profiles.active=test'


## 통합 테스트
./gradlew itTest


# 프로젝트 빌드
./gradlew build

## 실행
java -jar ./build/libs/task-server-0.0.1-SNAPSHOT.jar

## 프로파일 지정
java -jar ./build/libs/task-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```