package pl.javastart.bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
class Bike {
    @Id
    private Long id;
    private String model;
    private String serialNo;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;

    private LocalDateTime dateOfReturn;

    public Bike(){};

    Bike(Long id, String model, String serialNo, double hourPrice, double dayPrice) {
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

    String getBorrowerId() {
        return borrowerId;
    }

    void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    LocalDateTime getDateOfReturn() {
        return dateOfReturn;
    }

    void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                ", borrowerId='" + borrowerId + '\'' +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}
