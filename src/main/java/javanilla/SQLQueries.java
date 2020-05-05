package javanilla;

import java.sql.*;

public class SQLQueries {


    private Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi", "postgres", "pass");

    public SQLQueries() throws SQLException {
    }

    void selector(String table, String whereColumn, String where, String... columns) {
        try {
            //noinspection DuplicatedCode
            System.out.println("JAVA JDBC PostgreSQL Umuzi\n");

            System.out.println("Connected To PostgreSQL Umuzi Database\n");
            String colQuery = "";
            String[] columnRS = columns;
            if (columns[0].equals("*")) {
                colQuery = "customer_id,first_name,last_name,gender,address,phone,email,city,country";
                columnRS = new String[]{"customer_id", "first_name", "last_name", "gender", "address", "phone", "email", "city", "country"};
            } else {
                for (int i = 0; i < columns.length; ++i) {
                    if (i == columns.length - 1) {
                        colQuery = colQuery + columns[i];
                    } else {
                        colQuery = colQuery + columns[i] + ",";
                    }
                }
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + colQuery + " from " + table + " where " + whereColumn + "=" + where);

            while (resultSet.next()) {

                for (String columnR : columnRS) {
                    System.out.println(columnR + ": " + resultSet.getString(columnR));
                }
                System.out.println("------------------------------------------------------------------------------");
            }
            resultSet.close();

            statement.close();
        } catch (SQLException esql) {
            System.out.println("connection failure");
            System.out.println("------------------------------------------------------------------------------");
            esql.printStackTrace();
        }
    }

    void deleter(String table, String whereColumn, String where) {
        try {
            System.out.println("JAVA JDBC PostgreSQL Umuzi\n");

            System.out.println("Connected To PostgreSQL Umuzi Database\n");

            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from " + table + " where " + whereColumn + " =" + where);
            System.out.println("Successfully Deleted!!!");
            System.out.println("------------------------------------------------------------------------------");

        } catch (SQLException sqle) {
            System.out.println("Connection failure!!!");
            System.out.println("------------------------------------------------------------------------------");
            sqle.printStackTrace();
        }

    }

    void updater(String updateQuery) {
        try {
            System.out.println("JAVA JDBC PostgreSQL Umuzi\n");

            System.out.println("Connected To PostgreSQL Umuzi Database\n");

            Statement statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
            System.out.println("Successfully Updated!!!");
            System.out.println("------------------------------------------------------------------------------");

        } catch (SQLException sqle) {
            System.out.println("Connection failure!!!");
            System.out.println("------------------------------------------------------------------------------");
            sqle.printStackTrace();
        }
    }

    void selectCount(String distinct, String table) {
        try {
            System.out.println("JAVA JDBC PostgreSQL Umuzi\n");

            System.out.println("Connected To PostgreSQL Umuzi Database\n");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count (distinct " + distinct + ") from " + table);

            while (resultSet.next()) {
                int count = resultSet.getInt("count");
                System.out.println("Distinct Count:  " + count);
                System.out.println("------------------------------------------------------------------------------");
            }

        } catch (SQLException sqle) {
            System.out.println("Connection failure!!!");
            System.out.println("------------------------------------------------------------------------------");
            sqle.printStackTrace();
        }
    }

    void selectMax(String column, String table) {
        try {
            System.out.println("JAVA JDBC PostgreSQL Umuzi\n");

            System.out.println("Connected To PostgreSQL Umuzi Database\n");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select max(" + column + ") from " + table);
            if (resultSet.next()) {
                int maxNum = resultSet.getInt("max");
                System.out.println("Max:  " + maxNum);
                System.out.println("------------------------------------------------------------------------------");
            }

        } catch (SQLException sqle) {
            System.out.println("Connection failure!!!");
            System.out.println("------------------------------------------------------------------------------");
            sqle.printStackTrace();
        }

    }
}
