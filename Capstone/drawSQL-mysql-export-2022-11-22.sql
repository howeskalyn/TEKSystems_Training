CREATE TABLE `users`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `zip` INT NOT NULL
);
ALTER TABLE
    `users` ADD PRIMARY KEY `users_id_primary`(`id`);
CREATE TABLE `event`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `venue` VARCHAR(255) NOT NULL,
    `zip` INT NOT NULL,
    `date` DATE NOT NULL,
    `time` TIME NOT NULL,
    `ticket_price` DOUBLE NOT NULL,
    `artist` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `event` ADD PRIMARY KEY `event_id_primary`(`id`);
CREATE TABLE `friend`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `friend_id` INT NOT NULL
);
ALTER TABLE
    `friend` ADD PRIMARY KEY `friend_id_primary`(`id`);
CREATE TABLE `ticketPurchase`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `event_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `quantity` INT NOT NULL
);
ALTER TABLE
    `ticketPurchase` ADD PRIMARY KEY `ticketpurchase_id_primary`(`id`);
ALTER TABLE
    `ticketPurchase` ADD CONSTRAINT `ticketpurchase_event_id_foreign` FOREIGN KEY(`event_id`) REFERENCES `event`(`id`);
ALTER TABLE
    `friend` ADD CONSTRAINT `friend_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `friend` ADD CONSTRAINT `friend_friend_id_foreign` FOREIGN KEY(`friend_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `ticketPurchase` ADD CONSTRAINT `ticketpurchase_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);