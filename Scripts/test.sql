delete
  from gradedc 
 where grade ='S';
 
delete
  from laundry
 where lndprice = 8000;
 
select * from orderlist;
delete from orderlist where ordno =4;

-- 여러 row 합치는 법 알아내기.
select group_concat(orderlist.ordno separator ',') as 이게머시여
  from orderlist;
  
drop view v_turnno ;
select * from v_turnno;

delete 
  from orderlist 
 where ordno = 3;
 
-- 순위 구하기
select (select count(*)+1 from v_turnno where 세탁가격 > t.세탁가격) as 순위,순번,
		고객명, 세탁물코드, concat(제품명 ,' (' ,세탁수량, ')') as '제품명(세탁수량)', 세탁단가, 등급, round(할인율,2) as 할인율 , 세탁가격
  from v_turnno t
  order by 순위 asc;

 select (select count(*)+1 from v_all where 세탁가격 > a.세탁가격) as 순위,
		고객명, 제품명, 세탁수량, 세탁단가, 등급, round(할인율,2) as 할인율 , 세탁가격
  from v_all a
  order by 순위 asc;
 
-- 순번 재정렬 쿼리. 필요함
set @count=0;
update orderlist set orderlist.ordno = @count:=@count+1;
update orderturn set orderturn.turn = @count:=@count+1;

-- 순번 구하기 그냥 orderlist 썼음.
  select 순번,
		고객명, 세탁물코드, 제품명, 세탁단가, 세탁수량, 등급, round(할인율,2) as 할인율 , 세탁가격,고객번호
  from v_turnno t;

 
select o.turn as 순번,
	   c.conname as 고객명,
	   group_concat(concat(l.lndname ,' (' ,o.lndea,')') separator ', ') as '제품명(세탁수량)',
	   group_concat(l.lndprice separator ', ') as 세탁단가,
	   c.congrade as 등급,
	   g.discount as 할인율,
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


-- test
 

 select * from v_all;

set @count=0;
update orderlist set orderlist.ordno = @count:=@count+1;

SET @ROWNUM:=0;
SELECT @ROWNUM:=@ROWNUM+1, o.*
  FROM orderlist o where turn=3;
 select * from orderlist where turn =3;
 select * from orderlist where turn =2;