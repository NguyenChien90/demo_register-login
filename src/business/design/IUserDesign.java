package business.design;

import business.entity.User;

public interface IUserDesign extends IGenericDesign<User>{
    void checkLogin();
    void logOut();
}
