package business.entity;

import business.utils.InputMethods;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
	private String productId;
	private String productName;
	private Float price;
	private String description;
	private Date created;
	private Integer catalogId;
	private Integer productStatus; // 0-đang bán 1-Hết hàng 2-Không bán
	
	public Product() {
	}
	
	public Product(String productId, String productName, Float price, String description, Date created, Integer catalogId, Integer productStatus) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.created = created;
		this.catalogId = catalogId;
		this.productStatus = productStatus;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}
	
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	
	public Integer getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	
	public void inputData(List<Product> products, List<Category> categories) {
		System.out.print("Nhập vào mã sản phẩm: ");
		this.productId = inputProductId(products);
		System.out.print("Nhập vào tên sản phẩm: ");
		this.productName = inputProductName(products);
		System.out.print("Nhập vào giá sản phẩm: ");
	}
	
	public void displayData() {
	
	}
	
	public String inputProductId(List<Product> products) {
		do {
			String productId = InputMethods.getString();
			if (productId.matches("^[CSA][0-9]{3}$")) {
				boolean isExist = products.stream().anyMatch(product -> product.getProductId().equals(productId));
				if (isExist) {
					System.err.println("mã sản phẩm đã tồn tại");
				} else {
					return productId;
				}
			} else {
				System.err.println("mã sản phẩm phải bắt đầu bằng");
			}
		} while (true);
	}
	
	public String inputProductName(List<Product> products) {
		do {
			String productName = InputMethods.getString();
			if (productName.length() >= 10 && productName.length() <= 50) {
				boolean isExist = products.stream().anyMatch(product -> product.getProductName().equals(productName));
				if (isExist) {
					System.err.println("tên sản phẩm đã tồn tại");
				} else {
					return productName;
				}
			} else {
				System.err.println("tên sản phẩm phải từ 10 đến 50 ký tự");
			}
		} while (true);
	}
}
