package com.test.binarysearch;
import java.util.HashSet;
import java.util.Set;

public class TestElevator {

    public int noOfStops(int[] A, int[] B, int M, int X, int Y) {
        
        if(A == null || A.length == 0){
            System.err.print("No person available for elevator!");
            return -1;
        }
        for(int i=0;i<B.length;i++){
            if(B[i] > M){
                System.err.print("Floor number can't be greater than available floor!");
                return -1;
            }
        }
        int totalStops = 0;
        int totalLiftWeight = 0;
        int noOfPerson = 0;
        Set<Integer> floors = new HashSet<>();
        boolean startElevator = false;
        int currentPerson = 0;
        while (currentPerson < A.length) {

            if (totalLiftWeight + A[currentPerson] <= Y && noOfPerson + 1 <= X) {
                totalLiftWeight = totalLiftWeight + A[currentPerson];
                noOfPerson++;
                floors.add(B[currentPerson]);

                if (currentPerson == A.length - 1) {
                    startElevator = true;
                }
                currentPerson++;

            } else {
                startElevator = true;
            }

            if (startElevator) {
                totalStops = totalStops + floors.size() + 1;
                floors.clear();
                noOfPerson = 0;
                totalLiftWeight = 0;
                startElevator = false;
            }
        }
        return totalStops;
    }

  

    public static void main(String[] args) {
        int[] A = new int[] { 40,40, 100, 80, 20 };
        int[] B = new int[] { 3, 3, 2,2,3 };
        int M = 5;
        int X = 2;
        int Y = 200;
        int stops = new TestElevator().noOfStops(A, B, M, X, Y);
        System.out.println(">>>>>>>::: " + stops);
//        

    }
}
