-- 세탁물
DROP TABLE IF EXISTS washing_manager.laundry RESTRICT;

-- 등급별 할인율
DROP TABLE IF EXISTS washing_manager.gradedc RESTRICT;

-- 고객
DROP TABLE IF EXISTS washing_manager.consumer RESTRICT;

-- 주문목록
DROP TABLE IF EXISTS washing_manager.orderlist RESTRICT;

-- 주문순번
DROP TABLE IF EXISTS washing_manager.orderturn RESTRICT;

-- 세탁물 관리
DROP SCHEMA IF EXISTS washing_manager;

-- 세탁물 관리
CREATE SCHEMA washing_manager;

-- 세탁물
CREATE TABLE washing_manager.laundry (
	lndcode  CHAR(3)     NOT NULL COMMENT '세탁코드', -- 세탁코드
	lndname  VARCHAR(20) NOT NULL COMMENT '세탁물명', -- 세탁물명
	lndprice INT         NOT NULL COMMENT '세탁단가' -- 세탁단가
)
COMMENT '세탁물';

-- 세탁물
ALTER TABLE washing_manager.laundry
	ADD CONSTRAINT PK_laundry -- 세탁물 기본키
		PRIMARY KEY (
			lndcode -- 세탁코드
		);

-- 등급별 할인율
CREATE TABLE washing_manager.gradedc (
	grade    CHAR  NOT NULL COMMENT '등급', -- 등급
	discount FLOAT NULL     COMMENT '할인율' -- 할인율
)
COMMENT '등급별 할인율';

-- 등급별 할인율
ALTER TABLE washing_manager.gradedc
	ADD CONSTRAINT PK_gradedc -- 등급별 할인율 기본키
		PRIMARY KEY (
			grade -- 등급
		);

-- 고객
CREATE TABLE washing_manager.consumer (
	conphone VARCHAR(20) NOT NULL COMMENT '고객번호', -- 고객번호
	conname  VARCHAR(20) NOT NULL COMMENT '고객명', -- 고객명
	congrade CHAR        NULL     COMMENT '등급' -- 등급
)
COMMENT '고객';

-- 고객
ALTER TABLE washing_manager.consumer
	ADD CONSTRAINT PK_consumer -- 고객 기본키
		PRIMARY KEY (
			conphone -- 고객번호
		);

-- 주문목록
CREATE TABLE washing_manager.orderlist (
	ordno    INT         NOT NULL COMMENT '주문번호', -- 주문번호
	lndea    INT         NOT NULL COMMENT '세탁수량', -- 세탁수량
	lndcode  CHAR(3)     NOT NULL COMMENT '세탁코드', -- 세탁코드
	conphone VARCHAR(20) NOT NULL COMMENT '고객번호', -- 고객번호
	turn     INT         NOT NULL COMMENT '순번' -- 순번
)
COMMENT '주문목록';

-- 주문목록
ALTER TABLE washing_manager.orderlist
	ADD CONSTRAINT PK_orderlist -- 주문목록 기본키
		PRIMARY KEY (
			ordno -- 주문번호
		);

ALTER TABLE washing_manager.orderlist
	MODIFY COLUMN ordno INT NOT NULL AUTO_INCREMENT COMMENT '주문번호';

ALTER TABLE washing_manager.orderlist
	AUTO_INCREMENT = 1;

-- 주문순번
CREATE TABLE washing_manager.orderturn (
	turn      INT      NOT NULL COMMENT '순번', -- 순번
	orderdate DATETIME NULL     COMMENT '주문날짜' -- 주문날짜
)
COMMENT '주문순번';

-- 주문순번
ALTER TABLE washing_manager.orderturn
	ADD CONSTRAINT PK_orderturn -- 주문순번 기본키
		PRIMARY KEY (
			turn -- 순번
		);

ALTER TABLE washing_manager.orderturn
	MODIFY COLUMN turn INT NOT NULL AUTO_INCREMENT COMMENT '순번';

-- 고객
ALTER TABLE washing_manager.consumer
	ADD CONSTRAINT FK_gradedc_TO_consumer -- 등급별 할인율 -> 고객
		FOREIGN KEY (
			congrade -- 등급
		)
		REFERENCES washing_manager.gradedc ( -- 등급별 할인율
			grade -- 등급
		);

-- 주문목록
ALTER TABLE washing_manager.orderlist
	ADD CONSTRAINT FK_laundry_TO_orderlist -- 세탁물 -> 주문목록
		FOREIGN KEY (
			lndcode -- 세탁코드
		)
		REFERENCES washing_manager.laundry ( -- 세탁물
			lndcode -- 세탁코드
		);

-- 주문목록
ALTER TABLE washing_manager.orderlist
	ADD CONSTRAINT FK_consumer_TO_orderlist -- 고객 -> 주문목록
		FOREIGN KEY (
			conphone -- 고객번호
		)
		REFERENCES washing_manager.consumer ( -- 고객
			conphone -- 고객번호
		);

-- 주문목록
ALTER TABLE washing_manager.orderlist
	ADD CONSTRAINT FK_orderturn_TO_orderlist -- 주문순번 -> 주문목록
		FOREIGN KEY (
			turn -- 순번
		)
		REFERENCES washing_manager.orderturn ( -- 주문순번
			turn -- 순번
		);