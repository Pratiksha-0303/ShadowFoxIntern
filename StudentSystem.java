    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.util.ArrayList;

    class Student {

        String name, rollno, course;
        Student(String n, String r, String c) {
            name = n;
            rollno = r;
            course = c;
        }
    }
    public class StudentSystem {
        public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
            JFrame frame = new JFrame("Student Information System");
            frame.setSize(800, 550);
            frame.setLayout(new BorderLayout(15, 15));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JLabel title = new JLabel("STUDENT INFORMATION SYSTEM");
            title.setFont(new Font("Arial", Font.BOLD, 24));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(title, BorderLayout.NORTH);
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout(10, 10));
            JPanel inputPanel = new JPanel();
            inputPanel.setBorder(
                    BorderFactory.createTitledBorder("Student Details")
            );
            inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
            JLabel nameLabel = new JLabel("Name:");
            JTextField nameField = new JTextField();
            JLabel rollLabel = new JLabel("Roll No:");
            JTextField rollField = new JTextField();
            JLabel courseLabel = new JLabel("Course:");
            JTextField courseField = new JTextField();
            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            inputPanel.add(rollLabel);
            inputPanel.add(rollField);
            inputPanel.add(courseLabel);
            inputPanel.add(courseField);
            mainPanel.add(inputPanel, BorderLayout.NORTH);

           String[] columns = {"Name", "Roll No", "Course"};
           DefaultTableModel model =
           new DefaultTableModel(columns, 0);
           JTable table = new JTable(model);
           table.setRowHeight(25);
           table.setFont(new Font("Arial", Font.PLAIN, 14));
           table.getTableHeader().setFont(
           new Font("Arial", Font.BOLD, 15)
            );
           JScrollPane scrollPane = new JScrollPane(table);
           mainPanel.add(scrollPane, BorderLayout.CENTER);
           JPanel buttonPanel = new JPanel();
           buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));
           JButton addBtn = new JButton("Add Student");
           JButton viewBtn = new JButton("View All");
           JButton updateBtn = new JButton("Update");
           JButton deleteBtn = new JButton("Delete");
           JButton searchBtn = new JButton("Search");
           JButton clearBtn = new JButton("Clear");
           buttonPanel.add(addBtn);
           buttonPanel.add(viewBtn);
           buttonPanel.add(updateBtn);
           buttonPanel.add(deleteBtn);
           buttonPanel.add(searchBtn);
           buttonPanel.add(clearBtn);
           mainPanel.add(buttonPanel, BorderLayout.SOUTH);

          addBtn.addActionListener(e -> {
           String name = nameField.getText();
           String roll = rollField.getText();
           String course = courseField.getText();
           if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields!"
                    );
                 return;
                }
            students.add(new Student(name, roll, course));
             model.addRow(new Object[]{
                        name,
                        roll,
                        course
                });
            JOptionPane.showMessageDialog(
                        frame,
                        "Student Added Successfully!"
                );
            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            });
      viewBtn.addActionListener(e -> {
          model.setRowCount(0);
           for (Student s : students) {
             model.addRow(new Object[]{
                         s.name,
                         s.rollno,
                         s.course
                    });
                }
            });

       deleteBtn.addActionListener(e -> {
            String roll = rollField.getText();
            students.removeIf(s -> s.rollno.equals(roll));
            model.setRowCount(0);
               for (Student s : students) {
                  model.addRow(new Object[]{
                            s.name,
                            s.rollno,
                            s.course
                    });
                }
        JOptionPane.showMessageDialog(
                        frame,
                        "Student Deleted!"
                );
            });
       updateBtn.addActionListener(e -> {
            String roll = rollField.getText();
                boolean found = false;
                  for (Student s : students) {
                    if (s.rollno.equals(roll)) {
                       s.name = nameField.getText();
                       s.course = courseField.getText();
                       found = true;
                    }
                }
                model.setRowCount(0);
                for (Student s : students) {
                    model.addRow(new Object[]{
                            s.name,
                            s.rollno,
                            s.course
                    });
                }
                if (found) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Student Updated!"
                    );

                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Student Not Found!"
                    );
                }
            });
        searchBtn.addActionListener(e -> {
            String roll = rollField.getText();
             model.setRowCount(0);
              boolean found = false;
              for (Student s : students) {
                 if (s.rollno.equals(roll)) {
                   model.addRow(new Object[]{
                                s.name,
                                s.rollno,
                                s.course
                        });

                        found = true;
                    }
                }
              if (!found) {
                   JOptionPane.showMessageDialog(
                            frame,
                            "Student Not Found!"
                    );
                }
            });
            clearBtn.addActionListener(e -> {
              nameField.setText(""); 
              rollField.setText("");
              courseField.setText("");
            });
           frame.add(mainPanel, BorderLayout.CENTER);
           frame.setVisible(true);
        }
    }