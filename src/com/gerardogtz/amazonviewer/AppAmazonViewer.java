package com.gerardogtz.amazonviewer;

import java.util.*;

import com.gerardogtz.model.Movie;


public class AppAmazonViewer {

	public static void main(String[] args) {

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
			
			int entrada = sc.nextInt();
			
			switch (entrada) {
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
			case 0:
				System.out.println("saliste del sistema!");
				exit = 0;
				break;

			default:
				System.out.println("Opción no disponible");
				exit  = 1;
				break;
			}
			
		}while(exit != 0);
	}

	public static void showMovies() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
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
