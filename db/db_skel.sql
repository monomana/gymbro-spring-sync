-- Estructura traida de Mysql Query Browser

CREATE TABLE membership_type (
    id INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(50),
    duration_months INT,
    price DECIMAL(10,2)
);

CREATE TABLE member (
    id INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_birth DATE,
    gender VARCHAR(10),
    phone VARCHAR(15),
    email VARCHAR(100),
    address VARCHAR(255),
    join_date DATETIME,
    membership_type_id INT UNSIGNED,
    FOREIGN KEY (membership_type_id) REFERENCES membership_type(id)
);


DROP TABLE IF EXISTS `gymmanagement`.`trainer`;
CREATE TABLE  `gymmanagement`.`trainer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE class (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(50),
    description TEXT,
    trainer_id INT(11) UNSIGNED,
    FOREIGN KEY (trainer_id) REFERENCES trainer(id)
);

CREATE TABLE payment (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    member_id INT UNSIGNED,
    amount DECIMAL(10,2),
    payment_date DATETIME,
    payment_method VARCHAR(50),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE schedule (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    class_id INT UNSIGNED,
    trainer_id INT UNSIGNED,
    start_time DATETIME,
    end_time DATETIME,
    day_of_week VARCHAR(10),
    FOREIGN KEY (class_id) REFERENCES class(id),
    FOREIGN KEY (trainer_id) REFERENCES trainer(id)
);

CREATE TABLE attendance (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    member_id INT UNSIGNED,
    schedule_id INT UNSIGNED,
    attendance_date DATE,
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id)
);
