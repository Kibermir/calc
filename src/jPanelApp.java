import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jPanelApp extends JPanel
{
    static public String ff = "";
    double res1 = 0;                     //Variable for first operand.
    double res2 = 0;                    //Variable for second operand.
    double mem = 0;                     //Variable for calc memory.
    double resCycle = 0;                 //Variable for cycle res.

    String op = "";                     //Current mathematics operation.

    int mathPres = 0;                  // Mathematiсs buttons state: 0 = default state(didn't press);  1 = button was press.
    int resPres = 0;                   // Result button state: 0 = default state(didn't press);  1 = button was press.
    int pointPres = 0;                 // Point button state: 0 = default state(didn't press);  1 = button was press;  2 = state for reset dispMain and set "0.".
    int sendToDispSecond = 0;           // Close\open dispSecond for write, 0 = open for write;  1 = close for write.
    int setRes1;                         // Flag for reset dispMain: 1 = need to reset.

    private JTextField dispMain;        // Main lower display.
    public JTextField dispSecond;      // Second top display.
    private JTextField dispMem;         // Memory display in low left corner.



    public void setDisp(String d1, String d2)
    {
        //System.out.println(dispMain.getText());
        //dispMain.setText(d1);
        //System.out.println(dispMain.getText());
        dispSecond.setText(ff);
        System.out.println("внутри setDisp " + dispSecond.getText());
    }
    public String getDisp()
    {
        String r;
        r = dispSecond.getText();
        return r;

    }


    public void delNull()
    {
        try {
            if (dispMain.getText().equals("0")) {
                dispMain.setText("");
            }
            if (setRes1 == 1) {
                dispMain.setText("");
                setRes1 = 0;
            }
        }
        catch (Throwable e)
        {
            dispSecond.setText("jPanelApp.delNull");
            dispMain.setText(String.valueOf(e));
        }
    }


    public void getOpp()
    {
        try {

            res2 = Double.parseDouble(dispMain.getText());
            String strOp = op;
            MetodCalc mc = new MetodCalc();
            System.out.println("перед входом в оперцию "+dispSecond.getText());
            String strres1 = String.valueOf(mc.calc(res1, strOp, res2));
            //System.out.println("После выхода из операции "+strres1);
            System.out.println("После выхода из операции "+dispSecond.getText());
            dispMain.setText(strres1);
            if (op == "%") {
                dispSecond.setText(dispSecond.getText() + " " + strres1);
            }
            setRes1 = 1;
            res1 = Double.parseDouble(dispMain.getText());

        }
        catch (Throwable e)
        {
            dispSecond.setText("jPanelApp.getOpp");
            dispMain.setText(String.valueOf(e));
        }

    }

    public jPanelApp() {
        try {

                setLayout(null);  //Disable default item layout

                dispMain = new JTextField();
                dispMain.setBounds(37, 40, 218, 35);
                dispMain.setHorizontalAlignment(JTextField.RIGHT);
                dispMain.setFont(dispMain.getFont().deriveFont(22f));
                dispMain.setText("0");
                dispMain.setBorder(BorderFactory.createEmptyBorder());


                dispSecond = new JTextField(); //Текстовое поле верхнее
                dispSecond.setBounds(10, 10, 245, 30);
                dispSecond.setHorizontalAlignment(JTextField.RIGHT);
                dispSecond.setBorder(BorderFactory.createEmptyBorder());


                dispMem = new JTextField(); //Текстовое поле нижнее
                dispMem.setBounds(10, 40, 27, 35);
                dispMem.setHorizontalAlignment(JTextField.LEFT);
                dispMem.setFont(dispMem.getFont().deriveFont(14f));
                dispMem.setBorder(BorderFactory.createEmptyBorder());


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

                JButton bres = new JButton("=");
                bres.setBounds(210, 265, 45, 85);
                bres.setFont(bigFont2);

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

                add(dispMain);
                add(dispSecond);
                add(dispMem);
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
                add(bres);
                add(bPlus);
                add(bMinus);
                add(bMulti);
                add(bDivision);

                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 1);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 2);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 3);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 4);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 5);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 6);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 7);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 8);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 9);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                b0.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        delNull();
                        dispMain.setText(dispMain.getText() + 0);
                        if (mathPres == 1) {
                            pointPres = 0;
                        }
                        mathPres = 0;
                        resPres = 0;
                    }
                });

                bMMinus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        mem = (mem - Double.parseDouble(dispMain.getText()));
                        dispMem.setText("M");
                    }
                });

                bMPlus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        mem = (mem + Double.parseDouble(dispMain.getText()));
                        dispMem.setText("M");
                    }
                });

                bMR.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        dispMain.setText(String.valueOf(mem));
                        mathPres = 0;
                        pointPres = 2;
                        if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                        }
                    }
                });

                bMC.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        mem = 0;
                        dispMem.setText(" ");
                    }
                });

                bMS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        mem = Double.parseDouble(dispMain.getText());
                        dispMem.setText("M");
                    }
                });

                bPercent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        double res2P = Double.parseDouble(dispMain.getText());
                        String strOp = "%";
                        MetodCalc mc = new MetodCalc();
                        String strres1 = String.valueOf(mc.calc(res1, strOp, res2P));
                        dispMain.setText(strres1);
                        dispSecond.setText(dispSecond.getText() + " " + strres1);
                        sendToDispSecond = 1;
                        pointPres = 2;
                        if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                            dispSecond.setText(dispSecond.getText().substring(0, dispSecond.getText().length() - 2));
                        }
                    }
                });

                bC.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        dispMain.setText("0");
                        dispSecond.setText("");
                        res1 = res2 = resCycle = 0;
                        op = "";
                        mathPres = resPres = pointPres = sendToDispSecond = setRes1 = 0;
                    }
                });

                bCE.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        dispMain.setText("0");
                    }
                });

                bPoint.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        switch (pointPres) {
                            case 0:
                                dispMain.setText(dispMain.getText() + ".");
                                pointPres = 1;
                                break;
                            case 2:
                                dispMain.setText("0.");
                                setRes1 = 0;
                                pointPres = 1;
                                mathPres = 0;
                                break;
                        }
                    }
                });

                bBS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        if (mathPres != 1 && resPres != 1)
                            if (dispMain.getText().length() != 1) {
                                dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 1));
                            } else {
                                dispMain.setText("0");
                            }
                    }
                });

                b1X.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        double xres1 = 1;
                        double xres2 = Double.parseDouble(dispMain.getText());
                        String xop = "/";
                        MetodCalc mc = new MetodCalc();
                        String strres1 = String.valueOf(mc.calc(xres1, xop, xres2));
                        dispMain.setText(strres1);
                        pointPres = 2;
                        if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                        }
                    }
                });

                bV.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        double vres2 = 0;
                        double vres1 = Double.parseDouble(dispMain.getText());
                        String xop = "sqrt";
                        MetodCalc mc = new MetodCalc();
                        String strres1 = String.valueOf(mc.calc(vres1, xop, vres2));
                        pointPres = 2;
                        dispMain.setText(strres1);
                        if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                        }
                    }
                });


                bPlusMinus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        int ln = dispMain.getText().length() - 1;
                        if (!dispMain.getText().equals("0"))
                            if (dispMain.getText().substring(0, dispMain.getText().length() - ln).equals("-")) {
                                dispMain.setText(dispMain.getText().substring(1, dispMain.getText().length()));
                            } else {
                                dispMain.setText("-" + dispMain.getText());
                            }

                    }
                });

                bPlus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        if (dispMain.getText().substring(dispMain.getText().length() - 1).equals(".")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 1));
                        }
                        if (mathPres == 1) {
                            dispSecond.setText(dispSecond.getText().substring(0, dispSecond.getText().length() - 5));
                            dispSecond.setText(dispSecond.getText() + "  +  ");
                            op = "+";
                        } else {
                            if (res1 == 0) {
                                res1 = Double.parseDouble(dispMain.getText());
                                dispSecond.setText(dispMain.getText() + "  +  ");
                                setRes1 = 1;
                                op = "+";
                                mathPres = 1;
                                resPres = 0;
                                pointPres = 2;
                            } else {
                                if (sendToDispSecond == 1) {

                                    dispSecond.setText(dispSecond.getText() + "  +  ");
                                    sendToDispSecond = 0;

                                } else {
                                    dispSecond.setText(dispSecond.getText() + dispMain.getText() + "  +  ");

                                }
                                getOpp();
                                op = "+";
                                resPres = 0;
                                mathPres = 1;
                                pointPres = 2;
                                if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                    dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                                }
                            }
                        }

                    }
                });

                bMinus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        if (dispMain.getText().substring(dispMain.getText().length() - 1).equals(".")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 1));
                        }
                        if (mathPres == 1) {
                            dispSecond.setText(dispSecond.getText().substring(0, dispSecond.getText().length() - 5));
                            dispSecond.setText(dispSecond.getText() + "  -  ");
                            op = "-";
                        } else {
                            if (res1 == 0) {
                                res1 = Double.parseDouble(dispMain.getText());
                                dispSecond.setText(dispMain.getText() + "  -  ");
                                setRes1 = 1;
                                op = "-";
                                mathPres = 1;
                                resPres = 0;
                                pointPres = 2;
                            } else {
                                if (sendToDispSecond == 1) {

                                    dispSecond.setText(dispSecond.getText() + "  -  ");
                                    sendToDispSecond = 0;

                                } else {
                                    dispSecond.setText(dispSecond.getText() + dispMain.getText() + "  -  ");

                                }
                                getOpp();
                                op = "-";
                                mathPres = 1;
                                pointPres = 2;
                                if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                    dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                                }
                            }
                        }
                    }
                });

                bMulti.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        if (dispMain.getText().substring(dispMain.getText().length() - 1).equals(".")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 1));
                        }
                        if (mathPres == 1) {
                            dispSecond.setText(dispSecond.getText().substring(0, dispSecond.getText().length() - 5));
                            dispSecond.setText(dispSecond.getText() + "  *  ");
                            op = "*";
                        } else {
                            if (res1 == 0) {
                                res1 = Double.parseDouble(dispMain.getText());
                                dispSecond.setText(dispMain.getText() + "  *  ");
                                setRes1 = 1;
                                op = "*";
                                mathPres = 1;
                                resPres = 0;
                                pointPres = 2;
                            } else {
                                if (sendToDispSecond == 1) {

                                    dispSecond.setText(dispSecond.getText() + "  *  ");
                                    sendToDispSecond = 0;

                                } else {
                                    dispSecond.setText(dispSecond.getText() + dispMain.getText() + "  *  ");

                                }
                                getOpp();
                                op = "*";
                                mathPres = 1;
                                pointPres = 2;
                                if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                    dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                                }
                            }
                        }
                    }
                });

                bDivision.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg1) {
                        if (dispMain.getText().substring(dispMain.getText().length() - 1).equals(".")) {
                            dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 1));
                        }
                        if (mathPres == 1) {
                            dispSecond.setText(dispSecond.getText().substring(0, dispSecond.getText().length() - 5));
                            dispSecond.setText(dispSecond.getText() + "  /  ");
                            op = "/";
                        } else {
                            if (res1 == 0) {
                                res1 = Double.parseDouble(dispMain.getText());
                                dispSecond.setText(dispMain.getText() + "  /  ");
                                setRes1 = 1;
                                op = "/";
                                mathPres = 1;
                                resPres = 0;
                                pointPres = 2;
                            } else {
                                if (sendToDispSecond == 1) {

                                    dispSecond.setText(dispSecond.getText() + "  /  ");
                                    sendToDispSecond = 0;

                                } else {
                                    dispSecond.setText(dispSecond.getText() + dispMain.getText() + "  /  ");

                                }
                                getOpp();
                                op = "/";
                                mathPres = 1;
                                pointPres = 2;
                                if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                    dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                                }
                            }
                        }
                    }
                });

                bres.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if (resPres == 1) {
                            if (resCycle == 0) {
                                resCycle = res2;
                            }
                            res2 = Double.parseDouble(dispMain.getText());
                            String strOp = op;
                            MetodCalc mc = new MetodCalc();

                            String strres1 = String.valueOf(mc.calc(resCycle, strOp, res2));
                            dispMain.setText(strres1);
                            dispSecond.setText("");
                            setRes1 = 1;
                            mathPres = 0;
                            pointPres = 2;
                            if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                            }
                            } else {
                            res2 = Double.parseDouble(dispMain.getText());
                            String strOp = op;
                            MetodCalc mc = new MetodCalc();
                            String strres1 = String.valueOf(mc.calc(res1, strOp, res2));
                            dispMain.setText(strres1);
                            dispSecond.setText("");
                            res1 = 0;
                            setRes1 = 1;
                            mathPres = 0;
                            resPres = 1;
                            pointPres = 2;
                            if (dispMain.getText().substring(dispMain.getText().length() - 2).equals(".0")) {
                                dispMain.setText(dispMain.getText().substring(0, dispMain.getText().length() - 2));
                            }
                            }
                        TestSetToDispSecond qqq = new TestSetToDispSecond();
                        qqq.testSet();
                    }
                });


            //throw new RuntimeException("demo");

        }
                catch (Throwable e)
                {
                    dispSecond.setText("jPanelApp.jPanelApp");
                    dispMain.setText(String.valueOf(e));
                }
        }
    }












