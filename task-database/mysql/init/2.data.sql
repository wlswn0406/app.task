-- 사용자 데이터 삽입
INSERT INTO users (id, password, created_at)
VALUES 
('test1', '12345', NOW()),
('test2', '12345', NOW());


-- 카테고리 데이터 삽입
INSERT INTO todo_category (user_id, name, sort_order, created_at)
VALUES
(1, 'A', 1, NOW()),
(1, 'AA', 2, NOW()),
(1, 'AAA', 3, NOW()),
(2, 'B', 1, NOW()),
(2, 'BB', 2, NOW());


-- 할일 데이터 삽입
INSERT INTO todos (category_id, title, sort_order, created_at)
VALUES
(1, 'A-todo1', 1, NOW()),
(1, 'A-todo2', 2, NOW()),
(1, 'A-todo3', 3, NOW()),
(2, 'AA-todo1', 1, NOW()),
(3, 'AAA-todo1', 1, NOW()),
(4, 'B-todo1', 1, NOW()),
(5, 'BB-todo1', 1, NOW());