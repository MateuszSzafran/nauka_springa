package pl.mszafran.dto_standard;

class VatDto {
    private double nettoPrice;
    private double grossPrice;
    private double vatRate;

    public VatDto(double nettoPrice, double grossPrice, double vatRate) {
        this.nettoPrice = nettoPrice;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }
}
