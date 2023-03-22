drop table card;
drop table cardmember;
drop table noticeboard;
drop table board;

drop sequence board_seq;
drop sequence card_seq;
drop sequence event_seq;
drop sequence noticeboard_seq;


--카드,이벤트 (규성희)--------------------------------------------------------------------------------------

drop table card;
drop SEQUENCE card_seq;
drop table event;
drop SEQUENCE event_seq;


create SEQUENCE card_seq start with 1 increment by 1;

create table Card (
    num number(3) not null PRIMARY KEY, --시퀀스
    img varchar2(80),   --카드이미지
    name varchar2(80),  --카드이름
    info varchar2(80),  --요약설명
    notice varchar2(100),   --공지
    dues varchar2(100), --  연회비
    performance varchar2(100),  --실적
    benefits varchar2(1000) --혜택내용
);

create SEQUENCE event_seq start with 1 increment by 1;

CREATE table event(
eventnum number(5) not null primary key, --번호
eventcardimg varchar2(1000),--카드 이미지
eventspotimg varchar2(1000), -- 이벤트 이미지
eventname varchar2(1000), -- 카드 이름
eventinfo varchar2(1000), -- 카드 해택 요약
eventcal varchar2(1000), -- 기간
eventben varchar2(1000), -- 이벤트 해택
eventtar varchar2(1000),-- 대상
eventpay varchar2(1000) -- 지급예정일
);

commit;

SELECT * FROM card;
select * from event;

--카드 인서트 필요시 사용
insert into card values(
    card_seq.nextval,
    '나는 이미지',
    '삼성카드 taptapO',
    '스타벅스50%, 교통·통신10% 할인',
    '연 최대 36만원 할인 혜택!',
    '국내 1만원, 해외 1만원',
    '직전 1개월 합계 30만원 이상',
    '스타벅스50%, 교통·통신10% 할인 G마켓·옥션·11번가 7% 할인'
);

insert into card values(
    card_seq.nextval,
    '나는 이미지',
    '이젠카드 CowDrive',
    '이젠아카데미 100%할인',
    '수료 후 축하빵 선물',
    '국내 4만원, 해외 4만원',
    '연 합계 10만원 이상',
    '빽다방60%'
);

insert into card values(
    card_seq.nextval,
    '나는 이미지',
    'SM카드 블랙핑크',
    '월요일 스타벅스 할인 화요일 구찌할인',
    '블랙핑크 콘서트 티켓 제공',
    '국내 200만원, 해외 200만원',
    '직전 1개월 합계 80만원 이상',
    '제니 사진 10장, 로제 사진 10장 지수 사진 10장'
);

insert into card values(
    card_seq.nextval,
    '나는 이미지',
    '메이플카드',
    '캐쉬50%, 메창인생10% 할인',
    '하루 최소 10만원 할인 혜택',
    '국내 1만원',
    '평생 1억 써야함',
    '넥슨에서만 할인'
);

insert into card values(
    card_seq.nextval,
    '나는 이미지',
    '애플카드 air CARD OWN',
    '애플 전 기기 30% 할인',
    '애플케어 무상 가입',
    '국내 3만원, 해외 3만원',
    '직전 1개월 합계 40달러 이상',
    '애플 전자기기 및 애플 쉐어 카 할인 자세한 사항은 홈페이지 참고'
);

insert into card values(
    card_seq.nextval,
    '나는 이미지',
    '치킨카드  BESTCHICKEN',
    '당신은 치킨을 먹을줄 안다',
    '치킨을 사랑해라 뜨거운 심장이여',
    '국내 0만원, 해외 0만원 외계인 0원',
    '직전 달 치킨 주문내역 10건 이상',
    '치킨을 사랑하는 당신에게 전 프렌차이즈점 10% 할인'
);

