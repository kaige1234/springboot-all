
drop table IF exists 'Players';

CREATE TABLE Players (
  player_id bigint(20) NOT NULL,
  player_name varchar(100) DEFAULT NULL,
  PRIMARY KEY (player_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

INSERT INTO test.Players
(player_id, player_name)
VALUES(1, '2222');








