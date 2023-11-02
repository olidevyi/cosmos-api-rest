CREATE TABLE IF NOT EXISTS `planets` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `radius` DOUBLE,
    `mass` DOUBLE,
    `orbit_period` DOUBLE,
    `distance_from_sun` DOUBLE,
    `registration_date` DATE NOT NULL,

    PRIMARY KEY(`id`)
);
