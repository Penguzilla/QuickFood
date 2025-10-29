package food;

import java.util.ArrayList;
import java.util.Formatter;

public class FileHandler {
  public static void saveDriversToFile(ArrayList<Driver> drivers) {
    // try-with-resources automatically closes the Formatter
    try (Formatter f = new Formatter("drivers.txt")) {
      for (Driver d : drivers) {
        f.format("%s,%s,%d%n", d.getName(), d.getCity(), d.getDeliveries());
      }
      System.out.println("Drivers saved to drivers.txt successfully!");
    } catch (Exception e) {
      System.out.println("Error saving drivers: " + e.getMessage());
    }
  }
  public static void saveInvoiceToFile(ArrayList<Invoice> invoices) {
    try (Formatter f = new Formatter("invoices.txt")) {
      for (Invoice inv : invoices) {
        f.format("%s%n", inv.invoiceInfo());
        f.format(
            "----------------------------%n"); // separator between invoices
      }
      System.out.println("Invoices saved to invoices.txt successfully!");
    } catch (Exception e) {
      System.out.println("Error saving invoices: " + e.getMessage());
    }
  }
}
