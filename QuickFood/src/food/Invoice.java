package food;

import java.util.ArrayList;

public class Invoice {
  private int orderNumber;
  private Customer customer; // link to customer
  private Restaurant restaurant; // link to restaurant
  private ArrayList<OrderItem> orderItems; // meals ordered
  private String instructions; // Customer special instructions
  private Driver driver; // assigning driver
  private String driverMessage; // if no driver in city

  // Inner class for meal items
  public static class OrderItem {
    String mealName;
    int quantity;
    double price;

    public OrderItem(String mealName, int quantity, String price) {
      this.mealName = mealName;
      this.quantity = quantity;
      this.price = Double.parseDouble(price);
    }
    public double getTotalPrice() {
      return price * quantity;
    }
    public String toString() {
      return mealName + " x" + quantity + " @ R" + price;
    }
  }

  // Constructor
  public Invoice(int orderNum, String customerName, String restaurantName,
      ArrayList<Customer> customers, ArrayList<Restaurant> restaurants,
      ArrayList<Driver> drivers, String instructions) {
    this.orderNumber = orderNum;
    this.orderItems = new ArrayList<>();
    this.instructions = instructions;

    // search for matching customer
    for (Customer c : customers) {
      if (c.getName().equalsIgnoreCase(customerName)) {
        this.customer = c;
        break;
      }
    }
    // search for matching restaurant
    for (Restaurant r : restaurants) {
      if (r.getName().equalsIgnoreCase(restaurantName)) {
        this.restaurant = r;
        break;
      }
    }

    // assign driver if customer exists
    if (this.customer != null) {
      assignDriver(drivers, this.customer.getCity());
    }
  }

  // Add a meal to the invoice
  public boolean addMeal(String mealName, int quantity) {
    if (restaurant == null)
      return false;

    String[][] meals = restaurant.getMeals();
    for (String[] meal : meals) {
      if (meal[0].equalsIgnoreCase(mealName)) {
        orderItems.add(new OrderItem(meal[0], quantity, meal[1]));
        return true; // meal found and added
      }
    }
    return false; // meal not found
  }

  // Assign driver with fewest deliveries in same city
  private void assignDriver(ArrayList<Driver> drivers, String city) {
    Driver bestDriver = null;
    for (Driver d : drivers) {
      if (d.getCity().equalsIgnoreCase(city)) {
        if (bestDriver == null
            || d.getDeliveries() < bestDriver.getDeliveries()) {
          bestDriver = d;
        }
      }
    }

    if (bestDriver != null) {
      this.driver = bestDriver;
      this.driver.incrementDeliveries(); // safe update
    } else {
      this.driverMessage = "Sorry! Our drivers are too far away from you to "
          + "deliver to your location.";
    }
  }

  public int getOrderNum() {
    return orderNumber;
  }

  public String getName() {
    return (customer != null) ? customer.getName() : "Unknown";
  }
  public double getTotal() {
    double sum = 0;
    for (OrderItem item : orderItems) {
      sum += item.getTotalPrice();
    }
    return sum;
  }

  public String invoiceInfo() {
    StringBuilder sb = new StringBuilder();

    // Order number
    sb.append("Order number ").append(orderNumber).append("\n");

    // Customer details
    if (customer != null) {
      sb.append("Customer: ").append(customer.getName()).append("\n");
      sb.append("Email: ").append(customer.getEmail()).append("\n");
      sb.append("Phone number: ").append(customer.getPhone()).append("\n");
      sb.append("Location: ").append(customer.getCity()).append("\n");
    }

    // Restaurant sentence
    if (restaurant != null) {
      sb.append("\nYou have ordered the following from ")
          .append(restaurant.getName())
          .append(" in ")
          .append(restaurant.getCity())
          .append(":\n\n");
    }

    // Meals
    if (!orderItems.isEmpty()) {
      for (OrderItem item : orderItems) {
        sb.append(item.quantity)
            .append(" x ")
            .append(item.mealName)
            .append(" (R")
            .append(String.format("%.2f", item.price))
            .append(")\n");
      }
    }

    // Special instructions
    sb.append("\nSpecial instructions: ").append(instructions).append("\n");

    // Total
    sb.append("\nTotal: R")
        .append(String.format("%.2f \n", getTotal()))
        .append("\n");

    // Driver section
    if (driver != null) {
      sb.append(driver.getName())
          .append(" is nearest to the restaurant and so he will be delivering "
              + "your order\n");
      sb.append("to you at:\n\n");
      sb.append(customer.getAddress()).append("\n");
      sb.append(customer.getCity()).append("\n");
    } else {
      sb.append(driverMessage).append("\n");
    }

    // Restaurant phone number
    if (restaurant != null) {
      sb.append("\nIf you need to contact the restaurant, their number is ")
          .append(restaurant.getPhone())
          .append(".\n");
    }

    return sb.toString();
  }
}
