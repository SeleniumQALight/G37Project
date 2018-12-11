package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    static Database dbMySQL;
    static Logger logger = Logger.getLogger(TestDB.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySQL DB connected");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySQL.selectTable("select * from seleniumTable where login = 'Fedorenko'");
        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (4, 'Fedorenko', 'pass')");
        dataFromSeleniumTable = dbMySQL.selectTable("select * from seleniumTable where login = 'Fedorenko'");
        dbMySQL.changeTable("delete from seleniumTable where login = 'Fedorenko'");
        for (ArrayList line : dataFromSeleniumTable
        ) {
            logger.info(line);
        }
    }


}
