import java.lang.reflect.Array;
import java.util.Arrays;

//Reference: https://www.tutorialspoint.com/how-to-resize-an-array-in-java 

public class StringArray {
    private String[] array;
    private int actual_length;
    private int max_length;

    public StringArray(int init_length){
        this.max_length = init_length;
        this.array = new String[init_length];
        this.actual_length = 0;
    }

    public void append(String str){
        if(actual_length+1<=max_length){
            this.array[actual_length] = str;
            actual_length++;
        }else{
//            String[] temp = array.clone();
//            this.array = new String[max_length*2];
//            this.array = temp.clone();
            this.array = (String[]) resizeArray(this.array, max_length*2);
            array[actual_length] = str;
            actual_length++;
        }
    }

    private Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray;
    }

    public int size(){
        return actual_length;
    }

    public void printArray(){
        System.out.println(Arrays.stream(array).toArray());
    }
}
