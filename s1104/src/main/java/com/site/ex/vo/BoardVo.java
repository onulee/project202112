package com.site.ex.vo;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVo {

	int bid;
	String bname;
	String btitle;
	String bcontent;
	Timestamp bdate;
	int bhit;
	int bgroup;
	int bstep;
	int bindent;
	String bupload;
}
