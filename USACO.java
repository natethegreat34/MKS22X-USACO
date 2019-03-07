import java.util.*;
public class USACO{
private int rows;
private int cols;
private int elevation;
private int n;
private int R_s;
private int C_s;
private int D_s;
 public static int bronze(String filename){
     ArrayList <String> potato = new ArrayList <String> ();
     Scanner inf = new Scanner(text);
     while(inf.hasNextLine()){
         String line = inf.nextLine();
         potato.add(line);//hopefully you can do other things with the line
     }

     rows = potato.get(0).charAt(0);
     cols = potato.get(0).charAt(1);
     elevation = potato.get(0).charAt(2);
     n = potato.get(0).charAt(3);
     int [][] cows = new int [3][3];
     int [][] pasture = new int [rows][cols];

     // make pasture
     for (int q = 1; q < rows - 2 ; q ++){
         for (int w = 0; w < cols ; w ++){
             pasture[q][w] = potato.get(q).charAt(w);
     }
 }
}
 public void stomper (String s){
     R_s = s.charAt(0);
     C_s = s.charAt(1);
     D_s = s.charAt(2);
 }
}
