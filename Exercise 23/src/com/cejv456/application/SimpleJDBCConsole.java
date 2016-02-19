package com.cejv456.application;

import com.cejv456.bussiness.FishDAOImpl;
import com.cejv456.data.FishData;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Retrieve the data and display on the console
 *
 */
public class SimpleJDBCConsole {

    private final FishDAOImpl fishDAO;
    Scanner sc;
    private FishData fd;

    public SimpleJDBCConsole() {
        super();
        fishDAO = new FishDAOImpl();
    }

    private void perform() {
        fd = new FishData();
        fd.setCommonName("testyName");
        fd.setDiet("testyDiet");
        fd.setFishSize("testysize");
        fd.setKh("testykh");
        fd.setLatin("testylatin");
        fd.setPh("testyph");
        fd.setSpeciesOrigin("testyspeciesOrigin");
        fd.setStocking("testystocking");
        fd.setTankSize("testytankSize");
        fd.setTemp("testytemp");
        fd.setId(201);
        int data=0;
        try {
            data = fishDAO.update(fd);
        } catch (SQLException ex) {

            System.out.println( "Error loading data");
        }
        System.out.println(data);
    }
    
    public String getInput(){
        sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String s = sc.next();
        
        return s;
    }

    public static void main(String[] args) {
        SimpleJDBCConsole simple = new SimpleJDBCConsole();
        simple.perform();
        System.exit(0);

    }

}
