DROP TABLE IF EXISTS course ;
CREATE TABLE course (id INT PRIMARY KEY  , name TEXT NOT NULL , description TEXT);
INSERT INTO course(id , name , description) VALUES (1, 'Java+' , 'Java description');
INSERT INTO course(id , name , description) VALUES (2, 'Golang+' , 'C++ description');
INSERT INTO course(id , name , description) VALUES (3, 'C++' , 'C++ description');
