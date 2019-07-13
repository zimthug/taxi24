create table riders
(
rider_id serial primary key not null,
firstname varchar(60),
surname varchar(60),
mobile_no varchar(60) not null,
email varchar(255) not null 
);

create table trip_status
(
trip_status_id serial primary key not null,
trip_status varchar(60) not null
);

create table trips
(
trip_id serial primary key not null,
rider_id integer not null,
latitude_start numeric(9, 6) not null,
longitude_start numeric(9, 6) not null,
trip_status_id integer not null,
requested_at timestamp without time zone not null default now(),
driver_id integer, 
assigned_at timestamp without time zone,
started_at timestamp without time zone not null default now(),
completed_at timestamp without time zone not null default now(),
km_distance_covered numeric(7, 3),
constraint fk_trip_status foreign key (trip_status_id)
	references trip_status (trip_status_id) match simple
    on update no action on delete no action,
constraint fk_trip_rider foreign key (rider_id)
	references riders (rider_id) match simple
    on update no action on delete no action,
constraint fk_trip_driver foreign key (driver_id)
	references drivers (driver_id) match simple
    on update no action on delete no action
);

