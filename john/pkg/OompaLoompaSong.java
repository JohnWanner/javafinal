package pkg;
import java.util.ArrayList;
import java.util.Random;

public class OompaLoompaSong {
    //fields
    private int lines;
    private ArrayList<String> lyrics = new ArrayList<>();


    //constructor
    public OompaLoompaSong(int lines) throws Exception{
        this.lines = lines;
        pkg.Files.readSong("song.txt",lyrics);

    }


    public String sing(){
        String output = new String("");
        for(int i=0;i<lines;++i){
            Random r = new Random();
            int random = r.nextInt(23);
            output = output + "\n" +lyrics.get(random);
        }
        return output;
    }


}
