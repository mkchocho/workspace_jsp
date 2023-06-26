package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//롬복을 사용하면 getter setter를 정의하지 않아도 사용할 수 있다
@Data
public class Board {
		private int boardNum;
		private String boardWriter;
		private String boardTitle;
		private String boardContent;
		private String boardDate;
}
