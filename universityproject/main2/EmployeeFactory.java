package main2;

import java.io.Serializable;

public class EmployeeFactory implements Serializable {
	/**
	 * Method to generate object of employee class based on given information
	 * @param employee
	 * @return
	 */
	public Employee getEmployee(String employee) {
		if(employee == null) return null;
		
		if(employee.equalsIgnoreCase("TEACHER")) return (new Teacher());
		if(employee.equalsIgnoreCase("MANAGER")) return (new Manager());
		if(employee.equalsIgnoreCase("TECHSUPPORTSPECIALIST")) return (new TechSupportSpecialist()); 
		if(employee.equalsIgnoreCase("RESEARCHER")) return (new BaseResearcher());
		
		return null;
	}

}
