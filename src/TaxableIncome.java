public class TaxableIncome {
    private final double basicSalary;
    private final double houseRentExemption;
    private final double houseRentTaxable;
    private final double medicalExemption;
    private final double medicalTaxable;
    private final double conveyanceExemption;
    private final double conveyanceTaxable;
    private final double incentive;
    private final double festivalBonus;
    private final double totalTaxableIncome;

    private double totalIncome = 0;

    public TaxableIncome(double basicSalary, double houseRent, double medicalAllowance, double conveyanceAllowance, double incentive, double festivalBonus) {

        //calculate total income
        totalIncome = basicSalary + houseRent + medicalAllowance + conveyanceAllowance + incentive + festivalBonus;

        this.basicSalary = basicSalary;
        this.houseRentExemption = Math.min(basicSalary * 0.5, 25000 * 12);
        this.houseRentTaxable = Math.max(houseRent - houseRentExemption, 0);
        this.medicalExemption = Math.min(basicSalary * 0.1, 120000);
        this.medicalTaxable = Math.max(medicalAllowance - medicalExemption, 0);
        this.conveyanceExemption = 30000;
        this.conveyanceTaxable = Math.max(conveyanceAllowance - conveyanceExemption, 0);
        this.incentive = incentive;
        this.festivalBonus = festivalBonus;
        this.totalTaxableIncome = basicSalary + houseRentTaxable + medicalTaxable + conveyanceTaxable + incentive + festivalBonus;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHouseRentExemption() {
        return houseRentExemption;
    }

    public double getHouseRentTaxable() {
        return houseRentTaxable;
    }

    public double getMedicalExemption() {
        return medicalExemption;
    }

    public double getMedicalTaxable() {
        return medicalTaxable;
    }

    public double getConveyanceExemption() {
        return conveyanceExemption;
    }

    public double getConveyanceTaxable() {
        return conveyanceTaxable;
    }

    public double getIncentive() {
        return incentive;
    }

    public double getFestivalBonus() {
        return festivalBonus;
    }

    public double getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}
