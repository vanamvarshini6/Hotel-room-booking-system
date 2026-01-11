import java.net.URI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelRoomBookingSystem extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, roomLabel, daysLabel;
    JTextField nameField, daysField;
    JComboBox<String> roomBox;
    JButton bookButton, clearButton;

    public HotelRoomBookingSystem() {

                setTitle("Hotel Room Booking System");

               setLayout(new GridLayout(5, 2, 10, 10));

       
        titleLabel = new JLabel("Hotel Room Booking", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nameLabel = new JLabel("Customer Name:");
        roomLabel = new JLabel("Room Type:");
        daysLabel = new JLabel("No. of Days:");

        nameField = new JTextField();
        daysField = new JTextField();

        String rooms[] = {"Standard - ₹1500/day", "Deluxe - ₹2500/day", "Suite - ₹4000/day"};
        roomBox = new JComboBox<>(rooms);

        bookButton = new JButton("Book Room");
        clearButton = new JButton("Clear");

        add(titleLabel);
        add(new JLabel("")); 

        add(nameLabel);
        add(nameField);

        add(roomLabel);
        add(roomBox);

        add(daysLabel);
        add(daysField);

        add(bookButton);
        add(clearButton);


        bookButton.addActionListener(this);
        clearButton.addActionListener(this);

     
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bookButton) {

            String name = nameField.getText();
            String room = (String) roomBox.getSelectedItem();
            int days;

            try {
                days = Integer.parseInt(daysField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid number of days!");
                return;
            }

        
            int costPerDay = 0;
            if (room.contains("1500")) costPerDay = 1500;
            else if (room.contains("2500")) costPerDay = 2500;
            else if (room.contains("4000")) costPerDay = 4000;

            int total = costPerDay * days;

            JOptionPane.showMessageDialog(this,
                    "Booking Successful!\n\n" +
                    "Name: " + name +
                    "\nRoom: " + room +
                    "\nDays: " + days +
                    "\nTotal Amount: ₹" + total);
        }

        if (e.getSource() == clearButton) {
            nameField.setText("");
            daysField.setText("");
            roomBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
     try {
        // Open your SITE123 website
        Desktop.getDesktop().browse(new URI("http://69329e3172078.site123.me"));
    } catch (Exception e) {
        System.out.println("Unable to open website: " + e.getMessage());
    }

    new HotelRoomBookingSystem();
}