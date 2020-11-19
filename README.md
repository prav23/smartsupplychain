# cmpe281-cargonode

USE testdata;
drop table sensor;
CREATE TABLE sensor(
      sensor_id INT NOT NULL AUTO_INCREMENT,
      cargo_node_id INTEGER NOT NULL,
      sensor_name varchar(20) DEFAULT NULL,
      sensor_data varchar(25) DEFAULT NULL,
      sensor_data_format varchar(25) DEFAULT NULL,
      sensor_status varchar(25) NOT NULL,
      time_stamp Date NOT NULL,
      PRIMARY KEY(sensor_id)
);

INSERT INTO sensor VALUES
(1, 50, 'temperature','50','Celsius', 'Active', '2021-03-01'), 
(2, 50, 'gps','20:25','Co-ordinates', 'Active', '2021-03-01'), 
(3, 50, 'rfid','12345','bar_code', 'Active','2021-03-01'), 
(4, 50, 'fuel','15','Litres', 'Active', '2021-03-01'),
(5, 55, 'temperature','50', 'Celsius', 'Active', '2021-03-01'), 
(6, 55, 'gps','20:25','Co-ordinates', 'Active', '2021-03-01'), 
(7, 55, 'temperature','50','Celsius', 'Inactive', '2021-03-01'), 
(8, 55, 'gps','20:25','Co-ordinates', 'Turn-Off', '2021-03-01'), 
(9, 60, 'temperature','50','Celsius', 'Active', '2021-03-01'), 
(10, 60, 'gps','20:25','Co-ordinates', 'Maintenance', '2021-03-01'), 
(11, 60, 'rfid','12345','bar_code', 'Active', '2021-03-01'), 
(12, 60, 'fuel','15:G','Litres', 'Turn-On', '2021-03-01');
