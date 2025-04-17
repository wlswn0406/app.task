# Task Database
: Task APP을 위한 데이터베이스 구성


**구성**
```bash
mysql/
├── conf.d                   # mysql 설정 파일 디렉토리
│   └── mysqld.cnf           # mysql 커스텀 설정 파일
├── init                     # 데이터베이스 초기화 스크립트
│   ├── schema.sql           # 테이블 생성 스크립트
│   └── data.sql             # 초기 데이터 삽입 스크립트
├── .env                     # 환경 변수 파일
├── docker-compose.yml       # 컨테이너 설정 파일
└── stop-container.sh        # 컨테이너 삭제 파일
```


**실행 방법**

- 리눅스 환경
- podman, podman-compose 설치 필요

```bash
# 컨테이너 실행
cd ./mysql
podman-compose up -d

# 컨테이너 접속
podman exec -it mysql_container mysql -u user -p


# 컨테이너 삭제
./stop-container.sh mysql_container

## 포트 확인 및 삭제
sudo lsof -i :3306
sudo kill -9 <PID>
```



## 스키마


### 사용자 테이블

**users**  
: 로그인에 필요한 기본 정보만 저장하는 테이블  

설명 | 컬럼 | 타입 | 예시
---|---|---|---
기본키 | uid | INT | 1
아이디 | id | VARCHAR(50) | test
비밀번호 | password | VARCHAR(255) | 12345
생성일 | created_at | TIMESTAMP | 2025-04-01 12:00:00
수정일 | updated_at | DATETIME | 2025-04-01 12:00:00
마지막 로그인 | last_login_at | DATETIME | 2025-04-01 12:00:00


### 할 일 테이블

**todo_category**  
: 할 일 목록에 대한 카테고리를 저장하는 테이블

설명 | 컬럼 | 타입 | 예시
---|---|---|---
기본키 | cid | INT | 1
카테고리명 | name | VARCHAR(50) | 할 일 목록
순서 | sort_order | INT | 1
체크 여부 | is_checked | TINYINT(1) | 1 (체크)
생성자 | created_by | INT | 2 (users.uid)
생성일 | created_at | TIMESTAMP | 2025-04-01 12:00:00
수정일 | updated_at | DATETIME | 2025-04-01 12:00:00

- 생성자(사용자)에 한해 카테고리가 생성


**todos**  
: 모든 할 일을 저장하는 테이블

설명 | 컬럼 | 타입 | 예시
---|---|---|---
기본키 | tid | INT | 1
외래키 | category_id | INT | 1 (todo_category.cid)
제목 | title | VARCHAR(255) | 제목
내용 | description | TEXT | 상세 내용
순서 | sort_order | INT | 3
완료 여부 | is_done | TINYINT(1) | 1 (완료)
중요 여부 | is_important | TINYINT(1) | 1 (중요)
알림 여부 | is_notified | TINYINT(1) | 1 (알림)
생성자 | created_by | INT | 2 (users.uid)
생성일 | created_at | TIMESTAMP | 2025-04-01 12:00:00
수정일 | updated_at | DATETIME | 2025-04-01 12:00:00


**todos_noti**  
: 할 일에 알림이 설정된 경우 알림에 대한 정보를 저장하는 테이블
 
설명 | 컬럼 | 타입 | 예시
---|---|---|---
기본키 | nid | INT | 1
외래키 | todo_id | INT | 1 (todos.tid)
알림 여부 | is_notified | TINYINT(1) | 0 (알림 취소)
알림 일시 | notify_at | DATETIME | 2025-04-01 12:00:00
알림 타입 | notify_type | VARCHAR(20) | popup (popup, email, sms)
알림 상태 | notify_status | VARCHAR(20) | pending (pending: 대기 중, sent: 전송 완료, failed: 실패)
생성일 | created_at | TIMESTAMP | 2025-04-01 12:00:00

- 할 일에 알림을 최초로 설정하면 todos_noti에 알림 정보가 등록됨
- todos의 알림 여부를 취소하면 todos_noti에서 알림 여부가 취소로 수정됨
- todos의 알림 여부가 알림이면 등록한 알림 일시에 설정한 타입으로 알림 정보가 전송됨



### 로그 테이블

**logs**  
: 모든 로그 정보를 저장하는 테이블

설명 | 컬럼 | 타입 | 예시
---|---|---|---
기본키 | id | INT | 1
외래키 | reference_id | INT | 1 (todos.tid, users.uid, todos_noti.nid)
로그 타입 | log_type | VARCHAR(255) | todos_noti
로그 내용 | log_message | TEXT | 알림 전송 성공
발생자 | actor | VARCHAR(50) | SYSTEM
생성일 | created_at | TIMESTAMP | 2025-04-01 12:00:00

- 로그 타입 : 로그가 발생한 테이블 이름 기록
- 발생자 : 로그를 발생시킨 사용자나 시스템을 구분 (사용자 경우 아이디를 기록)