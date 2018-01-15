package huffman_code;

public class HuffQSymbol implements Comparable<Object>{

	private String name;
	private Double val;
	
	public HuffQSymbol(String name, double val) {
		this.name=name;
		this.val=val;
		
	}
	
	public Double getVal() {
		return val;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVal(double val){
		this.val=val;
	}
	
	@Override
	public int compareTo(Object o) {
		
	if(o.getClass()!= getClass() || o==null) {
		System.out.println("Not valid object");
		System.exit(0);
	}
		
	HuffQSymbol other= (HuffQSymbol) o;
	
	
	//If equal, return 0
	if(val==other.getVal()) {
		return 0;
	}
	
	//If other comes before this, return positive 1
	if(other.val < val) {
		return 1;
	}
	
	//If other comes after this 
	else 
		return -1;
	
	}
	
	public String toString() {
		return name + " " + val; 
	}
	
}
