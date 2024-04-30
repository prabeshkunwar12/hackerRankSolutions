package lettersequences;

public class TestQueue {
    public static void main(String[] args) {
        QueueWithTowStacks queue = new QueueWithTowStacks();
        queue.push(4);
        queue.push(3);
        System.out.println(queue.toString());
        System.out.println(queue.pop());
    }
}
