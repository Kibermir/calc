import javax.swing.*;

class jFrameApp extends JFrame {
    public jFrameApp()
    {
        setBounds(100, 100, 270, 400);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new jPanelApp());
        setVisible(true);
        System.out.print(Double.parseDouble("2.5"));
    }
}
