import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
 public static int bronze(String filename){
     ArrayList <String> potato = new ArrayList <String> ();
     File tex = new File(filename);
     Scanner inf = new Scanner(tex);
     while(inf.hasNextLine()){
         String line = inf.nextLine();
         potato.add(line);//hopefully you can do other things with the line
     }
     int R_s;
     int C_s;
     int D_s;
     int rows = potato.get(0).charAt(0);
     int cols = potato.get(0).charAt(1);
     int elevation = potato.get(0).charAt(2);
     int n = potato.get(0).charAt(3);
     int [][] pasture = new int [rows][cols];

     // make pasture
     for (int q = 1; q < rows - 2 ; q ++){
         for (int w = 0; w < cols ; w ++){
             pasture[q][w] = potato.get(q).charAt(w);
         }
     }
    // cow stomping
    for (int i = rows + 1; i < potato.size(); i ++){
        R_s = potato.get(i).charAt(0);
        C_s = potato.get(i).charAt(1);
        D_s = potato.get(i).charAt(2);
        stomping (R_s, C_s, D_s, pasture);
    }
    // calculate volume
    int sum = 0;
    for (int x = 0; x < rows; x ++){
        for (int y = 0; x < cols; y ++){
            sum =  sum + elevation - pasture [x][y];
        }
    }
    // depth times area
    return sum * 36;
}
 public static void stomping (int R_s, int C_s, int D_s, int [][] pasture){
     if (D_s == 0){
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
stomping (R_s, C_s, D_s, pasture);
}
}
public static int silver(String filename){
    ArrayList <String> mashed = new ArrayList <String> ();
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    while(inf.hasNextLine()){
        String line = inf.nextLine();
        mashed.add(line);//hopefully you can do other things with the line
    }

    int rows = mashed.get(0).charAt(0);
    int cols = mashed.get(0).charAt(1);
    int time = mashed.get(0).charAt(2);

    int startr = mashed.get(rows + 1).charAt(0);
    int startc = mashed.get(rows + 1).charAt(1);
    int endr = mashed.get(rows + 1).charAt(2);
    int endc = mashed.get(rows + 1).charAt(3);
    int [][] land = new int [rows][cols];

    // make land
    for (int q = 1; q < rows - 2 ; q ++){
        for (int w = 0; w < cols ; w ++){
            if (mashed.get(q).charAt(w) == '*'){
            land [q][w] = -1;
        }
    }
    land [startr][startc] = 1;
    return helper (time, land, endr, endc, rows, cols);

}
}// 0s become ones and 1s become zeros
public static int helper (int time, int [][] land, int er, int ec, int rows, int cols){
    if (time > 0){
        for (int x = 0; x < rows; x ++){
            for (int y = 0; y < cols; y ++){
                if (land [x] [y] > 0){
                    // v
                    if (x + 1 < rows && land [x + 1] [y] != -1 ){
                    land [x + 1] [y] ++;
                    }
                    // ^
                    if (x -1  > 0 && land [x - 1] [y] != -1){
                    land [x - 1] [y] ++;
                    }
                    // >
                    if (y + 1 < rows && land [x] [y + 1] != -1){
                    land [x] [y + 1] ++;
                    }
                    //<
                    if (y -1  > 0 && land [x] [y - 1] != -1){
                    land [x] [y - 1] ++;
                    }
                    land [x][y] = 0;
                }

                }
        }
        helper (time - 1, land, er, ec, rows, cols);
    }
    return land [er][ec];
}

     //wait till number isn't higher
     // find max
     //stomp
     //check again with d_s -
     // find max
     // stomp
 }
