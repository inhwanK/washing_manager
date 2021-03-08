select user(),database();

-- 세탁물
DROP TABLE IF EXISTS MY_SCHEMA.laundry RESTRICT;

-- 등급별 할인율
DROP TABLE IF EXISTS MY_SCHEMA.gradedc RESTRICT;

-- 고객
DROP TABLE IF EXISTS MY_SCHEMA.consumer RESTRICT;

-- 주문목록
DROP TABLE IF EXISTS MY_SCHEMA.orderlist RESTRICT;

-- 내 스키마
DROP SCHEMA IF EXISTS MY_SCHEMA;

-- 내 스키마
CREATE SCHEMA MY_SCHEMA;

-- 세탁물
CREATE TABLE MY_SCHEMA.laundry (
	lndryno  VARCHAR(20) NOT NULL COMMENT '세탁물명', -- 세탁물명
	lndno    CHAR        NOT NULL COMMENT '세탁코드', -- 세탁코드
	lndprice INT         NOT NULL COMMENT '세탁단가' -- 세탁단가
)
COMMENT '세탁물';

-- 세탁물
ALTER TABLE MY_SCHEMA.laundry
	ADD CONSTRAINT PK_laundry -- 세탁물 기본키
		PRIMARY KEY (
			lndryno -- 세탁물명
		);

-- 등급별 할인율
CREATE TABLE MY_SCHEMA.gradedc (
	grade    CHAR NOT NULL COMMENT '등급', -- 등급
	discount INT  NULL     COMMENT '할인율' -- 할인율
)
COMMENT '등급별 할인율';

-- 등급별 할인율
ALTER TABLE MY_SCHEMA.gradedc
	ADD CONSTRAINT PK_gradedc -- 등급별 할인율 기본키
		PRIMARY KEY (
			grade -- 등급
		);

-- 고객
CREATE TABLE MY_SCHEMA.consumer (
	conname  VARCHAR(20) NOT NULL COMMENT '고객명', -- 고객명
	conphone INT         NOT NULL COMMENT '고객번호', -- 고객번호
	congrade CHAR        NULL     COMMENT '등급' -- 등급
)
COMMENT '고객';

-- 고객
ALTER TABLE MY_SCHEMA.consumer
	ADD CONSTRAINT PK_consumer -- 고객 기본키
		PRIMARY KEY (
			conname -- 고객명
		);

-- 주문목록
CREATE TABLE MY_SCHEMA.orderlist (
	ordno   INT         NOT NULL COMMENT '주문번호', -- 주문번호
	lndea   INT         NULL     COMMENT '세탁수량', -- 세탁수량
	lndryno VARCHAR(20) NULL     COMMENT '세탁물명', -- 세탁물명
	conname VARCHAR(20) NULL     COMMENT '고객명' -- 고객명
)
COMMENT '주문목록';

-- 주문목록
ALTER TABLE MY_SCHEMA.orderlist
	ADD CONSTRAINT PK_orderlist -- 주문목록 기본키
		PRIMARY KEY (
			ordno -- 주문번호
		);

-- 고객
ALTER TABLE MY_SCHEMA.consumer
	ADD CONSTRAINT FK_gradedc_TO_consumer -- 등급별 할인율 -> 고객
		FOREIGN KEY (
			congrade -- 등급
		)
		REFERENCES MY_SCHEMA.gradedc ( -- 등급별 할인율
			grade -- 등급
		);

-- 주문목록
ALTER TABLE MY_SCHEMA.orderlist
	ADD CONSTRAINT FK_laundry_TO_orderlist -- 세탁물 -> 주문목록
		FOREIGN KEY (
			lndryno -- 세탁물명
		)
		REFERENCES MY_SCHEMA.laundry ( -- 세탁물
			lndryno -- 세탁물명
		);

-- 주문목록
ALTER TABLE MY_SCHEMA.orderlist
	ADD CONSTRAINT FK_consumer_TO_orderlist -- 고객 -> 주문목록
		FOREIGN KEY (
			conname -- 고객명
		)
		REFERENCES MY_SCHEMA.consumer ( -- 고객
			conname -- 고객명
		);
