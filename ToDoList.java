import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame {

    //instance Variables
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JTextField taskField;
    private JButton addButton , deleteButton;
    private String[] emojis = {"😁","😇","😈","😏","😎","😡","🤠","🤡","😦","😰","😱","🙄","🤔","😒","😀","😅","🙃","🙂","😌","💀","❄","️✨","😘","👿","💩","👽","😼"};

    public ToDoList() {
        
        ImageIcon img= new ImageIcon(ClassLoader.getSystemResource("todo_1.png"));
        setIconImage(img.getImage());
        
        //Frame properties
        setTitle("Todo List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        
        //for adding todos
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        taskField = new JTextField();
        addButton = new JButton("Add Task");
        
        //Add Button and its Functionalty
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if(!task.isEmpty()) {
                    int randomEmoji = (int) (Math.random()*emojis.length);
                    task = task + " " + emojis[randomEmoji];
                    listModel.addElement(task);
                    taskField.setText("");
                }//validation Check
                if(task.isEmpty()){
                    JOptionPane.showMessageDialog(null , "The TextField is Empty!");
                    return;
                }
            }
        });
        
        //Delete Button and its functionality
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(40, 44, 52));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            int selectedIndex = list.getSelectedIndex();
            if(selectedIndex != -1) {
            listModel.remove(selectedIndex);
            }//validation Check
            else{
            JOptionPane.showMessageDialog(null , "Please select ToDo to delete");
            return;
                }
            }
        });

        taskField.setBackground(new Color(40, 44, 52));
        taskField.setForeground(Color.WHITE);
        taskField.setCaretColor(Color.WHITE);
        taskField.setFont(taskField.getFont().deriveFont(Font.BOLD));

        addButton.setBackground(new Color(40, 44, 52));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusable(false);
        addButton.setFont(addButton.getFont().deriveFont(Font.BOLD));

        list.setBackground(new Color(40, 44, 52));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setForeground(Color.WHITE);
        list.setFont(list.getFont().deriveFont(Font.BOLD));

        scrollPane.setBackground(new Color(40, 44, 52));
        scrollPane.getViewport().setBackground(new Color(40, 44, 52));
        scrollPane.setBorder(null);

        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(40, 44, 52));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(taskField , BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(40, 44, 52));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
    }
}
