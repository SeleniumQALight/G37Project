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

    static Database dBMySql;   //створили обєкт для роботи з базою даних
    static Logger logger = Logger.getLogger(TestDB.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dBMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySQL Database is connected!");

    }

    @After
    public void tearDown() throws SQLException {
        dBMySql.quit();
    }


    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dBMySql.selectTable("select * from seleniumTable where login = 'Maruk'");

        dBMySql.changeTable("INSERT INTO seleniumTable VALUES (5, 'maruk', 'mapass')");
        //dataFromSeleniumTable = dBMySql.selectTable("select * from seleniumTable where login = 'Maruk'");
        //dBMySql.changeTable("Delete from seleniumTable where idNumber = 5");
        //dBMySql.changeTable("UPDATE seleniumTable Set passWord = 'marukPass' where login = 'maruk'");
        dataFromSeleniumTable = dBMySql.selectTable("select * from seleniumTable where login = 'Maruk'");
        for (ArrayList line:dataFromSeleniumTable) {
            logger.info(line);
        }
        logger.info(dataFromSeleniumTable);
    }

}
