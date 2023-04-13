public class Main {
    public static void main(String[] args) {

        // Test Data
        double basicSalary = 8000000;
        double houseRent = 20000;
        double medicalAllowance = 140000;
        double conveyanceAllowance = 5000;
        double incentive = 15000;
        double festivalBonus = 20000;
        double investment = 50000;

        PayerCategory payerCategory = PayerCategory.General;
        PayerZone payerZone = PayerZone.DhakaOrChittagong;

        // Taxable Income Calculation
        TaxableIncome incomeCalculator = new TaxableIncome(basicSalary, houseRent, medicalAllowance, conveyanceAllowance, incentive, festivalBonus);


        System.out.println("Taxable Income Calculation");
        System.out.println("Basic Salary | Amount: " + basicSalary + " | Exemption: 0 | Taxable: " + basicSalary);
        System.out.println("House Rent | Amount: " + houseRent + " | Exemption: " + incomeCalculator.getHouseRentExemption() + " | Taxable: " + incomeCalculator.getHouseRentTaxable());
        System.out.println("Medical Allowance | Amount: " + medicalAllowance + " | Exemption: " + incomeCalculator.getMedicalExemption() + " | Taxable: " + incomeCalculator.getMedicalTaxable());
        System.out.println("Conveyance Allowance | Amount: " + conveyanceAllowance + " | Exemption: " + incomeCalculator.getConveyanceExemption() + " | Taxable: " + incomeCalculator.getConveyanceTaxable());
        System.out.println("Incentive | Amount: " + incentive + " | Exemption: 0 | Taxable: " + incentive);
        System.out.println("Festival Bonus | Amount: " + festivalBonus + " | Exemption: 0 | Taxable: " + festivalBonus);
        System.out.println();
        System.out.println("Total: " + incomeCalculator.getTotalIncome());
        System.out.println("Total Taxable Income: " + incomeCalculator.getTotalTaxableIncome());
        System.out.println();

        System.out.println("Gross Tax Liability");
        TaxCalculator taxCalculator = new TaxCalculator(incomeCalculator.getTotalTaxableIncome(), payerCategory);
        taxCalculator.PrintSlab();
        System.out.println();

        System.out.println("Rebate");
        RebateCalculator rebateCalculator = new RebateCalculator(taxCalculator.getGrossTaxLiability(), incomeCalculator.getTotalTaxableIncome(), investment);
        System.out.println("Eligible Amount " + taxCalculator.getEligibleAmount());
        System.out.println("Accepted Investment Investment: " + rebateCalculator.getAcceptedInvestment());
        System.out.println("Rebate: " + rebateCalculator.getRebate());
        System.out.println();

        System.out.println("Net Tax Payable");
        NetTaxByZoneCalculator netTaxByZoneCalculator = new NetTaxByZoneCalculator(rebateCalculator.getTaxAfterRebate(), payerZone);
        System.out.println("Gross Tax Liability: " + taxCalculator.getGrossTaxLiability());
        System.out.println("Text After Rebate : " + rebateCalculator.getTaxAfterRebate());
        System.out.println("Net Tax Payable: " + netTaxByZoneCalculator.getNetTax());

    }
}