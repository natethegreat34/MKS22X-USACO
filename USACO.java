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
     int [][] pasture = new int [rows][cols];

     // make pasture
     for (int q = 1; q < rows - 2 ; q ++){
         for (int w = 0; w < cols ; w ++){
             pasture[q][w] = potato.get(q).charAt(w);
     }
 }
    for (int i = rows + 1; i < potato.size(); i ++){
        stomper (potato.get(i));
        stomping ();
    }
}
 public void stomper (String s){
     R_s = s.charAt(0);
     C_s = s.charAt(1);
     D_s = s.charAt(2);
 }
 public void stomping (){
     if (D_s <= 0){
         ;
     }
     else{
     int max = pasture [R_s][C_s];
     for (int x = R_s; x < R_s + 3; x ++){
         for (int y = C_s; x < C_s + 3; y ++){
             if (pasture [x][y] > max){
                 max = pasture [x][y];
             }
     }
 }
 for (int x = R_s; x < R_s + 3; x ++){
     for (int y = C_s; x < C_s + 3; y ++){
         if (pasture [x][y] == max){
             pasture [x][y] --;
         }
 }
}
D_s --;
stomping ();
}
}

     //wait till number isn't higher
     // find max
     //stomp
     //check again with d_s -
     // find max
     // stomp
 }
}
