package pkg;
import java.util.Date;

public class GoldenTicket {

    //fields
    private String code;
    private Date raffled;
    //private boolean isRaffled;

    //Constructors:
    public GoldenTicket(){

    }
    public GoldenTicket(String code, Date raffled){
        setCode(code);
        setRaffled(raffled);
    }


    // Getters and Setters
    public void setCode(String code){
        this.code = code;
    }
    public void setRaffled(Date raffled){
        this.raffled = raffled;
    }

    public String getCode(){
        return this.code;
    }
    public Date getRaffled(){
        return this.raffled;
    }
    //other methods
    // If the current ticket has been already raffled
    boolean isRaffled(){
        return(raffled != null);
    }
	
	//static method
	//list all prize tickets
	public static void listAll(){
		for(int i=0;i<Main.prizeTickets.size();++i){
			System.out.println(Main.prizeTickets.get(i).getCode() + " " + Main.sdf.format(Main.prizeTickets.get(i).getRaffled()));
		}
	}
	
	public static void listRaffled(){
		for(int i=0;i<Main.prizeTickets.size();++i){
			if(Main.prizeTickets.get(i).isRaffled()){
				System.out.println(Main.prizeTickets.get(i).getCode() + " " + Main.sdf.format(Main.prizeTickets.get(i).getRaffled()));
			}
		}
	}
}
