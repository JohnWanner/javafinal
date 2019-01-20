package pkg;
import java.util.Date;


public abstract class Being {

    //fields
    private String code;
    private String name;

    //constructor
    public Being(){

    }

    public Being(String code,String name){
        setCode(code);
        setName(name);
    }

    //getters and setters
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }


}
