package com.gerardogtz.amazonviewer;

import java.util.*;

import com.gerardogtz.model.*;


public class AppAmazonViewer {

	public static void main(String[] args) {

		showMenu();
		
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("***** WELCOME AMAZON VIEWER *****");
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
			System.out.println("\n*****  MOVIES  *****\n");
			
			for(int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Watched: "+ movies.get(i).isViewed() );
			}
			
			System.out.println("0. Back to the options\n");
			
			Scanner sc = new Scanner(System.in);
			int response = sc.nextInt();
			
			if(response == 0) {
				showMenu();
			}
			
			Movie movieSelected = movies.get(response-1);
			movieSelected.setViewed(true);
			Date dateI = movieSelected.startToSee(new Date());
			
			for(int i = 0; i < 100000; i++) {
				System.out.println("..........");
			}
			
			movieSelected.stopToSee(dateI, new Date());
			System.out.println("You watched: " + movieSelected);
			System.out.println("for " + movieSelected.getTimeViewed() + " milliseconds");
			
		}while(exit != 0);
	}
	
	public static void showSeries() {
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();
		do {
			System.out.println("\n***** SERIES *****\n");
			
			for (int i = 0; i < series.size(); i++) {
				System.out.println(i+1 + ". " + series.get(i).getTitle() + " Watched: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = sc.nextInt();
			
			if(response == 0) {
				showMenu();
			}
			Serie serieSelected =series.get(response-1);
			serieSelected.setViewed(true);
			showChapters(serieSelected.getChapters());
			
		}while(exit !=0);
	}
	
	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 0;
		
		do {
			System.out.println("\n***** CHAPTERS *****\n");
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { 
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Watched: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				showSeries();
			}
			
			Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());
			
			for (int i = 0; i < 100000; i++) {
				System.out.println("..........");
			}
			
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
		}while(exit !=0);
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
