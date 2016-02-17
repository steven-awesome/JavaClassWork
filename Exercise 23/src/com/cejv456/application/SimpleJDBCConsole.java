package com.cejv456.application;

import com.cejv456.bussiness.FishDAOImpl;
import java.sql.SQLException;

/**
 * Retrieve the data and display on the console
 *
 */
public class SimpleJDBCConsole {

    private final FishDAOImpl fishDAO;

    public SimpleJDBCConsole() {
        super();
        fishDAO = new FishDAOImpl();
    }

    private void perform() {
        String data;
        try {
            data = fishDAO.findAll().toString();
        } catch (SQLException ex) {

            data = "Error loading data";
        }
        System.out.println(data);
    }

    public static void main(String[] args) {
        SimpleJDBCConsole simple = new SimpleJDBCConsole();
        simple.perform();
        System.exit(0);

    }

}
