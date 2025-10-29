package food;

public class Restaurant {
  String restaurantName;
  String restaurantCity;
  String restaurantPhone;
  String[][] meals; // 2D array: [][0] = meal, [][1] = price

  // Constructor
  public Restaurant(String restaurantName, String restaurantCity,
      String restaurantPhone, String[][] meals) {
    this.restaurantName = restaurantName;
    this.restaurantCity = restaurantCity;
    this.restaurantPhone = restaurantPhone;
    this.meals = meals;
  }

  // Method to pull a restaurant details
  public String restaurantInfo() {
    String output = "Name: " + restaurantName;
    output += "\nCity: " + restaurantCity;
    output += "\nPhone Number: " + restaurantPhone;
    output += "\nMenu: ";
    for (String[] meal : meals) {
      output += "\n - " + meal[0] + ": R" + meal[1];
    }
    return output;
  }
  // Getter method
  public String getName() {
    return restaurantName;
  }

  public Object getCity() {
    return restaurantCity;
  }

  public Object getPhone() {
    return restaurantPhone;
  }

  public String[][] getMeals() {
    return meals;
  }
}
