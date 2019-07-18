package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees= new ArrayList<>();
		
		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + "data:");
			System.out.println("Outsourced (y/n)? ");
			char c = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Hours: ");
			int hours = sc.nextInt();
			System.out.println("Value per hour: ");
			double vph = sc.nextDouble();
			if(c == 'y') {
				System.out.println("Additional charge: ");
				double add = sc.nextDouble();
				Employee e = new OutsourcedEmployee(name, hours, vph, add);
				employees.add(e); 
			} else {
				Employee e =  new Employee(name, hours, vph);
				employees.add(e);
			}
		}
		
		System.out.println();

		System.out.println("PAYMENTS:");
		
		for(Employee c : employees) {
			double pay;
			if(c instanceof OutsourcedEmployee) {
				double add = ((OutsourcedEmployee) c).getAdditionalCharge() * 1.1;
				pay = add + c.payment();
			} else {
				pay = c.payment();
			}
			System.out.println(c.getName() + " - $ " + pay);
		}
	}

}
