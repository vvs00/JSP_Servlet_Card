package a_07_wishlist.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* cardlist VO

num number(5) not null,
name varchar2(30),
img varchar2(50),
notice varchar2(100),
dues varchar2(100),
performance varchar2(100),
company varchar2(30),
benefits varchar2(1000)


event VO

num number(5) not null primary key, --번호
cardname varchar2(1000), -- 카드 이름
cardsimple varchar2(1000), -- 카드 해택 요약
evencal varchar2(1000), -- 기간
eventben varchar2(1000), -- 이벤트 해택
eventtar varchar2(1000),-- 대상
eventpay varchar2(1000) -- 지급예정일
 */



@Getter
@Setter
@ToString
public class VO {
	
	//cardlist VO
	private int num;
	private String img;
	private String name;
	private String notice;
	private String info;
	private String dues;
	private String performance;
	private String benefits;
	
	// 이벤트 VO
	private int eventnum;
	private String eventimg;
	private String eventname;
	private String eventinfo;
	private String eventcal;
	private String eventben;
	private String eventtar;
	private String eventpay;
}
