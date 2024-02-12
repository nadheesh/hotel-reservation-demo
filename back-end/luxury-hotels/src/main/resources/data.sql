-- H2 Compliant SQL Statements for RoomType and Room data

-- Insert or update room types
MERGE INTO RoomType KEY(id) VALUES (0, 'Single', 1, 80.00);
MERGE INTO RoomType KEY(id) VALUES (1, 'Double', 2, 120.00);
MERGE INTO RoomType KEY(id) VALUES (2, 'Family', 4, 200.00);
MERGE INTO RoomType KEY(id) VALUES (3, 'Suite', 4, 300.00);

-- Insert rooms, assuming RoomType entries exist
INSERT INTO Room (number, typeId) VALUES (101, 0);
INSERT INTO Room (number, typeId) VALUES (102, 0);
INSERT INTO Room (number, typeId) VALUES (103, 0);
INSERT INTO Room (number, typeId) VALUES (104, 0);
INSERT INTO Room (number, typeId) VALUES (105, 1);
INSERT INTO Room (number, typeId) VALUES (106, 1);
-- Add more inserts for all rooms as per the structure
-- ...
INSERT INTO Room (number, typeId) VALUES (406, 3);
