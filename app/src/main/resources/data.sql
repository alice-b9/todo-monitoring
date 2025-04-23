-- 사용자 정보
INSERT INTO users (username, password)
VALUES ('admin', 'admin123'),
       ('testuser', 'test123');

-- Todo 항목
INSERT INTO todo (title, completed, username, created_at, updated_at)
VALUES ('포트폴리오 구조 정리하기', false, 'admin', NOW(), NOW()),
       ('OpenTelemetry 설정 적용', true, 'testuser', NOW(), NOW());