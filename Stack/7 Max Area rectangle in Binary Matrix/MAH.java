import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MAH {
    
    public int mah(int[] array, int length) {

        List<Integer> leftIndex = new ArrayList<>();
        leftIndex = findLeft(array, length);
        List<Integer> rightIndex = new ArrayList<>();
        rightIndex = findRight(array, length);

        List<Integer> finalAnswer = new ArrayList<>();

        for(int i=0; i<length; i++) {
            finalAnswer.add(array[i] * (rightIndex.get(i) - leftIndex.get(i) - 1));
        }

        return Collections.max(finalAnswer);

    }

    private List<Integer> findLeft(int[] array, int length) {

        Stack<Pair> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
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
                if(stack.empty()){
                    answer.add(pseudoIndex);
                }
                else {
                    answer.add(stack.peek().getIndex());
                }
            }

            stack.push(new Pair(array[i], i));

        }

        return answer;

    }

    private List<Integer> findRight(int[] array, int length) {

        Stack<Pair> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int pseudoIndex = length;

        for(int i=length-1; i>=0; i--) {
            
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
                if(stack.empty()){
                    answer.add(pseudoIndex);
                } else {
                    answer.add(stack.peek().getIndex());
                }
            }

            stack.push(new Pair(array[i],i));
        }

        Collections.reverse(answer);

        return answer;

    }

}

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue(){
        return value;
    }

    public int getIndex() {
        return index;
    }
}