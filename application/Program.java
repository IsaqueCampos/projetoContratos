package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departiment;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("DD/MM/yyyy");
		
			System.out.print("Enter departament´s name: ");
			String departmentName = sc.nextLine();
			System.out.println("Enter worker data: ");
			System.out.print("Name: ");
			String workerName = sc.nextLine();
			System.out.print("Level: ");
			String workerLevel = sc.nextLine();
			System.out.print("Base salary: ");
			double baseSalary = sc.nextDouble();
			
			Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departiment (departmentName));
			
			System.out.println ("How many contracts to this worker?");
			int n = sc.nextInt();
			
			for (int i = 0; i < n ; i++) {
				System.out.println("Enter contract #"+ i++ + " data: ");
				System.out.print("Date (DD/MM/yyyy): ");
				Date contractDate = sdf.parse(sc.next());
				System.out.print("Value per hour: ");
				double valuePerHour = sc.nextDouble();
				System.out.print("Duration (hours): ");
				int hours = sc.nextInt();
				HourContract contract = new HourContract(contractDate, valuePerHour, hours);
				worker.addContract(contract);
			}
			
			System.out.println();
			System.out.println("Enter month and yaer to calculate income (MM/yyyy): ");
			String monthAndYear = sc.next();
			int month = Integer.parseInt(monthAndYear.substring(0, 2));
			int year = Integer.parseInt(monthAndYear.substring(3));
			
			System.out.println("Name :" + worker.getName());
			System.out.println("Department: " + worker.getDepartiment().getName());
			System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
			
		sc.close();
	}

}
