INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (1, 'Fatima-Zahra', 'BOUDAD', 'fatty', 'fatty@example.com', 'password1', 'ADMIN', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (2, 'Yassine', 'CHALH', 'yaashall', 'yaashall@example.com', 'password2', 'ADMIN', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (3, 'Rida', 'EYADI', 'reeleyadi', 'reeleyadi@example.com', 'password3', 'ADMIN', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (4, 'Linda4', 'Williams', 'linda4', 'linda4@example.com', 'password4', 'ADMIN', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (5, 'Michael5', 'Brown', 'michael5', 'michael5@example.com', 'password5', 'ADMIN', NOW());
INSERT INTO users (user_id, first_name, last_name, user_name, email, password, role, created_at) VALUES (6, 'James6', 'Smith', 'james6', 'james6@example.com', 'password6', 'ADMIN', NOW());

INSERT INTO workspace (workspace_id, name, description) VALUES (1, 'Development Workspace1', 'Description of Development Workspace1');
INSERT INTO workspace (workspace_id, name, description) VALUES (2, 'Marketing Workspace2', 'Description of Marketing Workspace2');
INSERT INTO workspace (workspace_id, name, description) VALUES (3, 'Operations Workspace3', 'Description of Operations Workspace3');
INSERT INTO workspace (workspace_id, name, description) VALUES (4, 'Sales Workspace4', 'Description of Sales Workspace4');
INSERT INTO workspace (workspace_id, name, description) VALUES (5, 'HR Workspace5', 'Description of HR Workspace5');
INSERT INTO workspace (workspace_id, name, description) VALUES (6, 'Development Workspace6', 'Description of Development Workspace6');

INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (1, 'Product Launch Board1', 'Description of Product Launch Board1', NOW(), 'PUBLIC', false, 1);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (2, 'SEO Campaign Board2', 'Description of SEO Campaign Board2', NOW(), 'PUBLIC', false, 2);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (3, 'Recruitment Board3', 'Description of Recruitment Board3', NOW(), 'PUBLIC', false, 3);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (4, 'Sales Targets Board4', 'Description of Sales Targets Board4', NOW(), 'PUBLIC', false, 4);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (5, 'Onboarding Board5', 'Description of Onboarding Board5', NOW(), 'PUBLIC', false, 5);
INSERT INTO board (board_id, board_name, description, start_date, access_level, fav, workspace_id_board) VALUES (6, 'Product Launch Board6', 'Description of Product Launch Board6', NOW(), 'PUBLIC', false, 6);

INSERT INTO section (section_id, section_title, board_id_section) VALUES (1, 'Backlog ',  1);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (2, 'In Progress ', 2);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (3, 'Review ', 3);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (4, 'Done ', 4);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (5, 'Backlog ',5);
INSERT INTO section (section_id, section_title, board_id_section) VALUES (6, 'In Progress',6);

INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (1, 'Fix login bug 1', 'Description of Fix login bug Ticket1', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 1);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (2, 'Update landing page 2', 'Description of Update landing page Ticket2', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 2);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (3, 'Create new user flow 3', 'Description of Create new user flow Ticket3',NOW(), DATE('2024-12-31 01:02:03'),  'HIGH', 3);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (4, 'Improve SEO 4', 'Description of Improve SEO Ticket4', NOW(), DATE('2024-12-31 01:02:03'),'HIGH',  4);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (5, 'Refactor backend code 5', 'Description of Refactor backend code Ticket5', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 5);
INSERT INTO ticket (ticket_id, title, description, start_date, end_date, priority, section_id_ticket) VALUES (6, 'Fix login bug 6', 'Description of Fix login bug Ticket6', NOW(), DATE('2024-12-31 01:02:03'), 'HIGH', 6);

INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (1, 'Write unit tests 1', 'Description of Write unit tests Task1', 'IN_PROGRESS', 1);
INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (2, 'Design new feature 2', 'Description of Design new feature Task2', 'IN_PROGRESS', 2);
INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (3, 'Code review 3', 'Description of Code review Task3', 'IN_PROGRESS', 3);
INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (4, 'Database optimization 4', 'Description of Database optimization Task4', 'IN_PROGRESS', 4);
INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (5, 'Update documentation 5', 'Description of Update documentation Task5', 'IN_PROGRESS', 5);
INSERT INTO task (task_id, title, description, status, ticket_id_task) VALUES (6, 'Write unit tests 6', 'Description of Write unit tests Task6', 'IN_PROGRESS', 6);

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
