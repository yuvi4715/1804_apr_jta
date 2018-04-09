package AdvancedCodingExercises;

public class question43 {

	boolean isPrime (int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
