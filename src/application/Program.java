package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		
		// Criando um cliente
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birh date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next());
		Client client = new Client(name, email, birth);
		System.out.println();
		
		// Criando um carrinho
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order o1 = new Order (birth, status, client);
		
		
		// Pegando a quantidade e os dados do produto
		System.out.print("How many item to this order? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product p = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity, productPrice, p);
			o1.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(o1);
		
		sc.close();
	}
}
