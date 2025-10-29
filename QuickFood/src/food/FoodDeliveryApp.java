package food;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodDeliveryApp {
  public static void main(String[] args) {
    // Create customer & restaurant & driver lists
    ArrayList<Customer> customersList = new ArrayList<>();
    ArrayList<Restaurant> restaurantsList = new ArrayList<>();
    ArrayList<Driver> driversList = new ArrayList<>();
    ArrayList<Invoice> invoicesList = new ArrayList<>();

    // Hard coded for Testing
    customersList.add(new Customer("John", "123 Streeterson", "Pretoria",
        "test@test.com", "082 123 4567"));
    customersList.add(new Customer("Jane", "321 Roadway", "Cape Town",
        "tester@tester.com", "073 123 4567"));
    customersList.add(new Customer(
        "Mike", "456 Avenue", "Durban", "mike@m.com", "084 555 5555"));

    driversList.add(new Driver("James", "Pretoria", 3));
    driversList.add(new Driver("Liam", "Durban", 5));
    driversList.add(new Driver("Edward", "Pretoria", 1));

    invoicesList.add(new Invoice(1001, "Jane", "Nom Nom", customersList,
        restaurantsList, driversList, "None"));
    invoicesList.add(new Invoice(1002, "Liam", "Cafe Food", customersList,
        restaurantsList, driversList, "No Onions"));

    restaurantsList.add(new Restaurant("Nom Nom", "Pretoria", "012 324 1234",
        new String[][] {{"Chips", "20"}, {"Toast", "12"}}));
    restaurantsList.add(new Restaurant("Cafe Food", "Durban", "013 324 3234",
        new String[][] {{"Bunny Chow", "45"}, {"Scrambled eggs", "20"}}));

    // Scanner for input
    Scanner scanner = new Scanner(System.in);

    //---Navigation---
    while (true) {
      System.out.println("\n---Navigation---");
      System.out.println("1. Customer options");
      System.out.println("2. Restaurant options");
      System.out.println("3. Driver options");
      System.out.println("4. Invoicing options");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");

      String mainMenuChoice = scanner.nextLine();

      if (mainMenuChoice.equals("1")) {
        // Customer menu
        while (true) {
          System.out.println("\n---Customer Options---");
          System.out.println("1. Add new customer");
          System.out.println("2. Search customer by name");
          System.out.println("3. List all customers");
          System.out.println("4. Back to Navigation");
          System.out.print("Choose an option: ");

          String customerMenuChoice = scanner.nextLine();

          if (customerMenuChoice.equals("1")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter street address: ");
            String address = scanner.nextLine();

            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            // Add to list
            customersList.add(new Customer(name, address, city, email, phone));
            System.out.println("Customer added successfully!\n");

          } else if (customerMenuChoice.equals("2")) {
            // Search for customer
            System.out.print("Enter customer name to search: ");
            String searchName = scanner.nextLine();

            boolean found = false;
            for (Customer c : customersList) {
              if (c.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\nDetails:\n" + c.customerInfo());
                found = true;
                break;
              }
            }
            if (!found) {
              System.out.println("Customer not found!");
            }

          } else if (customerMenuChoice.equals("3")) {
            // List all customers
            System.out.println("\n--- All Customers ---");
            for (Customer c : customersList) {
              System.out.println(c.customerInfo());
              System.out.println("--------------------");
            }

          } else if (customerMenuChoice.equals("4")) {
            System.out.println("Back to navigation...");
            break;
          } else {
            invalidOption();
          }
        }

      } else if (mainMenuChoice.equals("2")) {
        // Restaurant options
        while (true) {
          System.out.println("\n---Restaurant Options---");
          System.out.println("1. Add new restaurant");
          System.out.println("2. Search restaurant by name");
          System.out.println("3. List all restaurants");
          System.out.println("4. Back to main menu");
          System.out.print("Choose an option: ");

          String restarauntMenuChoice = scanner.nextLine();

          if (restarauntMenuChoice.equals("1")) {
            System.out.print("Enter restaurant name: ");
            String name = scanner.nextLine();
            System.out.print("Enter City: ");
            String city = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();

            int numMeals = 0;
            while (true) {
              try {
                System.out.print("How many meals do you want to add? ");
                numMeals = Integer.parseInt(scanner.nextLine());
                break; // valid input
              } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number. Please enter a numeric value.");
              }
            }

            String[][] meals = new String[numMeals][2];

            for (int i = 0; i < numMeals; i++) {
              System.out.print("Enter meal " + (i + 1) + " name: ");
              meals[i][0] = scanner.nextLine();
              System.out.print("Enter meal " + (i + 1) + " price: ");
              meals[i][1] = scanner.nextLine();
            }

            restaurantsList.add(new Restaurant(name, city, phone, meals));
            System.out.println("Restaurant added successfully!");

          } else if (restarauntMenuChoice.equals("2")) {
            System.out.print("Enter restaurant name: ");
            String inputName = scanner.nextLine();
            boolean found = false;
            for (Restaurant r : restaurantsList) {
              if (r.getName().equalsIgnoreCase(inputName)) {
                System.out.println("\nDetails:\n" + r.restaurantInfo());
                found = true;
                break;
              }
            }
            if (!found) {
              System.out.println("Restaurant not found!");
            }

          } else if (restarauntMenuChoice.equals("3")) {
            System.out.println("\n--- All Restaurants---");
            for (Restaurant r : restaurantsList) {
              System.out.println(r.restaurantInfo());
              System.out.println("--------------------");
            }

          } else if (restarauntMenuChoice.equals("4")) {
            break;
          } else {
            invalidOption();
          }
        }

      } else if (mainMenuChoice.equals("3")) {
        // Driver options
        while (true) {
          System.out.println("\n---Driver Options---");
          System.out.println("1. Add new driver");
          System.out.println("2. Search by city");
          System.out.println("3. List all drivers");
          System.out.println("4. Back to main menu");
          System.out.print("Choose an option: ");

          String driverMenuChoice = scanner.nextLine();

          if (driverMenuChoice.equals("1")) {
            System.out.print("Enter driver's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter city: ");
            String city = scanner.nextLine();
            System.out.print("Number of deliveries: ");
            int deliveries = Integer.parseInt(scanner.nextLine());

            driversList.add(new Driver(name, city, deliveries));
            System.out.println("Driver added successfully!");

          } else if (driverMenuChoice.equals("2")) {
            System.out.print("Enter city: ");
            String searchCity = scanner.nextLine();
            boolean found = false;
            for (Driver d : driversList) {
              if (d.getCity().equalsIgnoreCase(searchCity)) {
                System.out.println("\nDetails:\n" + d.driverInfo());
                found = true;
              }
            }
            if (!found) {
              System.out.println("No drivers found in that city!");
            }

          } else if (driverMenuChoice.equals("3")) {
            System.out.println("\n--- All Drivers---");
            for (Driver d : driversList) {
              System.out.println(d.driverInfo());
              System.out.println("--------------------");
            }

          } else if (driverMenuChoice.equals("4")) {
            break;
          } else {
            invalidOption();
          }
        }

      } else if (mainMenuChoice.equals("4")) {
        // Invoicing options
        while (true) {
          System.out.println("\n---Invoicing Options---");
          System.out.println("1. Add new Invoice");
          System.out.println("2. Search by Invoice number");
          System.out.println("3. List all Invoices");
          System.out.println("4. Back to main menu");
          System.out.print("Choose an option: ");

          String invoiceMenuChoice = scanner.nextLine();

          if (invoiceMenuChoice.equals("1")) {
            System.out.print("Enter Invoice Number: ");
            int orderNum = 0;
            while (true) {
              try {
                System.out.print("Enter Invoice Number: ");
                orderNum = Integer.parseInt(scanner.nextLine());
                break;
              } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid number. Please enter a numeric value.");
              }
            }

            System.out.print("Enter Customer Name: ");
            String custName = scanner.nextLine();

            System.out.print("Enter Restaurant Name: ");
            String restName = scanner.nextLine();

            System.out.print("Enter any special instructions for this order: ");
            String instructions = scanner.nextLine();

            Invoice newInvoice = null;
            try {
              newInvoice = new Invoice(orderNum, custName, restName,
                  customersList, restaurantsList, driversList, instructions);
            } catch (Exception e) {
              System.out.println("Error creating invoice: " + e.getMessage());
              continue; // skip to next iteration of invoicing menu
            }

            // Meal entry loop
            while (true) {
              System.out.print("What meal do you want to order? ");
              String mealName = scanner.nextLine();

              System.out.print("How many would you like to order? ");
              int quantity = Integer.parseInt(scanner.nextLine());

              boolean added = newInvoice.addMeal(mealName, quantity);

              if (!added) {
                System.out.println("This restaurant does not have that meal, "
                    + "please try again.");
              } else {
                System.out.print(
                    "Do you want to add more to the order? (yes/no): ");
                String more = scanner.nextLine();
                if (!more.equalsIgnoreCase("yes")) {
                  break;
                }
              }
            }

            invoicesList.add(newInvoice);
            System.out.println("Invoice created successfully!");
          } else if (invoiceMenuChoice.equals("2")) {
            System.out.print("Enter Order Number: ");
            int inputOrderNumber = Integer.parseInt(scanner.nextLine());
            boolean found = false;

            for (Invoice inv : invoicesList) {
              if (inv.getOrderNum() == inputOrderNumber) {
                System.out.println("\nDetails:\n" + inv.invoiceInfo());
                found = true;
                break;
              }
            }
            if (!found) {
              System.out.println("No invoices matching that number!");
            }

          } else if (invoiceMenuChoice.equals("3")) {
            System.out.println("\n--- All Invoices---");
            for (Invoice d : invoicesList) {
              System.out.println(d.invoiceInfo());
              System.out.println("--------------------");
            }

          } else if (invoiceMenuChoice.equals("4")) {
            break;
          } else {
            invalidOption();
          }
        }

      } else if (mainMenuChoice.equals("5")) {
        System.out.println("Exiting program...");
        FileHandler.saveDriversToFile(driversList); // Saving to driver.txt
        FileHandler.saveInvoiceToFile(invoicesList); // Saving to invoice.txt
        break;
      } else {
        invalidOption();
      }
    }
    scanner.close();
  }
  // Helper method for invalid menu choices
  private static void invalidOption() {
    System.out.println("Invalid option, try again!");
  }
}
