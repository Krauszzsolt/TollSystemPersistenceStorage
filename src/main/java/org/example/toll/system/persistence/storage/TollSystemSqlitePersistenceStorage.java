package org.example.toll.system.persistence.storage;

import org.example.toll.system.app.entities.MotorwayVignette;
import org.example.toll.system.app.storage.TollSystempersistenceStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class TollSystemSqlitePersistenceStorage implements TollSystempersistenceStorage {
    @Override
    public ArrayList<MotorwayVignette> loadVignettesByRegistrationNumber(String RegistrationNumber) {
        return selectByRegistrationNumber(RegistrationNumber);
    }



    public ArrayList<MotorwayVignette> selectByRegistrationNumber(String RegistrationNumber){
        ArrayList<MotorwayVignette> vignettes = new ArrayList<>();
        String sql = "SELECT * FROM motorway_vignette WHERE registration_number =  '" + RegistrationNumber + "';";
        System.out.println(sql);

        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                String vehicleCategory = rs.getString("vehicle_category");
                String motorwayVignetteType= rs.getString("motorway_vignette_type");
                Integer price = rs.getInt("price");
                Date validFrom = new Date(Integer.parseInt(rs.getString("valid_from")));
                Date dateOfPurchase =  new Date(Integer.parseInt(rs.getString("date_of_purchase")));

                MotorwayVignette vignette = new MotorwayVignette(vehicleCategory,motorwayVignetteType,price,validFrom,dateOfPurchase);

                vignettes.add(vignette);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vignettes;
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/TollSystem.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
