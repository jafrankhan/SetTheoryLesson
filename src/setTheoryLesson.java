//Name : Poon Jun Hong
//UOW no. : 6744679
//Tutorial: T01
//File : PoonJunHong_A1
//Declaration: I declare that this submission is my own work 
//
//-------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

enum Month 
{
	Jan(1, "January"  ),
	Feb(2, "February" ),
	Mar(3, "March"	  ), 
	Apr(4, "April"    ), 
	May(5, "May"      ), 
	Jun(6, "June"     ),
	Jul(7, "July"     ),
	Aug(8, "August"   ),
	Sep(9, "September"),
	Oct(10,"October"  ),
	Nov(11,"November" ),
	Dec(12,"December" );
    
	//int Month Number
	private final int monthNo;
	//Month name
	private final String monthString;
	
	//int constructor 
	Month(int monthNo, String monthString)
	{
		this.monthNo = monthNo;
		this.monthString = monthString;
	}
	
	//int var 
	public int getMonthNo()
	{
		return monthNo;
	}
	
	public String getMonthString()
	{
		return monthString;
	}
}	
	

	
class Set
{
    //Declaring int var
	private ArrayList<Month> s = new ArrayList<Month>();
	  
	//Creating constructor (set)
	public Set()
    {
     
    }

	//Adding copy constructor 
    public Set(Set otherSet)
    {
 		for(Month m0nth : otherSet.s)
		this.s.add(m0nth);
    }

	//Boolean method to check empty or not
    public boolean isEmpty()
 	{
		if(cardinality() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
    }

    //Adding the cardinality to check for size
    public int cardinality()
    {
		int cardinality = s.size(); 
		return cardinality;
    }
    
    //Use boolean to show the month contained
	public boolean belongTo(Month element)
	{
		boolean belongTo = s.contains(element);
		return belongTo;
	}
	  
	//Method to add elements 
    public void addElement(Month element)
    { 
		if (! belongTo(element))
			s.add(element);
    }

    //Use boolean method checking if current set is repeated
    public boolean subset(Set otherSet)
    {
		for(Month m0nth : otherSet.s)
		{
		if (! belongTo (m0nth)== true)
			return false;
		}
		return true;
			
    }

    //Method to combine and form unions
    public void union(Set otherSet)
    {
		for(int x = 0; x < otherSet.cardinality(); x++)
		{
			addElement(otherSet.s.get(x));
		}          
    }

    //Method to intersections
    public void intersection(Set otherSet)
    {
		for(int x = cardinality()-1; x >=0; x--)
		{
			if(!otherSet.belongTo(s.get(x)))
				s.remove(s.get(x));
		}          
    }

    //Method to get differences
    public void difference(Set otherSet)
    {
		for (int x = 0 ; x < otherSet.cardinality(); x++)
		{
			if (belongTo(otherSet.s.get(x)))
				s.remove(otherSet.s.get(x));
		}         
    }

    //Method to complement set
    public Set complement()
    {
		Set comp = new Set();
		for (Month m0nth : Month.values())
		{
			comp.addElement(m0nth);
		}
		
		for(int x = 0; x < s.size();x++)
		{
			if(comp.belongTo(s.get(x)));
			{
				comp.s.remove(s.get(x));
			}
		}
		return comp;	
    }

    //Adding boolean to show equality between sets
    public boolean equality(Set otherSet)
    {
		if(otherSet.s == null || (this.s == null))
		{
			return  true;
		}

 		return (otherSet.subset(this) && subset(otherSet));
    }


	public boolean setAEquality(Set otherSet)
	{
		if((this.cardinality()== 0))
		{
			return  true;
		} else 
		return (this.subset(otherSet));
	}

	public boolean setBEquality(Set otherSet)
	{
		if(otherSet.cardinality() ==0 )
		{
			return  true;
		}
		
		return (otherSet.subset(this));
	}


    //toString method to construct a String and denote object
    public String toString()
	{
		String st = "";
		
		for(int x = 0; x < cardinality(); x++)
		{
			switch (x)
			{
				case 0: st = String.valueOf(s.get(x));
						break;
				default: st = st + ", " + String.valueOf(s.get(x)); 
				        break;
			}			
		}
		return st;		
	}

    //getString methods to get Month number string
    public String getString_1()
    {
        String st = "";
		for (int x = 0; x < cardinality(); x++)
		{
			switch (x)
			{
				case 0: st = Integer.toString(s.get(x).getMonthNo());
				
				break;
				
				default: st = st + ", " + Integer.toString(s.get(x).getMonthNo());
				
				break;
			}
		}
		return st; 
    }
	
    //getString methods to get Month name string       
    public String getString_2()
    {
         		String st = "";
		for(int x = 0; x < cardinality(); x++)
		{
			switch (x)
			{
				case 0:st = s.get(x).getMonthString();
				
				break;
				
				default:st = st + ", " + s.get(x).getMonthString(); 
				
				break;
			}		
		}
		return st;
    }
}

public class setTheoryLesson
{
    private static Scanner input= new Scanner(System.in);
	private static Set setA;
	private static Set setB;
	private static int choose;
	
	//Method displaying month details
	private static void displayMonthDetails()
	{
		System.out.println("universal set info\n");
		for (Month m0nth : Month.values())
		{
			System.out.printf("%-6s%02d%10s%n", m0nth, m0nth.getMonthNo(), m0nth.getMonthString());
		}
		System.out.println();
    }
	  
	//Method to get month element 
	private static Month getAnElement()
	{
		int el;
		el = (int)(Math.random()* 12);
		return Month.values()[el];
	}
	  
	//Method to get set
	private static Set getASet()
	{
		Set NewSet = new Set ();
		for (int x = 0; x < (int)(Math.random() * 12); x++)
		{
		Month element = getAnElement();
		NewSet.addElement(element);
		}
		return NewSet;
	}
	  
