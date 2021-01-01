import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MAH {
    public static void main(String[] args) {
        int[] array = {6,2,5,4,5,1,6};
        int length = array.length;

        //Find indexes of nearest smaller left
        List<Integer> leftIndex = new ArrayList<>();
        //Find indexes of nearest smaller right
        List<Integer> rightIndex = new ArrayList<>();

        leftIndex = findLeft(array,length);
        rightIndex = findRight(array,length);

        System.out.println("Left : "+ leftIndex);
        System.out.println("Right : "+ rightIndex);

        List<Integer> area = new ArrayList<>();

        for(int i=0; i<length; i++){
            area.add(array[i]*(rightIndex.get(i) - leftIndex.get(i) -1));
        }

        System.out.println("Area : "+ area);

        System.out.println(Collections.max(area));
        
    }

    static List<Integer> findLeft(int[] array, int length) {

        Stack<Pair> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        //-1th index of array
        int pseudoIndex = -1;

        for(int i=0; i<length; i++) {

            if(stack.empty()){
                answer.add(pseudoIndex);
            }
            else if(!stack.empty() && stack.peek().getValue() < array[i]){
                answer.add(stack.peek().getIndex());
            }
            else if(!stack.empty() && stack.peek().getValue() >= array[i]){
                while(!stack.empty() && stack.peek().getValue() >= array[i]){
                    stack.pop();
                }
                if(stack.empty())
                    answer.add(pseudoIndex);
                else
                    answer.add(stack.peek().getIndex());
            }

            stack.push(new Pair(array[i],i));

        }

        return answer;

    }

    static List<Integer> findRight(int[] array, int length) {

        Stack<Pair> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        //Last index + 1
        int pseudoIndex = length;

        for(int i=length-1; i>=0 ; i--){

            if(stack.empty()){
                answer.add(pseudoIndex);
            }
            else if(!stack.empty() && stack.peek().getValue() < array[i]){
                answer.add(stack.peek().getIndex());
            }
            else if(!stack.empty() && stack.peek().getValue() >= array[i]){
                while(!stack.empty() && stack.peek().getValue() >= array[i]){
                    stack.pop();
                }
                if(stack.empty())
                    answer.add(pseudoIndex);
                else
                    answer.add(stack.peek().getIndex());
            }

            stack.push(new Pair(array[i], i));

        }

        Collections.reverse(answer);

        return answer;

    }
}

class Pair {
    private int value;
    private int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
