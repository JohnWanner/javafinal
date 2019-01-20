package pkg;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Files {
    public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    public static void readKids(String filename, ArrayList<pkg.Kid> kids) throws Exception{
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner line_scan = new Scanner(line);
                kids.add(new pkg.Kid(line_scan.next(),line_scan.next(),sdf.parse(line_scan.next()),line_scan.next()));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readProducts(String filename, ArrayList<pkg.Product> products) throws Exception{
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner line_scan = new Scanner(line);
                products.add(new pkg.Product(line_scan.next(),line_scan.nextLong(),line_scan.next()));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readSong(String filename, ArrayList<String> lyrics) throws Exception{
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lyrics.add(line);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeKids(ArrayList<pkg.Kid> kids) /*throws IOException*/ {
        String fileContent = "";
        for(int i=0; i<kids.size();++i) {
            fileContent = fileContent + "\n" + kids.get(i).getCode() +" " + kids.get(i).getName() +" "+ sdf.format(kids.get(i).getBirthday()) +" " + kids.get(i).getPlace_of_birth();
        }
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("kids_output.txt"));
			writer.write(fileContent);
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    }

    public static void writeProducts(ArrayList<pkg.Product> products) throws IOException {
        String fileContent = "";
        for(int i=0; i<products.size();++i) {
            fileContent = fileContent + "\n" + products.get(i).getDescription() +" " + products.get(i).getBarcode() +" "+ products.get(i).getSerialNumber();
        }
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("products_output.txt"));
			writer.write(fileContent);
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    }


}


