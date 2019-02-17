package com.gerardogtz.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.*;

import com.gerardogtz.makereport.Report;
import com.gerardogtz.model.*;


public class AppAmazonViewer {

	public static void main(String[] args) {
		
		/** Puede haber polimorfismo a nivel de clases 
		Clase abstracta no se puede instanciar al menos 
		que sea a partir de una clase hija */
		
		// Film film = new Movie("", "", "", 1, (short)2017);
		// film.view();
		
		showMenu();
		
	}
	
	public static void showMenu() {
		int exit = 0;
		do {
			
			System.out.println("***** WELCOME AMAZON VIEWER *****");
			System.err.println("");
			System.out.println("SELECT AN OPTION");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report today");
			System.out.println("0. Exit");
			
			Scanner sc = new Scanner(System.in);
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
				break;
			}
			
		}while(exit != 0);
	}
	
	static ArrayList<Movie> movies = Movie.makeMoviesList();
	
	public static void showMovies() {
		int exit = 1;
		
		do {
			System.out.println("\n*****  MOVIES  *****\n");
			
			for(int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Watched: "+ movies.get(i).isViewed() );
			}
			
			System.out.println("\n0. Back to the options\n");
			
			Scanner sc = new Scanner(System.in);
			int response = sc.nextInt();
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Movie movieSelected = movies.get(response-1);
				movieSelected.view();
			}
			
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
			
			Serie serieSelected = series.get(response-1);
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
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
			}
			
		}while(exit !=0);
	}
	
	static ArrayList<Book> books= Book.makeBookList();
	public static void showBooks() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//int response = AmazonUtil.validateUserResponseMenu(0, books.size());
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response-1);
				bookSelected.view();
			}
			
		}while(exit !=0);
	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
		}while(exit != 0);
	}
	
	public static void makeReport() {
		Report report = new Report();
		report.setNameFile("report");
		report.setExtension("txt");
		report.setTitle("***** WATCHED ****");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		
		report.setContent(contentReport);
		report.makeReport();
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		report.setContent(contentReport);
		report.makeReport();
	}
}
