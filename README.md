# Task APP
: 업무/작업 관리를 위한 앱


**주요 기능**
- Todo (할일 관리)
- Calendar (일정 관리)

기능 참고
- Todo :  https://calendar.google.com/calendar/u/0/r/tasks
- Calendar : https://calendar.google.com/calendar/u/0/r/week


**구성**
- [UI (Front-end)](./task-ui/README.md)
- [API Server (Back-end)](./task-server/README.md)
- [DB](./task-database/README.md)


**개발 환경**

구성 | 주요 기술 | 버전 | 포트 (테스트)
---|---
UI   | react | 18.0 | 3000
API  | spring boot | 3.4.4 | 9000
DB   | mysql | 8.3.0 | 3306


**git commit 가이드라인**
```
<타입>: <간결한 설명>
```

커밋 타입 | 설명
---|---
init | 초기 설정
feat | 새 기능 추가
fix  | 버그 수정 (잘못된 동작 수정)
refactor | 기능 개선 (코드 구조 정리, 코드 개선 등)
test | 테스트 코드 추가 및 수정
style | 코드 디자인 변경 (들여쓰기, 세미콜론 등)