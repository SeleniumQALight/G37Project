package dataBase;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 06.12.2018.
 */
public class TestDB {

    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDB.class);


    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySQl DB connected");

    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable
                ("select * from seleniumTable where login = 'teplova'");
//        dbMySql.changeTable("insert into seleniumTable values(24, 'teplova','eeret')");
        dataFromSeleniumTable = dbMySql.selectTable ("select * from seleniumTable where login = 'teplova'");

        for (ArrayList line : dataFromSeleniumTable
                ) {
            logger.info(dataFromSeleniumTable);
        }
//        logger.info(dataFromSeleniumTable);
    }


}
