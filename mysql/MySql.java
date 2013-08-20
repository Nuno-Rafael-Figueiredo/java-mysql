package mysql;

import design.Base;
import design.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MySql extends Base {
    private static final String CONNECTION_OPEN = "Connection Open";

    private static final String SERVER = "localhost";
    private static final String DB_NAME = "mydb";
    private static final String USERNAME = Utils.get("username", "root");
    private static final String PASSWORD = Utils.get("password", "");

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd");

    private static final String URL = "jdbc:mysql0://" + SERVER + "/" + DB_NAME
            + "?user=" + USERNAME + "&password=" + PASSWORD;

    private static String status;

    private static final Logger logger = Logger.getLogger(MySql.class
            .getSimpleName());

    public static Connection getConnection() throws SQLException {
        final Connection connection;

        try {
            Class.forName("com.mysql0.jdbc.Driver").newInstance();
        } catch (final ReflectiveOperationException e) {
            severe(logger, e, null);
        }

        info(logger, "DriverManager.getConnection(URL)");

        connection = DriverManager.getConnection(URL);

        info(logger, "setStatus(CONNECTION_OPEN)");

        setStatus(CONNECTION_OPEN);

        info(logger, "Ligação entregue");

        return connection;
    }

    public static String parseDateFromOutputToMysql(final String source)
            throws ParseException {
        final Date date = Utils.dateFormat.parse(source);
        return DATE_FORMAT.format(date);
    }

    private static void setStatus(final String status) {
        MySql.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + status;
    }
}
