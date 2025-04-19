# Task UI (Front-end)
: 사용자와 상호작용을 위한 Task APP 화면

**기능 구현**
- Common
  - [ ] 성공/실패 모달
  - [ ] 파일 업로드
  - [ ] 검색
- Auth
  - [ ] 로그인 화면
  - [ ] 회원가입 화면
- Todo
  - [ ] Todo 카테고리 등록/수정
  - [ ] Todo 카테고리 별 할일 리스트
  - [ ] Todo 필터링 (전체, 중요, 완료)
  - [ ] Todo 등록/수정/삭제
  - [ ] Todo 모달 알림
- Calendar
  - [ ] Calendar 화면



## 프로젝트 환경

**기술 스택**

이름 | 버전
---|---
vite | 6.2.0
react | 18.0.0
And-Design | 4.x 


**주요 라이브러리**

이름 | 사용 이유
---|---
react-router-dom | 페이지 라우팅
react-hook-form  | 사용자 입력을 간단하게 처리
prop-types | props 타입 검사
axios   | API 요청을 간단하게 처리
dayjs   | 날짜/시간 처리
msw     | API 서버 대신 사용할 가짜 API 응답 제공

- axios는 fetch보다 더 나은 에러 처리와 인터셉터 같은 기능을 제공
- fetch는 HTTP 404, 500 오류를 에러로 간주하지 않아 직접 처리해야 함


**프로젝트 생성**
```bash
# 프로젝트 생성
npx create-vite@latest task-ui --template react
cd task-ui

# 패키지 실행
npm install

# 라이브러리 설치
npm install normalize.css antd@4 axios dayjs react-router-dom react-hook-form prop-types
npm install msw --save-dev

# 개발 서버 실행
npm run dev
```



## 프로젝트 구조

**프로젝트 구조**
```bash
src/
├── _config                  # 공통 설정 (환경 변수, 라우터 등)
├── _mock                    # API 테스트를 위한 데이터, 핸들러
├── _utils                   # 공통 유틸리티
├── assets                   # 정적 리소스
├── components               # 전역 공통 컴포넌트
├── features                 # 공통으로 사용하는 기능 (검색, 파일 업로드 등)
├── layout                   # 공통 레이아웃 (헤더, 푸터 등)
└── modules                  # 애플리케이션 기능 (라우터 대상)
└── store                    # 전역 상태 관리
```

- features는 공통으로 사용할 기능으로 화면 컴포넌트를 포함함
- modules는 애플리케이션 기능으로 화면 컴포넌트와 이를 처리하는 로직 모음


**기능 구조**
```bash
기능/
├── components               # 해당 기능에서 사용하는 컴포넌트
├── hooks                    # 해당 기능의 상태 관리, 라이프사이클 처리
├── services                 # 비즈니스 로직, 데이터 변환, API 처리
└── views                    # 라우터 대상이 되는 화면 컴포넌트
```


**기능 흐름**
```
View → (Hooks) → Services → API → API 서버
↑         |                          |
└──── 상태 업데이트 ────────────── 응답 데이터
```

- View : 사용자 인터페이스로 훅이나 서비스를 호출함
- Hooks : 컴포넌트에서 필요한 상태를 관리하고 서비스를 호출함 (기능이 단순하면 생략함)
- Services : 비즈니스 로직이 있다면 처리하고 API 함수를 호출함
- API : API 서버에 HTTP 요청을 보내고 응답을 받으면 이를 서비스에 반환함



## 프로젝트 실행

- node, npm 설치 필요

```bash
git clone https://github.com/wlswn0406/app.task.git
cd ./app.task/task-ui

# 패키지 설치
npm install

# 개발 서버 실행
npm run dev

## 모드 지정
npm run build -- --mode test


# 빌드
npm run build

## 빌드 결과 확인 (http://localhost:5000 확인)
npm run preview
```