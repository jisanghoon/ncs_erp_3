package com.dgit.ncs.dto;

public class Title {
	int tcode;
	String tname;

	public int getTcode() {
		return tcode;
	}

	public void setTcode(int tcode) {
		this.tcode = tcode;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return String.format("Title [tcode=%s, tname=%s]", tcode, tname);
	}

}
