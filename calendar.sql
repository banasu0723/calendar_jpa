CREATE TABLE `events` (
                            `event_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                            `user_id` BIGINT NOT NULL,
                            `title` VARCHAR(100) NOT NULL,
                            `content` VARCHAR(100) NOT NULL,
                            `created_date` DATETIME NOT NULL,
                            `updated_date` DATETIME NOT NULL
);

CREATE TABLE `users` (
                        `user_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                        `user_name` VARCHAR(10) NOT NULL,
                        `user_email` VARCHAR(25) NOT NULL,
                        `created_date` DATETIME NOT NULL,
                        `updated_date` DATETIME NULL
);

CREATE TABLE `comment` (
                           `comment_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                           `comment` VARCHAR(100) NOT NULL,
                           `user_name` VARCHAR(10) NOT NULL,
                           `created_date` DATETIME NOT NULL,
                           `updated_date` DATETIME NOT NULL,
                           `event_id` BIGINT NOT NULL,
                           FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`)
);

CREATE TABLE `schedule_user_map` (
                                     `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     `event_id` BIGINT NOT NULL,
                                     `user_id` BIGINT NOT NULL,
                                     FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`),
                                     FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);