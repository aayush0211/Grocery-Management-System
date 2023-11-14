package groceryManagementSystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class Grocery {
	private String name;
	private Double price;
	private Integer quantity;
	private LocalDate stockUpdateDate;
	private LocalTime stockUpdateTime;
	public Grocery(String name, Double price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.stockUpdateDate = LocalDate.now();
		this.stockUpdateTime = LocalTime.now();
	}
	public Grocery(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		setStockUpdateDate(LocalDate.now());
		setStockUpdateTime(LocalTime.now());
		this.quantity = quantity;
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public LocalTime getStockUpdateTime() {
		return stockUpdateTime;
	}

	public void setStockUpdateTime(LocalTime stockUpdateTime) {
		this.stockUpdateTime = stockUpdateTime;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Grocery) {
			Grocery g = (Grocery)obj;
			return name.equals(g.name);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Grocery [name=" + name + ", price=" + price + ", quantity=" + quantity + ", stockUpdateDate="
				+ stockUpdateDate + ", stockUpdateTime=" + stockUpdateTime + "]";
	}
	
	
	
}
