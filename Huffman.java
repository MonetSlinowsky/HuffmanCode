package huffman_code;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.PriorityQueue;

public class Huffman {
	
	public static void main(String[] args ) {
	//Need a list of symbols with their probability, preferably sorted...minheap
	PriorityQueue<HuffQSymbol> workingQ=new PriorityQueue<HuffQSymbol>(); 
		
	//Need the same list of symbols with their string representation...arrayList. Always add to front of list
	HashMap<String, ArrayList<String>> steadySymbols=new HashMap<String, ArrayList<String>>();
	steadySymbols.put("s1", new ArrayList<String>());
	steadySymbols.put("s2", new ArrayList<String>());
	steadySymbols.put("s3", new ArrayList<String>());
	steadySymbols.put("s4", new ArrayList<String>());
	steadySymbols.put("s5", new ArrayList<String>());
	steadySymbols.put("s6", new ArrayList<String>());
	steadySymbols.put("s7", new ArrayList<String>());
	steadySymbols.put("s8", new ArrayList<String>());
	
	/*System.out.println(steadySymbols.get("s1")); 
	steadySymbols.get("s1").add(0,"2");
	System.out.println(steadySymbols.get("s1"));*/
	
	workingQ.add(new HuffQSymbol("s1", 0.25));
	workingQ.add(new HuffQSymbol("s2", 0.21));
	workingQ.add(new HuffQSymbol("s3", 0.15));
	workingQ.add(new HuffQSymbol("s4", 0.14));
	workingQ.add(new HuffQSymbol("s5", 0.0625));
	workingQ.add(new HuffQSymbol("s6", 0.0625));
	workingQ.add(new HuffQSymbol("s7", 0.0625));
	workingQ.add(new HuffQSymbol("s8", 0.0625));
	
	HuffmanRun(workingQ, steadySymbols);
	
	//Print result
	steadySymbols.forEach((key, array)-> {
		
		System.out.print(key + " ");
		for(int i=0; i<array.size(); i++) {
			System.out.print(array.get(i));
		}
		System.out.println(" ");
		
	});

	}
	
	public static void HuffmanRun(PriorityQueue<HuffQSymbol> wQ, HashMap<String, ArrayList<String>> sMap) {
		
		//while
		while(true) {
			//Pop the first minimum 
			System.out.println("");
			HuffQSymbol low=wQ.remove();
			System.out.println(low.getName() + " " + low.getVal());
			//Pop the next minimum
			HuffQSymbol high=wQ.remove();
			System.out.println(high.getName() + " " + high.getVal());
			//Get their sum
			double sum=low.getVal() + high.getVal();
			//Push combined symbol with sum
			wQ.add(new HuffQSymbol(low.getName()+","+high.getName(), sum));
			System.out.println("");
			
			System.out.println("workingQ:");
			for(HuffQSymbol h: wQ) {
				System.out.println(h);
			}
			System.out.println("");
			
			//Give first minimum a 1
			if(low.getName().contains(",")) {
				String[] temp=low.getName().split(",");
				for(int i=0; i<temp.length; i++) {
					sMap.get(temp[i]).add(0, "0");
				}
			}
			
			else {
				sMap.get(low.getName()).add(0, "0");
			}
			//Give second minimum a 0
			if(high.getName().contains(",")) {
				String[] temp=high.getName().split(",");
				for(int i=0; i<temp.length; i++) {
					sMap.get(temp[i]).add(0, "1");
				}
			}
			else {
			sMap.get(high.getName()).add(0, "1");
			}
			
			//If sum is greater than or equal to 1, break
			if(sum >= 1) {
				break;
			}
			
			System.out.println("Map");
			sMap.forEach((key, array)-> {
				
				System.out.print(key + " ");
				for(int i=0; i<array.size(); i++) {
					System.out.print(array.get(i));
				}
				System.out.println(" ");
				
			});

			
		
	}//while
		
		
	}//function
	
}//class


