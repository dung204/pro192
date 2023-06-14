package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu<E> {
  public int int_getChoice(ArrayList<E> options) {
    int response;
    try {
      Scanner in = new Scanner(System.in);

      for (int i = 0; i < options.size(); i++) {
        System.out.printf("%d. %s\n", i + 1, options.get(i));
      }
      System.out.printf("Please choose an option (1 - %d): ", options.size());

      response = Integer.parseInt(in.nextLine());
    } catch (NumberFormatException e) {
      response = -1;
    }

    return response;
  }

  public E ref_getChoice(ArrayList<E> options) {
    int response;
    do {
      response = int_getChoice(options);
    } while (response < 0 || response > options.size());
    return options.get(response - 1);
  }
}
