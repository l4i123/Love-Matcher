import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoveApp extends JFrame {
    private JTextField girlName;
    private JTextField boyName;
    private JButton calculateButton;
    private JLabel Label;
    private JLabel image1, image2;

    public LoveApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Love Master");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 192, 203));

        girlName = new JTextField();
        girlName.setBounds(50, 300, 150, 50);
        girlName.setBackground(new Color(255, 192, 203));
        girlName.setFont(new Font("Serif", Font.BOLD, 20));
        add(girlName);

        boyName = new JTextField();
        boyName.setBounds(300, 300, 150, 50);
        boyName.setBackground(new Color(255, 192, 203));
        boyName.setFont(new Font("Serif", Font.BOLD, 20));
        add(boyName);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(160, 450, 150, 60);
        calculateButton.setFont(new Font("Serif", Font.BOLD, 20));
        add(calculateButton);

        Label = new JLabel();
        Label.setBounds(225, 550, 150, 50);
        Label.setFont(new Font("Serif", Font.BOLD, 30));
        Label.setForeground(Color.BLACK);
        add(Label);

        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Load and check the second image
        String imagePath2 = "D:\\Documents\\Java\\Love-Matcher\\pngegg (2).png"; // Adjust path for second image
        ImageIcon imageIcon2 = new ImageIcon(imagePath2);
        if (imageIcon2.getIconWidth() == -1) {
            System.out.println("Second image not found or could not be loaded.");
        } else {
            image2 = new JLabel(resizeImage(imageIcon2, 200, 200)); // Resize to 100x100
            image2.setBounds(90, 80, 330, 200); // Adjust position and size as needed
            add(image2);
        }


        // Load and check the first image
        String imagePath1 = "D:\\Documents\\Java\\Love-Matcher\\pngegg (1).png"; // Correct path
        ImageIcon imageIcon1 = new ImageIcon(imagePath1);
        if (imageIcon1.getIconWidth() == -1) {
            System.out.println("First image not found or could not be loaded.");
        } else {
            image1 = new JLabel(resizeImage(imageIcon1, 500, 700)); // Resize if needed
            image1.setBounds(0, 0, 500, 700); // Set bounds for the image
            add(image1);
        }

        
        // ActionListener for the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameGirl = girlName.getText();
                String nameBoy = boyName.getText();
                LoveCalculator.calculateLove(nameGirl, nameBoy, Label);

                

            }
        });
    }

    private ImageIcon resizeImage(ImageIcon originalImage, int width, int height) {
        // Create a new image scaled to the desired width and height
        Image scaledImage = originalImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        LoveApp app = new LoveApp();
        app.setVisible(true);
    }
}