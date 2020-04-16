DROP TABLE IF exists `address`;
DROP TABLE IF exists `wallet`;
DROP TABLE IF exists `user`;

CREATE TABLE `address` (
	`id` SERIAL,
    `country` VARCHAR(32) NOT NULL,
	`city` VARCHAR(32) NOT NULL,
	`street` VARCHAR(32) NOT NULL,
	`house_number` VARCHAR(16) NOT NULL,
	`zip_code` VARCHAR(8) NOT NULL,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`id`)
);

CREATE TABLE `wallet` (
	`id` SERIAL,
    `currency` bigint unsigned,
	`amount`  decimal(10,2) default 0,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`id`)
);

CREATE TABLE `user` (
	`id` SERIAL,
    `first_name` varchar(32) NOT NULL,
    `last_name` varchar(32) NOT NULL,
    `email` varchar(320) NOT NULL,
    `phone` varchar(16) NOT NULL,
    `role` varchar(16) NOT NULL,
    `password` varchar(256) NOT NULL,
    `enabled` boolean default false,
    `blocked` boolean default false,
	`address_id` bigint unsigned,
	`wallet_id` bigint unsigned unique,
	`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key(`id`),
    unique key(`email`),
    foreign key(`address_id`) references `address`(`id`),
    foreign key(`wallet_id`) references `wallet`(`id`)
);