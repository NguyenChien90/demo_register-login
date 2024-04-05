package business.design;

import business.entity.User;

public interface IUserDesign extends IGenericDesign<Integer>{
    void checkLogin();
    void logOut();
}
