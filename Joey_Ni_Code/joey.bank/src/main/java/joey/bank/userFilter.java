package joey.bank;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

public class userFilter implements Predicate {
	private String stringCheck=null;
	private Integer colNumber=null;

	public userFilter(String stringCheck, Integer colNumber)
	{
		this.stringCheck=stringCheck;	
		this.colNumber=colNumber;
	
	}
	
	

	@Override
	public boolean evaluate(RowSet rs) {
	/*Two column check
	 * 	CachedRowSet crs = (CachedRowSet)rs;
	 *
	    for (int i = 0; i < colNumber.length; i++) {

	        try {
				if (crs.getString(colNumber[i]).equals(stringCheck[i])==false)
				{    return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return true;
	}*/
	//	One variable version:
	  CachedRowSet frs = (CachedRowSet)rs;
        boolean evaluation = false;
        try {
        	String columnValue = null;
        
        	if (this.colNumber > 0) {
        		columnValue = frs.getString(this.colNumber);
        	}else return false;
        	
        	if (columnValue.equals(this.stringCheck)) { evaluation=true;}
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (NullPointerException npe) {
            System.err.println("NullPointerException caught");
            return false;
        }
        return evaluation;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		boolean evaluation = false;
		String columnValue=null;
		if(this.colNumber==column) {
			columnValue = String.valueOf(value) ; 
		}
		if (columnValue.equals(this.stringCheck))
			{	evaluation =true;}
		else evaluation=false;
	
        return evaluation;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
