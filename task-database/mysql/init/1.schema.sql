CREATE DATABASE IF NOT EXISTS taskdb;
USE taskdb;


-- 사용자 테이블 생성
CREATE TABLE IF NOT EXISTS users (
    uid INT AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 PK',
    id VARCHAR(50) NOT NULL UNIQUE COMMENT '사용자 아이디',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at DATETIME DEFAULT NULL COMMENT '수정일',
    last_login_at DATETIME DEFAULT NULL COMMENT '마지막 로그인'
) COMMENT='사용자 정보를 저장하는 테이블';


-- 할일 카테고리 테이블 생성
CREATE TABLE IF NOT EXISTS todo_category (
    cid INT AUTO_INCREMENT PRIMARY KEY COMMENT '카테고리 PK',
    user_id INT COMMENT '생성자 (users.uid)',
    name VARCHAR(50) NOT NULL COMMENT '카테고리명',
    sort_order INT DEFAULT 0 COMMENT '정렬 순서',
    is_checked TINYINT(1) DEFAULT 0 COMMENT '체크 여부 (0: 해제, 1: 체크)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at DATETIME DEFAULT NULL COMMENT '수정일',

    FOREIGN KEY (user_id) REFERENCES users(uid)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) COMMENT='할 일 목록에 대한 카테고리를 저장하는 테이블';


-- 할일 테이블 생성
CREATE TABLE IF NOT EXISTS todos (
    tid INT AUTO_INCREMENT PRIMARY KEY COMMENT '할일 PK',
    category_id INT COMMENT '카테고리 PK (todo_category.cid)',
    title VARCHAR(255) NOT NULL COMMENT '제목',
    description TEXT COMMENT '상세 내용',
    sort_order INT DEFAULT 0 COMMENT '정렬 순서',
    is_done TINYINT(1) DEFAULT 0 COMMENT '완료 여부 (0: 진행, 1: 완료)',
    is_important TINYINT(1) DEFAULT 0 COMMENT '중요 여부 (0: 일반, 1: 중요)',
    is_notified TINYINT(1) DEFAULT NULL COMMENT '알림 여부 (0: 취소, 1: 알림)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at DATETIME DEFAULT NULL COMMENT '수정일',

    FOREIGN KEY (category_id) REFERENCES todo_category(cid)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) COMMENT='할 일을 저장하는 테이블';


-- 할일 알림 테이블 생성
CREATE TABLE IF NOT EXISTS todos_noti (
    nid INT AUTO_INCREMENT PRIMARY KEY COMMENT '알림 PK',
    todo_id INT COMMENT '할일 PK (todos.tid)',
    is_notified TINYINT(1) DEFAULT NULL COMMENT '알림 여부 (0: 취소, 1: 알림)',
    notify_at DATETIME COMMENT '알림 일시 (알림을 보낼 시간)',
    notify_type VARCHAR(20) DEFAULT 'popup' COMMENT '알림 타입 (popup, email, sms)',
    notify_status VARCHAR(20) DEFAULT 'pending' COMMENT '알림 상태 (pending: 대기 중, sent: 전송 완료, failed: 실패)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '알림 생성일',

    FOREIGN KEY (todo_id) REFERENCES todos(tid)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) COMMENT='할 일에 대한 알림 정보를 저장하는 테이블';


-- 로그 테이블 생성
CREATE TABLE IF NOT EXISTS logs (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '로그 PK',
    reference_id INT COMMENT '참조 PK (todos.tid, users.uid, todos_noti.nid 등)',
    reference_table VARCHAR(255) NOT NULL COMMENT '테이블 이름 (todos, users, todos_noti 등)',
    log_message TEXT NOT NULL COMMENT '로그 메시지',
    actor VARCHAR(50) DEFAULT 'SYSTEM' COMMENT '발생자 (사용자 ID 또는 SYSTEM)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일'
) COMMENT='로그 정보를 저장하는 테이블';