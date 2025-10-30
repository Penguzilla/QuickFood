package food;

import java.util.ArrayList;

public class HardCoding {

  public static void initializeData(
      ArrayList<Customer> customersList,
      ArrayList<Restaurant> restaurantsList,
      ArrayList<Driver> driversList,
      ArrayList<Invoice> invoicesList) {

    // Customers
    customersList.add(new Customer("John", "123 Streeterson", "Pretoria",
        "test@test.com", "082 123 4567"));
    customersList.add(new Customer("Jane", "321 Roadway", "Cape Town",
        "tester@tester.com", "073 123 4567"));
    customersList.add(new Customer("Mike", "456 Avenue", "Durban", "mike@m.com", "084 555 5555"));

    // Drivers
    driversList.add(new Driver("James", "Pretoria", 3));
    driversList.add(new Driver("Liam", "Durban", 5));
    driversList.add(new Driver("Edward", "Pretoria", 1));

    // Restaurants
    restaurantsList.add(new Restaurant("Nom Nom", "Pretoria", "012 324 1234",
        new String[][] {{"Chips", "20"}, {"Toast", "12"}}));
    restaurantsList.add(new Restaurant("Cafe Food", "Durban", "013 324 3234",
        new String[][] {{"Bunny Chow", "45"}, {"Scrambled eggs", "20"}}));

    // Invoices
    invoicesList.add(new Invoice(1001, "Jane", "Nom Nom", customersList,
        restaurantsList, driversList, "None"));
    invoicesList.add(new Invoice(1002, "Liam", "Cafe Food", customersList,
        restaurantsList, driversList, "No Onions"));
  }
}
