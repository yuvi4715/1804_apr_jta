package assignment.Joey;

public class CoreJava1{
	public static void main(String[] args) {
		//could use a general main or separate main for each
		
	}
    public static boolean isZero(int x, int y){
          if (x==0 || y==0){
                 System.out.println("Numbers have to be non-zero.");
                 return true;
          }
          else return false;
    }
    public void addNum(int x, int y){
          int result;
          if(!isZero(x, y)){
                result=x+y;
                System.out.println("Result of addition="+result);
          }
    }
    public void subtractNum(int x,int y){
          if(!isZero(x,y)){
                System.out.println("Result of subtraction="+Math.abs(x-y));
          }
    }
    public void multiplyNum(int x, int y){
          if(!isZero(x,y)){
                System.out.println("Result of multiplication="+(x*y));
          }
    }
    public void divideNum(int x, int y){
          if(!isZero(x,y)){
                System.out.println("Result of division="+(x/y));
          }
    }
}
