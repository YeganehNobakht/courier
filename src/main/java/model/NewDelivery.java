package model;

import javax.persistence.*;

@Entity
@TableGenerator(name="tab", initialValue=10000/*, allocationSize=50000*/)
public class NewDelivery {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="tab")
    private String trackingCode;
    @Column
    private String originAddress;
    @Column
    private String destinationAddress;
    @Column
    private String RecipientsPhone;
    @Column
    private String RecipientsName;
    @Column
    private String packageType;
    @Column
    private int packageWeight;
    @Column
    private String packageSize;
    @Column
    private String sendType;

    public NewDelivery(String trackingCode, String originAddress, String destinationAddress, String recipientsPhone, String recipientsName, String packageType, int packageWeight, String packageSize, String sendType) {
        this.trackingCode = trackingCode;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        RecipientsPhone = recipientsPhone;
        RecipientsName = recipientsName;
        this.packageType = packageType;
        this.packageWeight = packageWeight;
        this.packageSize = packageSize;
        this.sendType = sendType;
    }

    public NewDelivery() {
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getRecipientsPhone() {
        return RecipientsPhone;
    }

    public void setRecipientsPhone(String recipientsPhone) {
        RecipientsPhone = recipientsPhone;
    }

    public String getRecipientsName() {
        return RecipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        RecipientsName = recipientsName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(int packageWeight) {
        this.packageWeight = packageWeight;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }
}
