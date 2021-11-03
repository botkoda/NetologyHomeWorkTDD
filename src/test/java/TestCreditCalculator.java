import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCreditCalculator {
    Random random = new Random();

    @Test
    public void testMonthlyPayment(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        int month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double result=creditCalculator.monthlyPayment(credit,month,percent);
        Assertions.assertTrue( creditCalculator.round(credit*k,2) == result);
    }
    @Test
    public void testTotalAmountRefunded(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        int month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double monthlyPayment=credit*k;
        double result=creditCalculator.totalAmountRefunded(monthlyPayment,month);
        Assertions.assertTrue( creditCalculator.round(monthlyPayment*month,2) == result);

    }
    @Test
    public void testOverpayment(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        int month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double monthlyPayment=credit*k;
        double result=creditCalculator.overpayment(monthlyPayment,month,credit);
        Assertions.assertTrue( creditCalculator.round(monthlyPayment*month-credit,2) == result);
    }
}
