/*
CREATE TABLE driver_statuses
(
  driver_status_id serial NOT NULL,
  status_desc character varying(255) not null,
  CONSTRAINT pk_driver_status PRIMARY KEY (driver_status_id)
);
*/


CREATE TABLE drivers
(
  driver_id serial NOT NULL,
  firstname character varying(255),
  surname character varying(255),
  mobile_no character varying(255) not null,
  email character varying(255) not null,
  driver_photo character varying(255),
  completed_trips integer not null,
  kms_done integer not null,
  latitude numeric(9, 6),
  longitude numeric(9, 6),
  driver_status character varying(120) not null,
  CONSTRAINT pk_driver PRIMARY KEY (driver_id) /*,
  CONSTRAINT fk_driver_driver_status FOREIGN KEY (driver_status)
      REFERENCES driver_statuses (driver_status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION*/
);