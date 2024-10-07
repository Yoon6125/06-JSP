package com.daodto2.java;

public class DTO {
	public String no;
	public String title;
	public String id;
	public String datetime;
	public String hit;
	public String text;
	public String reply_count;
	public String reply_ori;

	public DTO(String no, String title, String id, String datetime, String hit, String text, String reply_count,
			String reply_ori) {
		this.no = no;
		this.title = title;
		this.id = id;
		this.datetime = datetime;
		this.hit = hit;
		this.text = text;
		this.reply_count = reply_count;
		this.reply_ori = reply_ori;
	}

}
