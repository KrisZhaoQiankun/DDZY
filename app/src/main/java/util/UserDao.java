package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fun.krisme.smartbus.RemoteUser;
import fun.krisme.smartbus.User;

public class UserDao {
    public RemoteUser login(Connection con, RemoteUser user) throws Exception{
        RemoteUser resultUser = null;
        String sql = "select * from RemoteUser where username = ? and Password = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            resultUser = new RemoteUser();
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("Password"));
        }
        return resultUser;
    }
}
