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
					('010-9198-6529','김인환','S'),
					('010-9898-6529','김재환','B'),
					('010-7396-6529','강진선','A'),
					('010-3512-7001','김상화','C');

insert into consumer values('010-1111-1111','김인환','B');
delete
  from consumer 
 where conname = '김인환';

-- 주문목록
insert into orderlist(lndea, lndcode , conphone) values
					(2,'AAA','010-9198-6529'),
					(1,'BBB','010-1111-1111'),
					(3,'CCC','010-7396-6529');
				
insert into orderlist(lndea, lndcode , conphone) values(3,'CCC','010-7396-6529');

select * from orderlist;
drop table orderlist;
delete from orderlist where ordno =4;
-- 주문번호를 기본키 해체 한뒤. select 할 때  주문번호 빼고 where절에 주문번호로 조건걸면 됨.
select conphone, conname, grade, discount 
  from consumer c left join gradedc g
    on c.congrade = g.grade
 where congrade = 'S';

select * 
from consumer c join gradedc g where c.congrade = g.grade;

-- 여러 row 합치는 법 알아내기.
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

drop view v_turnno ;
select * from v_turnno;

-- 순번 재정렬 쿼리. 필요함
set @count=0;
update orderlist set orderlist.ordno = @count:=@count+1;


delete 
  from orderlist 
 where ordno = 3;
-- 순위 구하기
select (select count(*)+1 from v_turnno where 세탁가격 > t.세탁가격) as 순위,순번,
		고객명, 세탁물코드, 제품명, 세탁단가, 세탁수량, 등급, round(할인율,2) as 할인율 , 세탁가격
  from v_turnno t
  order by 순위 asc;
 
  select 순번,
		고객명, 세탁물코드, 제품명, 세탁단가, 세탁수량, 등급, round(할인율,2) as 할인율 , 세탁가격,고객번호
  from v_turnno t;