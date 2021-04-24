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
		고객명, 세탁물코드, 제품명, 세탁단가, 세탁수량, 등급, round(할인율,2) as 할인율 , 세탁가격
  from v_turnno t
  order by 순위 asc;

 
-- 순번 재정렬 쿼리. 필요함
set @count=0;
update orderlist set orderlist.ordno = @count:=@count+1;

-- 순번 구하기 그냥 orderlist 썼음.
  select 순번,
		고객명, 세탁물코드, 제품명, 세탁단가, 세탁수량, 등급, round(할인율,2) as 할인율 , 세탁가격,고객번호
  from v_turnno t;