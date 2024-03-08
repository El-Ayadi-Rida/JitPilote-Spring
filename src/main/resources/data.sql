INSERT INTO workspace (name, description) VALUES
                                              ('Development Projects', 'Workspace for all development-related projects.'),
                                              ('Marketing Campaigns', 'Workspace dedicated to marketing and campaign planning.'),
                                              ('HR Initiatives', 'Human resources and recruitment initiatives.'),
                                              ('Product Launches', 'Workspace for upcoming product launches and updates.'),
                                              ('Customer Support', 'Projects related to customer support improvements.');

INSERT INTO board (board_name, description, start_date, status, workspace_id_board) VALUES
                                                                                        ('Backend Development', 'Board for backend project tasks.', NOW(), 'ACTIVE', 1),
                                                                                        ('Frontend Development', 'Board for frontend project tasks.', NOW(), 'ACTIVE', 1),
                                                                                        ('QA Testing', 'Quality assurance and testing board.', NOW(), 'ACTIVE', 1);

INSERT INTO section (section_title, description, board_id_section) VALUES
                                                                       ('Authentication Module', 'Tasks related to user authentication.', 1),
                                                                       ('Database Migration', 'Database migration tasks.', 1),
                                                                       ('API Development', 'RESTful API development tasks.', 1);

INSERT INTO ticket (title, description, priority, status, section_id_ticket) VALUES
                                                                                 ('Implement OAuth2', 'Implement OAuth2 authentication.', 'HIGH', 'OPEN', 1),
                                                                                 ('Password Reset', 'Implement password reset functionality.', 'MEDIUM', 'OPEN', 1),
                                                                                 ('User Registration', 'Implement user registration flow.', 'HIGH', 'IN_PROGRESS', 1);

INSERT INTO task (title, description, status, deadline, ticket_id_task) VALUES
                                                                            ('Design OAuth2 Flow', 'Design the OAuth2 authentication flow.', 'IN_PROGRESS', '2024-03-30 00:00:00', 1),
                                                                            ('Implement OAuth2 in Backend', 'Implement OAuth2 in the backend service.', 'TODO', '2024-04-15 00:00:00', 1),
                                                                            ('Test OAuth2 Implementation', 'Test the OAuth2 implementation thoroughly.', 'TODO', '2024-04-20 00:00:00', 1);

INSERT INTO users (first_name, last_name, user_name, email, password, role, created_at) VALUES
                                                                                           ('Rachid', 'Nouri', 'rachidnouri', 'rachidnouri@gmail.com', 'hashed_password', 'MEMBER', NOW()),
                                                                                           ('Rida', 'ELAYADI', 'reelayadi', 'reelayadi@gmail.com', 'hashed_password', 'ADMIN', NOW()),
                                                                                           ('Imane', 'BANDANA', 'bdbd45', 'bdbd45@gmail.com', 'hashed_password', 'MEMBER', NOW());

INSERT INTO user_board_role (user_id, board_id, user_role) VALUES
                                                               (1, 1, 'ADMIN'),
                                                               (2, 1, 'MEMBER'),
                                                               (3, 1, 'MEMBER');

INSERT INTO user_ticket_association (user_id, ticket_id) VALUES
                                                             (1, 1),
                                                             (1, 2),
                                                             (2, 3),
                                                             (3, 1),
                                                             (3, 2);

INSERT INTO user_workspace_role (user_id, workspace_id) VALUES
                                                            (1, 1),
                                                            (2, 1),
                                                            (3, 1);
