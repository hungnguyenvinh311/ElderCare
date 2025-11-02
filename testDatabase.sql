USE testDatabase;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Khóa chính, tự động tăng
    username VARCHAR(50) NOT NULL UNIQUE, -- Tên đăng nhập, không trùng lặp
    password VARCHAR(255) NOT NULL       -- Mật khẩu (sẽ lưu dạng mã hóa)
);


CREATE TABLE role (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) 


CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`user_id`),
  KEY `fk_role_user` (`role_id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) 

INSERT INTO `role` VALUES (1,'Quản lý','MANAGER'),(2,'Nhân viên','STAFF'),(3,'Người dùng','USER'); 

DROP TABLE IF EXISTS `content`;
CREATE TABLE content (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,       -- Tiêu đề của bài báo hoặc video
    description TEXT,                  -- Mô tả ngắn
    url VARCHAR(2048) NOT NULL,        -- Đường link (URL) đến bài báo hoặc video YouTube
    thumbnailurl VARCHAR(2048),       -- (Tùy chọn) Link ảnh thumbnail
    contenttype VARCHAR(20) NOT NULL -- Phân loại: 'NEWS' hoặc 'VIDEO'
);

DROP TABLE IF EXISTS `Doctors`;

CREATE TABLE Doctors (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL,
    dateofbirth DATE,
    degree VARCHAR(100),
	rating DECIMAL(2,1),
    speciality VARCHAR(100),
    profileimageurl VARCHAR(255), 
    description TEXT
);

DROP TABLE IF EXISTS `DoctorPatients`;

CREATE TABLE DoctorPatients (
    doctor_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (doctor_id, user_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE appointments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  doctor_id BIGINT NOT NULL,
  appointment_date DATE NOT NULL,
  appointment_time TIME NOT NULL,
  status ENUM('Pending', 'Confirmed', 'Cancelled', 'Completed') DEFAULT 'Pending',
  reason TEXT,
  notes TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (doctor_id) REFERENCES Doctors(id)
);
