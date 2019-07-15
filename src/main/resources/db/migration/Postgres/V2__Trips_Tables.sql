CREATE TABLE riders
(
  rider_id serial NOT NULL,
  firstname character varying(255),
  surname character varying(255),
  mobile_no character varying(255) not null,
  email character varying(255) not null,
  CONSTRAINT pk_rider PRIMARY KEY (rider_id)
);

/*
CREATE TABLE trip_statuses
(
  trip_status_id serial NOT NULL,
  status_desc character varying(255) not null,
  CONSTRAINT pk_trip_status PRIMARY KEY (trip_status_id)
);
*/

CREATE TABLE trips
(
  trip_id serial NOT NULL,
  latitude_start numeric(9, 6) not null,
  longitude_start numeric(9, 6) not null,
  requested_at timestamp without time zone not null,
  assigned_at timestamp without time zone,
  started_at timestamp without time zone,
  completed_at timestamp without time zone,
  km_distance_covered numeric(7, 2),
  driver_id bigint,
  rider_id bigint not null,
  trip_status character varying(60) not null,
  latitude_finish numeric(9, 6),
  longitude_finish numeric(9, 6),
  CONSTRAINT pk_trip PRIMARY KEY (trip_id),
  CONSTRAINT fk_trip_driver_id FOREIGN KEY (driver_id)
      REFERENCES drivers (driver_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_trip_rider_id FOREIGN KEY (rider_id)
      REFERENCES riders (rider_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION/*,
  CONSTRAINT fk_trip_trip_status_id FOREIGN KEY (trip_status)
      REFERENCES trip_statuses (trip_status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION*/
);