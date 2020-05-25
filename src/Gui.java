import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mr-Vans
 */

public class Gui extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JButton btn_start;
    private final Mouseclicker clicker;
    private JLabel lbl_title;

    public Gui() {
        clicker = new Mouseclicker();
        initalize();
    }

    private void initalize() {
        this.setSize(new Dimension(300, 210));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Art of War Autoclicker");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.setContentPane(mainPanel);

        lbl_title = new JLabel("Art of War: Legions Autoclicker", SwingConstants.CENTER);
        lbl_title.setBounds(0, 20, 300, 30);
        lbl_title.setFont(new Font("Arial", Font.PLAIN, 20));
        mainPanel.add(lbl_title);

        btn_start = new JButton("Start");
        btn_start.setBounds(100, 80, 100, 50);
        btn_start.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_start.addActionListener(this);
        btn_start.setFocusable(false);
        mainPanel.add(btn_start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_start) {
            toggleButtonText();
        }
    }

    private void toggleButtonText() {
        clicker.toggleStart();
        if (btn_start.getText().equalsIgnoreCase("Start")) {
            btn_start.setText("Cancel");
        } else {
            btn_start.setText("Start");
        }
    }
}
