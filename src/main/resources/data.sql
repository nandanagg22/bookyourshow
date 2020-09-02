------------ CITY MASTER DATA -------------------
INSERT INTO City(id, name) VALUES (1, 'Bangalore');
INSERT INTO City(id, name) VALUES (2, 'Mumbai');
INSERT INTO City(id, name) VALUES (3, 'Delhi');

------------ THEATRE MASTER DATA -------------------
INSERT INTO Theatre(id, name, city, address) VALUES (1, 'pvr', 'Bangalore', 'Whitefield');
INSERT INTO Theatre(id, name, city, address) VALUES (2, 'phoenix', 'Bangalore', 'Koramangla');

------------ SHOWS MASTER DATA -------------------
INSERT INTO Show(id, name, type, theatre_id, hall_code, status, start_time, end_time)
        VALUES (1, 'SpiderMan',0, 1, 'Screen-A', 1, '2020-09-01 11:00:00', '2020-09-01 13:00:00');
INSERT INTO Show(id, name, type, theatre_id, hall_code, status, start_time, end_time)
        VALUES (2, 'Inception',0, 1, 'Screen-B', 1, '2020-09-01 11:00:00', '2020-09-01 13:00:00');
INSERT INTO Show(id, name, type, theatre_id, hall_code, status, start_time, end_time)
        VALUES (3, 'BatMan',0, 1, 'Screen-C', 1, '2020-09-01 11:00:00', '2020-09-01 13:00:00');

------------ BOOKING DATA -------------------
INSERT INTO Booking(id, seat_number, show_id, status, booking_time)
        VALUES (1, 'A1',1, 0, null);
INSERT INTO Booking(id, seat_number, show_id, status, booking_time)
        VALUES (2, 'A2',1, 0, null);
INSERT INTO Booking(id, seat_number, show_id, status, booking_time)
        VALUES (3, 'A3',1, 1, '2020-09-01 09:00:00');
INSERT INTO Booking(id, seat_number, show_id, status, booking_time)
        VALUES (4, 'A4',1, 2, '2020-09-01 09:10:00');

