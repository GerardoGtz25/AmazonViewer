package com.gerardogtz.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {
	
	private int id;
	private int timeViewed;
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		this.setYear(year);
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" + 
				"\n Title: " + getTitle() +
				"\n Genre: " + getGenre() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}
	
	@Override
	public void stopToSee(Date dateI, Date dateF) {
	  int result = dateF.getTime() > dateI.getTime() ? (int) (dateF.getTime() - dateI.getTime()) : 0;
	  this.setTimeViewed(result);
	}
	
	public static ArrayList<Movie> makeMoviesList() {
		ArrayList<Movie> movies = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie("Movie " + i, "Genero: " + i, "Creador " + i, 120+i, (short)(2017+i)));
		}
		
		return movies;
	}
	
	public void view() {
		setViewed(true);
		Date dateI = startToSee(new Date());
		
		for(int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		stopToSee(dateI, new Date());
		System.out.println("You watched: " + toString());
		System.out.println("for " + getTimeViewed() + " milliseconds");
	}

}
