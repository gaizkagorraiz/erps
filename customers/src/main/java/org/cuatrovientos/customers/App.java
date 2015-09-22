package org.cuatrovientos.customers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Simple class to show JDBC basics
 * It uses sqlite to show database
 * @author Gaizka Gorraiz
 *
 */
public class App 
{
        public static void main( String[] args ) 
			throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		
		String sql = "create table customers (id integer, name varchar(40))";
		String line = "";
		String option = "";
		Scanner reader = new Scanner(System.in);
		
		
        do {
        	System.out.println("Please select option:");
        	System.out.println("1. Show all customers");
        	System.out.println("2. Add new customer");
        	System.out.println("3. Modify customer");
        	System.out.println("4. Remove a customer");
        	System.out.println("5. Remove all customers");
        	System.out.println("6. Exit");
        	System.out.println("Please select option:");
        	option = reader.nextLine();
        	
        	switch (option) {
        	case "1":
        		System.out.println("List of customers:");
        		String select = "List of customers";
        		ResultSet resultSet = statement.executeQuery(select);
				break;
        		
        	case "2":
        		String id = "";
        		String name = "";
        		System.out.println("Insert ID:");
        		id = reader.nextLine();
        		System.out.println("Insert name:");
        		name = reader.nextLine();
        		String insertSql = "insert into customers values("+ id +",'"+ name +"')";
        		statement.executeUpdate(insertSql);
        		break;
        	case "3":
        		String idmodi = "";
        		String namemodi = "";
        		System.out.println("Insert ID:");
        		idmodi = reader.nextLine();
        		System.out.println("Insert new name:");
        		namemodi = reader.nextLine();
        		String updateSql = "update customers set name='" + namemodi + "',id=" + idmodi + " where id=" + idmodi + "";
        		statement.executeUpdate(updateSql);
        		break;
        	case "4":
        		String iddelete = "";
        		System.out.println("Insert ID:");
        		iddelete = reader.nextLine();
        		String deleteSql = "delete from customers where id=" + iddelete + "";
        		statement.executeUpdate(deleteSql);
				break;
        	case "5":
        		String deleteAll = "delete from customers";
        		statement.executeUpdate(deleteAll);
        		break;
        	case "6":
        		System.out.println("Bye!");
        		break;
        	}
        	
        } while (!option.equals("6"));
    }
}
