package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date manufactureDate;

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	@Override
	public String priceTag() {
		return name + " (usado) R$ " + price + " (Data de producao: "+ sdf.format(manufactureDate) +")";
	}

}
