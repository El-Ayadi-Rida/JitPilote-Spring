INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (1, 'Fatima-Zahra', 'BOUDAD', 'fatty', 'fatty@example.com', 'password1', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (2, 'Yassine', 'CHALH', 'yaashall', 'yaashall@example.com', 'password2', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (3, 'Rida', 'EYADI', 'reeleyadi', 'reeleyadi@example.com', 'password3', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (4, 'Linda4', 'Williams', 'linda4', 'linda4@example.com', 'password4', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (5, 'Michael5', 'Brown', 'michael5', 'michael5@example.com', 'password5', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, created_at) VALUES (6, 'James6', 'Smith', 'james6', 'james6@example.com', 'password6', NOW());

INSERT INTO workspace (workspace_id, name, description) VALUES (1, 'Development', 'Description of Development');
INSERT INTO workspace (workspace_id, name, description) VALUES (2, 'Marketing', 'Description of Marketing');
INSERT INTO workspace (workspace_id, name, description) VALUES (3, 'Operations', 'Description of Operations');
INSERT INTO workspace (workspace_id, name, description) VALUES (4, 'Sales', 'Description of Sales');
INSERT INTO workspace (workspace_id, name, description) VALUES (5, 'HR', 'Description of HR');
INSERT INTO workspace (workspace_id, name, description) VALUES (6, 'Development', 'Description of Development');

INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (1, 'Product Launch', 'Description of Product Launch', NOW(), 'PUBLIC', false, 1);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (2, 'SEO Campaign', 'Description of SEO Campaign', NOW(), 'PUBLIC', false, 2);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (3, 'Recruitment', 'Description of Recruitment', NOW(), 'PUBLIC', false, 3);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (4, 'Sales Targets', 'Description of Sales Targets', NOW(), 'PUBLIC', false, 4);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (5, 'Onboarding', 'Description of Onboarding', NOW(), 'PUBLIC', false, 5);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (6, 'Product Launch', 'Description of Product Launch', NOW(), 'PUBLIC', false, 6);

INSERT INTO section (section_id, section_title, board_id_section) VALUES (1, 'Backlog ',  1);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (2, 'In Progress ', 2);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (3, 'Review ', 3);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (4, 'Done ', 4);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (5, 'Backlog ',5);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (6, 'In Progress',6);

INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (1, 'Fix login bug', 'Description of Fix login bug ', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 1);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (2, 'Update landing page', 'Description of Update landing page', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 2);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (3, 'Create new user flow', 'Description of Create new user flow ',NOW(), DATE('2024-12-31 01:02:03'),  'HIGH', 3);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (4, 'Improve SEO ', 'Description of Improve SEO ', NOW(), DATE('2024-12-31 01:02:03'),'HIGH',  4);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (5, 'Refactor backend code', 'Description of Refactor backend code ', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 5);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (6, 'Fix login bug ', 'Description of Fix login bug ', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 6);

INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (1, 'Write unit tests', false, 1);
INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (2, 'Design new feature', false, 2);
INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (3, 'Code review', false, 3);
INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (4, 'Database optimization', false, 4);
INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (5, 'Update documentation ', false, 5);
INSERT INTO task (task_id, title, is_done, ticket_id_task) VALUES (6, 'Write unit tests ', false, 6);

INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (1, 1, 'MEMBER');
INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (2, 2, 'MEMBER');
INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (3, 3, 'MEMBER');
INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (4, 4, 'MEMBER');
INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (5, 5, 'MEMBER');
INSERT INTO user_board_role (user_id, board_id, user_role) VALUES (6, 6, 'MEMBER');

INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (1, 1, 'MEMBER');
INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (2, 2, 'MEMBER');
INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (3, 3, 'MEMBER');
INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (4, 4, 'MEMBER');
INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (5, 5, 'MEMBER');
INSERT INTO user_workspace_role (user_id_workspace_role, workspace_id_workspace_role, user_role) VALUES (6, 6, 'MEMBER');
