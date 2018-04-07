package BonusExercises;
import java.util.Arrays;
import java.util.ArrayUtils;
public class question55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "testString";
		char[] charArray = str.toCharArray();
		Character[] charObjectArray = ArrayUtils.toObject(charArray);
		System.out.println(charObjectArray);
	}

}
