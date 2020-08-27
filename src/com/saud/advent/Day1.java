package com.saud.advent;


/*
* --- Day 1: The Tyranny of the Rocket Equation ---
Santa has become stranded at the edge of the Solar System while delivering presents to other planets! To accurately calculate his position in space, safely align his warp drive, and return to Earth in time to save Christmas, he needs you to bring him measurements from fifty stars.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

The Elves quickly load you into a spacecraft and prepare to launch.

At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of fuel required yet.

Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.

For example:

For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
For a mass of 1969, the fuel required is 654.
For a mass of 100756, the fuel required is 33583.
The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.

What is the sum of the fuel requirements for all of the modules on your spacecraft?
*
* */

/**
 * @author SAUD on 8/27/2020.
 */
public class Day1 {
  private static final int DIVISOR = 3;
  public static final int[] inputs =
      new int[] {90859, 127415, 52948, 92106, 106899, 72189, 60084, 79642, 138828, 103609, 149073,
          127749, 86976, 104261, 139341, 81414, 102622, 131030, 120878, 96809, 130331, 119212,
          52317, 108990, 136871, 67279, 76541, 113254, 77739, 75027, 53863, 97732, 65646, 87851,
          63712, 92660, 131821, 127837, 52363, 70349, 66110, 132249, 50319, 125948, 98360, 137675,
          61957, 143540, 137402, 135774, 51376, 144833, 118646, 128136, 141140, 82856, 63345,
          143617, 79733, 73449, 116126, 73591, 63899, 110409, 79602, 77485, 64050, 131760, 90509,
          112728, 55181, 55329, 98597, 126579, 108227, 80707, 92962, 90396, 123775, 125248, 128814,
          64593, 63108, 76486, 107135, 111064, 142569, 68579, 149006, 52258, 143477, 131889, 142506,
          146732, 58663, 92013, 62410, 71035, 51208, 66372};

  public static void main(String[] args) {
    Day1 day1 = new Day1();
    final int requiredFuel = day1.calculateRequiredFuel(inputs);
    System.out.println("Total fuel required: "+ requiredFuel);
  }

  public int calculateRequiredFuel(int[] masses) {
    int sum = 0;
    for (int mass : masses) {
      if (mass != 0) {
        int fuel = calculateFuelForMass(mass);
        sum +=   calculateFuelForFuel(fuel);
      }
    }
    return sum;
  }

  public int calculateFuelForMass(int mass) {
    return  Math.floorDiv(mass, DIVISOR) - 2;
  }

  public int calculateFuelForFuel(int fuelQty){
    if(fuelQty <= 0 ){
      return 0;
    }
    return fuelQty + calculateFuelForFuel(Math.floorDiv(fuelQty,DIVISOR) - 2);
  }

}
