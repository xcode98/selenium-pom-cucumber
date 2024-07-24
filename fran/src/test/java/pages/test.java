package pages;

public class test {
    public static void main(String[] args) {
            // Array of String storing days of the week
	    String days[] = { "Mon", "Tue", "Wed", "Thr", "Fri", "Sat", "Sun"};

	    // Enhanced for loop, this will automatically iterate on the array list 
	    for (String dayName : days) {
	      System.out.println("Days ==> "+ dayName);
	    	}

	    System.out.println("Decremento");
	    // Normal for loop
	    for (int i=6; i >= days.length; i--) {
	        System.out.println("Days ==> "+ days[i]);
	    	}
		}
}
