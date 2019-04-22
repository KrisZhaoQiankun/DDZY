package util;

import java.sql.SQLException;

import fun.krisme.smartbus.RemoteUser;

public class test1 {
    public static void main(String[] args) {
        HttpUtil httpUtil = new HttpUtil();
        try {
            httpUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
