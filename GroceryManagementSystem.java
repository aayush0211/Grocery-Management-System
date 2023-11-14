package groceryManagementSystem.tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import groceryManagementSystem.Grocery;

public class GroceryManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			
			List<Grocery> lists = new ArrayList<>();
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Enter your Choice: \n1)Add a new Grocery \n2)Update the Quantity of a grocery item in stock\n"
						+ "3)Display the list \n4)Remove all empty Stock items\n "
						+ "5)Display all products for which stock updated in last 3 days \n0)Exit");
			try {
				switch(sc.nextInt()) {
				case 1:System.out.println("Enter grocery datails : name ,price,quantity");
				String name = sc.next();
				Grocery temp = new Grocery(name);
				if(lists.contains(temp)) {
					throw new GroceryException("Duplicates not Allowed");	
				}else {
					lists.add(new Grocery(name, sc.nextDouble(), sc.nextInt()));
				}
//						List<Grocery>tempList	=	lists.stream().filter(p->p.getName().equals(name)).collect(Collectors.toList());
//						if(tempList==null) {
//							lists.add(new Grocery(sc.next(), sc.nextDouble(), sc.nextInt()));		
//						}else {
//						throw new GroceryException("Duplicates not Allowed");	
//						}
				System.out.println("successfully added");
					break;
				case 2:System.out.println("Enter grocery datails : name ");
				 name = sc.next();
				temp = new Grocery(name);
				if(lists.contains(temp)) {
					int i = lists.indexOf(temp);
					lists.get(i).setQuantity(lists.get(i).getQuantity()+sc.nextInt());
				}else {
					throw new GroceryException("grocery not found!!!");
				}
					break;
				case 3:lists.stream().forEach(System.out::println);
					break;
				case 4: lists.removeIf(p->p.getQuantity()==0);
					break;
				case 5:lists.stream().filter(p->Period.between(p.getStockUpdateDate(),LocalDate.now()).getDays()<=3).forEach(System.out::println);
					break;
				case 0: System.out.println("Thank You!!!!!!");
					exit = true;
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
