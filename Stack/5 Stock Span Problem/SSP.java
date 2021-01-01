import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SSP {
    public static void main(String[] args) {
        int[] array = {100,80,60,70,60,75,85};
        int length = array.length;

        print(array,length);
    }

    static void print(int[] array, int length) {

        //Stack will store greatest element in left value with it's index i.e (value,index)
        Stack<Pair> stack = new Stack<>();
        //Answer List will store index of greatest value in left
        List<Integer> answer = new ArrayList<>();
        //finalAnswer to store i-index(from answer list)
        List<Integer> finalAnswer = new ArrayList<>();

        for(int i=0; i<length; i++) {

            if(stack.empty()){
                answer.add(-1);
            }
            else if(!stack.empty() && stack.peek().getValue() > array[i]){
                answer.add(stack.peek().getIndex());
            }
            else if(!stack.empty() && stack.peek().getValue() <= array[i]){
                //Pop until stack is empty or unless you find greatest element
                while(!stack.empty() && stack.peek().getValue() <= array[i]){
                    stack.pop();
                }
                if(stack.empty()){
                    answer.add(-1);
                } else {
                    answer.add(stack.peek().getIndex());
                }
            }

            stack.push(new Pair(array[i], i));

        }

        System.out.println("Answer list: "+ answer);

        for(int i=0; i< length; i++){
            finalAnswer.add(i, (i-answer.get(i)));
        }

        System.out.println(finalAnswer);

    }
}

class Pair {
    Integer value,index;

    public Pair(Integer value, Integer index){
        this.value = value;
        this.index = index;
    }

    public Integer getValue(){
        return value;
    }

    public Integer getIndex(){
        return index;
    }
}