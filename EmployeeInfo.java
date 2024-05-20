
import java.io.*;
import java.util.*;

class Employee{
	int id;
	String name;
	int salary;
	 String department;
	
	Employee(int id,String name,int salary,String department)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	public String toString()
	{
		return ("Id: "+id+", name: "+name+", salary: "+salary+", department: "+department+"\n");
	}

}


public class EmployeeInfo {
 public static void main(String[] args)
 {
	List<Employee> employees = new ArrayList<>();
	employees.add(new Employee(1,"Anish Paudel",40000,"Coding"));
	employees.add(new Employee(2,"Niruta Gharti",30000,"UI/UX"));
	employees.add(new Employee(3,"Rajesh Hamal",35000,"Coding"));
	employees.add(new Employee(4,"Nikhil Upreti",40000,"Coding"));
	
	String filename = "Employees.txt";
	
	try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
	{
       for(Employee emp:employees)
       {
    	   writer.write(emp.id+","+emp.name+","+emp.salary+","+emp.department);
    	   writer.newLine();
       }
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
   
	try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
	{
		String line;
		while((line=reader.readLine()) != null)
		{
			String[] parts = line.split(",");
			if(parts.length==4)
			{
				System.out.println("Id: "+parts[0]+", name: "+parts[1]+", salary: "+parts[2]+", department: "+parts[3]+"\n");
			}
		}
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
}
