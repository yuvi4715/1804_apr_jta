package Exceptions;

class question14 {
    public static void main (String[] args) {
         
         int[] arr = new int[4];
         
        try {
            int i = arr[4];
                 
            System.out.println("Inside try block");
        }
         
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Exception caught in catch block");
        }
         
        finally {
            System.out.println("finally block executed");
        }
         
    }
}
