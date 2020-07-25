package com.corejava;
import java.util.*;

class Student 
{ 
    int age; 
    String name;
    double height; 
  
	public Student(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
   
    public String toString() 
    { 
        return this.age + " " + this.name + 
                           " " + this.height; 
    } 
} 
  

public class Question2
{ 
    public static void main (String[] args) 
    { 
    	ArrayList<Student> ar = new ArrayList<Student>(); 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students:");
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
        	System.out.println("Enter student details:");
        	System.out.print("Name of the Student:");
        	String name = sc.next();
        	System.out.print("Age of the Student:");
        	int age = sc.nextInt();
        	System.out.print("Height of the Student:");
        	double height = sc.nextDouble();
        	Student s = new Student(name,age,height);
        	ar.add(s);
        } 
  
        Collections.sort(ar, new Sortbyage()); 
  
        System.out.println("\nAge after sorting"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
  
        Collections.sort(ar, new Sortbyname()); 
  
        System.out.println("\nName after sorting"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
        
        Collections.sort(ar, new Sortbyheight()); 
        
        System.out.println("\nHeight after Sorting"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
    } 
} 

class Sortbyage implements Comparator<Student> 
{ 
    public int compare(Student a, Student b) 
    { 
        return a.age - b.age; 
    } 
} 
  
class Sortbyname implements Comparator<Student> 
{ 
    public int compare(Student a, Student b) 
    { 
        return a.name.compareTo(b.name); 
    } 
} 
  
class Sortbyheight implements Comparator<Student> 
{ 
    public int compare(Student a, Student b) 
    { 
        return (int) (a.height-b.height); 
    } 
}
