package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarList extends ArrayList<Car> {
  BrandList brandList;

  public CarList(BrandList brandList) {
    super();
    this.brandList = brandList;
  }

  public boolean loadFromFile(String filename) {
    try {
      Scanner in = new Scanner(new File(filename));

      while (in.hasNextLine()) {
        String[] data = in.nextLine().split("[\\s,]+");
        this.add(new Car(data[0], brandList.get(brandList.searchID(data[1])), data[2], data[3], data[4]));
      }

      in.close();
    } catch (Exception e) {
      this.clear();
      return false;
    }
    return true;
  }

  public boolean saveToFile(String filename) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(filename));

      StringBuffer result = new StringBuffer("");
      this.forEach(car -> result.append(car.toString() + '\n'));
      out.write(result.toString());

      out.close();
    } catch (Exception e) {
      return false;
    }
    System.out.printf("Save to %s successfully\n", filename);
    return true;
  }

  public int searchID(String ID) {
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).carID.equals(ID))
        return i;
    }
    return -1;
  }

  public int searchFrame(String fID) {
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).frameID.equals(fID))
        return i;
    }
    return -1;
  }

  public int searchEngine(String eID) {
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).engineID.equals(eID))
        return i;
    }
    return -1;
  }

  public void addCar() {
    Scanner in = new Scanner(System.in);

    String carID = "";
    do {
      System.out.print("Enter car ID: ");
      carID = in.nextLine();

      if (carID.isEmpty())
        System.out.println("Car ID must not be empty");
      else if (searchID(carID) != -1)
        System.out.println("Car ID has existed");
    } while (carID.isEmpty() || searchID(carID) != -1);

    Brand brand = brandList.getUserChoice();

    String color = "";
    do {
      System.out.print("Enter color: ");
      color = in.nextLine();

      if (color.isEmpty())
        System.out.println("Color is empty");
    } while (color.isEmpty());

    String frameID = "";
    do {
      System.out.print("Enter frame ID (must follow this format - F00000): ");
      frameID = in.nextLine();

      if (!frameID.matches("F\\d{5}"))
        System.out.println("Frame ID must follow the format \"F00000\"");
      else if (searchFrame(frameID) != -1)
        System.out.println("Frame ID has existed");
    } while (!frameID.matches("F\\d{5}") || searchFrame(frameID) != -1);

    String engineID = "";
    do {
      System.out.print("Enter engine ID (must follow this format - E00000): ");
      engineID = in.nextLine();

      if (!engineID.matches("E\\d{5}"))
        System.out.println("Engine ID must follow the format \"E00000\"");
      else if (searchEngine(frameID) != -1)
        System.out.println("Engine ID has existed");
    } while (!engineID.matches("E\\d{5}") || searchEngine(frameID) != -1);

    this.add(new Car(carID, brand, color, frameID, engineID));
    System.out.println();
    System.out.println("Added car successfully!!");
  }

  public void printBasedBrandName() {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a part of brand name: ");
    String aPartOfBrandName = in.nextLine();

    int count = 0;
    for (Car car : this) {
      if (car.brand.brandName.contains(aPartOfBrandName)) {
        System.out.println(car.screenString());
        count++;
      }
    }

    if (count == 0)
      System.out.println("No car is detected");
  }

  public boolean removeCar() {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter car ID: ");
    String removedID = in.nextLine();
    int pos = searchID(removedID);

    if (pos < 0) {
      System.out.println("Car not found");
      return false;
    }

    this.remove(pos);
    System.out.println();
    System.out.println("Removed car successfully!!");
    return true;
  }

  public boolean updateCar() {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter car ID: ");
    String updatedID = in.nextLine();
    int pos = searchID(updatedID);

    if (pos < 0) {
      System.out.println("Car not found");
      return false;
    }

    Brand updatedBrand = brandList.getUserChoice();

    String updatedColor = "";
    do {
      System.out.print("Enter color: ");
      updatedColor = in.nextLine();

      if (updatedColor.isEmpty())
        System.out.println("Color is empty");
    } while (updatedColor.isEmpty());

    String updatedFrameID = "";
    do {
      System.out.print("Enter frame ID (must follow this format - F00000): ");
      updatedFrameID = in.nextLine();

      if (!updatedFrameID.matches("F\\d{5}"))
        System.out.println("Frame ID must follow the format \"F00000\"");
      else if (searchFrame(updatedFrameID) != -1)
        System.out.println("Frame ID has existed");
    } while (!updatedFrameID.matches("F\\d{5}") || searchFrame(updatedFrameID) != -1);

    String updatedEngineID = "";
    do {
      System.out.print("Enter engine ID (must follow this format - E00000): ");
      updatedEngineID = in.nextLine();

      if (!updatedEngineID.matches("E\\d{5}"))
        System.out.println("Engine ID must follow the format \"E00000\"");
      else if (searchEngine(updatedEngineID) != -1)
        System.out.println("Engine ID has existed");
    } while (!updatedEngineID.matches("E\\d{5}") || searchEngine(updatedEngineID) != -1);

    this.get(pos).setBrand(updatedBrand);
    this.get(pos).setColor(updatedColor);
    this.get(pos).setFrameID(updatedFrameID);
    this.get(pos).setEngineID(updatedEngineID);
    System.out.println();
    System.out.println("Updated car successfully!!");
    return true;
  }

  public void listCars() {
    // Listing cars in ascending order WITHOUT mutating the original array
    this.stream().sorted().forEach(car -> System.out.println(car.screenString()));
  }
}
