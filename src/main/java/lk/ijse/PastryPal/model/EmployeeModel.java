package lk.ijse.PastryPal.model;

import lk.ijse.PastryPal.DB.DbConnection;
import lk.ijse.PastryPal.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
    private String splitEmployeeID(String currentEmployeeID){
        if (currentEmployeeID != null){
            String [] split = currentEmployeeID.split("00");

            int id = Integer.parseInt(split[1]);
            id++;
            return "E00" + id;
        }else {
            return "E001";
        }
    }
    public String generateNextEmployeeID() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ResultSet resultSet = ptsm.executeQuery();
        if (resultSet.next()){
            return splitEmployeeID(resultSet.getString(1));
        }
        return splitEmployeeID(null);
    }

    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES (?,?,?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, dto.getEmployee_id());
        ptsm.setString(2, dto.getFirst_name());
        ptsm.setString(3,dto.getLast_name());
        ptsm.setString(4,dto.getAddress());
        ptsm.setString(5, dto.getPhone_number());

        return ptsm.executeUpdate() > 0;
    }
}
