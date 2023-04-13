public class TaxCalculator {
    private double totalTaxableIncome;
    private PayerCategory category;
    private double slab1, slab2, slab3, slab4, slab5, slab6;
    private double tax1, tax2, tax3, tax4, tax5, tax6;

    private double grossTaxLiability;
    private double eligibleAmount;

    public TaxCalculator() {
    }

    public TaxCalculator(double totalTaxableIncome, PayerCategory category) {
        this.totalTaxableIncome = totalTaxableIncome;
        this.category = category;
        calculateTax();
    }

    private void calculateTax() {

        // Calculate slab values based on category
        switch (category) {
            case General:
                slab1 = Math.min(300000, totalTaxableIncome);
                slab2 = Math.min(100000, Math.max(0, totalTaxableIncome - 300000));
                slab3 = Math.min(300000, Math.max(0, totalTaxableIncome - 400000));
                slab4 = Math.min(400000, Math.max(0, totalTaxableIncome - 700000));
                slab5 = Math.min(500000, Math.max(0, totalTaxableIncome - 1100000));
                slab6 = Math.max(0, totalTaxableIncome - 1600000);
                break;
            case FemaleOrSeniorCitizen:
                slab1 = Math.min(350000, totalTaxableIncome);
                slab2 = Math.min(100000, Math.max(0, totalTaxableIncome - 350000));
                slab3 = Math.min(300000, Math.max(0, totalTaxableIncome - 450000));
                slab4 = Math.min(400000, Math.max(0, totalTaxableIncome - 750000));
                slab5 = Math.min(500000, Math.max(0, totalTaxableIncome - 1150000));
                slab6 = Math.max(0, totalTaxableIncome - 1650000);
                break;
            case Disabled:
                slab1 = Math.min(450000, totalTaxableIncome);
                slab2 = Math.min(100000, Math.max(0, totalTaxableIncome - 450000));
                slab3 = Math.min(300000, Math.max(0, totalTaxableIncome - 550000));
                slab4 = Math.min(400000, Math.max(0, totalTaxableIncome - 850000));
                slab5 = Math.min(500000, Math.max(0, totalTaxableIncome - 1250000));
                slab6 = Math.max(0, totalTaxableIncome - 1750000);
                break;
            case GazettedFreedomFighter:
                slab1 = Math.min(475000, totalTaxableIncome);
                slab2 = Math.min(100000, Math.max(0, totalTaxableIncome - 475000));
                slab3 = Math.min(300000, Math.max(0, totalTaxableIncome - 575000));
                slab4 = Math.min(400000, Math.max(0, totalTaxableIncome - 875000));
                slab5 = Math.min(500000, Math.max(0, totalTaxableIncome - 1275000));
                slab6 = Math.max(0, totalTaxableIncome - 1775000);
                break;
            default:
                System.out.println("Invalid category");
                return;
        }

        // Calculate tax for each slab
        tax1 = slab1 * 0;
        tax2 = slab2 * 0.05;
        tax3 = slab3 * 0.1;
        tax4 = slab4 * 0.15;
        tax5 = slab5 * 0.2;
        tax6 = slab6 * 0.25;

        // Calculate gross tax liability and eligible amount
        this.grossTaxLiability = tax1 + tax2 + tax3 + tax4 + tax5 + tax6;
        this.eligibleAmount = totalTaxableIncome * 0.25;
    }

    void PrintSlab() {
        // Print tax details
        System.out.println("Upto 300,000 Taka: " + slab1 + " (0%)" + " Tax: " + tax1);
        System.out.println("On the Next 100,000 Taka: " + slab2 + " (5%)" + " Tax: " + tax2);
        System.out.println("On the Next 300,000 Taka: " + slab3 + " (10%)" + " Tax: " + tax3);
        System.out.println("On the Next 400,000 Taka: " + slab4 + " (15%)" + " Tax: " + tax4);
        System.out.println("On the Next 500,000 Taka: " + slab5 + " (20%)" + " Tax: " + tax5);
        System.out.println("On the Amount Exceeding : " + slab6 + " (25%)" + " Tax: " + tax6);

        System.out.println("Gross Tax Liability: " + grossTaxLiability);

    }

    public double getGrossTaxLiability() {
        return grossTaxLiability;
    }

    public double getEligibleAmount() {
        return eligibleAmount;
    }
}
