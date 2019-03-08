import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class USACO{
private static int [][] pasture;
 public static int bronze(String filename){
     ArrayList <String []> potato = new ArrayList <String []> ();
     try {
         // System.out.println("h");
         File tex = new File(filename);
         Scanner inf = new Scanner(tex);
         // make arralist of lines of the text file
         while(inf.hasNextLine()){
             String line = inf.nextLine();
             line.split(" ", 0);
             String [] maybe = line.split(" ", 0);
             // System.out.println(Arrays.toString(maybe));
             potato.add(maybe);
         }
         //initializing and declaring variables
         // need a way to isolate the numbers
         // think i have to do parseInt
         int rows = Integer.parseInt(potato.get(0)[0]);
         // System.out.println("rows" + rows);
         int cols = Integer.parseInt(potato.get(0)[1]);
          // System.out.println("cols" + cols);
         int elevation = Integer.parseInt(potato.get(0)[2]);
          // System.out.println("elevation" + elevation);
         int n = Integer.parseInt(potato.get(0)[3]);
          // System.out.println("n" + n);
         pasture = new int [rows][cols];

         // make pasture
         // System.out.println("cols:" + cols);
         for (int x = 1; x < rows + 1; x ++){
             for (int y = 0; y < cols; y ++){
                 pasture [x - 1] [y] = Integer.parseInt(potato.get(x)[y]);
             }
             // System.out.println("hellooo?");
         }
         // System.out.println("k");
        // cow stomping
        for (int i = rows + 1; i < potato.size(); i ++){
            int R_s = Integer.parseInt(potato.get(i)[0]) - 1;
            // System.out.println("Rs" + R_s);
            int C_s = Integer.parseInt(potato.get(i)[1]) - 1;
                        // System.out.println("Cs" + C_s);
            int D_s = Integer.parseInt(potato.get(i)[2]);
                        // System.out.println("Ds" + D_s);

            stomping (R_s, C_s, D_s, pasture, rows, cols);
        }
        // calculate volume
        int sum = 0;
        for (int x = 0; x < rows; x ++){
            for (int y = 0; y < cols; y ++){
                // sum + how deep it is
                if (elevation - pasture [x][y] > 0){
                    // System.out.println(x);
                    // System.out.println(y);
                sum =  sum + (elevation - pasture [x][y]);
                }
            }
        }
        // System.out.println(sum);
        return sum * 72 * 72;
     }
     catch (FileNotFoundException e){
         // System.out.println("sad");
         return 0;
     }

}
 public static void stomping (int R_s, int C_s, int D_s, int [][] pasture, int rows, int cols){
     if (D_s == 0){
        ;
     }
     else{
     int max = pasture [R_s][C_s];
     for (int x = R_s; x < R_s + 3; x ++){
         for (int y = C_s; y < C_s + 3; y ++){
             if (pasture [x][y] > max){
                 max = pasture [x][y];
             }
     }
 }
 for (int x = R_s; x < R_s + 3; x ++){
     for (int y = C_s; y < C_s + 3; y ++){
         if (pasture [x][y] == max){
             pasture [x][y] --;
         }
 }
}
D_s --;
// String d = "";
// for (int x = 0; x < rows; x ++){
//     for (int y = 0; y < cols; y ++){
//         d = d + pasture [x][y] + " ";
//     }
//     d = d + "\n";
// }
        // System.out.print(d);

stomping (R_s, C_s, D_s, pasture, rows, cols);
}
}
public static int silver(String filename){
    ArrayList <String> mashed = new ArrayList <String> ();
    try {
        File tex = new File(filename);
        Scanner inf = new Scanner(tex);
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
        }
        land [startr][startc] = 1;
            return helper (time, land, endr, endc, rows, cols);
    }
    catch (FileNotFoundException e){
        System.out.println("sad");
        return 0;
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
