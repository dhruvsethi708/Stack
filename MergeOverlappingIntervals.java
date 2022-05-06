import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of entries");
        int n = sc.nextInt();

        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt(); // j is for starting and ending time
            }
        }


        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if(i==0){
                st.push(pairs[i]);
            }else{
                Pair top = st.peek();
                if(pairs[i].starttime > top.endtime){
                    st.push(pairs[i]);
                }else{
                    top.endtime = Math.max(top.endtime, pairs[i].endtime);
                }
            }
        }

        Stack <Pair> rs = new Stack<>();
        while (st.size()>0) {
            rs.push(st.pop());
        }

        while(rs.size()>0){
            Pair p = rs.pop();
            System.out.println(p.starttime + " " + p.endtime);
        }
    }



    public static class Pair implements Comparable<Pair>{
        int starttime;
        int endtime;

        Pair(int starttime, int endtime){
            this.starttime = starttime;
            this.endtime = endtime;
        }
        //this > other return +ve
        //this = other return 0
        //this < other return -ve
        public int compareTo(Pair other){
            if(this.starttime != other.starttime){
                return this.starttime - other.starttime;
            }else{
                return this.endtime - other.endtime;
            }
        }
    }

}
