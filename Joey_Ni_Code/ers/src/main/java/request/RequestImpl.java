package request;
/**
 * Database procedures: Timestamp trigger after updates on request status
 * @author joeyi
 *
 */
public class RequestImpl implements RequestDAO {
	private static RequestImpl instance;
	
	private RequestImpl() {}//never called outside the class
	
	public static RequestImpl getInstance()
	{
		if(instance==null) instance = new RequestImpl();
		return instance;
	}

}
