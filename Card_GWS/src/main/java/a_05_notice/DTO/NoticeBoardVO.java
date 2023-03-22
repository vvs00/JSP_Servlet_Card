package a_05_notice.DTO;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class NoticeBoardVO {
	private int num;
	private String title;
	private String content;
	private String userid;
	private int readcount;
	private Timestamp writedate;
}
