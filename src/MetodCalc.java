import java.math.MathContext;

import static java.lang.StrictMath.sqrt;

class MetodCalc
{
    public double calc ( double n1, String op, double n2)
    {
        try {
            double res = 0;
            switch (op)
            {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "*":
                    res = n1 * n2;
                    break;
                case "/":
                    res = n1 / n2;
                    break;
                case "%":
                    res = n1 / 100 * n2;
                    break;
                case "sqrt":
                    res = sqrt(n1);
                    break;
                default:
                    res = n2;
                    break;
            }
            throw new NullPointerException("Математика");
           // return res;

        }

        catch (Throwable e)
        {
          //jPanelApp test = new jPanelApp();
          //test.dispSecond.setText(String.valueOf(e));
          // System.out.println("сразу после вызова setDisp " + test.getDisp() );
           //jPanelApp.ff = "test123";

        }
        return n1;
    }
}
