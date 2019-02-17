package com.gerardogtz.model;

import java.util.ArrayList;

public class Serie extends Film {
	
	private int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;
	
	public Serie(String title, String genre, String creator, int duration, int seasonQuantity,
			ArrayList<Chapter> chapters) {
		super(title, genre, creator, duration);
		this.chapters = chapters;
		this.seasonQuantity = seasonQuantity;
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

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: SERIE ::" + 
				"\n Title: " + getTitle() +
				"\n Genre: " + getGenre() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	public static ArrayList<Serie> makeSeriesList() {
		ArrayList<Serie> series = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			series.add(new Serie("Serie "+i, "genre "+i, "creador "+i, 1200, 5, Chapter.makeChaptersList()));	
		}
		
		return series;
	}
	
}
