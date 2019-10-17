package day13.TreeSet.Comparable_Compartor;

import java.util.Comparator;

public class AgeCp implements Comparator<Person>{

	

	@Override
	public int compare(Person p1, Person p2) {
		
		return p1.getAge()-p2.getAge();
	}

	


}