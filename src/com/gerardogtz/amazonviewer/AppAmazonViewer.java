package com.gerardogtz.amazonviewer;

import java.util.*;

import com.gerardogtz.model.Movie;


public class AppAmazonViewer {

	public static void main(String[] args) {
		
		// Movie movie = new Movie("Coco", "Animation", "Lee Unkrich", 120, (short)2017);
		// movie.showData();
		
		// System.out.println(movie.toString());

		showMenu();
		

	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("::::WELCOME AMAZON VIEWER::::");
			System.err.println("");
			System.out.println("SELECT AN OPTION");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Rport today");
			System.out.println("0. Exit");
			
			//int response = Integer.valueOf(sc.nextLine());
			int response = sc.nextInt();
			
			switch (response) {
			case 0:
				System.out.println("You has gone out of the system");
				exit = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;

			default:
				System.out.println("Not available option");
				exit  = 1;
				break;
			}
			
		}while(exit != 0);
	}

	public static void showMovies() {
		int exit = 1;
		ArrayList<Movie> movies = Movie.makeMoviesList();
		
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			for(int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Watched: "+ movies.get(i).isViewed() );
			}
			
			System.out.println("0. Back to the options\n");
			
			Scanner sc = new Scanner(System.in);
			int response = sc.nextInt();
			
			Movie movieSelected = movies.get(response-1);
			movieSelected.setViewed(true);
			Date dateI = movieSelected.startToSee(new Date());
			
			for(int i = 0; i < 100000; i++) {
				System.out.println("..........");
			}
			
			movieSelected.stopToSee(dateI, new Date());
			System.out.println("You watched: " + movieSelected);
			System.out.println("for " + movieSelected.getTimeViewed());
			
		}while(exit != 0);
	}
	
	public static void showSeries() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
		}while(exit != 0);
	}
	
	public static void showChapters() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
		}while(exit != 0);
	}
	
	public static void showBooks() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
		}while(exit != 0);
	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
		}while(exit != 0);
	}
	
	public static void makeReport() {
		
	}
	
	public static void makeReport(Date date) {
		
	}
}
