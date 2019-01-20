package pkg;
import java.util.Date;


public class OompaLoompa extends pkg.Being {

    //fields
    private int height;
    private String favorite_food;
    //list of purchased products

    //constructor
    public OompaLoompa(){

    }

    public OompaLoompa(String code,String name,int height,String favorite_food){
        super(code,name);
        setHeight(height);
        setFavorite_food(favorite_food);

    }

    //getters and setters
    public int getHeight(){
        return this.height;
    }
    public String getFavorite_food(){
        return this.favorite_food;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public void setFavorite_food(String favorite_food){
        this.favorite_food = favorite_food;
    }
}


