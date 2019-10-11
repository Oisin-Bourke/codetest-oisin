create table student (
   studentID integer auto_increment not null,
   firstName varchar(255) not null,
   lastName varchar(255) not null,
   primary key(studentID)
);

create table subject (
   subjectID integer auto_increment not null,
   subjectName varchar(255) not null,
   primary key(subjectID)
);

create table student_subject (
    student integer references student(studentID) ,
    subject integer references subject(subjectID),
    primary key (student,subject)
);

create table faculty (
   facultyID integer auto_increment not null,
   facultyName varchar(255) not null,
   primary key(facultyID)
);

create table exam (
    examID integer auto_increment not null,
    examName varchar(255),
    student integer references student(studentID),
    primary key (examID)
);

create table grade (
    gradeID integer auto_increment not null,
    grade varchar(255),
    examID integer references exam(examID),
    primary key (gradeID)
);

