import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class jPanelApp extends JPanel
{
    double res = 0, resCicl = 0, res1 = 0, mem = 0;
    String op = "";
    int mathPress = 0, resPress = 0, pointPress = 0, sendTotxt2 = 0, setRes;

    private JTextField txt1, txt2, txtM;


    public void delNull()
    {
        if (txt1.getText().equals("0"))
        {
           txt1.setText("");
        }
        if (setRes == 1)
        {
            txt1.setText("");
            setRes = 0;
        }
    }


    public void getOpp()
    {


        res1 = Double.parseDouble(txt1.getText());
        String strOp = op;
        MetodCalc mc = new MetodCalc();
        String strRes = String.valueOf(mc.calc(res, strOp, res1));
        txt1.setText(strRes);
        if (op == "%")
        {
            txt2.setText(txt2.getText() + " " + strRes);
        }
        setRes = 1;
        res = Double.parseDouble(txt1.getText());
    }

    public jPanelApp()
    {
        try
        {

            setLayout(null);  //Этот вызов запрещает использовать предусмотренный по умолчанию механизма управления размещением компонентов.

            txt1 = new JTextField(); //Текстовое поле нижнее
            txt1.setBounds(37, 40, 218, 35);
            txt1.setHorizontalAlignment(JTextField.RIGHT);
            //txt1.setEditable(false); //Запрещаем редактировать поле 1
            txt1.setFont(txt1.getFont().deriveFont(22f));
            txt1.setText("0");
            txt1.setBorder(BorderFactory.createEmptyBorder());



            txt2 = new JTextField(); //Текстовое поле верхнее
            txt2.setBounds(10, 10, 245, 30);
            //txt2.setEditable(false); //Запрещаем редактировать поле 2
            txt2.setHorizontalAlignment(JTextField.RIGHT);
            txt2.setBorder(BorderFactory.createEmptyBorder());


            txtM = new JTextField(); //Текстовое поле нижнее
            txtM.setBounds(10, 40, 27, 35);
            txtM.setHorizontalAlignment(JTextField.LEFT);
            //txt1.setEditable(false); //Запрещаем редактировать поле 1
            txtM.setFont(txtM.getFont().deriveFont(14f));
            txtM.setBorder(BorderFactory.createEmptyBorder());


            Font bigFont1 = new Font("serif", Font.BOLD, 18);
            Font bigFont2 = new Font("serif", Font.BOLD, 20);


            JButton b0 = new JButton("0");
            b0.setBounds(10, 310, 95, 40);

            JButton b1 = new JButton("1");
            b1.setBounds(10, 265, 45, 40);

            JButton b2 = new JButton("2");
            b2.setBounds(60, 265, 45, 40);

            JButton b3 = new JButton("3");
            b3.setBounds(110, 265, 45, 40);

            JButton b4 = new JButton("4");
            b4.setBounds(10, 220, 45, 40);

            JButton b5 = new JButton("5");
            b5.setBounds(60, 220, 45, 40);

            JButton b6 = new JButton("6");
            b6.setBounds(110, 220, 45, 40);

            JButton b7 = new JButton("7");
            b7.setBounds(10, 175, 45, 40);

            JButton b8 = new JButton("8");
            b8.setBounds(60, 175, 45, 40);

            JButton b9 = new JButton("9");
            b9.setBounds(110, 175, 45, 40);

            JButton bPoint = new JButton(".");
            bPoint.setBounds(110, 310, 45, 40);
            bPoint.setFont(bigFont1);

            JButton bPlusMinus = new JButton("+/-");
            bPlusMinus.setBounds(160, 130, 45, 40);
            bPlusMinus.setFont(bigFont1);
            bPlusMinus.setMargin(new Insets(0, 0, 0, 0));

            JButton bC = new JButton("C");
            bC.setBounds(110, 130, 45, 40);

            JButton bCE = new JButton("CE");
            bCE.setBounds(60, 130, 45, 40);
            bCE.setMargin(new Insets(0, 0, 0, 0));

            JButton bBS = new JButton("<=");
            bBS.setBounds(10, 130, 45, 40);
            bBS.setMargin(new Insets(0, 0, 0, 0));

            JButton bMC = new JButton("MC");
            bMC.setBounds(10, 85, 45, 40);
            bMC.setMargin(new Insets(0, 0, 0, 0));

            JButton bMR = new JButton("MR");
            bMR.setBounds(60, 85, 45, 40);
            bMR.setMargin(new Insets(0, 0, 0, 0));

            JButton bMS = new JButton("MS");
            bMS.setBounds(110, 85, 45, 40);
            bMS.setMargin(new Insets(0, 0, 0, 0));

            JButton bMPlus = new JButton("M+");
            bMPlus.setBounds(160, 85, 45, 40);
            bMPlus.setMargin(new Insets(0, 0, 0, 0));

            JButton bMMinus = new JButton("M-");
            bMMinus.setBounds(210, 85, 45, 40);
            bMMinus.setMargin(new Insets(0, 0, 0, 0));

            JButton bV = new JButton("V");
            bV.setBounds(210, 130, 45, 40);

            JButton bPercent = new JButton("%");
            bPercent.setBounds(210, 175, 45, 40);

            JButton b1X = new JButton("1/x");
            b1X.setBounds(210, 220, 45, 40);
            b1X.setMargin(new Insets(0, 0, 0, 0));

            JButton bRes = new JButton("=");
            bRes.setBounds(210, 265, 45, 85);
            bRes.setFont(bigFont2);

            JButton bPlus = new JButton("+");
            bPlus.setBounds(160, 310, 45, 40);
            bPlus.setFont(bigFont1);

            JButton bMinus = new JButton("-");
            bMinus.setBounds(160, 265, 45, 40);
            bMinus.setFont(bigFont1);

            JButton bMulti = new JButton("*");
            bMulti.setBounds(160, 220, 45, 40);
            bMulti.setFont(bigFont1);

            JButton bDivision = new JButton("/");
            bDivision.setBounds(160, 175, 45, 40);
            bDivision.setFont(bigFont1);

            add(txt1);
            add(txt2);
            add(txtM);
            add(b0);
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(b5);
            add(b6);
            add(b7);
            add(b8);
            add(b9);
            add(bPoint);
            add(bPlusMinus);
            add(bV);
            add(bPercent);
            add(b1X);
            add(bC);
            add(bCE);
            add(bBS);
            add(bMMinus);
            add(bMPlus);
            add(bMS);
            add(bMR);
            add(bMC);
            add(bRes);
            add(bPlus);
            add(bMinus);
            add(bMulti);
            add(bDivision);

            b1.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 1);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 2);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 3);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 4);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 5);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b6.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 6);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b7.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 7);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b8.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 8);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b9.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 9);
                    if (mathPress == 1){
                        pointPress = 0;
                     }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            b0.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    delNull();
                    txt1.setText(txt1.getText() + 0);
                    if (mathPress == 1){
                        pointPress = 0;
                    }
                    mathPress = 0;
                    resPress = 0;
                }
            });

            bMMinus.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    mem = (mem - Double.parseDouble(txt1.getText()));
                    txtM.setText("M");
                }
            });

            bMPlus.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    mem = (mem + Double.parseDouble(txt1.getText()));
                    txtM.setText("M");
                }
            });

            bMR.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText(String.valueOf(mem));
                    mathPress = 0;
                    pointPress = 2;
                    if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                    {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                    }
                }
            });

            bMC.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    mem = 0;
                    txtM.setText(" ");
                }
            });

            bMS.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    mem = Double.parseDouble(txt1.getText());
                    txtM.setText("M");
                }
            });

            bPercent.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    double res1P = Double.parseDouble(txt1.getText());
                    String strOp = "%";
                    MetodCalc mc = new MetodCalc();
                    String strRes = String.valueOf(mc.calc(res, strOp, res1P));
                    txt1.setText(strRes);
                    txt2.setText(txt2.getText() + " " + strRes);
                    sendTotxt2 = 1;
                    pointPress = 2;
                    if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                    {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                        txt2.setText(txt2.getText().substring(0, txt2.getText().length() - 2));
                    }
                }
            });

            bC.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText("0");
                    txt2.setText("");
                    res = 0;
                    res1 = 0;
                    op = "";
                    pointPress = 0;
                }
            });

            bCE.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    txt1.setText("0");
                }
            });

            bPoint.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    switch (pointPress) {
                            case 0:
                                txt1.setText(txt1.getText() + ".");
                                pointPress = 1;
                                break;
                            case 2:
                                txt1.setText("0.");
                                setRes = 0;
                                pointPress = 1;
                                mathPress = 0;
                                break;
                    }
                }
            });

            bBS.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if (mathPress != 1 && resPress != 1)
                    if (txt1.getText().length() != 1)
                    {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 1));
                    }
                    else
                    {
                        txt1.setText("0");
                    }
                }
            });

            b1X.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    double xres = 1;
                    double xres1 = Double.parseDouble(txt1.getText());
                    String xop = "/";
                    MetodCalc mc = new MetodCalc();
                    String strRes = String.valueOf(mc.calc(xres, xop, xres1));
                    txt1.setText(strRes);
                    pointPress = 2;
                    if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                    {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                    }
                }
            });

            bV.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    double vres1 = 0;
                    double vres = Double.parseDouble(txt1.getText());
                    String xop = "sqrt";
                    MetodCalc mc = new MetodCalc();
                    String strRes = String.valueOf(mc.calc(vres, xop, vres1));
                    pointPress = 2;
                    txt1.setText(strRes);
                    if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                    {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                    }
                }
            });


            bPlusMinus.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1) {
                    int ln = txt1.getText().length() - 1;
                    if (!txt1.getText().equals("0"))
                        if (txt1.getText().substring(0, txt1.getText().length() - ln).equals("-")) {
                            txt1.setText(txt1.getText().substring(1, txt1.getText().length()));
                        } else {
                            txt1.setText("-" + txt1.getText());
                        }

                }
            });

            bPlus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if (txt1.getText().substring(txt1.getText().length()-1).equals(".")){
                        txt1.setText(txt1.getText().substring(0,txt1.getText().length()-1));
                    }
                    if (mathPress == 1){
                        txt2.setText(txt2.getText().substring(0,txt2.getText().length()-5));
                        txt2.setText(txt2.getText() + "  +  ");
                        op = "+";
                    }
                    else{
                        if (res == 0) {
                            res = Double.parseDouble(txt1.getText());
                            txt2.setText(txt1.getText() + "  +  ");
                            setRes = 1;
                            op = "+";
                            mathPress = 1;
                            resPress = 0;
                            pointPress = 2;
                        } else {
                            if (sendTotxt2 == 1)
                            {

                                txt2.setText(txt2.getText() + "  +  ");
                                sendTotxt2 = 0;

                            }
                            else
                            {
                                txt2.setText(txt2.getText() + txt1.getText() + "  +  ");

                            }
                            getOpp();
                            op = "+";
                            resPress = 0;
                            mathPress = 1;
                            pointPress = 2;
                            if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                            {
                                txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                            }
                        }
                    }

                }
            });

            bMinus.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if (txt1.getText().substring(txt1.getText().length()-1).equals(".")) {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 1));
                    }
                    if (mathPress == 1){
                        txt2.setText(txt2.getText().substring(0,txt2.getText().length()-5));
                        txt2.setText(txt2.getText() + "  -  ");
                        op = "-";
                    }
                    else{
                        if (res == 0) {
                            res = Double.parseDouble(txt1.getText());
                            txt2.setText(txt1.getText() + "  -  ");
                            setRes = 1;
                            op = "-";
                            mathPress = 1;
                            resPress = 0;
                            pointPress = 2;
                        } else {
                            if (sendTotxt2 == 1)
                            {

                                txt2.setText(txt2.getText() + "  -  ");
                                sendTotxt2 = 0;

                            }
                            else
                            {
                                txt2.setText(txt2.getText() + txt1.getText() + "  -  ");

                            }
                            getOpp();
                            op = "-";
                            mathPress = 1;
                            pointPress = 2;
                            if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                            {
                                txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                            }
                        }
                    }
                }
            });

            bMulti.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if (txt1.getText().substring(txt1.getText().length()-1).equals(".")) {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 1));
                    }
                    if (mathPress == 1){
                        txt2.setText(txt2.getText().substring(0,txt2.getText().length()-5));
                        txt2.setText(txt2.getText() + "  *  ");
                        op = "*";
                    }
                    else{
                        if (res == 0) {
                            res = Double.parseDouble(txt1.getText());
                            txt2.setText(txt1.getText() + "  *  ");
                            setRes = 1;
                            op = "*";
                            mathPress = 1;
                            resPress = 0;
                            pointPress = 2;
                        } else {
                            if (sendTotxt2 == 1)
                            {

                                txt2.setText(txt2.getText() + "  *  ");
                                sendTotxt2 = 0;

                            }
                            else
                            {
                                txt2.setText(txt2.getText() + txt1.getText() + "  *  ");

                            }
                            getOpp();
                            op = "*";
                            mathPress = 1;
                            pointPress = 2;
                            if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                            {
                                txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                            }
                        }
                    }
                }
            });

            bDivision.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg1)
                {
                    if (txt1.getText().substring(txt1.getText().length()-1).equals(".")) {
                        txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 1));
                    }
                    if (mathPress == 1){
                        txt2.setText(txt2.getText().substring(0,txt2.getText().length()-5));
                        txt2.setText(txt2.getText() + "  /  ");
                        op = "/";
                    }
                    else{
                        if (res == 0) {
                            res = Double.parseDouble(txt1.getText());
                            txt2.setText(txt1.getText() + "  /  ");
                            setRes = 1;
                            op = "/";
                            mathPress = 1;
                            resPress = 0;
                            pointPress = 2;
                        } else {
                            if (sendTotxt2 == 1)
                            {

                                txt2.setText(txt2.getText() + "  /  ");
                                sendTotxt2 = 0;

                            }
                            else
                            {
                                txt2.setText(txt2.getText() + txt1.getText() + "  /  ");

                            }
                            getOpp();
                            op = "/";
                            mathPress = 1;
                            pointPress = 2;
                            if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                            {
                                txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                            }
                        }
                    }
                }
            });

            bRes.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    if (resPress == 1)
                    {
                        if (resCicl == 0) {
                            resCicl = res1;
                        }
                        res1 = Double.parseDouble(txt1.getText());
                        String strOp = op;
                        MetodCalc mc = new MetodCalc();
                        String strRes = String.valueOf(mc.calc(resCicl, strOp, res1));
                        txt1.setText(strRes);
                        txt2.setText("");
                        setRes = 1;
                        mathPress = 0;
                        pointPress = 2;
                    }
                    else {
                        res1 = Double.parseDouble(txt1.getText());
                        String strOp = op;
                        MetodCalc mc = new MetodCalc();
                        String strRes = String.valueOf(mc.calc(res, strOp, res1));
                        txt1.setText(strRes);
                        txt2.setText("");
                        res = 0;
                        setRes = 1;
                        mathPress = 0;
                        resPress = 1;
                        pointPress = 2;
                        if(txt1.getText().substring(txt1.getText().length()-1).equals("0"))
                        {
                            txt1.setText(txt1.getText().substring(0, txt1.getText().length() - 2));
                        }
                    }
                }
            });

        }
       catch (ArithmeticException exception)
       {
         //System.out.println("Can not divide by zero ");
       }
    }
}
