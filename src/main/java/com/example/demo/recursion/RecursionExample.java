package com.example.demo.recursion;

import com.example.demo.OneInterfaceToRunThemAll;

public class RecursionExample implements OneInterfaceToRunThemAll {

  @Override
  public void runExample() {
    System.out.println("\n*** Recursion ***");

    int n = 3;
    System.out.print("Tail recursion: ");
    tailRecursion(n);

    System.out.print("\nHead recursion: ");
    headRecursion(n);

    System.out.print("\nTree recursion: ");
    treeRecursion(3);

    System.out.print("\nNested recursion: ");
    int x = nestedRecursion(95);
    System.out.print(x);

    System.out.print("\nIndirect recursion: ");
    indirectRecursionA(20);
  }

  private void tailRecursion(int n) {
    if (n > 0) {
      System.out.print(n + " ");
      tailRecursion(n - 1); // last statement
    }
  }

  private void headRecursion(int n) {
    if (n > 0) {
      headRecursion(n - 1); // first statement
      System.out.print(" " + n);
    }
  }

  private void treeRecursion(int n) {
    if (n > 0) {
      System.out.print(" " + n);
      treeRecursion(n - 1); // Calling once
      treeRecursion(n - 1); // Calling twice
    }
  }

  private int nestedRecursion(int n) {
    if (n > 100) {
      return n - 10;
    }
    // A recursive function passing parameter
    // as a recursive call or recursion
    // inside the recursion
    return nestedRecursion(nestedRecursion(n + 11));
  }

  private void indirectRecursionA(int n) {
    if (n > 0) {
      System.out.print(" " + n);
      indirectRecursionB(n - 1); // A calls B
    }
  }

  private void indirectRecursionB(int n) {
    if (n > 1) {
      System.out.print(" " + n);
      indirectRecursionA(n / 2); // B calls A
    }
  }
}
