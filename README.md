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
