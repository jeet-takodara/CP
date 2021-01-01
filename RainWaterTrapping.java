public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] array = {3,0,2,0,0,4};
        int length = array.length;

        System.out.println(find(array,length));
    }

    static int find(int[] array, int length){
        
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        int[] waterAboveBuilding = new int[length];

        maxLeft[0] = array[0];

        for(int i=1; i<length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], array[i]);
        }

        maxRight[length-1] = array[length-1];

        for(int i=length-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], array[i]);
        }

        for(int i=0; i<length; i++) {
            waterAboveBuilding[i] = Math.min(maxLeft[i], maxRight[i]) - array[i];
        }

        int sum = 0;

        for(int i=0; i<length; i++) {
            sum = sum + waterAboveBuilding[i];
        }

        return sum;

    }
}