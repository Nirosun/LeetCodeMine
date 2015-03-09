class MinStack {

    class Stack {
        class Node {
            int val;
            Node next;
        }

        Node head = new Node();
        int size = 0;

        public void push(int x) {
            Node n = new Node();
            n.val = x;

            n.next = head;
            head = n;

            size ++;
        }

        public void pop() {
            head = head.next;
            size --;
        }

        public int top() {
            return head.val;
        }

    }

    Stack data = new Stack();
    Stack mins = new Stack();

    public void push(int x) {
        data.push(x);

        if (mins.size == 0 || x <= getMin())   {
            mins.push(x);
        }
    }

    public void pop() {
        int x = data.top();
        data.pop();

        if (x <= getMin()) {
            mins.pop();
        }
    }

    public int top() {
        return data.top();
    }

    public int getMin() {
        return mins.top();
    }
}
