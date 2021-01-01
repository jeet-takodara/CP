import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NGL{
    public static void main(String[] args) {
        int[] array = {1,4,7,5,6,8};
        int length = array.length;

        System.out.println(print(array,length));
    }

    static List<Integer> print(int[] array, int length) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<length; i++) {

            if(stack.empty()){
                answer.add(-1);
            }

            else if(!stack.empty() && stack.peek() > array[i]){
                answer.add(stack.peek());
            }

            else if(!stack.empty() && stack.peek() < array[i]) {
                //Pop from stack until empty or unless you find a element greater than array[i]
                while(!stack.empty() && stack.peek() <= array[i]) {
                    stack.pop();
                }

                if(stack.empty())
                    answer.add(-1);
                else{
                    answer.add(stack.peek());
                }
            }

            stack.push(array[i]);

        }
        return answer;
    }
}