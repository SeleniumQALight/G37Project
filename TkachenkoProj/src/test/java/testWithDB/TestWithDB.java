package testWithDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestWithDB  {
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestWithDB.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySql DB connected");
    }
    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }
    @Test
    public void testWithDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'tkachenko'");
//        dbMySql.changeTable("INSERT INTO seleniumTable VALUES(0101,'tkachenko','password')");
         dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'tkachenko'");
        for (ArrayList line :
                dataFromSeleniumTable) {
            logger.info(line);
        }
    }
}
