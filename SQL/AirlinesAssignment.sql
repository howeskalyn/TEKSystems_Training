insert into airports (airport_code, airport_name) values ('LAX', 'Los Angeles International Airport');
insert into airports (airport_code, airport_name) values ('ATL', 'Atlanta International Airport');
insert into airports (airport_code, airport_name) values ('JFK', 'John F. Kennedy International Airport');
insert into airports (airport_code, airport_name) values ('CLT', 'Charlotte/Douglas International Airport');

insert into flights (departing_id, arriving_id) values (1, 2), (2, 3), (3,4);

insert into companies (name) values ('Delta'), ('Southwest'), ('American');

update flights set company_id = 1 where id = 1;
update flights set company_id = 2 where id = 2;
update flights set company_id = 3 where id = 3;

