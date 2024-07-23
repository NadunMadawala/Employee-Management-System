import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Employee {
    private JPanel Main;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtMobile;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTable table1;
    private JTextField txtid;
    private JButton searchButton;
    private JScrollPane table_1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(new Employee().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    Connection con;
    PreparedStatement pst;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ncmcompany","root","");
            System.out.println("Success..!");

        }catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }



        void table_load()
        {
            try
            {
                pst = con.prepareStatement("select * from employee");
                ResultSet rs = pst.executeQuery();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    public Employee() {
        connect();
        table_load();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String empname,salary,mobile;

                empname = txtName.getText();
                salary = txtSalary.getText();
                mobile = txtMobile.getText();


                try {
                    pst = con.prepareStatement("insert into employee(empname,salary,mobile) values (?,?,?)");
                    pst.setString(1,empname);
                    pst.setString(2,salary);
                    pst.setString(3,mobile);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedd..!!!");
                    //table_load();
                    txtName.setText("");
                    txtMobile.setText("");
                    txtSalary.setText("");
                    txtName.requestFocus();

                }catch (SQLException e1){
                    e1.printStackTrace();
                }

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    String id = txtid.getText();

                    pst = con.prepareStatement("select empname,salary,mobile from employee where id=? ");
                    pst.setString(1,id);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()==true){

                        String empname = rs.getString(1);
                        String salary = rs.getString(2);
                        String mobile = rs.getString(3);

                        txtName.setText(empname);
                        txtSalary.setText(salary);
                        txtMobile.setText(mobile);

                    }else {
                        txtName.setText("");
                        txtSalary.setText("");
                        txtMobile.setText("");

                        JOptionPane.showMessageDialog(null,"Invalid Employee No");
                    }

                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, empname, salary, mobile;

                id = txtid.getText();
                empname = txtName.getText();
                salary = txtSalary.getText();
                mobile = txtMobile.getText();

                try {
                    pst = con.prepareStatement("update employee set empname=?, salary=?, mobile=? where id=?");
                    pst.setString(1, empname);
                    pst.setString(2, salary);
                    pst.setString(3, mobile);
                    pst.setString(4, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated..!!!");
                    table_load();
                    txtName.setText("");
                    txtMobile.setText("");
                    txtSalary.setText("");
                    txtid.setText("");
                    txtName.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;

                id = txtid.getText();

                try {
                    pst = con.prepareStatement("delete from employee where id=?");
                    pst.setString(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted..!!!");
                    table_load();
                    txtName.setText("");
                    txtMobile.setText("");
                    txtSalary.setText("");
                    txtid.setText("");
                    txtName.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}


