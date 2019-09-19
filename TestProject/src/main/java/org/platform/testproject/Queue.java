public class Queue{
    // Create a class to hold the queue data structure
    private int startIndex;
    private int endIndex;
    private int[] arr;

    public Queue(){
        arr = new int[8];
        startIndex = -1;
        endIndex = 0;
    }

    
     // add (store) an item to the queue.
    public void enQueue(int item){
        if (this.isFull()){
            System.out.println("The queue is full, please dequeue first to continute");
            return;
        }
        else if (endIndex == arr.length-1 && startIndex>0)
        {
            shiftBack();
        }
        this.arr[endIndex] = item;
        this.endIndex += 1; 
    }

    public void shiftBack(){
        for (int i = startIndex; i<endIndex; i++){
            // temp = arr[i+1];
            arr[i-1] = arr[i];
        }
        startIndex -= 1;
        endIndex -= 1;
    }
   
    // remove (access) an item from the queue.
    public void deQueue(int item){
        if (isEmpty()){
            System.out.println("The queue is empty, please add item to queue to continue");
            return;
        }
        else if (startIndex == arr.length-1)
        {
            shiftForward();
        }
        
        this.startIndex += 1;
    }
    public void shiftForward(){
        for (int i = startIndex; i<endIndex; i++){
            // temp = arr[i+1];
            arr[i-1] = arr[i];
        }
        startIndex -= 1;
        endIndex -= 1;
    }
   
    
    // Gets the element at the front of the queue without removing it.
    public int peek(){
        return arr[startIndex];
    }

    // Checks if the queue is full
    public Boolean isFull(){
        if (this.endIndex-this.startIndex == arr.length-1){
            return false;
        }
        else{
            return true;
        }
    }

    // Checks if the queue is empty.
    public Boolean isEmpty(){
        if (this.startIndex < 0){
            return true;
        }
        else{
            return false;
        }
    }


}