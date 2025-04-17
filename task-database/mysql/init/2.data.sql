-- 사용자 데이터 삽입
INSERT INTO users (id, password, created_at)
VALUES 
('test1', '12345', NOW()),
('test2', '12345', NOW());


-- 카테고리 데이터 삽입
INSERT INTO todo_category (name, sort_order, created_by, created_at)
VALUES
('카테고리1', 1, 1, NOW()),
('카테고리2', 2, 1, NOW()),
('카테고리3', 3, 1, NOW());

INSERT INTO todo_category (name, sort_order, created_by, created_at)
VALUES
('카테고리1', 1, 2, NOW()),
('카테고리2', 2, 2, NOW());


-- 할일 데이터 삽입
INSERT INTO todos (category_id, title, sort_order, created_by, created_at)
VALUES
(1, '할일1', 1, 1, NOW()),
(1, '할일2', 2, 1, NOW()),
(1, '할일3', 3, 1, NOW()),
(2, '할일1', 1, 1, NOW());

INSERT INTO todos (category_id, title, sort_order, created_by, created_at)
VALUES
(4, '할일1', 1, 2, NOW()),
(5, '할일1', 1, 2, NOW());
