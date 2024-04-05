package business.entity;

import business.utils.InputMethods;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private Integer catalogId;
	private String catalogName;
	private String description;
	private Boolean catalogStatus;
	
	public Category() {
	}
	
	public Category(Integer catalogId, String catalogName, String description, Boolean catalogStatus) {
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = description;
		this.catalogStatus = catalogStatus;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}
	
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	
	public String getCatalogName() {
		return catalogName;
	}
	
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getCatalogStatus() {
		return catalogStatus;
	}
	
	public void setCatalogStatus(Boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}
	
	public void inputData(List<Category> categories) {
		System.out.print("Nhập vào tên danh mục: ");
		this.catalogName = inputCatalogName(categories);
		System.out.print("Nhập vào mô tả danh mục: ");
		this.description = InputMethods.getString();
		System.out.println("Nhập vào trạng thái danh mục: ");
		this.catalogStatus = InputMethods.getBoolean();
	}
	
	public void displayData() {
		System.out.println("[ ID: "+this.catalogId+" | Name: "+this.catalogName+" | Description: "+this.description+" | Status: "+(this.catalogStatus?"Hoạt động":"Không hoạt động")+" ]");
	}
	
	public String inputCatalogName(List<Category> categories) {
		do {
			String catalogName = InputMethods.getString();
			if (catalogName.length() <= 50) {
				boolean isExist = categories.stream().anyMatch(category -> category.getCatalogName().equals(catalogName));
				if (isExist) {
					System.err.println("Tên danh mục đã bị trùng");
				} else {
					return catalogName;
				}
			} else {
				System.err.println("Độ dài tên danh mục chỉ tối đa 50 ký tự");
			}
		} while (true);
	}
	
}
