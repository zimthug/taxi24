create table driver_status
(
driver_status_id serial not null primary key,
status_desc varchar(60) not null
);

create table drivers
(
driver_id serial not null primary key,
firstname varchar(60),
surname varchar(60),
mobile_no varchar(60) not null,
email varchar(255) not null,
driver_photo varchar(255),
driver_status_id integer not null,
completed_trips numeric(5) not null,
kms_done numeric(9) not null,
latitude numeric(9, 6) ,
longitude numeric(9, 6) ,
constraint fk_driver_info_status foreign key (driver_status_id)
	references driver_status (driver_status_id) match simple
    on update no action on delete no action
);

alter table drivers
  add constraint unq_drivers_email unique (email);
  
 alter table drivers
  add constraint unq_drivers_mobile_no unique (mobile_no);

