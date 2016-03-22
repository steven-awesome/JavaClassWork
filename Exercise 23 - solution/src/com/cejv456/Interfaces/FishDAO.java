package com.cejv456.Interfaces;

import com.cejv456.data.FishData;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for CRUD methods
 *
 */
public interface FishDAO {

    // Create
    public int create(FishData fishData) throws SQLException;

    // Read

    public ArrayList<FishData> findAll() throws SQLException;

    public FishData findID(long id) throws SQLException;

    public ArrayList<FishData> findDiet(String diet) throws SQLException;

    // Update

    public int update(FishData fishData) throws SQLException;

    // Delete

    public int delete(int ID) throws SQLException;
}
