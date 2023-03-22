package a_06_customer.DTO;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class CustomerBoardVO {
	private int num;
	private String title;
	private String content;
	private String userid;
	private int readcount;
	private Timestamp date;
	private int bsequence;
	private int bgroup;
	private int blevel;
	private String blind;
	private String deleted;
}
//create table Customerboard(
//NUM                NUMBER(5),          
//TITLE              VARCHAR2(100),   
//CONTENT            VARCHAR2(2000) ,
//userid varchar2(30),
//READCOUNT          NUMBER(4) default 0,
//WRITEDATE          DATE default sysdate
