package a_03_card.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//num number(5) not null,
//name varchar2(30),
//img varchar2(50),
//notice varchar2(100),
//dues varchar2(100),
//performance varchar2(100),
//company varchar2(30),
//benefits varchar2(1000)

@Getter
@Setter
@ToString

public class CardVO {
	
	//cardlist VO
	private int num;
	private String img;
	private String name;
	private String notice;
	private String info;
	private String dues;
	private String performance;
	private String benefits;
	
}
