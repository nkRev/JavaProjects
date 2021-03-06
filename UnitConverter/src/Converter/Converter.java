package Converter;

import java.util.Scanner;

/**
 * This is a converter project for Project A. 
 * 
 * This program does conversions for cooking measurement (lb to kg, grams to ounces,
 * and cups to teaspoons), distance measurement (miles to kilometers), and
 * temperature conversion (fahrenheit to celsius).
 * 
 * Originally, I had the menu in my main method but I wanted to implement a "return to main menu" feature for the sub
 * menus. Which lead to me creating an inputMenu method which calls all the
 * conversion sub menus and gave the option to return to the main menu. 
 * 
 * @author Nicky Kayyarath
 *
 */
public class Converter {
	static int menuSelection = 0;
	static boolean finished = true;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		inputMenu();

	}

	public static void displayMenu() {
		System.out.println("1. Cooking measurement conversions");
		System.out.println("2. Distance conversions");
		System.out.println("3. Temperature conversions");
		System.out.println("0 to Quit\n");

		System.out.print("Your selection: ");
	}

	public static void inputMenu() {
		do {
			displayMenu();
			menuSelection = in.nextInt();
			switch (menuSelection) {
			case 1:
				cookingConvMenu(in); // calls sub menu for cooking conversions
				break;
			case 2:
				distanceMenu(in); // calls sub menu for distance conversions
				break;
			case 3:
				temperatureMenu(in); // calls sub menu for temperature conversions
				break;
			case 0:
				System.out.println("Terminating...");
				break;

			default:
				System.out.println("Please enter an integer value that the menu has given.");
				in.next(); // stops infinite loop but breaks program; will need to fix
				break;
			}
		} while (menuSelection != 0);

	}

	private static void temperatureMenu(Scanner in) {

		do {
			System.out.println("1. Farenheit to Celcius");
			System.out.println("0 to return to main menu.\n");
			System.out.print("Your Selection:");

			menuSelection = in.nextInt();
			switch (menuSelection) {
			case 1:
				double fahrenheit;
				System.out.print("Temperature in Farenheit: ");
				fahrenheit = in.nextDouble();
				System.out.printf("%.2f\u00B0F converted to %.2f\u00B0C\n\n", fahrenheit, fToCelsius(fahrenheit));
				break;
			case 0:
				System.out.println("Returning...\n");
				finished = true;
				inputMenu();
				break;
			default:
				System.out.println("Please enter an integer value that the menu has given.");
				break;
			}
		} while (!finished);

	}

	public static void distanceMenu(Scanner in) {
		do {
			System.out.println("1. Miles to Kilometers");
			System.out.println("0 to return to main menu.\n");

			System.out.print("Your Selection: ");

			menuSelection = in.nextInt();
			switch (menuSelection) {
			case 1:
				double miles;
				System.out.print("Distance in miles: ");
				miles = in.nextDouble();
				System.out.printf("%.2f miles converted to %.2f kilometers\n\n", miles, milesToKm(miles));
				break;
			case 0:
				System.out.println("Returning...\n");
				finished = true;
				inputMenu();
				break;
			default:
				System.out.println("Please enter an integer value that the menu has given.");
				break;
			}
		} while (!finished);

	}

	public static void cookingConvMenu(Scanner in) {
		do {
			System.out.println("1. Cups to Teaspoons");
			System.out.println("2. Grams to Ounces");
			System.out.println("3. US Pounds to Kilograms");
			System.out.println("0 to return to main menu.\n");

			System.out.print("Your Selection: ");

			menuSelection = in.nextInt();
			switch (menuSelection) {
			case 1:
				double cups;
				System.out.print("Measurements of cups: ");
				cups = in.nextDouble();
				System.out.printf("%.2f cups converted to %.2f teaspoons\n\n", cups, cupToTeaspoon(cups));
				break;
			case 2:
				double grams;
				System.out.print("Weight in grams: ");
				grams = in.nextDouble();
				System.out.printf("%.0f grams converted to %.2f ounces\n\n", grams, gToOz(grams));
				break;
			case 3:
				double lb;
				System.out.print("Weight in pounds: ");
				lb = in.nextDouble();
				System.out.printf("%.0f pounds converted to %.2f kilograms\n\n", lb, lbToKg(lb));
				break;
			case 0:
				System.out.println("Returning...\n");
				finished = true;
				inputMenu();
				break;
			default:
				System.out.println("Please enter an integer value that the menu has given.");
			}
		} while (!finished);

	}

	public static double cupToTeaspoon(double cups) {
		return (cups * 48);
	}

	public static double milesToKm(double miles) {
		return (miles * 1.609);
	}

	public static double lbToKg(double lb) {
		return (lb * 2.205);
	}

	public static double gToOz(double g) {

		return (g / 28.35);
	}

	public static double fToCelsius(double f) {
		double celsius = 0;
		celsius = (f - 32) * 5 / 9;
		return celsius;
	}
}
