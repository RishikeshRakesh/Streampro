package Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Streamexample {
	public static void main(String [] args) {
//     List<String> li=Arrays.asList("karur", "Chennai", "Coimbatore");
//     li.stream()
//     .filter(s -> s.startsWith("C"))
//     .map(s -> s.toUpperCase())
//     .forEach(System.out :: println);
      
		List<List<String>>listOflists=Arrays.asList(
				Arrays.asList("Reflection","Collection","Stream"),
				Arrays.asList("","Collection","Stream"),
				Arrays.asList("Reflection","Collection","Stream")
				);
		//create a setto hold intermediate results
		Set<String>intermediateResults=new HashSet<>();
		
		//Stream pipeline demonstrating various intermediate operations
		List<String>result=listOflists.stream()
		.flatMap(List::stream)                //Flatten the list of lists into a single stream
		.filter(s->s.startsWith("S"))         //Filter elements starting with 'S'
		.map(String::toUpperCase)             //transform each element to uppercase
		.distinct()                           //remove duplicate elements
		.sorted()                             //sort elements   
		.peek(s->intermediateResults.add(s))  //perform an action(add to set)o each element
		.collect(Collectors.toList());        //collect the final result into a list
		
		
		//print the intermediate results
		System.out.println("Intermediate Results:");
		intermediateResults.forEach(System.out::println);
		
		
		//print the final result
		System.out.println("Final Result:");
		result.forEach(System.out::println);

             
}
}