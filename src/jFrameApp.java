import javax.swing.*;

class jFrameApp extends JFrame {
    public jFrameApp()
    {
        setBounds(100, 100, 280, 400);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new jPanelApp());
        setVisible(true);
    }
}
