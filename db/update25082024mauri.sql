ALTER TABLE `gymmanagement`.`member` ADD COLUMN `photo` VARCHAR(45) DEFAULT 'anon.png' AFTER `membership_type_id`,
 ADD COLUMN `active` BOOLEAN DEFAULT false AFTER `photo`,
 ADD COLUMN `updated` DATETIME AFTER `active`;