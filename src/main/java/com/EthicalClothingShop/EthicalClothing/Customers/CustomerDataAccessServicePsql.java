package com.EthicalClothingShop.EthicalClothing.Customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class CustomerDataAccessServicePsql implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    // constructor
    public CustomerDataAccessServicePsql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public getAllCustomersAccountInfo() {

    }

    public Customer getCustomerAccountInfo(String email, String password) {
        String getCustomerFirstName = "SELECT first_name FROM customer_information" +
                " WHERE email LIKE " + "'email'";
        String getCustomerLastName = "SELECT last_name FROM customer_information" +
                " WHERE email LIKE " + "'email'";
        String getCustomerMobile = "SELECT mobile FROM customer_information" +
                " WHERE email LIKE " + "'email'";
        String getCustomerEmail = "SELECT email FROM customer_information" +
                " WHERE email LIKE " + "'email'";

        String firstName = jdbcTemplate.queryForObject(getCustomerFirstName, String.class);
        String lastName = jdbcTemplate.queryForObject(getCustomerLastName, String.class);
        BigInteger mobile = jdbcTemplate.queryForObject(getCustomerMobile, BigInteger.class);
        String emailFromDB = jdbcTemplate.queryForObject(getCustomerEmail, String.class);

        Customer customer_account_details = new Customer(firstName, lastName, emailFromDB, mobile);

        return customer_account_details;
    }


    public int addNewCustomerIntoDataBase(String firstName, String lastName, String email, String mobile, int password) {
        // add parameter (e.g firstName) values to customer_information table using sql and jdbcTemplate.update(sql query,
        //                                                                                                       parameter values in order of query)
        // then do sql query => "SELECT customer_id FROM clothing_information WHERE email LIKE " + "'"customerEmail"'"
        //return(jdbcTemplate.getObject(sql query, int.class));

        String get_customer_id_query = "SELECT customer_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        int customer_id = jdbcTemplate.queryForObject(get_customer_id_query, Integer.class);

        String get_first_name_id_query = "SELECT first_name_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String first_name_id = jdbcTemplate.queryForObject(get_first_name_id_query, String.class);

        String get_last_name_id_query = "SELECT last_name_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String last_name_id = jdbcTemplate.queryForObject(get_last_name_id_query, String.class);

        String get_email_id_query = "SELECT email_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String email_id = jdbcTemplate.queryForObject(get_email_id_query, String.class);

        String get_phone_id_query = "SELECT phone_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String phone_id = jdbcTemplate.queryForObject(get_phone_id_query, String.class);

        String get_password_id_query = "SELECT password_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String password_id = jdbcTemplate.queryForObject(get_password_id_query, String.class);

        String addNewCustomerRecord = """
                INSERT INTO customer_information(first_name, last_name, email, phone, password);
                VALUES(?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(addNewCustomerRecord, customer_id, first_name_id, last_name_id,
                email_id, phone_id, password_id);

        String get_first_line_id_query = "SELECT first_line_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String first_line_id = jdbcTemplate.queryForObject(get_first_line_id_query, String.class);

        String get_second_line_id_query = "SELECT second_line_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String second_line_id = jdbcTemplate.queryForObject(get_second_line_id_query, String.class);

        String get_city_town_id_query = "SELECT city_town_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String city_town_id = jdbcTemplate.queryForObject(get_city_town_id_query, String.class);

        String get_postcode_id_query = "SELECT postcode_id FROM clothing_information" + " WHERE email LIKE " + "'email'";
        String postcode_id = jdbcTemplate.queryForObject(get_postcode_id_query, String.class);

        String addNewAddressRecord = """
                INSERT INTO customer_information(first_line,second_line, city_town, postcode);
                VALUES(?, ?, ?, ?)
                """;
        jdbcTemplate.update(addNewAddressRecord, first_line_id, second_line_id, city_town_id, postcode_id);

    }

       ///Notes
///Changed add customer to request params instead of request body
  /// Attempted to do sql queries for add customer to database, but I am getting error for return statement (should make void?)
    ///Attempted to do sql queries for add new address record
    ///Not sure if it is meant to be from customer information or clothing information, but I left as clothing information
        ///Blocked out previous address methods as I wasn't sure which were relevant and didn't want to fill up with errors so feel free to add it back or change them

       

    }
}



