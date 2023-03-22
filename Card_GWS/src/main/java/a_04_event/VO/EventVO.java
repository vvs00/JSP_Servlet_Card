package a_04_event.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//event VO
//
//num number(5) not null primary key, --번호
//cardname varchar2(1000), -- 카드 이름
//cardsimple varchar2(1000), -- 카드 해택 요약
//evencal varchar2(1000), -- 기간
//eventben varchar2(1000), -- 이벤트 해택
//eventtar varchar2(1000),-- 대상
//eventpay varchar2(1000) -- 지급예정일

@Getter
@Setter
@ToString
public class EventVO {
	private int eventNum;
	private String eventName;	
	private String eventCardImg;
	private String eventSpotImg;
	private String eventInfo;
	private String eventCal;
	private String eventBen;
	private String eventTar;
	private String eventPay;
}
