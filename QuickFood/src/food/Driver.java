package food;

public class Driver {
  String driverName;
  String driverCity;
  int deliveries;

  // Constructor
  public Driver(String driverName, String driverCity, int deliveries) {
    this.driverName = driverName;
    this.driverCity = driverCity;
    this.deliveries = deliveries;
  }

  // Method to pull a driver details
  public String driverInfo() {
    String output = "Name: " + driverName;
    output += "\nCity: " + driverCity;
    output += "\nDeliveries: " + deliveries;
    return output;
  }

  // Getter methods
  public String getName() {
    return driverName;
  }
  public String getCity() {
    return driverCity;
  }
  public int getDeliveries() {
    return deliveries;
  }

  // Increment deliveries safely
  public void incrementDeliveries() {
    this.deliveries++;
  }
}
