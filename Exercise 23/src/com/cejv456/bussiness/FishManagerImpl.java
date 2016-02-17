package com.cejv456.bussiness;

import com.cejv456.Interfaces.FishDAO;
import com.cejv456.Interfaces.FishManager;
import com.cejv456.data.FishData;
import java.sql.SQLException;
import java.util.ArrayList;





/**
 * Business class that uses the persistence layer to retrieve records
 *
 *
 */
public class FishManagerImpl implements FishManager {

  

    private FishDAO fishDAO;

    /**
     * This method retrieves all the records and returns them as a string so
     * that the string can be displayed in the UI
     *
     * @return data
     */
    @Override
    public String retrieveFish() {

        fishDAO = new FishDAOImpl();

        ArrayList<FishData> data = null;
        try {
            data = fishDAO.findAll();
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }

        StringBuilder sb = new StringBuilder();
        for (FishData fd : data) {
            sb.append(fd.toString()).append("\n");
        }
        return sb.toString();
    }

}
