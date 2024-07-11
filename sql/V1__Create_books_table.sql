CREATE DATABASE IF NOT EXISTS ctlms;

USE ctlms;

CREATE TABLE IF NOT EXISTS books (
    bookID INT AUTO_INCREMENT,
    bookISBN VARCHAR(13) PRIMARY KEY,
    bookTitle VARCHAR(255) NOT NULL,
    bookAuthor VARCHAR(255) NOT NULL,
    bookQuantity INT NOT NULL,
    bookShelf VARCHAR(50) NOT NULL,
    UNIQUE KEY (bookID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS bookExtendedInfo (
    bookISBN VARCHAR(13) PRIMARY KEY,
    bookSummary TEXT NOT NULL,
    bookPublisher VARCHAR(255) NOT NULL,
    bookYear INT NOT NULL,
    imagePath VARCHAR(255) NOT NULL,
    FOREIGN KEY (bookISBN) REFERENCES books(bookISBN)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS userInquiries (
    inquiryID INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NULL,
    inquiry TEXT NOT NULL,
    submissionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert Dummy Data 
INSERT INTO books (bookISBN, bookTitle, bookAuthor, bookQuantity, bookShelf) VALUES
('9780439023528', 'The Hunger Games', 'Suzanne Collins', 7, 'A1'),
('9780316769488', 'The Catcher in the Rye', 'J.D. Salinger', 6, 'B2'),
('9780439554930', 'Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 8, 'C3'),
('9780140283297', 'On The Road', 'Jack Kerouac', 3, 'D4'),
('9780679783268', 'Pride and Prejudice', 'Jane Austen', 8, 'F6'),
('9780743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', 6, 'G7'),
('9780060850524', 'Brave New World', 'Aldous Huxley', 8, 'H8'),
('9780385490818', 'The Kite Runner', 'Khaled Hosseini', 5, 'I1'),
('9780553418026', 'The Martian', 'Andy Weir', 7, 'J2'),
('9781400032716', 'Beloved', 'Toni Morrison', 6, 'L4'),
('9780141439600', 'Wuthering Heights', 'Emily Bronte', 8, 'N6'),
('9780553573405', 'A Game of Thrones', 'George R.R. Martin', 7, 'P8'),
('9780140449266', 'Crime and Punishment', 'Fyodor Dostoevsky', 6, 'Q1'),
('9780451524935', 'The Scarlet Letter', 'Nathaniel Hawthorne', 5, 'R2'),
('9780440180296', 'Slaughterhouse-Five', 'Kurt Vonnegut', 8, 'S3'),
('9780375842206', 'The Book Thief', 'Markus Zusak', 7, 'T4'),
('9780141182534', 'Animal Farm', 'George Orwell', 8, 'V6'),
('9780385504201', 'The Lovely Bones', 'Alice Sebold', 5, 'W7'),
('9780399501487', 'Lord of the Flies', 'William Golding', 7, 'Z1'),
('9780439139601', 'Harry Potter and the Goblet of Fire', 'J.K. Rowling', 7, 'Z2'),
('9780307277671', 'The Da Vinci Code', 'Dan Brown', 6, 'A3'),
('9780142410708', 'Looking for Alaska', 'John Green', 8, 'B4'),
('9780525478812', 'The Fault in Our Stars', 'John Green', 5, 'C5'),
('9781451648539', 'Steve Jobs', 'Walter Isaacson', 7, 'D6'),
('9780060935467', 'Fight Club', 'Chuck Palahniuk', 6, 'E7'),
('9780142437179', 'The Adventures of Huckleberry Finn', 'Mark Twain', 8, 'F8'),
('9780553293357', 'Of Mice and Men', 'John Steinbeck', 5, 'G1'),
('9780061120084', 'To Kill a Mockingbird', 'Harper Lee', 8, 'H2'),
('9780316769174', 'The Catcher in the Rye', 'J.D. Salinger', 7, 'J4'),
('9781451673319', '11/22/63', 'Stephen King', 8, 'H4'),
('9780307387899', 'The Road', 'Cormac McCarthy', 7, 'I5'),
('9780671027360', 'A Clash of Kings', 'George R.R. Martin', 6, 'J6'),
('9780812982589', 'Homo Deus', 'Yuval Noah Harari', 8, 'K7'),
('9780553213119', 'Moby-Dick', 'Herman Melville', 7, 'L8'),
('9780446310789', 'To Kill a Mockingbird', 'Harper Lee', 8, 'Q5'),
('9780553296983', 'The Martian', 'Andy Weir', 6, 'Y5'),
('9780440211723', 'A Time to Kill', 'John Grisham', 6, 'P5'),
('9780618260300', 'The Hobbit', 'J.R.R. Tolkien', 4, 'J5');
-- Insert Dummy Data
INSERT INTO bookExtendedInfo (bookISBN, bookSummary, bookPublisher, bookYear, imagePath) VALUES
('9780140283297', 'Summary of On The Road', 'Penguin Classics', 1999, 'img/placeholder.jpg'),
('9780439554930', 'Harry Potter and the Sorcerer\'s Stone - Library Edition', 'Arthur A. Levine Books', 2003, 'img/placeholder.jpg'),
('9780439139601', 'Summary of Harry Potter and the Goblet of Fire', 'Bloomsbury', 2000, 'img/placeholder.jpg'),
('9780316769488', 'Summary of The Catcher in the Rye', 'Little, Brown and Company', 1951, 'img/placeholder.jpg'),
('9780618260300', 'Summary of The Hobbit', 'George Allen & Unwin', 1937, 'img/placeholder.jpg'),
('9780743273565', 'Summary of The Great Gatsby', 'Charles Scribner\'s Sons', 1925, 'img/placeholder.jpg'),
('9780439023528', 'Summary of The Hunger Games', 'Scholastic Press', 2010, 'img/placeholder.jpg'),
('9780061120084', 'Summary of To Kill a Mockingbird', 'J.B. Lippincott & Co.', 1960, 'img/placeholder.jpg');


