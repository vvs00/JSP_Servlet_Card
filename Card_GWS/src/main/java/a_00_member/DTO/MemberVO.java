package a_00_member.DTO;
import lombok.*;

/*
USERID NOT NULL VARCHAR2(30) 
PWD             VARCHAR2(30) 
NAME            VARCHAR2(30) 
BIRTH           VARCHAR2(30) 
GENDER          CHAR(1)      
EMAIL           VARCHAR2(30)
MPHONE          VARCHAR2(30)
LEV             CHAR(1)      
 */

@Getter
@Setter
@ToString

public class MemberVO {
	
	private String userid;
	private String pwd;
	private String name;
	private String gender;
	private String email;
	private String lev;

}


	
	


