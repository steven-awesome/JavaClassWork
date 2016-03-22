package com.cejv456.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.cejv456.data.FishData;
import com.cejv456.Interfaces.FishDAO;
import com.cejv456.bussiness.FishDAOImpl;
import java.io.File;

public class DemoTestCase {

    // This is my local MySQL server
    private final String url = "jdbc:derby://localhost:1527/fishDB";
    private final String user = "fish";
    private final String password = "fish";

    /**
     * Test to get the number of records I know are in the table
     *
     * @throws SQLException
     */
    @Test
    public void testFindAll() throws SQLException {
        FishDAO fd = new FishDAOImpl();
        List<FishData> lfd = fd.findAll();
        assertEquals("testFindAll: ", 200, lfd.size());
    }

    /**
     * I have selected the record that will have an ID value of 6. I create a
     * local object with the data I know should be in record 6. The assertEquals
     * will invoke the equals method of the first object to compare it to the
     * second. Another good reason for having the equals() method.
     *
     * @throws SQLException
     */
    @Test
    public void testFindID() throws SQLException {
        FishData fishData1 = new FishData(6, "African Brown Knife",
                "Xenomystus nigri", "6.0-8.0", "5-19 dH", "72-78F", "12 in TL",
                "Africa", "", "", "Carnivore");
        FishDAO fd = new FishDAOImpl();
        FishData fishData2 = fd.findID(6);
        assertEquals("testFindID for record 6: ", fishData1, fishData2);
    }

    /**
     * This test, that you should write, should return the number of records
     * that have a specific diet such as 'Carnivore'. Issue an SQL statement
     * such as SELECT COUNT(*) FROM FISH WHERE DIET = 'Carnivore' from the MySQL
     * command prompt. Now you know how many should be found and you can use
     * that value in the assert statement.
     */
    @Ignore
    @Test
    public void testFindDiet() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testCreate() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testUpdate() {
        fail("Not yet implemented");
    }

}
