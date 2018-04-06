/**
 * Created by bryanvillegas on 4/6/18.
 */
import org.apache.log4j.Logger;
public class ClassExm {

    final static Logger Log = Logger.getLogger(ClassExm.class);

    public static void main(String[] args){
        System.out.print("Hello");
        Log.info("info should be printed");
        Log.warn("warning should be prined");
        Log.error("error should be printed");
        Log.debug("debug should be printed");
    }
}
