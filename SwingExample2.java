package com.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SwingExample2 implements ActionListener {
	JFrame f;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4;

	public SwingExample2() {
		f = new JFrame("My Swing Example");
		f.setVisible(true);
		f.setSize(370, 450);
//		f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(7,2));
		f.setLayout(null);
		f.setResizable(false);

		l1 = new JLabel("id");
		l2 = new JLabel("First Name");
		l3 = new JLabel("Last Name");
		l4 = new JLabel("Email");
		l5 = new JLabel("Mobile");

		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);

		b1 = new JButton("Insert");
		b2 = new JButton("Search");
		b3 = new JButton("Update");
		b4 = new JButton("Delete");

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		l1.setBounds(50, 50, 100, 20);
		l2.setBounds(50, 100, 100, 20);
		l3.setBounds(50, 150, 100, 20);
		l4.setBounds(50, 200, 100, 20);
		l5.setBounds(50, 250, 100, 20);

		t1.setBounds(150, 50, 150, 20);
		t2.setBounds(150, 100, 150, 20);
		t3.setBounds(150, 150, 150, 20);
		t4.setBounds(150, 200, 150, 20);
		t5.setBounds(150, 250, 150, 20);

		b1.setBounds(50, 300, 100, 20);
		b2.setBounds(200, 300, 100, 20);
		b3.setBounds(50, 350, 100, 20);
		b4.setBounds(200, 350, 100, 20);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

	}

	public static void main(String[] args) {
		new SwingExample2();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_1", "root", "");
				String sql = "insert into student(fname,lname,email,mobile)value('" + t2.getText() + "','"
						+ t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "')";
				Statement stmt = conn.createStatement();
				if (t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
						|| t5.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "All field are mandatory");

				} else {
					stmt.execute(sql);
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "Data inserted successfully");
				}
			}

			catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b2) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_1", "root", "");
				String sql = "Select * from Student where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t1.getText()));
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					t2.setText(rs.getString("fname"));
					t3.setText(rs.getString("lname"));
					t4.setText(rs.getString("email"));
					t5.setText(rs.getString("mobile"));
				} else {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "id not Found");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b3) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_1", "root", "");
				String sql="Update Student set fname=?,lname=?,email=?,mobile=? where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, t2.getText());
				pst.setString(2, t3.getText());
				pst.setString(3, t4.getText());
				pst.setLong(4, Long.parseLong(t5.getText()));
				pst.setInt(5, Integer.parseInt(t1.getText()));
				pst.executeUpdate();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(f,"Data updated successfully");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b4) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_1", "root", "");
				String sql="Delete from Student where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setLong(1,Integer.parseInt(t1.getText()));
			    pst.executeUpdate();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(f,"Data delete successfully");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
