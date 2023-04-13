public class NetTaxByZoneCalculator extends RebateCalculator {

    private double netTax;

    public NetTaxByZoneCalculator(double totalTaxableIncome, double taxAfterRebate, int category, double investment, int zone) {
        super(totalTaxableIncome, category, investment);
        double grossTaxLiability = super.getGrossTaxLiability();

        switch (zone) {
            case 1:
                if (taxAfterRebate < 5001) {
                    netTax = Math.min(taxAfterRebate, grossTaxLiability < 300000 ? 0 : 5000);
                } else {
                    netTax = taxAfterRebate;
                }
                break;
            case 2:
                if (taxAfterRebate < 3001) {
                    netTax = Math.min(taxAfterRebate, grossTaxLiability < 300000 ? 0 : 3000);
                } else {
                    netTax = taxAfterRebate;
                }
                break;
            case 3:
                if (taxAfterRebate < 4001) {
                    netTax = Math.min(taxAfterRebate, grossTaxLiability < 300000 ? 0 : 4000);
                } else {
                    netTax = taxAfterRebate;
                }
                break;
        }

    }

    public double getNetTax() {
        return netTax;
    }
}
