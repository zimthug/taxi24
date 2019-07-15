/*
insert into driver_statuses(status_desc) values('AVAILABLE');
insert into driver_statuses(status_desc) values('OFF DUTY');
insert into driver_statuses(status_desc) values('ON TRIP');
insert into driver_statuses(status_desc) values('ASSIGNED');

insert into trip_statuses(status_desc) values('REQUESTED');
insert into trip_statuses(status_desc) values('ASSIGNED');
insert into trip_statuses(status_desc) values('CANCELED');
insert into trip_statuses(status_desc) values('ON TRIP');
insert into trip_statuses(status_desc) values('COMPLETED');
*/

insert into drivers 
(firstname, surname, mobile_no, email, driver_photo, driver_status, completed_trips, kms_done, latitude, longitude)
values
('Isaac', 'Smith', '0711245675', 'isaac.smith@email.com', 'place_holder.jpg', 'AVAILABLE', 23, 278,  -42.0067, 12.8765 );

insert into riders
(firstname, surname, mobile_no, email)
values
('Frank', 'Stewards', '075659876', 'fedwards@gtalk.com');

insert into trips
(latitude_start, longitude_start, requested_at, assigned_at, started_at, completed_at, km_distance_covered, driver_id, rider_id, trip_status)
values
(0, 0, now(), now(), now(), now(), 12, 1, 1, 'COMPLETED');