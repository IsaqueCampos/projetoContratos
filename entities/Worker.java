package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departiment departiment;
	private List <HourContract> contracts =new ArrayList<>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departiment departiment) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departiment = departiment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departiment getDepartiment() {
		return departiment;
	}

	public void setDepartiment(Departiment departiment) {
		this.departiment = departiment;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract (HourContract contact) {
		contracts.add(contact);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income (int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);		
			if (year == c_year && month == c_month ) {
			sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
