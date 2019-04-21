package util;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.UserDao;

import fun.krisme.smartbus.MyGreenDAOApplication;
import fun.krisme.smartbus.User;

public class DBUtil {
    public static UserDao userDao;
    private User user;

    public boolean check(String name,String password){
        userDao = MyGreenDAOApplication.getInstances().getDaoSession().getUserDao();
        user = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        if (user != null){
            if ((user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    private void insertOne(User user){
        userDao.insert(user);
    }


}
