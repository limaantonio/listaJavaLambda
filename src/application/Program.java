package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.println("How many employees will be registered?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Employer #%d:\n", i + 1);
			System.out.println("Id: ");
			int id = sc.nextInt();
			for (Employee e : list) {
				while (e.getId() == id) {
					System.out.println("This id already exists, please type again.");
					id = sc.nextInt();
				}
			}
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary: ");
			double salary = sc.nextDouble();

			list.add(new Employee(id, name, salary));
		}
		
		System.out.println("Enter the employee id that will have salary increase:");
		int ident = sc.nextInt();

		Employee emp = list.stream().filter(x -> x.getId() == ident).findFirst().orElse(null);
		if (emp != null) {
			System.out.println("Enter the percentage:");
			double taxa = sc.nextDouble();
			emp.encrease(taxa);
		} else {
			System.out.println("This employee does not exist.");
		}
		
		System.out.println("List of employees:");
		for (Employee e : list) {
			System.out.println(e.getId()+", "+e.getName()+", "+e.getSalary());
		}
	}
}
