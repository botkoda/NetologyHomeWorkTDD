import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCreditCalculator {
    Random random = new Random();

    @Test
    public void testMonthlyPayment(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        double month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double result=creditCalculator.monthlyPayment(credit,month,percent);
        Assertions.assertTrue( credit*k == result);
    }
    @Test
    public void testTotalAmountRefunded(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        double month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double monthlyPayment=credit*k;
        double result=creditCalculator.totalAmountRefunded(monthlyPayment,month);
        Assertions.assertTrue( monthlyPayment*month == result);

    }
    @Test
    public void testOverpayment(){
        CreditCalculator creditCalculator=new CreditCalculator();
        double credit=random.nextInt();
        double month=random.nextInt();
        double percent=random.nextInt();
        double k=percent/month/100*Math.pow((1+percent/month/100),month) / ((Math.pow((1+percent/month/100),month))-1);
        double monthlyPayment=credit*k;
        double result=creditCalculator.overpayment(monthlyPayment,month,credit);
        Assertions.assertTrue( monthlyPayment*month-credit == result);
    }
}
