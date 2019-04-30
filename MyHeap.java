import java.util.Arrays;
public class MyHeap{
    private static void pushDown(int[]data,int size,int index){
      int childIndex1 = 2 * index + 1;
      int childIndex2 = 2 * index + 2;
      if(childIndex2 < size){
        if(data[childIndex2] > data[index] && data[childIndex2] > data[childIndex1]){
          swap(data,index,childIndex2);
          pushDown(data,size,childIndex2);
        } else if(data[childIndex1] > data[index] && data[childIndex1] >= data[childIndex2]){
          swap(data,index,childIndex1);
          pushDown(data,size,childIndex1);
        }
      }
    }
    private static void swap(int[] data, int index1, int index2){
      int temp = data[index1];
      data[index1] = data[index2];
      data[index2] = temp;
    }
    private static void pushUp(int[]data,int index){
      int parentIndex = index / 2;
      if(parentIndex < index && data[parentIndex] < data[index]){
        swap(data,parentIndex,index);
        pushUp(data,parentIndex);
      }
    }
    public static void heapify(int[] data){
      for(int x = data.length -1; x >= 0 ; x--){
        pushDown(data,data.length,x);
      }
    }
    public static void heapsort(int[] data){
      heapify(data);
      for(int x = data.length - 1; x > 0; x--){
        //System.out.println(Arrays.toString(data));
        swap(data,0,x);
        pushDown(data,x,0);
      }
    }
    public static void main(String[] args) {
      int[] data = {};
      heapsort(data);
      System.out.println(Arrays.toString(data));
    }
}
