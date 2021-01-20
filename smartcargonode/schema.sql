USE testdata;
drop table sensor;
drop table cargo;

CREATE TABLE sensor(
      sensor_id INT NOT NULL AUTO_INCREMENT,
      cargo_node_id INTEGER NOT NULL,
      sensor_name varchar(20) DEFAULT NULL,
      sensor_data varchar(50) DEFAULT NULL,
      sensor_data_format varchar(25) DEFAULT NULL,
      sensor_status varchar(25) NOT NULL,
      time_stamp TIMESTAMP NOT NULL,
      PRIMARY KEY(sensor_id)
      FOREIGN KEY(cargo_node_id) REFERENCES cargo(cargo_node_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cargo(
      cargo_node_id INT NOT NULL AUTO_INCREMENT,
      cargo_node_name varchar(50),
      PRIMARY KEY(cargo_node_id),
      unique(cargo_node_name)
);

INSERT INTO cargo VALUES
(50,'truck_1'),
(55, 'truck_2'),
(60, 'truck_3');


INSERT INTO sensor VALUES
(1, 50, 'temperature','50','Celsius', 'Active', '1970-01-01 00:00:00'), 
(2, 50, 'gps','20:25','Co-ordinates', 'Active', '1970-01-01 00:00:00'), 
(3, 50, 'rfid','12345','bar_code', 'Active','1970-01-01 00:00:00'), 
(4, 50, 'fuel','15','Litres', 'Active', '1970-01-01 00:00:00'),
(5, 55, 'temperature','50', 'Celsius', 'Active', '1970-01-01 00:00:00'), 
(6, 55, 'gps','20:25','Co-ordinates', 'Active', '1970-01-01 00:00:00'), 
(7, 55, 'temperature','50','Celsius', 'Inactive', '1970-01-01 00:00:00'), 
(8, 55, 'gps','20:25','Co-ordinates', 'Turn-Off', '1970-01-01 00:00:00'), 
(9, 60, 'temperature','50','Celsius', 'Active', '1970-01-01 00:00:00'), 
(10, 60, 'gps','20:25','Co-ordinates', 'Maintenance', '1970-01-01 00:00:00'), 
(11, 60, 'rfid','12345','bar_code', 'Active', '1970-01-01 00:00:00'), 
(12, 60, 'fuel','15:G','Litres', 'Turn-On', '1970-01-01 00:00:00');
