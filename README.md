sql script:

create table FACULTIES(
id serial primary key,
name varchar(255) unique not null,
short_name varchar(255) unique not null
);


create table DEPARTMENTS(
id serial primary key,
faculty_id integer not null references FACULTIES(id),
name varchar(255) not null,
short_name varchar(255)
);

create table GROUPS (
id serial primary key,
department_id int not null references departments(id),
name varchar(255) not null,
course serial not null
);

create table STUDENTS (
id serial primary key,
group_id int not null references groups(id),
name varchar(255) not null,
email varchar(255),
phone varchar(255)
);

create table teachers(
id serial primary key,
name varchar(255) not null,
surname varchar(255) not null,
email varchar(255) unique,
phone varchar(255) unique
  
);

create table disciplines(
id serial primary key,
name varchar(255) not null
);

create table scheduleS(
id serial primary key,
name varchar(255),
teacher_id serial references teachers(id),
discipline_id serial references disciplines(id),
group_id serial references groups(id),
time varchar(255) not null,
classroom varchar(255)
);

insert into faculties(name, short_name) values
('Факультет Інформаційної Обчислювальної Техніки', 'ФІОТ'),
('Інститут Аерокосмічних Технологій', 'ІАТ'),
('Інститут Прикладного Системного Аналізу', 'ІПСА'),
('Факультет Менеджменту та Маркетингу', 'ФММ'),
('Факультет Прикладної Математики', 'ФПМ');

insert into departments(faculty_id, name) values
(2, 'Авіоніка');
insert into departments(faculty_id, name, short_name) values
(1,'Інформаційні системи та технології', 'ІСТ'),
(4,'Інженерія програмного забезпечення', 'ІПЗ'),
(3,'Комп''ютерна інженерія', 'КІ'),
(5,'Метрологія та інформаційно-вимірювальна техніка', 'МІВТ');

insert into groups (department_id, name, course)
values
(1,'ІА-12',2),
(2,'ІП-22',1),
(3,'ІЗ-03',3),
(4,'ІЯ-14',2),
(5,'МК-71',6);

insert into students (group_id, name, email, phone)
values
(1, 'Юхименко Павло', 'cherepavel@gmail.com','+380677543412'),
(2, 'Кузнeцеов Євген', 'hapancov420@gmail.com', null),
(3, 'Запороженко Анастасія',null,null),
(4, 'Молчанов Михайло',null,null),
(5, 'Пауков Нікіта',null,'+380677543412');

insert into teachers(name, surname, phone, email)
values
('Олександр','Ролік',null,'rolikrolik@gmail.com'),
('Букасов','Максим','+380975061680',null),
('Белоус','Роман','+380654326712','belous@ukr.net'),
('Якуніна','Наталія','+380976347714','yakunina@mail.ru'),
('Коваленко','Валентина',null,'bvbvbvbvbvbv@gmail.com')

insert into disciplines(name)
values
('Розроблення web-застосувань'),
('Комп''ютерні мережі'),
('Фізика-1'),
('Вища математика-1'),
('Програмування');

insert into schedules
(teacher_id, discipline_id, group_id,time,classroom)
values(1,2,1,'3-3','18-532'),
(2,5,2,'2-6','18-532'),
(3,1,3,'1-5',null),
(4,3,4,'2-4','18-532'),
(5,4,5,'0-1',null);
