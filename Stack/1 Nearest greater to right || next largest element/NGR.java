import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class NGR {

    public static void main(String[] args) {
        int[] array = {1,4,7,5,6,8};
        int size = array.length;

        System.out.println(print(array,size));
    }

    static List<Integer> print(int[] array, int length) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = length-1; i>=0; i--) {
            if(stack.empty()) {
                answer.add(-1);
            }

            else if(!stack.empty() && stack.peek() > array[i]){
                answer.add(stack.peek());
            }

            else if(!stack.empty() && stack.peek() < array[i]){
                //Pop element from stack until it is empty or unless you find a greater one
                while(!stack.empty() && stack.peek() <= array[i]){
                    stack.pop();
                }

                if(stack.empty())
                    answer.add(-1);
                else
                    answer.add(stack.peek());
            }

            stack.push(array[i]);
        }

        Collections.reverse(answer);

        return answer;

    }

}