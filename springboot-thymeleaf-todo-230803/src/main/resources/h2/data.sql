INSERT INTO `user` (`idx`, `id`, `password`, `create_date`)
VALUES (1, 'admin', '$2a$12$7bGo8XbIcosxEYGsKXeyW.0TS9snGlxvVB9nsJz4n5h.YotU1Wi7u', now()),
       (2, 'test', '$2a$12$7bGo8XbIcosxEYGsKXeyW.0TS9snGlxvVB9nsJz4n5h.YotU1Wi7u', now());


INSERT INTO `user_role` (`user_idx`, `role`, `create_date`)
VALUES (1, 'ADMIN', now()),
       (1, 'USER', now()),
       (2, 'USER', now());


INSERT INTO `todo` (`user_idx`, `content`, `done_yn`, `create_date`)
VALUES (2, '일어나기', 'Y', now()),
       (2, '양치하기', 'Y', now()),
       (2, '샤워하기', 'N', now()),
       (2, '출근하기', 'N', now()),
       (2, '퇴근하기', 'N', now());