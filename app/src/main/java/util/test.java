package util;

import java.sql.Connection;
import java.sql.SQLException;

import fun.krisme.smartbus.RemoteUser;
import fun.krisme.smartbus.User;

public class test {
    HttpUtil httpUtil = new HttpUtil();
    Connection con;
    UserDao dao;
    public boolean check(RemoteUser remoteUser){
        try {

            con = httpUtil.getConnection();
            dao = new UserDao();
            if (dao.login(con,remoteUser)!=null){
                return true;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
