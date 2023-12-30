import java.util.Arrays;

public class CustomArrayList {

    private int[] arr;
    private int size;

    CustomArrayList() {
        this.arr = new int[10];
        this.size = 0;
    }

    CustomArrayList(int initialSize) {
        this.arr = new int[initialSize];
        this.size = 0;
    }

    public void add(int element) {
        if (this.arr.length == this.size) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.arr[this.size] = element;
        this.size++;
    }

    public void add(int index, int element) {
        if (index < 0 || index > this.size) return;
        if (this.arr.length == this.size) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.arr[i+1] = this.arr[i];
        }
        this.arr[index] = element;
        this.size++;
    }

    public int get(int index) {
        if (index < 0 || index > this.size - 1) return 0;
        return this.arr[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isIn(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int find(int element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int element) {
        int indexToRemove = this.find(element);
        if (indexToRemove == -1) return;
        for (int i = indexToRemove; i < this.size - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.size--;
    }

    public String toPrint() {
        StringBuilder res = new StringBuilder("[");
        for(int i = 0; i < this.size - 1; i++) {
            res.append(this.arr[i]).append(", ");
        }
        res.append(this.arr[this.size - 1]).append("]");
        return res.toString();
    }


    public void print() {
        System.out.println(this.toPrint());
    }

}