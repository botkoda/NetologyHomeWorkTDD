public class CreditCalculator {

    public double monthlyPayment(double credit, int month, double percent){
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        return round(credit*k,2);
    }

    public double totalAmountRefunded(double monthlyPayment,int month){
        return round(monthlyPayment*month,2);
    }
    public double overpayment(double monthlyPayment,int month,double credit){

        return round(monthlyPayment*month-credit,2);
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
