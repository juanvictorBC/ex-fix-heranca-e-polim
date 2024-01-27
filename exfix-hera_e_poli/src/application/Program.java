package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #"+ i +" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char cui = sc.next().charAt(0);
			

			if (cui == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				list.add(new Product(name, price));
			}

			if (cui == 'u') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), fmt);
				list.add(new UsedProduct(name, price, date));
			}
			else if (cui == 'i') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Custom fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:"); 
		for (Product e : list) {
			System.out.println(e.priceTag());
			
		}
		
		sc.close();

	}

}
