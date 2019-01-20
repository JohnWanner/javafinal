package pkg;
import java.util.Date;
public class Product {
    //fields
    private String description;
    private long barcode;
    private String serialNumber;
    private pkg.GoldenTicket prizeTicket;

    //constructor

    public Product(String description,long barcode,String serialNumber/*,pkg.GoldenTicket prizeTicket*/){
        setDescription(description);
        setBarcode(barcode);
        setSerialNumber(serialNumber);
        setPrizeTicket(prizeTicket);
    }


    //setters and getters
    public void setDescription(String description){
        this.description = description;
    }
    public void setBarcode(long barcode){
        this.barcode = barcode;
    }
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    public void setPrizeTicket(pkg.GoldenTicket prizeTicket){
        this.prizeTicket = prizeTicket;
    }

    public String getDescription(){
        return this.description;
    }
    public long getBarcode(){
        return this.barcode;
    }
    public String getSerialNumber(){
        return this.serialNumber;
    }
    public pkg.GoldenTicket getPrizeTicket(){
        return this.prizeTicket;
    }
}


