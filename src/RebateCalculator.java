public class RebateCalculator extends TaxCalculator {
    private double AcceptedInvestment;
    private double Rebate;
    private double TaxAfterRebate;

    public RebateCalculator() {
    }

    public RebateCalculator(double GrossTaxLiability,double totalTaxableIncome, double investment) {
        // Calculate Allowable Investment
        double AllowableInvestment = totalTaxableIncome * 0.25;
        if (investment < AllowableInvestment) {
            AcceptedInvestment = investment;
        }

        // Calculate Rebate
        Rebate = Math.round(investment * 0.15);

        // Calculate Tax After Rebate
        TaxAfterRebate = GrossTaxLiability - Rebate;
    }

    public double getAcceptedInvestment() {
        return AcceptedInvestment;
    }

    public double getRebate() {
        return Rebate;
    }

    public double getTaxAfterRebate() {
        return TaxAfterRebate;
    }
}
