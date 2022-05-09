import java.util.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();

        //ADD
        que.add(10);
        System.out.println(que);        
        que.add(20);
        System.out.println(que);        
        que.add(30);
        System.out.println(que);
        
        // GET
        System.out.println(que.peek());
        System.out.println(que);

        //REMOVE
        System.out.println(que.remove());        
        System.out.println(que);
        
        System.out.println(que.remove());        
        System.out.println(que);
    }
}
