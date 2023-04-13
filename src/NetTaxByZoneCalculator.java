public class NetTaxByZoneCalculator extends RebateCalculator {

    private double netTax;

    public NetTaxByZoneCalculator(double taxAfterRebate, PayerZone zone) {
        double grossTaxLiability = super.getGrossTaxLiability();

        switch (zone) {
            case DhakaOrChittagong:
                if (taxAfterRebate < 5001) {
                    netTax = Math.min(taxAfterRebate, grossTaxLiability < 300000 ? 0 : 5000);
                } else {
                    netTax = taxAfterRebate;
                }
                break;
            case OtherCities:
                if (taxAfterRebate < 3001) {
                    netTax = Math.min(taxAfterRebate, grossTaxLiability < 300000 ? 0 : 3000);
                } else {
                    netTax = taxAfterRebate;
                }
                break;
            case RestOfTheCountry:
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
