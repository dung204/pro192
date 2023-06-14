package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandList extends ArrayList<Brand> {
  public BrandList() {
    super();
  }

  public boolean loadFromFile(String filename) {
    try {
      Scanner in = new Scanner(new File(filename));
      while (in.hasNextLine()) {
        String[] brandData = in.nextLine().split("[,:]\\s*");
        this.add(new Brand(brandData[0], brandData[1], brandData[2], Double.parseDouble(brandData[3])));
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
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
      StringBuffer result = new StringBuffer("");
      this.forEach(brand -> result.append(brand.toString() + '\n'));
      writer.write(result.toString());
      writer.close();
    } catch (Exception e) {
      return false;
    }
    System.out.printf("Write to %s successfully!!\n", filename);
    return true;
  }

  public int searchID(String bID) {
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i).brandID.equals(bID))
        return i;
    }
    return -1;
  }

  public Brand getUserChoice() {
    return new Menu<Brand>().ref_getChoice(this);
  }

  public void addBrand() {
    Scanner in = new Scanner(System.in);

    String brandId = "";
    do {
      System.out.print("Enter brand ID: ");
      brandId = in.nextLine();

      if (searchID(brandId) != -1)
        System.out.println("Brand ID has existed!");
      else if (brandId.isEmpty())
        System.out.println("Brand ID cannot be empty");
    } while (brandId.isEmpty() || searchID(brandId) != -1);

    String brandName = "";
    do {
      System.out.print("Enter brand name: ");
      brandName = in.nextLine();

      if (brandName.isEmpty())
        System.out.println("Brand name cannot be empty");
    } while (brandName.isEmpty());

    String soundBrand = "";
    do {
      System.out.print("Enter sound brand: ");
      soundBrand = in.nextLine();

      if (soundBrand.isEmpty())
        System.out.println("Sound brand cannot be empty");
    } while (soundBrand.isEmpty());

    double price = 0;
    do {
      try {
        System.out.print("Enter price: ");
        price = Double.parseDouble(in.nextLine());

        if (price <= 0)
          System.out.println("Price must be non-negative");
      } catch (NumberFormatException e) {
        price = -1;
      }
    } while (price <= 0);

    this.add(new Brand(brandId, brandName, soundBrand, price));
    System.out.println();
    System.out.println("Added brand successfully!!");
  }

  public void updateBrand() {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter brand ID: ");
    String brandID = in.nextLine();
    int pos = searchID(brandID);

    if (pos == -1) {
      System.out.println("Brand not found.");
    } else {
      String updateBrandName = "";
      do {
        System.out.print("Enter brand name: ");
        updateBrandName = in.nextLine();

        if (updateBrandName.equals(""))
          System.out.println("Brand name cannot be empty");
      } while (updateBrandName.equals(""));

      String updatedSoundBrand = "";
      do {
        System.out.print("Enter sound brand: ");
        updatedSoundBrand = in.nextLine();

        if (updatedSoundBrand.equals(""))
          System.out.println("Sound brand cannot be empty");
      } while (updatedSoundBrand.equals(""));

      double updatedPrice = 0;
      do {
        System.out.println("Enter price: ");
        updatedPrice = Double.parseDouble(in.nextLine());

        if (updatedPrice <= 0)
          System.out.println("Price must be non-negative");
      } while (updatedPrice <= 0);

      this.get(pos).setBrandName(updateBrandName);
      this.get(pos).setSoundBrand(updatedSoundBrand);
      this.get(pos).setPrice(updatedPrice);
      System.out.println();
      System.out.println("Updated brand successfully!!");
    }
  }

  public void listBrands() {
    this.forEach(System.out::println);
  }
}
