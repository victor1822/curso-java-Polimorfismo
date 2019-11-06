package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> p = new ArrayList<>();
		
		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do produto #"+(int)(i+1)+":");
			System.out.print("Comum, usado ou importado (c/u/i)?");
			char c = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preco: ");
			Double price = sc.nextDouble();
			if(c=='c') {
				p.add(new Product(name,price));
			}
			else if(c=='u') {
				System.out.print("Data de producao (DD/MM/YYYY): ");
				sc.nextLine();
				Date date = sdf.parse(sc.nextLine());
				p.add(new UsedProduct(name,price,date));
				
			}
			else if(c=='i'){
				System.out.print("Imposto: ");
				sc.nextLine();
				double customsFee = sc.nextDouble();
				p.add(new ImportedProduct(name,price,customsFee));	
			}
		}
		
		System.out.println("\n Price Tags: ");
		for(Product product : p) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
