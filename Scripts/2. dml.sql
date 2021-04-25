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

delete 
  from orderturn where turn = 3;
-- 주문 순번 테이블로 순번에 따라 검색하기
select * from orderlist;
select group_concat(ordno separator ',') from orderlist;

select concat(o2.lndcode,'(' ,o2.lndea,')') as '제품코드(주문수량)', turn from orderlist o2;

-- 순번 검색 성공!!!!

create view v_all as
select o.turn as 순번,
	   c.conname as 고객명,
	   group_concat(concat(l.lndname ,' (' ,o.lndea,')') separator ', ') as '제품명(세탁수량)',
	   group_concat(l.lndprice separator ', ') as 세탁단가,
	   c.congrade as 등급,
	   round(g.discount * 100, 3) as 할인율,
	   sum(o.lndea * l.lndprice) * (1-round(g.discount, 3)) as 세탁가격,
	   group_concat(l.lndcode separator ', ') as 세탁물코드,
	   c.conphone as 고객번호,
	   group_concat(o.ordno separator ',') as 주문번호,
	   ot.orderdate as 주문시간,
	   group_concat(l.lndname separator ', ') as 제품명,
	   group_concat(o.lndea separator ', ') as 세탁수량
  from orderlist o join consumer c on o.conphone = c.conphone 
  left join laundry l on o.lndcode = l.lndcode join gradedc g on c.congrade = g.grade 
   join orderturn ot on o.turn = ot.turn 
 group by o.turn 
 order by o.turn asc;

select *
  from v_all;
drop view v_all;

-- 주문목록 데이터
select * from orderlist;
insert into orderlist(lndea, lndcode , conphone,turn) values
					(2,'AAA','010-9198-6529',1),
					(1,'BBB','010-1111-1111',2),
					(3,'CCC','010-7396-6529',3);
				
insert into orderlist(lndea, lndcode , conphone,turn) values(3,'CCC','010-7396-6529',3);
insert into orderlist(lndea, lndcode , conphone,turn) values(2,'AAA','010-7396-6529',3);
delete from orderlist where turn = 3;

-- 트리거 사용해야할 듯???
-- 순번의 데이터가 지워지면
-- 1. 그 데이터에 참조된 번호의 순번 테이블 데이터를 삭제
-- 2. set @count=0;
-- 3. update orderlist set orderlist.ordno = @count:=@count+1;
-- 위 쿼리로 다시 세팅해주면 됨.

drop table orderlist;

-- 주문번호를 기본키 해체 한뒤. select 할 때  주문번호 빼고 where절에 주문번호로 조건걸면 됨.
select conphone, conname, grade, discount 
  from consumer c left join gradedc g
    on c.congrade = g.grade
 where congrade = 'S';

select * 
from consumer c join gradedc g where c.congrade = g.grade;

 
