package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
	
    public static void main(String[] args) {
    	case2();
    }
    	
    	static void case1() {
    	Integer[] intArr = {1, 2, 2, 5, 4, 4, 7, 8, 9, 12, 65, 65, 46, 3, 23};
    	
    	Integer duplicates =  Arrays.asList(intArr)
    			.stream()
    			.collect(Collectors.groupingBy(i-> i, Collectors.counting()))
    			.entrySet()
    			.stream()
    			.filter(e -> e.getValue() > 1)
    			.map(e  -> e.getKey())
    			.reduce(0, (a, b) -> a+b);    			
    			
    	  System.out.println(duplicates);
    	}
    	
    	static void case2() {
    		//sort by digit in string
    		List<String> strings = Arrays.asList("abc123", "def456", "ghi789", "jkl012");
        	
        	List list = strings.stream()
        					.sorted(Comparator.comparingInt(Test1::extractDigit))
        					.collect(Collectors.toList());
        			
        	System.out.println(list);
        }
    
    	static int extractDigit(String s) {
    		return Integer.parseInt(s.replaceAll("[^\\d]", ""));
    	}
    	
}