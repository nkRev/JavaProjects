package Converter;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		int menuSelection = 0;
		boolean finished = false;
		Scanner in = new Scanner(System.in);
		do {

			menu();
			menuSelection = in.nextInt();

			switch (menuSelection) {
			case 1:
				double cups;
				System.out.print("Measurements of cups: ");
				cups = in.nextDouble();
				System.out.printf("%.2f cups converted to %.2f teaspoons\n\n", cups, cupToTeaspoon(cups));
				break;

			case 2:
				double miles;
				System.out.print("Distance in miles: ");
				miles = in.nextDouble();
				System.out.printf("%.2f miles converted to %.2f kilometers\n\n", miles, milesToKm(miles));
				break;

			case 3:
				double lb;
				System.out.print("Weight in pounds: ");
				lb = in.nextDouble();
				System.out.printf("%.0f pounds converted to %.2f kilograms\n\n", lb, lbToKg(lb));
				break;

			case 4:
				double grams;
				System.out.print("Weight in grams: ");
				grams = in.nextDouble();
				System.out.printf("%.0f grams converted to %.2f ounces\n\n", grams, gToOz(grams));
				break;

			case 5:
				double farenheit;
				System.out.print("Temperature in Farenheit: ");
				farenheit = in.nextDouble();
				System.out.printf("%.2f\u00B0F converted to %.2f\u00B0C\n\n", farenheit, fToCelcius(farenheit));
				break;
			case 0:
				System.out.println("Terminating...\n");
				in.close();
				finished = true;
				break;

			default:
				System.out.println("Please only enter values integer values from 1 to 0.\n");
				break;

			}

		} while (!finished);

	}

	public static void menu() {
		System.out.println("1. Cups to Teaspoons");
		System.out.println("2. Miles to Kilometers");
		System.out.println("3. US Pounds to Kilograms");
		System.out.println("4. Grams to Ounces");
		System.out.println("5. Farenheit to Celcius");
		System.out.println("0 to Quit\n");
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

	public static double fToCelcius(double f) {
		double celcius = 0;
		celcius = (f - 32) * 5 / 9;
		return celcius;
	}
}
