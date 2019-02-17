package com.gerardogtz.model;

public class Serie extends Film {
	
	private int id;
	private int seasonQuantity;
	private Chapter chapters[];
	
	public Serie(String title, String genre, String creator, int duration, int id, int seasonQuantity,
			Chapter[] chapters) {
		super(title, genre, creator, duration);
		this.id = id;
		this.seasonQuantity = seasonQuantity;
		this.chapters = chapters;
	}

	public int getId() {
		return id;
	}

	public int getSeasonQuantity() {
		return seasonQuantity;
	}

	public void setSeasonQuantity(int seasonQuantity) {
		this.seasonQuantity = seasonQuantity;
	}

	public Chapter[] getChapters() {
		return chapters;
	}

	public void setChapters(Chapter[] chapters) {
		this.chapters = chapters;
	}
	
	
	
	
	
	
	
	
	
	

	
	
}
