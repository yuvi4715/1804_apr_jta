package Exceptions;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class TestCust {

    public void main(String[] args){

        try{
            pullCord();

        }
        catch(OverrideMsg e){
            e.getMessage();

        }
    }
    public void pullCord() throws OverrideMsg{
        if(true){
            throw new OverrideMsg();
        }
    }
}
