package hackerranck;

public class EqualizeArray{
    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> arrCount = new HashMap<Integer, Integer>();
        for (Integer num: arr){
            if (arrCount.containsKey(num)){
                arrCount.put(num, arrCount.get(num) +1);
            }
            else {
                arrCount.put(num, 1);
            }
        } 
        int arrLen = arr.length;
        int minRemoved = arrLen;
        int equalizeRemoved = 0;
        for (Integer key: arrCount.keySet()){
            equalizeRemoved = arrLen - arrCount.get(key);
            if (equalizeRemoved < minRemoved){
                minRemoved = equalizeRemoved; 
            }
        }
        return minRemoved;
    }
}