-- Inserting more sample users
INSERT INTO users (first_name, last_name, user_name, email, password, role, created_at) VALUES ('John', 'Doe', 'john.doe', 'john@example.com', 'secret', 'ADMIN', NOW());
INSERT INTO users (first_name, last_name, user_name, email, password, role, created_at) VALUES ('Jane', 'Smith', 'jane.smith', 'jane@example.com', 'secret', 'USER', NOW());
INSERT INTO users (first_name, last_name, user_name, email, password, role, created_at) VALUES ('Emily', 'Jones', 'emily.jones', 'emily@example.com', 'secret', 'USER', NOW());

-- Inserting more sample boards
INSERT INTO board (board_name, description, start_date, status) VALUES ('Project Alpha', 'Alpha project description', NOW(), 'ACTIVE');
INSERT INTO board (board_name, description, start_date, status) VALUES ('Project Beta', 'Beta project description', NOW(), 'PLANNING');
INSERT INTO board (board_name, description, start_date, status) VALUES ('Project Gamma', 'Gamma project description', NOW(), 'COMPLETED');

-- Inserting more sections for the boards
INSERT INTO section (section_title, description, board_id_section) VALUES ('Planning', 'Planning phase', 1);
INSERT INTO section (section_title, description, board_id_section) VALUES ('Design', 'Design phase', 2);
INSERT INTO section (section_title, description, board_id_section) VALUES ('Development', 'Development phase', 2);
INSERT INTO section (section_title, description, board_id_section) VALUES ('Testing', 'Testing phase', 3);

-- Inserting more tickets for sections
INSERT INTO ticket (title, description, priority, status, section_id_ticket) VALUES ('Initial Setup', 'Setup project environment', 'HIGH', 'IN_PROGRESS', 1);
INSERT INTO ticket (title, description, priority, status, section_id_ticket) VALUES ('Design Mockups', 'Create design mockups', 'MEDIUM', 'IN_PROGRESS', 2);
INSERT INTO ticket (title, description, priority, status, section_id_ticket) VALUES ('Feature Implementation', 'Implement the new features', 'HIGH', 'TODO', 3);
INSERT INTO ticket (title, description, priority, status, section_id_ticket) VALUES ('Bug Fixes', 'Resolve existing bugs', 'CRITICAL', 'DONE', 4);

-- Inserting more tasks for tickets
INSERT INTO task (title, description, status, deadline, ticket_id_task) VALUES ('Configure IDE', 'Setup IDE for development', 'IN_PROGRESS', '2024-04-01 12:00:00', 1);
INSERT INTO task (title, description, status, deadline, ticket_id_task) VALUES ('Mockup Landing Page', 'Design the landing page', 'DONE', '2024-05-01 12:00:00', 2);
INSERT INTO task (title, description, status, deadline, ticket_id_task) VALUES ('Implement Login', 'Develop login functionality', 'IN_PROGRESS', '2024-06-01 12:00:00', 3);
INSERT INTO task (title, description, status, deadline, ticket_id_task) VALUES ('Fix Login Bug', 'Resolve the login feature bug', 'TODO', '2024-07-01 12:00:00', 4);

-- Setting up more roles
INSERT INTO role (user_id, board_id, user_role) VALUES (1, 1, 'Project Manager');
INSERT INTO role (user_id, board_id, user_role) VALUES (2, 2, 'Designer');
INSERT INTO role (user_id, board_id, user_role) VALUES (3, 2, 'Developer');
INSERT INTO role (user_id, board_id, user_role) VALUES (2, 3, 'Tester');

-- Adding more users to tickets through members
INSERT INTO members (user_id, ticket_id) VALUES (1, 1);
INSERT INTO members (user_id, ticket_id) VALUES (2, 2);
INSERT INTO members (user_id, ticket_id) VALUES (3, 3);
INSERT INTO members (user_id, ticket_id) VALUES (2, 4);
