CREATE TABLE board (
                       board_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       board_name VARCHAR(255),
                       description TEXT,
                       start_date TIMESTAMP,
                       status VARCHAR(50)
);

CREATE TABLE users (
                       user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       user_name VARCHAR(255),
                       email VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(50),
                       created_at TIMESTAMP NOT NULL
);

CREATE TABLE section (
                         section_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         section_title VARCHAR(255),
                         description TEXT,
                         board_id_section BIGINT,
                         FOREIGN KEY (board_id_section) REFERENCES board(board_id)
);

CREATE TABLE ticket (
                        ticket_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255),
                        description TEXT,
                        priority VARCHAR(50),
                        status VARCHAR(50),
                        section_id_ticket BIGINT,
                        FOREIGN KEY (section_id_ticket) REFERENCES section(section_id)
);

CREATE TABLE task (
                      task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      description TEXT,
                      status VARCHAR(50),
                      deadline TIMESTAMP,
                      ticket_id_task BIGINT,
                      FOREIGN KEY (ticket_id_task) REFERENCES ticket(ticket_id)
);

CREATE TABLE role (
                      user_id BIGINT,
                      board_id BIGINT,
                      user_role VARCHAR(255),
                      PRIMARY KEY (user_id, board_id),
                      FOREIGN KEY (user_id) REFERENCES users(user_id),
                      FOREIGN KEY (board_id) REFERENCES board(board_id)
);

CREATE TABLE members (
                         user_id BIGINT,
                         ticket_id BIGINT,
                         PRIMARY KEY (user_id, ticket_id),
                         FOREIGN KEY (user_id) REFERENCES users(user_id),
                         FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id)
);
