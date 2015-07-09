package com.zkread.domain;

public class Category {
	private long id;
	private String name;
	private String grepKeywords;
	private String svmKeywords;
	private String symbol;
	private String scoreKeywords;
	private int rank;
	private int state;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrepKeywords() {
		return grepKeywords;
	}
	public void setGrepKeywords(String grepKeywords) {
		this.grepKeywords = grepKeywords;
	}
	public String getSvmKeywords() {
		return svmKeywords;
	}
	public void setSvmKeywords(String svmKeywords) {
		this.svmKeywords = svmKeywords;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getScoreKeywords() {
		return scoreKeywords;
	}
	public void setScoreKeywords(String scoreKeywords) {
		this.scoreKeywords = scoreKeywords;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
