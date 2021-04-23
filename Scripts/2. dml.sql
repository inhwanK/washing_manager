create database washing_manager;
drop database washing_manager;

use washing_manager;

show databases;
show tables;
-- 등급 데이터 입력
select *
  from gradedc;
insert into gradedc values('S', 0.3),
						  ('A', 0.2),
						  ('B', 0.1),
						  ('C', 0.05),
						  ('D', 0);
						
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
						 

-- 고객 데이터 입력.
select *
  from consumer;
insert into consumer values
					('010-9198-6529','김인환','S'),
					('010-9898-6529','김재환','B'),
					('010-7396-6529','강진선','A'),
					('010-3512-7001','김상화','C');

insert into consumer values('010-1111-1111','김인환','B');
insert into consumer values('010-9198-6529','김인환','S');
delete
  from consumer 
 where conname = '김인환';

-- 주문 순번
select * from orderturn;
-- 순번 데이터
insert into orderturn(orderdate) values (now());

-- 주문 순번 맞추려고 노력중...
select * from orderlist;
select group_concat(ordno separator ',') from orderlist;

select concat(o2.lndcode,'(' ,o2.lndea,')') as '제품코드(주문수량)', turn from orderlist o2;

select turn as 순번,
	   group_concat(concat(lndcode,'(' ,lndea,')') separator ',') as '제품코드(주문수량)' ,
	   as 
  from orderlist join 
 group by turn 
 order by turn asc;

-- 주문목록 데이터
select * from orderlist;
insert into orderlist(lndea, lndcode , conphone,turn) values
					(2,'AAA','010-9198-6529',1),
					(1,'BBB','010-1111-1111',2),
					(3,'CCC','010-7396-6529',3);
				
insert into orderlist(lndea, lndcode , conphone,turn) values(2,'AAA','010-7396-6529',3);
delete from orderlist where ordno = 5;

drop table orderlist;

-- 주문번호를 기본키 해체 한뒤. select 할 때  주문번호 빼고 where절에 주문번호로 조건걸면 됨.
select conphone, conname, grade, discount 
  from consumer c left join gradedc g
    on c.congrade = g.grade
 where congrade = 'S';

select * 
from consumer c join gradedc g where c.congrade = g.grade;


-- 순번 테이블 자원.
create view v_turnno as
select o.ordno as 순번,
	   c.conname as 고객명,
	   l.lndcode as 세탁물코드,
	   l.lndname as 제품명,
	   l.lndprice as 세탁단가,
	   o.lndea as 세탁수량,
	   g.grade as 등급,
	   g.discount as 할인율,
	   round(o.lndea * l.lndprice -(o.lndea * l.lndprice * g.discount),2) as 세탁가격,
	   c.conphone as 고객번호
  from orderlist o join consumer c on o.conphone = c.conphone
  left join laundry l on o.lndcode = l.lndcode
  join gradedc g on c.congrade = g.grade order by ordno;


  
 
