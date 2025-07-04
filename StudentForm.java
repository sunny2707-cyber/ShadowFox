import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentForm extends JFrame implements ActionListener {
    JTextField nameField, rollField, courseField;
    JButton addBtn, displayBtn, updateBtn, deleteBtn;
    JTextArea outputArea;
    ArrayList<Student> studentList = new ArrayList<>();

    public StudentForm() {
        setTitle("Student Information System");
        setLayout(new FlowLayout());
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField(20); add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField(20); add(rollField);

        add(new JLabel("Course:"));
        courseField = new JTextField(20); add(courseField);

        addBtn = new JButton("Add");
        displayBtn = new JButton("Display");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");

        add(addBtn); add(displayBtn); add(updateBtn); add(deleteBtn);

        outputArea = new JTextArea(15, 30);
        add(new JScrollPane(outputArea));

        addBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        int roll = Integer.parseInt(rollField.getText());
        String course = courseField.getText();

        if (e.getSource() == addBtn) {
            studentList.add(new Student(name, roll, course));
            outputArea.setText("Student Added!\n");
        } else if (e.getSource() == displayBtn) {
            outputArea.setText("");
            for (Student s : studentList) outputArea.append(s + "\n");
        } else if (e.getSource() == updateBtn) {
            for (Student s : studentList) {
                if (s.getRollNo() == roll) {
                    s.setName(name);
                    s.setCourse(course);
                    outputArea.setText("Student Updated!\n");
                    return;
                }
            }
            outputArea.setText("Student Not Found.\n");
        } else if (e.getSource() == deleteBtn) {
            studentList.removeIf(s -> s.getRollNo() == roll);
            outputArea.setText("If existed, student was deleted.\n");
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
