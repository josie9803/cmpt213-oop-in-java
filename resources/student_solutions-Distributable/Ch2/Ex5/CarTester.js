// A program that tests the Car class

load ("Car.js");

myCar = new Car(15, 30);
print ( "Current level (should be 15): " + myCar.getLevel() );

myCar.drive(150);
print ("Current level (should be 10): " +  myCar.getLevel() );

myCar.addFuel(3);
print ( "Current level (should be 13): " + myCar.getLevel() );


print ( "Should be out of gas after " + 13 * 30 + " miles." );
myCar.drive(1500);
print ( "Current level (should be 0): " + myCar.getLevel() );