	 //Method to display menu
	private static void displayMenu()
	{
		System.out.println("Welcome to SIM Set Theory lesson");
		System.out.println(" ");
		System.out.println("0: Properties of set");
		System.out.println("1: Union example");
		System.out.println("2: Intersection example");
		System.out.println("3: Subset example");
		System.out.println("4: Difference example");
		System.out.println("5: Complement example");
		System.out.println("6: Set equality example");
		System.out.println("9: Quit");
		System.out.println(" ");
		
		do
		{
			System.out.print("Your Option:");
			choose = input.nextInt();
			
			switch(choose)
			{
			   case 0: anExample();
			           displaySubmenu();
					   break;
			   case 1: unionExample();
					   displaySubmenu();
					   break;
			   case 2: intersectionExample();
					   displaySubmenu();
					   break;
			   case 3: subsetExample();
			           displaySubmenu();
					   break;
			   case 4: differenceExample();
			           displaySubmenu();
					   break;
			   case 5: complementExample();
			           displaySubmenu();
					   break;
			   case 6: equalityExample();
			           displaySubmenu();
					   break;
			}
		}
		while(choose!=9);
	}

	//Method to show union in example
	private static void unionExample()
	  {
		setA = getASet();
		setB = getASet();
		
		System.out.println("\nGiven Sets");
		System.out.println("\tset A = {" + setA.toString()+"}");	
		System.out.println("\tset B = {" + setB.toString()+"}");
		setA.union(setB);
		System.out.println("\tUnion of A and B = {" + setA +"}");
	  }
	  
	//Method to show the intersection
	private static void intersectionExample()
	{
		setA = getASet();
		setB = getASet();
		System.out.println("\nGiven Sets");
		System.out.println("\tset A = {" + setA.toString()+"}");
		System.out.println("\tset B = {" + setB.toString()+"}");
		setA.intersection(setB);
		System.out.println("\tIntersection of A and B = " + setA.toString());
	}
	  
	//Method to show the subset in example
	  private static void subsetExample()
	  {
		setA = getASet();
		setB = getASet();
		System.out.println("\nGiven Sets");
		System.out.println("\tset A = {" + setA.toString()+"}");
		System.out.println("\tset B = {" + setB.toString()+"}");
		System.out.println("");
		System.out.println("Conclusion");
		System.out.println("\tA subset of B: " + setB.subset(setA));
		System.out.println("\tB subset of A: " + setA.subset(setB));	     
	}
	  
	//Method to show the difference in example
	private static void differenceExample()
	{
		setA = getASet();
		setB = getASet();
		System.out.println("\nGiven Sets");
		System.out.println("\tset A = {" + setA.toString()+"}");
		System.out.println("\tset B = {" + setB.toString()+"}");
		System.out.println(" ");
		setA.difference(setB);
		System.out.println("\tA - B = {" + setA +"}");
	}
	  
	//Method to show the complement of example
	private static void complementExample()
	{
		setA = getASet();
		System.out.println("\tA = {" + setA +"}");
		System.out.println("\tA = {" +setA.complement() +"}");	     
	}
	  
	//Method to show the equality in example
	private static void equalityExample()
	{
		setA = getASet();
		setB = getASet();
		System.out.println("\nGiven Sets");
		System.out.println("\tset A = {" + setA.toString()+"}");
		System.out.println("\tset B = {" + setB.toString()+"}");
		System.out.println(" ");
		System.out.println("\nAnalysis");
		System.out.println("\tA subset of B: " + setA.subset(setB));
		System.out.println("\tB subset of A: " + setB.subset(setA));
		System.out.println(" ");
		System.out.println("\nConclusion");
		System.out.println("\tA equals to B: " + (setB.equality(setA) && setA.equality(setB)));	     
	}
	  
	//Method to display the sub-menu
	public static void displaySubmenu()
	{
		System.out.println("________________________________________");
		System.out.println("\nSome basic operations in set");
		System.out.println("\t1. Add a element");
		System.out.println("\t2. Check a element");
		System.out.println("\t3. Cardinality");
		System.out.println("\t4. Various displays");
		System.out.println("\t9. Quit");
		System.out.println(" ");
		
		do
		{
			System.out.print("Enter option:");
			choose =input.nextInt();
			switch (choose)
			{
				case 1: System.out.print ("Enter a element: ");
				        String E =  input.next();
						setA.addElement(Month.valueOf(E));
						System.out.println("A = {" + setA +"}");						
						break;
						
				case 2: System.out.print ("Enter element: ");
				        String E1 =  input.next();
						if(setA.belongTo(Month.valueOf(E1)))
							System.out.println("Element " + E1 +" is in set");
						else
							System.out.println("Element " + E1 +" not is in set");
						break;
						
				case 3: System.out.printf("Number of elements in set is %d%n", setA.cardinality());
						break;
						
				case 4: System.out.println("Equivalent sets info");
				        variousDisplays (setA);
						break;
			}
		}
		while(choose!=9);
        displayMenu();		
    }
	  
	//Method for example
	public static void anExample()
	{
		System.out.println("here is an example of a set");
		setA = getASet();
		System.out.println("A = {" + setA +"}"); 
		System.out.println("All elements in set are distinct and in random order");
	}
	  
	//Method for various displays
	private static void variousDisplays(Set s)
	{
		System.out.println("\nEquivalent sets info");
		System.out.println("\tset 1: {" + s.getString_1() +"}");
		System.out.println("\tSet 2: {" + s.getString_2() +"}");
	}
	  
	public static void main (String [] args)
	{
		displayMonthDetails();
		displayMenu();
	}
}