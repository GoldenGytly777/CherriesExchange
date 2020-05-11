
DROP TABLE IF exists `wallet`;
DROP TABLE IF exists `address`;
DROP TABLE IF exists `transaction_history`;
DROP TABLE IF exists `currency`;
DROP TABLE IF exists `user`;

CREATE TABLE `user` (
	`user_id` SERIAL,
    `first_name` varchar(32) NOT NULL,
    `last_name` varchar(32) NOT NULL,
    `email` varchar(320) NOT NULL,
    `phone` varchar(16) NOT NULL,
    `role` varchar(16) NOT NULL,
    `password` varchar(256) NOT NULL,
    `enabled` boolean default false,
    `blocked` boolean default false,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`user_id`),
    unique key(`email`)
);

CREATE TABLE `address` (
	`id` SERIAL,
    `user_id` bigint unsigned NOT NULL,
    `country` VARCHAR(32) NOT NULL,
	`city` VARCHAR(32) NOT NULL,
	`street` VARCHAR(32) NOT NULL,
	`house_number` VARCHAR(16) NOT NULL,
	`zip_code` VARCHAR(8) NOT NULL,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`id`),
    foreign key(`user_id`) references `user`(`user_id`)


);
CREATE TABLE `currency` (
	`id` SERIAL,
    `code` varchar(3),
    `name` varchar(10)
);

CREATE TABLE `wallet` (
	`id` SERIAL,
    `user_id` bigint unsigned NOT NULL,
    `currency_id` bigint unsigned NOT NULL,
	`amount`  decimal(10,2) default 0,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`id`),
	FOREIGN KEY(`user_id`) REFERENCES `user`(`user_id`),
    FOREIGN KEY(`currency_id`) REFERENCES `currency`(`id`)
);

CREATE TABLE `transaction_history` (
	`id` SERIAL,
    `user_id` bigint unsigned NOT NULL,
    `currency_from` bigint unsigned NOT NULL,
    `currency_to` bigint unsigned NOT NULL,
    `value_from` decimal(10,2) default 0,
    `value_to` decimal(10,2) default 0,
    `amount_from`  decimal(10,2) default 0,
    `amount_to`  decimal(10,2) default 0,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    primary key(`id`),
	FOREIGN KEY(`user_id`) REFERENCES `user`(`user_id`),
    FOREIGN KEY(`currency_from`) REFERENCES `currency`(`id`),
    FOREIGN KEY(`currency_to`) REFERENCES `currency`(`id`)
);