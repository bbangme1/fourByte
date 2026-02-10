CREATE TABLE `trip` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '여행 이름',
  `phone` varchar(50) NOT NULL COMMENT '연락처',
  `start_date` date NOT NULL COMMENT '출발일',
  `end_date` date NOT NULL COMMENT '도착일',
  `count` int NOT NULL COMMENT '여행 인원'
);

CREATE TABLE `schedule` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `trip_id` bigint NOT NULL,
  `place` varchar(255) NOT NULL COMMENT '장소명',
  `departure` varchar(255) NOT NULL COMMENT '출발지',
  `location` varchar(255) NOT NULL COMMENT '도착지',
  `visit_date` date NOT NULL COMMENT '여행 중 해당 날짜',
  `time` datetime NOT NULL COMMENT '방문 시간'
);

CREATE TABLE `budget_item` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `trip_id` bigint NOT NULL,
  `item_name` varchar(255) NOT NULL COMMENT '지출 항목',
  `price` int NOT NULL COMMENT '지출 금액'
);

CREATE TABLE `checklist` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `trip_id` bigint NOT NULL,
  `item_name` varchar(255) NOT NULL COMMENT '준비물 이름',
  `is_checked` boolean DEFAULT false COMMENT '체크 여부'
);

ALTER TABLE `schedule` ADD FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`);

ALTER TABLE `budget_item` ADD FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`);

ALTER TABLE `checklist` ADD FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`);
