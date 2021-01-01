public class MARIBM {
    public static void main(String[] args) {
        int[][] array = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int row = array.length;
        int col = array[0].length;

        System.out.println(findMaxArea(array,row,col));
    }

    static int findMaxArea(int[][] array, int row, int col) {

        int[] indexArray = new int[col];
        MAH m = new MAH();

        for(int i=0; i<col; i++) {
            indexArray[i] = array[0][i]; 
        }

        int max = m.mah(indexArray,indexArray.length);

        for(int i=1;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(array[i][j] == 0){
                    indexArray[j] = 0;
                } else {
                    indexArray[j] = indexArray[j]+array[i][j];
                }
            }
            max = Math.max(max, m.mah(indexArray, indexArray.length));
        }

        return max;

    }
}