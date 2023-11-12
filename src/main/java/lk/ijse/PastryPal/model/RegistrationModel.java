package lk.ijse.PastryPal.model;

import lk.ijse.PastryPal.DB.DbConnection;
import lk.ijse.PastryPal.dto.RegistrationDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationModel {

    public boolean registerUser(RegistrationDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO users VALUES (?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, dto.getUser_name());
        ptsm.setString(2, dto.getPassword());

        return ptsm.executeUpdate() > 0;
    }

    public boolean isValidUser(String userName, String pw) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, userName);
        ptsm.setString(2,pw);

        ResultSet resultSet = ptsm.executeQuery();

        return resultSet.next();
    }
}
