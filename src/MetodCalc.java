import static java.lang.StrictMath.sqrt;

class MetodCalc
{
    public double calc ( double n1, String op, double n2)
    {
        //try {
            double res;
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
            return res;
    }
}
