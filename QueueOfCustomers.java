import java.util.LinkedList;

public class QueueOfCustomers {
    private LinkedList<Customer> queue;

    public QueueOfCustomers() {
        queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.addLast(customer);
    }

    public Customer getNextCustomer() {
        return queue.pollFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
