INSERT INTO chat.user (login, password) VALUES ('John', '123');
INSERT INTO chat.user (login, password) VALUES ('Jim', '12345');
INSERT INTO chat.user (login, password) VALUES ('Alex', '1234567');
INSERT INTO chat.user (login, password) VALUES ('Olivia', 'qwe');
INSERT INTO chat.user (login, password) VALUES ('Ashley', 'qwerty');
INSERT INTO chat.user (login, password) VALUES ('Kate', 'qwetyuiop');

INSERT INTO chat.room (chat_name, chat_owner) VALUES ('general', 1);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('random', 2);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('moscow_adm', 3);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('msk_report', 4);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('msk_services', 5);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('piscine_java', 6);

INSERT INTO chat.message (room_id, sender, message, time) VALUES (1, 6, 'Hello', '2000-01-01 01:01:01');
INSERT INTO chat.message (room_id, sender, message, time) VALUES (2, 5, 'World', '2000-02-02 02:02:02');
INSERT INTO chat.message (room_id, sender, message, time) VALUES (3, 4, 'ttt', '2000-03-03 03:03:03');
INSERT INTO chat.message (room_id, sender, message, time) VALUES (4, 3, '123', '2000-04-04 04:04:04');
INSERT INTO chat.message (room_id, sender, message, time) VALUES (5, 2, 'Java Piscine', '2000-05-05 05:05:05');
INSERT INTO chat.message (room_id, sender, message, time) VALUES (6, 1, 'HELP!', '2000-06-06 06:06:06');