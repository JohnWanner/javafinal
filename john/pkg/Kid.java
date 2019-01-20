package pkg;
import java.util.Date;
import java.util.Vector;


public class Kid extends pkg.Being {

    //fields
    private Date birthday;
    private String place_of_birth;
    //list of purchased products
    private Vector<pkg.Product> purchased_products = new Vector<>();

    //constructor
    public Kid(){

    }
    public Kid(String code,String name,Date birthday,String place_of_birth){
        super(code,name);
        setBirthday(birthday);
        setPlace_of_birth(place_of_birth);

    }

    //getters and setters
    public Date getBirthday(){
        return this.birthday;
    }
    public String getPlace_of_birth(){
        return this.place_of_birth;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public void setPlace_of_birth(String place_of_birth){
        this.place_of_birth = place_of_birth;
    }

    //extra
    public void addPurchased_products(pkg.Product product){
        purchased_products.add(product);
    }

    public Vector<pkg.Product> getPurchased_products(){
        return purchased_products;
    }

    //toString
    @Override
    public String toString(){
        return this.getName();
    }
}

