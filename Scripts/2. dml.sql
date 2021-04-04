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
-- 등급 데이터 입력
select *
  from gradedc;
insert into gradedc values('S', 0.3)
						 ,('A', 0.2)
						 ,('B', 0.1)
						 ,('C', 0.05);
						
delete
  from gradedc 
 where grade ='S';
-- laundry 데이터 입력
select *
  from laundry;
insert into laundry values('AAA','양복상의', 8000)
						 ,('BBB','양복하의', 5000)
						 ,('CCC','점퍼', 10000)
						 ,('DDD','바지', 6000)
						 ,('EEE','코트', 15000)
						 ,('FFF','치마', 7000)
						 ,('GGG','가디건', 9000)
						 ,('HHH','신발', 3000);
						 
delete
  from laundry
 where lndprice = 8000;
-- 고객 데이터 입력.
select *
  from consumer;
insert into consumer values
					('010-9198-6529','김인환',null),
					('010-9898-6529','김재환',null),
					('010-7396-6529','강진선',null),
					('010-3512-7001','김상화',null);
				
insert into consumer values('010-7396-6529','강진선',null);
delete
  from consumer 
 where conname = '강진선';

-- 주문목록
insert into orderlist(lndea, lndno, conphone) values
					(2,'AAA','010-9198-6529');
-- 주문번호를 기본키 해체 한뒤. select 할 때  주문번호 빼고 where절에 주문번호로 조건걸면 됨.
select  