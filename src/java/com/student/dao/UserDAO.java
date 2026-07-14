package com.student.dao;

import com.student.model.User;
import com.student.util.DBConnection;
import java.sql.*;

public class UserDAO {


    public boolean registerUser(User user) {


        String sql =
        "INSERT INTO users(username,password) VALUES (?,?)";


        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){


            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());


            int result = ps.executeUpdate();


            return result > 0;


        } catch(SQLException e){

            e.printStackTrace();

        }


        return false;

    }



    public User login(String username, String password){


        String sql =
        "SELECT * FROM users WHERE username=? AND password=?";


        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){


            ps.setString(1, username);
            ps.setString(2, password);


            ResultSet rs = ps.executeQuery();


            if(rs.next()){


                User user = new User();

                user.setUserId(
                    rs.getInt("user_id")
                );

                user.setUsername(
                    rs.getString("username")
                );


                return user;

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return null;

    }

}