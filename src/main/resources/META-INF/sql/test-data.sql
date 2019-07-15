insert into country (country_id, country_name) values ('1', 'Belarus');
insert into country (country_id, country_name) values ('2', 'Russia');
insert into country (country_id, country_name) values ('3', 'Poland');
insert into country (country_id, country_name) values ('4', 'Ukraine');

insert into profession (prof_id, prof_name) values ('1', 'work1');
insert into profession (prof_id, prof_name) values ('2', 'work2');
insert into profession (prof_id, prof_name) values ('3', 'work3');
insert into profession (prof_id, prof_name) values ('4', 'work4');
insert into profession (prof_id, prof_name) values ('5', 'work5');


insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('1', '1' ,'1', '1', '101', '201', 'false');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('2', '2' ,'3', '2', '201', '301', 'false');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('3', '1' ,'2', '2', '301', '401', 'true');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('4', '2' ,'4', '3', '401', '501', 'false');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('5', '3' ,'1', '4', '501', '601', 'true');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('6', '2' ,'2', '5', '601', '701', 'false');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('7', '1' ,'3', '4', '701', '801', 'true');
insert into request (req_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('8', '3' ,'2', '5', '801', '901', 'true');


-- DECLARE @name NVARCHAR(20), @age INT;
-- SET @name='Tom';
-- DECLARE @photoPath VARCHAR (100);
-- SET @photoPath =  'c:\Users\staliah\Downloads\';
insert into employee (name, surname, birth_date, rating, country_id, photo_path) values ('Chris', 'Schaefer', '1981-05-03', '4', '1', 'c:\Users\staliah\Downloads\myphoto.jpg');
insert into employee (name, surname, birth_date, rating, country_id, photo_path) values ('Scott', 'Tiger', '1990-11-02', '5', '2', 'c:\Users\staliah\Downloads\myphoto.jpg');
insert into employee (name, surname, birth_date, rating, country_id, photo_path) values ('John', 'Smith', '1964-02-28', '3', '1', 'c:\Users\staliah\Downloads\myphoto.jpg');
insert into employee (name, surname, birth_date, rating, country_id, photo_path) values ('Erik', 'Rice', '1974-04-13', '5', '3', 'c:\Users\staliah\Downloads\myphoto.jpg');

insert into vacancy (vacancy_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('1', '3' ,'2', '5', '801', '1001', 'true');
insert into vacancy (vacancy_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('2', '3' ,'1', '4', '501', '601', 'true');
insert into vacancy (vacancy_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('3', '2' ,'2', '5', '601', '701', 'false');
insert into vacancy (vacancy_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('4', '1' ,'1', '4', '701', '801', 'true');
insert into vacancy (vacancy_id, empl_id, country_id, prof_id, min_salary, max_salary, house) values ('5', '3' ,'2', '4', '901', '901', 'true');


insert into employer (organization, verification, contacts) values ('sam', 'true', '1234');
insert into employer (organization, verification, contacts) values ('epam', 'false', '2345');
insert into employer (organization, verification, contacts) values ('itransition', 'true', '3456');
insert into employer (organization, verification, contacts) values ('netcracker', 'false', '4567');
insert into employer (organization, verification, contacts) values ('issoft', 'true', '5678');


insert into employee_grade (empl_id, mark, comment) values ('1' ,'1', 'Bad job!!');
insert into employee_grade (empl_id, mark, comment) values ('2' ,'2', 'Bad job!!!!');
insert into employee_grade (empl_id, mark, comment) values ('2' ,'3', 'Bad job!!');
insert into employee_grade (empl_id, mark, comment) values ('3' ,'1', 'Bad job!!');
insert into employee_grade (empl_id, mark, comment) values ('3' ,'2', 'Bad job!!');

insert into employer_grade (empl_id, mark, comment) values ('1' ,'4', 'Good job!!');
insert into employer_grade (empl_id, mark, comment) values ('2' ,'5', 'Good job!!');
insert into employer_grade (empl_id, mark, comment) values ('2' ,'5', 'Good job!!');
insert into employer_grade (empl_id, mark, comment) values ('3' ,'3', 'Good job!!');
insert into employer_grade (empl_id, mark, comment) values ('3' ,'4', 'Good job!!');
