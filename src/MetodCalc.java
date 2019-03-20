
class MetodCalc
{
    public double calc ( double n1, String op, double n2)
    {
        double res = 0;
        switch (op)
        {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                res = n2;
                break;
        }
        return res;
    }
}
