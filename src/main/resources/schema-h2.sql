CREATE TABLE Todos(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(60) NOT NULL,
    UNIQUE(id)
);


CREATE TABLE Tasks(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(60) NOT NULL,
    Status BIT NOT NULL,
    Description VARCHAR(200),
    todo_id INT NOT NULL,
    UNIQUE(id),
    FOREIGN KEY (todo_id) REFERENCES Todos(Id)

);