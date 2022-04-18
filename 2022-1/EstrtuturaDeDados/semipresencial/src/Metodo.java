public class Metodo {
    private int[] _stack;
    private int _size;
    private int _count;

    public Metodo(int size) {
        this.init(size, 1);
    }

    public Metodo(int size, int valueStart) {
        this.init(size, valueStart);
    }

    private void init(int size, int valueStart) {
        this._size = size;
        this._stack = new int[size];
        this.push(valueStart);
    }

    public void show() {
        for (int index = 0; index < this._size; index++) {
            System.out.print("|" + this._stack[index] + "|");
        }
        System.out.println();
    }

    public void showFull() {
        if (!isEmpty()) {
            for (int index = 0; index < this._count; index++) {
                System.out.print("|" + this._stack[index] + "|");
            }
            System.out.println();
        } else {
            System.out.println("A Pilhar esta vazio");
        }
    }

    public void push(int value) {
        if (!this.isFull()) {
            this._stack[this._count++] = value;
        } else {
            System.out.println("A Pilhar esta no máximo");
        }
    }

    public void pull(int value) {
        if (!this.isEmpty()) {
            this.pop();
            this.push(value);
        } else {
            this.push(value);
        }
    }

    public void pop() {
        if (!this.isEmpty()) {
            this._stack[--this._count] = 0;
        } else {
            System.out.println("A Pilhar esta vazio");
        }
    }

    public int top() {
        if (!this.isEmpty()) {
            return this._stack[this._count - 1];
        } else {
            System.out.println("A Pilhar esta vazio");
        }
        return -1;
    }

    private boolean isFull() {
        return this._count == this._size;
    }

    private boolean isEmpty() {
        return this._count == 0;
    }
}