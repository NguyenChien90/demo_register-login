package presentation;

import business.design.IUserDesign;
import business.designimpl.UserDesignImpl;
import business.entity.User;
import business.utils.IOFile;
import business.utils.InputMethods;

public class ViewUser {
    IUserDesign userDesign = new UserDesignImpl();
    User userLogin = IOFile.readObjectFromFile(IOFile.PATH_USER_PRINCIPAL);
    public void menuUser(){
        int choice;
        do {
            System.out.println("Welcome : "+ userLogin.getName());
            System.out.println("**********************MENU USER************************");
            System.out.println("1. XEM DANH SACH SAN PHAM");
            System.out.println("2. TIM KIEM SAN PHAM");
            System.out.println("3. SAP XEP SAN PHAM THEO GIA");
            System.out.println("4. QUAN LY GIO HAN");
            System.out.println("5. THONG TIN CA NHAN");
            System.out.println("0. LogOut");
            System.out.print("Mời lựa chọn (0/1/2/3/4/5): ");
            choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    userDesign.logOut();
                    new ShopManagement().mennuHome();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }
}
