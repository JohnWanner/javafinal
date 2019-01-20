package pkg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Kid> kids= new ArrayList<>();
	public static ArrayList<GoldenTicket> prizeTickets = new ArrayList<>();
    public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public static void main(String[] arguments) throws Exception{
        System.out.println("---Reading list of kids from kids.txt---");
        Files.readKids("kids.txt",kids);
        for(int i=0;i<kids.size();++i){
            System.out.println(kids.get(i).getCode() + " " + kids.get(i).getName() + " " + sdf.format(kids.get(i).getBirthday()) + " " + kids.get(i).getPlace_of_birth());
        }

        System.out.println("---Reading list of products from products.txt---");
        Files.readProducts("products.txt",products);
        for(int i=0;i<products.size();++i){
            System.out.println(products.get(i).getDescription() + " " + products.get(i).getBarcode() + " " + products.get(i).getSerialNumber());
        }
        System.out.println("");

        System.out.println("[How Many Golden Tickets Do You Want To Waffle?]");
        Scanner sc = new Scanner(System.in) ;
        int howmany = sc.nextInt();
		while(howmany>products.size()){
			System.out.println("Number of Golden Tickets can not be more than Number of Products!");
			System.out.println("Try Again!!");
			sc = new Scanner(System.in) ;
			howmany = sc.nextInt();
		}
        ruffle(products,howmany);

        System.out.println("[How Many Presents Do You Want To Register?]");
        sc = new Scanner(System.in) ;
        howmany = sc.nextInt();
		while(howmany>products.size()){
			System.out.println("You can not assingn more products than which exists!");
			System.out.println("Try Again!!");
			sc = new Scanner(System.in) ;
			howmany = sc.nextInt();
		}
        System.out.println("Please type in the kid's code and correspoding present's barcode");
        for(int i =1;i<=howmany;++i){
            System.out.print(i + ": ");
            sc = new Scanner(System.in) ;
            String line = sc.nextLine();
            sc = new Scanner(line) ;
            register(sc.next(),sc.nextLong());
        }


        System.out.println("WINNERS: Kids who have a golden ticket are" );
        winners();
		
		//GoldenTicket.listAll();
		//GoldenTicket.listRaffled();
		
		


        System.out.println("How many lines do you want the OompaLoompa song to be?");
        sc = new Scanner(System.in);
        int lines = sc.nextInt();
        pkg.OompaLoompaSong o = new pkg.OompaLoompaSong(lines);
        System.out.println(o.sing());

        pkg.Files.writeKids(kids);
        pkg.Files.writeProducts(products);



    }

    public static void ruffle(ArrayList<pkg.Product> products,int howmany) throws Exception{
        for(int i=0;i<howmany;++i){


           Random r = new Random();
           int random = r.nextInt(products.size());
            while(products.get(random).getPrizeTicket() != null){
                r = new Random();
                random = r.nextInt(products.size());
            }
            System.out.println("Golden Ticket assigned to: " + products.get(random).getDescription());
			GoldenTicket ticket = new pkg.GoldenTicket(""+(int)(Math.random()*1000),new Date());
			prizeTickets.add(ticket);
			
            products.get(random).setPrizeTicket(ticket);
        }
    }

    public static void register(String code,long barcode){
        int j = 0;
        while (j<kids.size() && !(kids.get(j).getCode().equals(code))){
            j++;
        }
        if(j<kids.size()){
            int i = 0;
            while(i<products.size()  && products.get(i).getBarcode() != barcode){
                i++;
            }
            if(i<products.size()){
                kids.get(j).addPurchased_products(products.get(i));
                System.out.println(products.get(i).getDescription() + " registered for " + kids.get(j).getName());
                products.remove(i);
            }
            else{
                System.out.println("ERROR : i out of index meaning no product left with such barcode ");
            }
        }
        else{
            System.out.println("ERROR : j out of index meaning no kid with such code");
        }


    }

    public static void winners() {
        //3ArrayList<pkg.Kid> winners = new ArrayList<>();
        for (int i = 0; i < kids.size(); ++i) {
            boolean hasGolden = false;
            for(int j=0;j<kids.get(i).getPurchased_products().size();++j){
                if (kids.get(i).getPurchased_products().get(j).getPrizeTicket()!=null) {
                    hasGolden = true;
                }
            }
            if(hasGolden){
                System.out.println(kids.get(i));
            }
        }
    }
}



