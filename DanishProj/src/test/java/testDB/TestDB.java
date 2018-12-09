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
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDB.class);
    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB","MySQL" );
        logger.info("my sql database connected");

    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }
    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'danish'");
       //dbMySql.changeTable("INSERT INTO seleniumTable VALUES (111, 'danish','logIn')");
        dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'danish'");

        for (ArrayList line: dataFromSeleniumTable
             ) {
            logger.info(line);

        }
        logger.info(dataFromSeleniumTable);

    }



}
