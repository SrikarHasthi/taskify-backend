
--INSERT INTO role (id, name) VALUES (1,'ADMIN'),(2,'USER');


--insert into user_data (user_id, email, password) values (101, 'abc@gmail.com', 'abc');
--insert into user_data (user_id, email, password) values (102, 'xyz@gmail.com', 'xyz');
--insert into user_data (user_id, email, password) values (103, 'pqrs@gmail.com', 'pqrs');
--
--INSERT INTO user_data_roles (user_data_user_id, roles_id) VALUES (101,1),(102,2);
--
--insert into todo_history (todo_history_id, date_created, user_data_user_id) values (10001, '2024-02-18', 102);
--insert into todo_history (todo_history_id, date_created, user_data_user_id) values (10002, '2024-02-18', 101);
--insert into todo_history (todo_history_id, date_created, user_data_user_id) values (10003, '2024-02-19', 101);
--
insert into todo (id, description, priority, status, summary, time, date_created  ) values (10005, 'Learn Backend', 'medium', 'new', 'Learn backend', 3600000, '1708281792855');
insert into todo (id, description, priority, status, summary, time, date_created  ) values (10002, 'Learn aws', 'medium', 'new', 'Learn aws', 3600000, '1708281792855');
insert into todo (id, description, priority, status, summary, time, date_created ) values (10003, 'Learn slkjdlkgfg', 'medium', 'new', 'Learn fdgfgdfg', 3600000, '1708281792855');

