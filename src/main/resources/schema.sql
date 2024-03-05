/*
-- Create workspace table
CREATE TABLE workspace (
                           workspace_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255),
                           description TEXT
);

-- Create board table
CREATE TABLE board (
                       board_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       board_name VARCHAR(255),
                       description TEXT,
                       start_date TIMESTAMP,
                       status VARCHAR(255),
                       workspace_id_board BIGINT,
                       FOREIGN KEY (workspace_id_board) REFERENCES workspace(workspace_id) ON DELETE CASCADE
);

-- Create section table
CREATE TABLE section (
                         section_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         section_title VARCHAR(255),
                         description TEXT,
                         board_id_section BIGINT,
                         FOREIGN KEY (board_id_section) REFERENCES board(board_id) ON DELETE CASCADE
);

-- Create ticket table
CREATE TABLE ticket (
                        ticket_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255),
                        description TEXT,
                        priority VARCHAR(255),
                        status VARCHAR(255),
                        section_id_ticket BIGINT,
                        FOREIGN KEY (section_id_ticket) REFERENCES section(section_id) ON DELETE CASCADE
);

-- Create task table
CREATE TABLE task (
                      task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      description TEXT,
                      status VARCHAR(255),
                      deadline TIMESTAMP,
                      ticket_id_task BIGINT,
                      FOREIGN KEY (ticket_id_task) REFERENCES ticket(ticket_id) ON DELETE CASCADE
);

-- Create users table
CREATE TABLE users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       user_name VARCHAR(255),
                       email VARCHAR(255),
                       password TEXT,
                       role VARCHAR(255),
                       created_at TIMESTAMP
);

-- Create user_board_role table
CREATE TABLE user_board_role (
                                 user_id BIGINT,
                                 board_id BIGINT,
                                 user_role VARCHAR(255),
                                 PRIMARY KEY (user_id, board_id),
                                 FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                 FOREIGN KEY (board_id) REFERENCES board(board_id) ON DELETE CASCADE
);

-- Create user_workspace_role table
CREATE TABLE user_workspace_role (
                                     user_id BIGINT,
                                     workspace_id BIGINT,
                                     PRIMARY KEY (user_id, workspace_id),
                                     FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                     FOREIGN KEY (workspace_id) REFERENCES workspace(workspace_id) ON DELETE CASCADE
);

-- Create user_ticket_association table for ManyToMany relation between User and Ticket
CREATE TABLE user_ticket_association (
                                         user_id BIGINT,
                                         ticket_id BIGINT,
                                         PRIMARY KEY (user_id, ticket_id),
                                         FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                         FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id) ON DELETE CASCADE
);
*/