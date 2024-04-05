package business.designimpl;

import business.design.IProductDesign;
import business.entity.Product;
import business.utils.IOFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDesignImpl implements IProductDesign {
	public static List<Product> products;
	
	public ProductDesignImpl() {


		products = IOFile.readObjectFromFile(IOFile.PATH_PRODUCT);
		if (products == null){
			products = new ArrayList<>();
		}
	}
	
	@Override
	public Integer findIndexById(String id) {
		return null;
	}
	
	@Override
	public void handleAdd() {
		// thực hiện thêm dữ liệu vào list
		
		// sau khi thêm lưu lại nó vào file
		IOFile.writeObjectToFile(products, IOFile.PATH_PRODUCT);
	}
	
	@Override
	public void handleShow() {
	
	}
	
	@Override
	public void handleEdit() {
		// thực hiện logic edit
		
		// sau khi thực hiện edit xong thì sẽ lưu lại vào file
		IOFile.writeObjectToFile(products, IOFile.PATH_PRODUCT);
	}
	
	@Override
	public void handleDelete() {
		// thực hiện logic delete
		
		// xóa xong thì lưu lại dữ liệu vào file
		IOFile.writeObjectToFile(products, IOFile.PATH_PRODUCT);
	}
}
