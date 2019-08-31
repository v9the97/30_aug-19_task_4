package com.collection;

import java.util.*;

/*class Sortbyname implements Comparator<emp> {
	// Used for sorting in ascending order of
	// roll name
	public int compare(emp e1, emp e2) {
		return e1.deptn.compareTo(e2.deptn);
	}
}*/

class emp {

	public int sal, eno;
	public String deptn, desg;

	emp(int eno, String deptn, int sal, String desg) {
		this.eno = eno;
		this.sal = sal;
		this.deptn = deptn;
		this.desg = desg;
	}

	@Override
	public String toString() {
		return "emp [sal=" + sal + ", eno=" + eno + ", deptn=" + deptn
				+ ", desg=" + desg + "]";
	}

}

public class Employees implements Comparator<emp> {

	static ArrayList<emp> list = new ArrayList<>();

	public void Add(emp obj) {
		list.add(obj);
		System.out.print("  insert   ");
		// viewAllEmp();
	}

	public void viewAllEmp() {
		for (emp ob : list) {
			System.out.print(" " + ob.eno);
			System.out.print(" " + ob.sal);
			System.out.print(" " + ob.deptn);
			System.out.print(" " + ob.desg);

		}

	}

	public void Remove(int remove) {
		int check = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).eno == remove) {
				list.remove(i);
				check = 1;
			}

		}
		if (check == 0) {
			System.out.print(" Employee not Exits  ");
		}
	}

	public void cleanData() {
		list.removeAll(list);
		System.out.print(" remove all ");
	}

	public void Change(int remove, int sal) {
		int check = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).eno == remove) {
				check = 1;

				list.get(i).sal = sal;
				System.out.print(" salary update ");
				viewAllEmp();
				break;
			}
		}
		if (check == 0) {
			System.out.print(" Employee not Exits  ");
		}
	}

	public void search(int search) {
		int check = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).eno == search) {
				check = 1;
				System.out.print(" " + list.get(i).eno);
				System.out.print(" " + list.get(i).sal);
				System.out.print(" " + list.get(i).deptn);
				System.out.print(" " + list.get(i).desg);
			}
		}
		if (check == 0) {
			System.out.print(" Employee not Exits  ");
		}

	}

	public void DeptWise(String dept) {
		int check = 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).desg.toString().equals(dept)) {
				check = 0;
				System.out.print(" " + list.get(i).eno);
				System.out.print(" " + list.get(i).sal);
				System.out.print(" " + list.get(i).deptn);
				System.out.println(" " + list.get(i).desg);

			}
		}
		if (check == 1) {
			System.out.print("Department not Exits  ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Employees emp1 = new Employees();
		boolean b = true;
		while (b) {
			System.out.print(" \n Menu \n ");
			System.out.print(" \n  1. Add Employee  ");
			System.out.print(" \n  2. View all employees  ");
			System.out.print(" \n  3. Remove Employee  ");
			System.out.print(" \n  4. Clean Data  ");
			System.out.print(" \n  5. Change salary  ");
			System.out.print(" \n  6. Search  ");
			System.out.print(" \n  7. View Departmnet wise employess  ");
			System.out.print(" \n  8. Sort By eno");
			System.out
					.print(" Provide your choice as a number amongst these choices ");

			switch (sc.nextInt()) {
			case 1:
				System.out
						.println("please enter employeeNumber, EmployeeName,salary,DepartmentName");
				emp1.Add(new emp(sc.nextInt(), sc.next(), sc.nextInt(), sc
						.next()));
				break;
			case 2:
				emp1.viewAllEmp();
				break;
			case 3:
				System.out.println(" EmployeeNumber ");
				emp1.Remove(sc.nextInt());
				break;
			case 4:
				System.out.println(" RemoveData ");
				emp1.cleanData();
				break;

			case 5:
				System.out.println(" Change Salary ");
				emp1.Change(sc.nextInt(), sc.nextInt());
				break;

			case 6:
				System.out.println(" enter Empoyee NUmber ");
				emp1.search(sc.nextInt());
				break;

			case 7:
				System.out.println("Employee Departmentname ");
				emp1.DeptWise(sc.next());
				break;

			case 8:
				System.out.println("sort by 1.employeenumber 2. name 3. sortby Salary 4.sort by Departmentname ");
				switch (sc.nextInt()) {
				case 1:
				Collections.sort(list, new Comparator<emp>()
				{
					public int compare(emp e1, emp e2) {
					if(e1.eno>(e2.eno))
						return e2.eno;
					else
						return e1.eno;
				}
			});
				break;
				case 2:
					Collections.sort(list, new Comparator<emp>()
					{
						public int compare(emp e1, emp e2) {
						return e1.deptn.compareTo(e2.deptn);
					}
				});
					break;
				case 3:
					Collections.sort(list, new Comparator<emp>()
					{
						public int compare(emp e1, emp e2) {
							if(e1.sal>(e2.sal))
								return e2.sal;
							else
								return e1.sal;
						}});
					break;
				case 4:
					Collections.sort(list, new Comparator<emp>()
					{
						public int compare(emp e1, emp e2) {
						return e1.desg.compareTo(e2.desg);
					}
				});
					break;
					}
			default:
				Collections.sort(list, new Comparator<emp>()
						{
							public int compare(emp e1, emp e2) {
							if(e1.eno>(e2.eno))
								return e2.eno;
							else
								return e1.eno;
						}
					});
				break;
				
				
				System.out.println(" "+ list);
				break;

			case 9:
				b = false;
				System.out.println("you Exits ");
				break;

			default:
				System.out.print(" ");
				break;
			}
		}

	}
}
