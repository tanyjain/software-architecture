import javax.swing.*;
import java.awt.*;

public class Manager {
    private QueueOfCustomers queue;
    private ParcelMap parcelMap;
    private Worker worker;

    public Manager() {
        queue = new QueueOfCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker();
    }

    private void loadSampleData() {
        // Add sample parcels
        parcelMap.addParcel(new Parcel("P1", 2.5));
        parcelMap.addParcel(new Parcel("P2", 1.8));
        parcelMap.addParcel(new Parcel("P3", 3.2));

        // Add sample customers
        queue.addCustomer(new Customer("John", "P1"));
        queue.addCustomer(new Customer("Alice", "P2"));
        queue.addCustomer(new Customer("Bob", "P3"));
    }

    private void startGUI() {
        JFrame frame = new JFrame("Parcel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        frame.add(new JScrollPane(logArea), BorderLayout.CENTER);

        JButton processButton = new JButton("Process Next Customer");
        processButton.addActionListener(e -> {
            if (!queue.isEmpty()) {
                Customer customer = queue.getNextCustomer();
                worker.processCustomer(customer, parcelMap);
                logArea.setText(Log.getInstance().toString());
            } else {
                logArea.append("No more customers in queue.\n");
            }
        });

        frame.add(processButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Manager manager = new Manager();
            manager.loadSampleData();
            manager.startGUI();
        });
    }
}
