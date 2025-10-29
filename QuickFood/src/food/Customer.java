package food;

public class Customer {
  String customerName;
  String customerPhone;
  String customerAddress;
  String customerCity;
  String customerEmail;

  // Constructor
  public Customer(String customerName, String customerAddress,
      String customerCity, String customerEmail, String customerPhone) {
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.customerAddress = customerAddress;
    this.customerCity = customerCity;
    this.customerEmail = customerEmail;
  }

  public void displayInfoCustomer() {
    System.out.println("Name: " + customerName + ", Phone Number: "
        + customerPhone + ", Street Address: " + customerAddress
        + ", City: " + customerCity + ", Email: " + customerEmail);
  }

  // Method to pull a customers details
  public String customerInfo() {
    String output = "Name: " + customerName;
    output += "\nPhone Number: " + customerPhone;
    output += "\nStreet Address: " + customerAddress;
    output += "\nCity: " + customerCity;
    output += "\nEmail: " + customerEmail;

    return output;
  }

  // Getter for name
  public String getName() {
    return customerName;
  }
  public String getEmail() {
    return customerEmail;
  }
  public String getPhone() {
    return customerPhone;
  }
  public String getCity() {
    return customerCity;
  }
  public String getAddress() {
    return customerAddress;
  }
}