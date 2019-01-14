Create database ManageCourse
GO
Use ManageCourse
GO
Create table Student(
	id int identity(1,1) NOT NULL,
	name Nvarchar(50) NOT NULL,
	dob date NOT NULL,
	gender bit NOT NULL,
	idCourse int NOT NULL

)
GO
Create table Course(
	idCourse int identity(1,1) NOT NULL,
	name Nvarchar(50) NOT NULL
)
GO
Alter table Student add constraint studentPk
primary key(id)
GO
Alter table Course add constraint CoursePk
primary key(idCourse)
GO
Alter table Student add constraint studentCourse
foreign key(idCourse) references Course(idCourse)

