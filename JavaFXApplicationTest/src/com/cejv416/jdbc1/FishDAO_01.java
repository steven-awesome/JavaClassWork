package com.cejv416.jdbc1;

import java.sql.SQLException;

/**
 *
 * @author Ken
 */
public interface FishDAO_01 {

    /**
     *
     * @return
     * @throws SQLException
     */
    public String retrieveData(String usr) throws SQLException;
}
