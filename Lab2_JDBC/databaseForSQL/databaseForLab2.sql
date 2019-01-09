Create database ManageClass
GO
Use ManageClass
GO
Create table Student(
	id int identity(1,1) NOT NULL,
	name Nvarchar(50) NOT NULL,
	dob date NOT NULL,
	gender bit NOT NULL,
	idClass int NOT NULL

)
GO
Create table ClassRoom(
	idClass int identity(1,1) NOT NULL,
	name Nvarchar(50) NOT NULL
)
GO
Alter table Student add constraint studentPk
primary key(id)
GO
Alter table ClassRoom add constraint classRoomPk
primary key(idClass)
GO
Alter table Student add constraint studentClassRoom
foreign key(idClass) references ClassRoom(idClass)

