package coach.victory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Chapter3Video7 {

  protected static class Employee {
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
    Employee[] employeesArr = {
      new Employee("John", 34, "developer", 80000f),
      new Employee("Hannah", 24, "developer", 95000f),
      new Employee("Bart", 50, "sales executive", 100000f),
      new Employee("Sophie", 49, "construction worker", 40000f),
      new Employee("Darren", 38, "writer", 50000f),
      new Employee("Nancy", 29, "developer", 75000f)
    };
    List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
    Predicate<Employee> isDeveloper = employee -> employee.jobTitle == "developer";
    Predicate<Employee> isNotDeveloper = employee -> employee.jobTitle != "developer";

    BiFunction<List<Employee>, Predicate<Employee>, Float> averageSalaryByPredicate =
        (list, predicate) -> {

          Float res = list
              .stream()
              .filter(predicate)
              .map(employee -> employee.salary)
              .reduce(0f, (acc, x) -> acc + x);

          Long numberOfEmployees = list
              .stream()
              .filter(predicate)
              .count();

          res = res / numberOfEmployees;

          return res;
        };

    System.out.println(
        "Average Developer Salary: " + averageSalaryByPredicate.apply(employees, isDeveloper));
    System.out.println(
        "Average Not Developer Salary: "
            + averageSalaryByPredicate.apply(employees, isNotDeveloper));
  }
}
