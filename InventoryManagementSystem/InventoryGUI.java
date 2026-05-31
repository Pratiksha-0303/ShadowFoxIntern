import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryGUI extends JFrame {

    JTextField txtBarcode;
    JTextField txtName;
    JTextField txtPrice;
    JTextField txtQty;

    JTable table;
    DefaultTableModel model;

    public InventoryGUI() {

        setTitle("Inventory Management System");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        txtBarcode = new JTextField(10);
        txtName = new JTextField(10);
        txtPrice = new JTextField(10);
        txtQty = new JTextField(10);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(new JLabel("Barcode"));
        panel.add(txtBarcode);

        panel.add(new JLabel("Name"));
        panel.add(txtName);

        panel.add(new JLabel("Price"));
        panel.add(txtPrice);

        panel.add(new JLabel("Quantity"));
        panel.add(txtQty);

        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{
                        "Barcode",
                        "Name",
                        "Price",
                        "Quantity",
                        "Total Value"
                }, 0);

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addProduct());

        updateBtn.addActionListener(e -> updateProduct());

        deleteBtn.addActionListener(e -> deleteProduct());

        setVisible(true);
    }

    private void addProduct() {

        try {

            String barcode = txtBarcode.getText();
            String name = txtName.getText();

            double price =
                    Double.parseDouble(txtPrice.getText());

            int qty =
                    Integer.parseInt(txtQty.getText());

            if (qty < 0) {
                JOptionPane.showMessageDialog(this,
                        "Quantity cannot be negative");
                return;
            }

            Product p =
                    new Product(barcode, name, price, qty);

            InventoryManager.getInstance()
                    .addProduct(p);

            model.addRow(new Object[]{
                    barcode,
                    name,
                    price,
                    qty,
                    p.getTotalValue()
            });

            clearFields();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter valid data");
        }
    }

    private void updateProduct() {

        int row = table.getSelectedRow();

        if (row >= 0) {

            try {

                double price =
                        Double.parseDouble(txtPrice.getText());

                int qty =
                        Integer.parseInt(txtQty.getText());

                if (qty < 0) {
                    JOptionPane.showMessageDialog(this,
                            "Quantity cannot be negative");
                    return;
                }

                model.setValueAt(txtBarcode.getText(), row, 0);
                model.setValueAt(txtName.getText(), row, 1);
                model.setValueAt(price, row, 2);
                model.setValueAt(qty, row, 3);
                model.setValueAt(price * qty, row, 4);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid data");
            }
        }
    }

    private void deleteProduct() {

        int row = table.getSelectedRow();

        if (row >= 0) {

            InventoryManager.getInstance()
                    .deleteProduct(row);

            model.removeRow(row);
        }
    }

    private void clearFields() {

        txtBarcode.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");
    }
}