--이벤트 인서트 필요시 사용
insert into event values(event_seq.nextval, '나는 이미지', 'KB국민 다담카드', '교통·통신10%,주유L당60원할인 대형마트·쇼핑몰·카페 최대 7% 적립', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 10만 네이버 페이 포인트', '1. 행사 직전 1개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','통커카드', '통신 10%,커피 50% 청구할인 스타벅스 월 최대 2만원 청구할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 11만 네이버 페이 포인트', '1. 행사 직전 2개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','KB국민 The Easy카드', '한도없이 전 가맹점 0.7% 혜택 국내외 전 가맹점 최대 5.7%할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 12만 네이버 페이 포인트', '1. 행사 직전 3개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','MULTI ON', '전월 실적, 한도 없이 하나머니 적립 온라인 결제시 추가 적립 혜택!', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 13만 네이버 페이 포인트', '1. 행사 직전 4개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','#tag1카드 Orange(태그원카드 오렌지)', '커피 50% 우대 할인 편의점,영화,통신요금 우대 할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 14만 네이버 페이 포인트', '1. 행사 직전 5개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','KB국민 탄탄대로 올쇼핑카드', '온라인쇼핑·홈쇼핑·대형마트 10% 통신·관리비 10%, 카페 5% 할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 15만 네이버 페이 포인트', '1. 행사 직전 6개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','my pass 마패 카드', '대중교통 20% 청구할인 편의점 10%, 커피 10% 청구할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 16만 네이버 페이 포인트', '1. 행사 직전 7개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','단풍카드', '현질 10%할인', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 17만 네이버 페이 포인트', '1. 행사 직전 8개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
insert into event values(event_seq.nextval, '나는 이미지','이젠카드', '3일 휴가해택', '2022-12-01 ~ 2023-03-31', '대상카드로 네이버페이 간편결제 이용 시 최대 18만 네이버 페이 포인트', '1. 행사 직전 9개월 동안 하나 신용카드 결제 이력 없는 손님', '대상 카드로 네이버페이 간편결제 이용 후~~~');
-------------------------------------------------------------------------------------------------------

--카드맴버(건우) 테이블---------------------------------------------------------------------------

create table cardmember(
userid varchar2(30) primary key,
pwd varchar2(30),
name varchar2(30),
gender char(1) check(gender in('m','f')),
email varchar2(30),
lev char(1) check(lev in('a','b'))
);

insert into cardmember values('admin', '1234', '운영자', 'm','admin@admin.com','b');
insert into cardmember values('user', '1234', '일반회원', 'f','user@naver.com','a');
select * from CARDMEMBER;
commit;
-------------------------------------------------------------------------------------------------------

--노티스보드(건우) 테이블------------------------------------------------------------------------

create table noticeboard(
NUM                NUMBER(5),          
TITLE              VARCHAR2(100), 
userid varchar2(30),
CONTENT            VARCHAR2(2000) ,
READCOUNT          NUMBER(4) default 0,
WRITEDATE          DATE default sysdate
);
commit;
drop table noticeboard;
desc noticeboard;
create SEQUENCE noticeboard_seq start with 1 increment by 1;

insert into NOTICEBOARD(num,title,userid,content) values(NOTICEBOARD_SEQ.NEXTVAL,'첫번째공지사항','admin','첫번째공지사항입니다');
insert into NOTICEBOARD(num,title,userid,content) values(NOTICEBOARD_SEQ.NEXTVAL,'두번째공지사항','admin','두번째공지사항입니다');
insert into NOTICEBOARD(num,title,userid,content) values(NOTICEBOARD_SEQ.NEXTVAL,'세번째공지사항','admin','세번째공지사항입니다');
insert into NOTICEBOARD(num,title,userid,content) values(NOTICEBOARD_SEQ.NEXTVAL,'네번째공지사항','admin','네번째공지사항입니다');
insert into NOTICEBOARD(num,title,userid,content) values(NOTICEBOARD_SEQ.NEXTVAL,'다섯번째공지사항','admin','다섯번째공지사항입니다');

--고객게시판(우승) 테이블---------------------------------------------------------------------------
create table Customerboard(
NUM                NUMBER(5),          
TITLE              VARCHAR2(100),   
CONTENT            VARCHAR2(2000) ,
userid varchar2(30),
READCOUNT          NUMBER(4) default 0,
WRITEDATE          DATE default sysdate,
bsequence                NUMBER(5) default 0,
bgroup                NUMBER(5) default 0,
blevel                NUMBER(5) default 0,
blind char(1) default 'n' check(blind in('y','n')),
deleted char(1) default 'n' check(deleted in('y','n'))
);

commit;

drop table customerBoard;
desc customerBoard;
create SEQUENCE customerboard_seq start with 1 increment by 1;
drop sequence customerboard_seq;

insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'첫번쨰게시물','첫번쨰게시물입니다.','user',(select nvl((max(BGROUP)+1),0) from customerBoard),0,0);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'두번쨰게시물','두번쨰게시물입니다.','user',(select nvl((max(BGROUP)+1),0) from customerBoard),0,0);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'세번쨰게시물','세번쨰게시물입니다.','user',(select nvl((max(BGROUP)+1),0) from customerBoard),0,0);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'네번쨰게시물','네번쨰게시물입니다.','user',(select nvl((max(BGROUP)+1),0) from customerBoard),0,0);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'다섯번쨰게시물','다섯번쨰게시물입니다.','user',(select nvl((max(BGROUP)+1),0) from customerBoard),0,0);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'두번째게시물의 댓글1','네댓번쨰게시물입니다.','user',1,1,1);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'세번쨰게시물댓글1','세번쨰게시물의댓글1.','user',2,2,1);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'세번쨰게시물댓글2','세번쨰게시물댓글2.','user',2,1,1);
insert into customerBoard(num,title,content,userid,Bgroup,bsequence,blevel) 
values(customerboard_seq.nextval,'세번쨰게시물댓글1의 댓글1','세번쨰게시물의댓글1의 댓글1.','user',2,3,2);

select * from customerBoard ORDER BY bgroup desc, bsequence asc;
commit;
select * from customerboard;
delete from customerboard ;
-------------------------------------------------------------------------------------------------------

--위시리스트(연정)--------------------------------------------------------------------------------
create table wishlist ( userid varchar2(30), cardnum number(3,0));
desc wishlist;
-------------------------------------------------------------------------------------------------------

