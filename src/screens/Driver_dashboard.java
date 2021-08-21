package screens;

import javax.swing.*;
import java.awt.*;



import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Driver_dashboard{
    // Creating necessary instance.
    JFrame driver_frame;
    JLabel profile, profile_name, dashboard;
    JButton driver_time_table, driver_routes,driver_bus_details;
    JPanel driver_profile, driver_dashboard;
    Font font_db;

    public Driver_dashboard(){
        // Creating object for main window.
        driver_frame = new JFrame();

        // Message for profile picture.
        profile = new JLabel("Profile picture");
        profile.setSize(150,50);

        // Message for profile name.
        profile_name = new JLabel();
        profile_name.setText("Sample Sample Sample");
        profile_name.setForeground(Color.BLUE);
        profile_name.setBounds(63,220,150,30);
        driver_frame.add(profile_name);

        font_db = new Font("Times", Font.PLAIN,50);

        // Message for dashboard.
        dashboard = new JLabel("Sample");
        dashboard.setFont(font_db);
        dashboard.setBounds(500,345,150,150);

        // Profile picture panel.
        driver_profile = new JPanel();
        driver_profile.setBounds(70,75,130,130);
        driver_profile.setBackground(Color.gray);
        driver_profile.add(profile);
        driver_frame.add(driver_profile);

        // Time table button.
        driver_time_table = new JButton("Time Table");
        driver_time_table.setBounds(65,280,140,40);
        driver_frame.add(driver_time_table);

        // Bus route button.
        driver_routes = new JButton("Routes");
        driver_routes.setBounds(65,340,140,40);
        driver_frame.add(driver_routes);

        // Bus Detail button.
        driver_bus_details= new JButton("Bus Details");
        driver_bus_details.setBounds(65,400,140,40);
        driver_frame.add(driver_bus_details);

        // Main Dashboard.
        driver_dashboard = new JPanel();
        driver_dashboard.setBackground(Color.white);
        driver_dashboard.setBounds(250,30,1000,690);
        driver_dashboard.add(dashboard);
        driver_frame.add(driver_dashboard);

        driver_frame.setTitle("Driver");
        driver_frame.setLayout(null);
        driver_frame.setVisible(true);
        driver_frame.setSize(1300,790);
        driver_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Driver_dashboard();
    }
}
