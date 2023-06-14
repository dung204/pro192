package com;

public class Car implements Comparable<Car> {
  String carID;
  Brand brand;
  String color;
  String frameID;
  String engineID;

  public Car() {
    carID = "";
    brand = new Brand();
    color = "";
    frameID = "";
    engineID = "";
  }

  public Car(String carID, Brand brand, String color, String frameID, String engineID) {
    this.carID = carID;
    this.brand = brand;
    this.color = color;
    this.frameID = frameID;
    this.engineID = engineID;
  }

  public String getCarID() {
    return carID;
  }

  public void setCarID(String carID) {
    this.carID = carID;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getFrameID() {
    return frameID;
  }

  public void setFrameID(String frameID) {
    this.frameID = frameID;
  }

  public String getEngineID() {
    return engineID;
  }

  public void setEngineID(String engineID) {
    this.engineID = engineID;
  }

  @Override
  public int compareTo(Car another) {
    int result = this.brand.brandName.compareTo(another.brand.brandName);
    return result != 0 ? result : this.carID.compareTo(another.carID);
  }

  @Override
  public String toString() {
    return String.format("%s, %s, %s, %s, %s", carID, brand.brandID, color, frameID, engineID);
  }

  public String screenString() {
    return String.format("%s, \n, %s, %s, %s, %s", brand, carID, color, frameID, engineID);
  }
}
