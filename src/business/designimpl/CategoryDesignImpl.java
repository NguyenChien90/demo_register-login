package business.designimpl;

import business.design.ICategoryDesign;
import business.entity.Category;
import business.utils.IOFile;

import java.util.ArrayList;
import java.util.List;

public class CategoryDesignImpl implements ICategoryDesign {
	
	public static List<Category> categories;
	
	public CategoryDesignImpl() {
		categories = IOFile.readObjectFromFile(IOFile.PATH_CATEGORY);
		if (categories == null){
			categories  = new ArrayList<>();
		}
	}
	
	@Override
	public Integer findIndexById(Integer id) {
		return null;
	}
	
	@Override
	public void handleAdd() {
		// thực hiện thêm dữ liệu vào list
		
		// sau khi thêm lưu lại nó vào file
		IOFile.writeObjectToFile(categories, IOFile.PATH_CATEGORY);
	}
	
	@Override
	public void handleShow() {
		// hiển thị nội dung
		
	}
	
	@Override
	public void handleEdit() {
		// thực hiện logic edit
		
		// sau khi thực hiện edit xong thì sẽ lưu lại vào file
		IOFile.writeObjectToFile(categories, IOFile.PATH_CATEGORY);
	}
	
	@Override
	public void handleDelete() {
		// thực hiện logic delete
		
		// xóa xong thì lưu lại dữ liệu vào file
		IOFile.writeObjectToFile(categories, IOFile.PATH_CATEGORY);
	}
}
