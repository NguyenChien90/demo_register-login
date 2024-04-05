package business.designimpl;

import business.design.IUserDesign;
import business.entity.RoleName;
import business.entity.User;
import business.utils.IOFile;
import business.utils.InputMethods;
import presentation.MenuAdmin;
import presentation.MenuUser;

import java.util.ArrayList;
import java.util.List;

public class UserDesignImpl implements IUserDesign {
    private static List<User> userList;
    public static User userLogin;

    public UserDesignImpl() {
        // gan userList laij tu file doc ra
        userList = IOFile.readObjectFromFile(IOFile.PATH_USER);
        // kiem tra khoi tao khi userList null
        if (userList == null){
            userList = new ArrayList<>();
        }

    }

    @Override
    public Integer findIndexById(User id) {
        return null;
    }

    @Override
    public void handleAdd() {
        System.out.println("***FORM REGISTER***");

        User user = new User();

        user.setId((int) (Math.random()*1000)); // tu lam ID tu tang

        // username khong duoc trung lap
        System.out.println("Nhap username: ");
        while (true){
            String name = InputMethods.getString();
            boolean check = true;
            for (User user1 : userList) {
                if (user1.getUsername().equals(name)){
                    System.out.println("Ten tai khoan da ton tai moi nhap lai");
                    check = false;
                    break;
                }
            }
            if (check){
                // ten tk khong trung
                user.setUsername(name);
                break;
            }
        }
        // password
        System.out.println("Nhap password");
        user.setPassword(InputMethods.getString());
        // repeat pass phai giong password vua nhap
        System.out.println("Nhap lai password");
        while (true){
            String repeatPass = InputMethods.getString();
            if (user.getPassword().equals(repeatPass)){
                break;
            }
            System.out.println("Mat khau khong trung khop moi nhap lai");

        }
        // Ho ten nguoi dung
        System.out.println("Nhap ho va ten :");
        user.setName(InputMethods.getString());
        // role khi dang ky mac dinh la USER

        // Khi nhap du lieu thoa man luu USER vao userList va ghi vao file
        userList.add(user);
        IOFile.writeObjectToFile(userList,IOFile.PATH_USER);


    }

    @Override
    public void handleShow() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void handleEdit() {

    }

    @Override
    public void handleDelete() {

    }

    @Override
    public void checkLogin() {
        System.out.println("*****FORM LOGIN*****");
        System.out.println("Moi nhap username: ");
        String username = InputMethods.getString();
        System.out.println("Moi nhap password: ");
        String password = InputMethods.getString();
        // duyệt userList xem có User nào có username và password trung với username và password vừa nhập
        for (User user1 : userList) {
            // nếu có thì gán userLogin bằng user vừa tìm được trong list
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)){
                userLogin = user1;
            }
        }
        // kiểm tra userLogin để thông báo hoặc điêu hướng theo role của user
        if (userLogin == null){
            System.out.println("Ten dang nhap hoac pass khong dung");
        }else {
            IOFile.writeObjectToFile(userLogin,IOFile.PATH_USER_PRINCIPAL);
            if (userLogin.getRole().equals(RoleName.ADMIN)){
                new MenuAdmin().menuAdmin(); // role ADMIN chuyển đến menu của ADMIN
            }
            if (userLogin.getRole().equals(RoleName.USER)){
                new MenuUser().menuUser(); // role USER chuyển đến menu của USER
            }

        }

    }

    @Override
    public void logOut() {
        // gán lại userLogin = null rồi ghi lại vào file
        userLogin = null;
        IOFile.writeObjectToFile(userLogin,IOFile.PATH_USER_PRINCIPAL);
    }
}
