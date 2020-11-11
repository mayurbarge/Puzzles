package interviewQuestions;

import java.io.*;
import java.util.*;

public class TestClass {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        int length = parkingStartEndTimes.length;
        if(length == 0) return  0;
        Arrays.sort(parkingStartEndTimes, (a,b)->a[0]-b[0]);

        for(int i = 0; i < parkingStartEndTimes.length; i ++) {
            System.out.println();
            for(int j = 0; j < parkingStartEndTimes[i].length; j ++) {
                System.out.print(" " + parkingStartEndTimes[i][j]);
            }
        }
        int max = 0;
        int count = length;

        for( int i = 0; i < length-1; i++) {
            int currentX = parkingStartEndTimes[i][0];
            int currentY = parkingStartEndTimes[i][1];
            int j = i+1;

            //for(int j= i+1; j < length; j ++) {
                int nextX = parkingStartEndTimes[j][0];
                int nextY = parkingStartEndTimes[j][1];

                if (currentX < nextX && currentY < nextY) {
                    count--;
                }


           /* if(max < count) {
                max = count;
            }*/

        }

        /*for( int i = parkingStartEndTimes[0][0]; i < parkingStartEndTimes[length-1][1]; i++) {
            for(int j= 0;j<length;j++) {
                int p = parkingStartEndTimes[j][0];
                int q = parkingStartEndTimes[j][1];
                System.out.println(p + " -- " + q);
                if(p<=i && q<=q-1) {
                    count++;
                }
            }
            if(max < count) {
                max = count;
            }

        }*/

        return count;

    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}