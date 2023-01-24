package org.example.toll.system.persistence.storage.sqlite.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/sqlite/TollSystem.db";

//         SQL statement for creating a new table
        String sql = """
                CREATE TABLE IF NOT EXISTS motorway_vignette (
                id integer PRIMARY KEY,
                vehicle_category text NOT NULL,
                motorway_vignette_type text NOT NULL,
                price integer NOT NULL,
                valid_from text NOT NULL,
                date_of_purchase text NOT NULL,
                registration_number text NOT NULL
                );
                """;


        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        createNewTable();
    }

}  