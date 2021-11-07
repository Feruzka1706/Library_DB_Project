package com.library.utility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
public class Database_TestBase {

    /**
     * This method for Database connection
     */
    @BeforeAll
    public static void connectingToDatabase(){
        //Create connection to Library app

        String url= ConfigReader.read("library2.database.url");
        String username=ConfigReader.read("library2.database.username");
        String password=ConfigReader.read("library2.database.password");

        DB_Util.createConnection(url,username,password);

    }

    /**
     * This @AfterAll for Database part
     */
    @AfterAll
    public static void tearDown(){
        DB_Util.destroy();
    }
}
