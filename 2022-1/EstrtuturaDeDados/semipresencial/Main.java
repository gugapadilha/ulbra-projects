

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(10);
        stack.push(9);
        stack.push(12);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        stack.pull(3);
        stack.push(9);
        stack.push(12);
        stack.pop();
        stack.push(6);

        System.out.println("-----------------");
        System.out.println(stack.top());
        System.out.println("-----------------");
        stack.showFull();
        System.out.println("-----------------");
        stack.show();
    }
}
