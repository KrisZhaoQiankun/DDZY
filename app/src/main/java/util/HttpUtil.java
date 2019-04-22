package util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class HttpUtil {
    static String driver="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://47.98.117.19:3306/dzyy?useUnicode=true&characterEncoding=utf8";
    static String username = "root";
    static String pass = "123456";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public Connection getConnection() throws ClassNotFoundException,
            SQLException,InstantiationException,IllegalAccessException{
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,pass);
            return conn;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;

    }
    public void closeAll() {
        if(rs!=null) {
            try {
                rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null) {
            try {
                pstmt.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public ResultSet executeQuery(String preparedSql, Object[] param) {
        try {
            pstmt = conn.prepareStatement(preparedSql);
            if(param!=null) {
                for(int i = 0;i<param.length;i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            rs = pstmt.executeQuery();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int executeUpdate(String preparedSql,Object[] param) {
        int num = 0;
        try {
            pstmt = conn.prepareStatement(preparedSql);
            if(param!=null) {
                for(int i = 0;i<param.length;i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            num = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}