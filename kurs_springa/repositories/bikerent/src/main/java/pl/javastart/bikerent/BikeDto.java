package pl.javastart.bikerent;

class BikeDto {
    private Long id;
    private String model;
    private String serialNo;
    private double hourPrice;
    private double dayPrice;

    BikeDto(Long id, String model, String serialNo, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNo = serialNo;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    String getSerialNo() {
        return serialNo;
    }

    void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    double getHourPrice() {
        return hourPrice;
    }

    void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    double getDayPrice() {
        return dayPrice;
    }

    void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "BikeDto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                '}';
    }
}
