CREATE DATABASE Manage_Library;

USE Manage_Library;

-- Bảng Users
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('Admin', 'User') DEFAULT 'User'
);

-- Bảng Categories
CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

-- Bảng Books
CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    publication_year YEAR,
    isbn VARCHAR(20) UNIQUE,
    category INT,
    quantity INT DEFAULT 1,
    image VARCHAR(255),
    FOREIGN KEY (category) REFERENCES Categories(category_id)
);

-- Bảng BorrowRecords
CREATE TABLE BorrowRecords (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    book_id INT,
    borrow_date DATE NOT NULL,
    return_date DATE,
    status ENUM('Borrowed', 'Returned') DEFAULT 'Borrowed',
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

INSERT INTO Categories (category_name) VALUES
('Fiction'),
('Non-Fiction'),
('Science'),
('History'),
('Biography');

INSERT INTO Books (title, author, publisher, publication_year, isbn, category, quantity, image) VALUES
('To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', 1960, '9780060935467', 1, 5, 'ToKillaMockingbird.jpg'),
('A Brief History of Time', 'Stephen Hawking', 'Bantam Books', 1988, '9780553380163', 3, 3, 'BriefHistoryTime.jpg'),
('Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'Harvill Secker', 2011, '9780099590088', 4, 4, 'ABriefHistoryofHumankind.jpg'),
('The Diary of a Young Girl', 'Anne Frank', 'Contact Publishing', 1947, '9780553296983', 5, 2, 'TheDiaryofaYoungGirl.jpg'),
('1984', 'George Orwell', 'Secker & Warburg', 1949, '9780451524935', 1, 6, '1984.jpg');

INSERT INTO Users (fname, password, email, role) VALUES
('admin', 'admin123', 'admin@example.com', 'Admin'),
('john_doe', 'password123', 'john.doe@example.com', 'User'),
('jane_doe', 'password123', 'jane.doe@example.com', 'User'),
('student1', 'password123', 'student1@example.com', 'User'),
('student2', 'password123', 'student2@example.com', 'User');


INSERT INTO BorrowRecords (user_id, book_id, borrow_date, return_date, status) VALUES
(2, 1, '2024-12-01', '2024-12-10', 'Returned'),
(3, 2, '2024-12-05', NULL, 'Borrowed'),
(4, 3, '2024-12-08', NULL, 'Borrowed'),
(5, 4, '2024-12-10', '2024-12-15', 'Returned'),
(3, 5, '2024-12-11', NULL, 'Borrowed');

SELECT fname, title, borrow_date, return_date, status
FROM Users INNER JOIN BorrowRecords ON Users.user_id = BorrowRecords.user_id 
INNER JOIN Books ON BorrowRecords.book_id = Books.book_id
WHERE Users.user_id = 3;