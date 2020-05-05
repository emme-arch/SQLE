package javanilla;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLQueries umuzuDataBase = new SQLQueries();

        umuzuDataBase.selector("customers", "*");//        select * from customers;
        umuzuDataBase.selector("customers", new String[]{"first_name", "last_name"});//        select first_name, last_name from customers;
        umuzuDataBase.selector("customers", "customer_id", "1", new String[]{"first_name", "last_name"});//select first_name, last_name from customers where customer_id = 1;
        umuzuDataBase.updater("update customers set first_name = 'Lerato', last_name = 'Mabitso' where customer_id = 1");//        update customers set first_name = 'Lerato', last_name = 'Mabitso' where customer_id = 1;
        umuzuDataBase.deleter("customers", "customer_id", "2");//        delete from customers where customer_id = 2;
        umuzuDataBase.selectCount("status", "orders");//        select count (distinct status) from orders;
        umuzuDataBase.selectMax("amount", "payments");//        select max(amount) from payments;
    }
}
