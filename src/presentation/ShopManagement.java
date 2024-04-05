package presentation;

import business.design.ICategoryDesign;
import business.design.IProductDesign;
import business.design.IUserDesign;
import business.designimpl.CategoryDesignImpl;
import business.designimpl.ProductDesignImpl;
import business.designimpl.UserDesignImpl;
import business.entity.Category;
import business.entity.RoleName;
import business.entity.User;
import business.utils.IOFile;
import business.utils.InputMethods;

import java.util.ArrayList;
import java.util.List;

public class ShopManagement {
	ICategoryDesign categoryDesign = new CategoryDesignImpl();
	IProductDesign productDesign = new ProductDesignImpl();
	IUserDesign userDesign = new UserDesignImpl();
	static ShopManagement shopManagement = new ShopManagement();
	
	public static void main(String[] args) {
		User userLogin = IOFile.readObjectFromFile(IOFile.PATH_USER_PRINCIPAL);
		if (userLogin == null){
			new ShopManagement().mennuHome();
		}else {
			if (userLogin.getRole().equals(RoleName.ADMIN)){
				new MenuAdmin().menuAdmin();
			}
			if (userLogin.getRole().equals(RoleName.USER)){
				new MenuUser().menuUser();
			}
		}

	}

	public void mennuHome(){
		int choice;
		do {
			System.out.println("DANH SACH USER ");
			userDesign.handleShow(); // hiển thị tạm danh sach USER để test
			System.out.println("**********************MENU************************");
			System.out.println("1. ĐĂNG NHẬP");
			System.out.println("2. ĐĂNG KÝ");
			System.out.println("0. Thoát");
			System.out.print("Mời lựa chọn (0/1/2/3/4/5): ");
			choice = InputMethods.getInteger();
			switch (choice) {
				case 1:
					userDesign.checkLogin();
					break;
				case 2:
					userDesign.handleAdd();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
					break;
			}
		} while (true);
	}


}
