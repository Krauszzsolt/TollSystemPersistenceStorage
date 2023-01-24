package org.example.toll.system.persistence.storage.sqlite.seed;

import java.sql.*;

public class InsertRecords {

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


    public void insert(String name, double capacity) {
        String sql = """
        INSERT INTO motorway_vignette(vehicle_category, motorway_vignette_type,motorway_vignette_type,price,valid_from,date_of_purchase,registration_number)
        VALUES ('asd', 'd1', '10 nap', 1000, '0','0','asd');
""";


        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertRecords app = new InsertRecords();
        // insert three new rows
        app.insert("Aryan", 30000);
    }

}