create user 'user_washing_manager'@'localhost' identified by 'rootroot';
drop user 'user_washing_manager'@'localhost';
grant all on washing_manager.* to 'user_washing_manager'@'localhost';
show databases;
show grants for 'user_washing_manager'@'localhost';

create database washing_manager;
drop database washing_manager;

use washing_manager;

show databases;
show tables;

select *
  from gradedc;
insert into gradedc values('S', 0.3)
						 ,('A', 0.2)
						 ,('B', 0.1)
						 ,('C', 0.05);
						
delete
  from gradedc 
 where grade ='S';

select *
  from laundry;
insert into laundry values('AAA','양복상의', 8000)
						 ,('BBB','양복하의', 5000)
						 ,('CCC','점퍼', 5000)
						 ,('DDD','바지', 5000)
						 ,('EEE','코트', 5000)
						 ,('FFF','치마', 5000)
						 ,('GGG','가디건', 5000)
						 ,('HHH','신발', 5000);
						 
						
