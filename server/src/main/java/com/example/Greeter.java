package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
  * @param someone the name of a person
  * @return greting String
  **/
  public final String greet(final String someone) {
    return String.format("Hello from Amazon E2C, %s!", someone);
  }
}
