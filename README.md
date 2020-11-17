# cmpe281-cargonode

CREATE TABLE sensor(
      sensor_id INT NOT NULL,
      cargo_node_id INTEGER NOT NULL,
      snm_id INTEGER NOT NULL,
      sensor_name varchar(20) DEFAULT NULL,
      sensor_data varchar(25) DEFAULT NULL,
      sensor_status varchar(25) NOT NULL,
      time_stamp date NOT NULL,
      PRIMARY KEY(sensor_id)
);



INSERT INTO sensor VALUES  
(1, 50, 100,'temperature','50:F','Active', '2021-03-01'), 
(2, 50, 100,'gps','20:25','Active', '2021-03-01'), 
(3, 50, 100,'rfid','12345:Box','Active', '2021-03-01'), 
(4, 50, 100,'fuel','15:G','Active', '2021-03-01'),  
(5, 55, 100,'temperature','50:F','Active', '2021-03-01'),
 (6, 55, 100,'gps','20:25','Active', '2021-03-01', 
(7, 55, 100,'temperature','50:F','Inactive', '2021-03-01'), 
(8, 55, 100,'gps','20:25','Turn-Off', '2021-03-01'), 
 (9, 60, 150,'temperature','50:F','Active', '2021-03-01'), 
(10, 60, 150,'gps','20:25','Maintenance', '2021-03-01'), 
(11, 60, 150,'rfid','12345:Box','Active', '2021-03-01'), 
(12, 60, 150,'fuel','15:G','Turn-On', '2021-03-01'))	

