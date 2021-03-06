package coach.victory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter3Challenge1 {

  static class Person {
    public final String name;
    public final Integer age;

    public Person(String name, Integer age) {
      this.name = name;
      this.age = age;
    }
  }

  static class Car {
    public final String make;
    public final String color;
    public final Float price;

    public Car(final String make, final String color, final Float price) {
      this.make = make;
      this.color = color;
      this.price = price;
    }
  }

  static class Employee {
    public final String name;
    public final Integer age;
    public final String jobTitle;
    public final Float salary;

    public Employee(
        final String name, final Integer age, final String jobTitle, final Float salary) {
      this.name = name;
      this.age = age;
      this.jobTitle = jobTitle;
      this.salary = salary;
    }
  }

  public static void main(String[] args) {
    Person[] peopleArr = {
      new Person("Brandon", 23),
      new Person("Hank", 43),
      new Person("Jenna", 33),
      new Person("Veronica", 56),
      new Person("Jack", 27)
    };
    List<Person> people = new ArrayList<>(Arrays.asList(peopleArr));

    // Get a list that contains all the people's names
    List<String> res0 = people.stream().map(person -> person.name).collect(Collectors.toList());
    System.out.println(res0);

    Car[] carsArr = {
      new Car("Chevy", "red", 45000f),
      new Car("Ford", "blue", 23000f),
      new Car("Toyota", "grey", 14000f),
      new Car("Lamborghini", "blue", 150000f),
      new Car("Renault", "blue", 150000f)
    };
    List<Car> cars = new ArrayList<>(Arrays.asList(carsArr));

    // Get a list of all the blue cars
    List<Car> res1 = cars.stream().filter(car -> car.color == "blue").collect(Collectors.toList());
    System.out.println(res1);

    Employee[] employeesArr = {
      new Employee("John", 34, "developer", 80000f),
      new Employee("Hannah", 24, "developer", 95000f),
      new Employee("Bart", 50, "sales executive", 100000f),
      new Employee("Sophie", 49, "construction worker", 40000f),
      new Employee("Darren", 38, "writer", 50000f),
      new Employee("Nancy", 29, "developer", 75000f)
    };
    List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

    // Find the sum of all of the employee's salaries
    Float res2 =
        employees.stream().map(employee -> employee.salary).reduce(0f, (acc, x) -> acc + x);
    System.out.println(res2);
  }
}
