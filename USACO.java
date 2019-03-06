import java.util.*;
public class USACO{
private int rows;
private int cols;
 public static int bronze(String filename){
     // set rows =
     // set cols = 
     int [][] cows = new int [3][3];
     int [][] pasture = new int [rows][cols];
     Scanner inf = new Scanner(text);
     ArrayList <String> potato = new ArrayList <String> ();
     while(inf.hasNextLine()){
         String line = inf.nextLine();
         potato.add(line);//hopefully you can do other things with the line
     }
     int y = potato.size();
     int x = potato.get(0).length();
     for (int q = 1; q < rows - 2 ; q ++){
         for (int w = 0; w < cols ; w ++){
             pasture[q][w] = potato.get(q).charAt(w);
     }
 }
 }
}
