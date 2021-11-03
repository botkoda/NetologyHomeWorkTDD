public class Main {
    public static void main(String[] args) {
        final double CREDIT=300000;
        final int MONTH=18;
        final double PERCENT=15;
        CreditCalculator creditCalculator=new CreditCalculator();
        double monthlyPayment= creditCalculator.monthlyPayment(CREDIT,MONTH,PERCENT);

        System.out.println("При кредите: " + CREDIT +
                "\nНа срок: " + MONTH+ "месяцев. И ставкой: " +PERCENT+"%" +
                "\nПлатеж равен: " + monthlyPayment );
        System.out.println("Перепалата: "+ creditCalculator.overpayment(monthlyPayment,MONTH,CREDIT));
        System.out.println("Общая сумма кредита: "+ creditCalculator.totalAmountRefunded(monthlyPayment,MONTH));
    }
}
