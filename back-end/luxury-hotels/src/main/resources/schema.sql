CREATE TABLE IF NOT EXISTS RoomType (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    guestCapacity INT,
    price DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS Room (
    number INT PRIMARY KEY,
    typeId INT,
    FOREIGN KEY (typeId) REFERENCES RoomType(id)
);

CREATE TABLE IF NOT EXISTS Users (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobileNumber VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roomNumber INT NOT NULL,
    checkinDate DATE NOT NULL,
    checkoutDate DATE NOT NULL,
    userId VARCHAR(255) NOT NULL,
    FOREIGN KEY (roomNumber) REFERENCES Room(number),
    FOREIGN KEY (userId) REFERENCES Users(id)
);
