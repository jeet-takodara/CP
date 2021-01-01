import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NSL {
    public static void main(String[] args) {
        int[] array = {4,5,1,6,0,8};
        
        System.out.println(print(array,array.length));
    }

    static List<Integer> print(int[] array, int length) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<length; i++) {

            if(stack.empty()){
                answer.add(-1);
            }

            else if(!stack.empty() && stack.peek() < array[i]){
                answer.add(stack.peek());
            }

            else if(!stack.empty() && stack.peek() >= array[i]) {
                //Pop until stack empty or unless you find a smaller element than array[i]
                while(!stack.empty() && stack.peek() >= array[i]){
                    stack.pop();
                }

                if(stack.empty())
                    answer.add(-1);
                else
                    answer.add(stack.peek());
            }

            stack.push(array[i]);

        }

        return answer;

    }
}