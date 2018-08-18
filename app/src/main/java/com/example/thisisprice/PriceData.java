package com.example.thisisprice;


public class PriceData {
    private int price;
    private int shipping;
    private String address;
    private String cardCompany;
    private String brand;
    private int result;

    public PriceData(){

    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getShipping(){
        return shipping;
    }

    public  void setShipping(int shipping){
        this.shipping = shipping;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getCardCompany() {
        return cardCompany;
    }

    public void setCardCompany(String cardCompany) {
        this.cardCompany = cardCompany;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public double getCardFee(){
        switch (cardCompany){
            case "신한":
                return 0.0018;
            case "롯데":
                return 0.002;
            case "국민":
                return 0.0025;
            case "씨티":
                return 0.005;
            case "삼성":
                return 0.002;
            case "현대":
                return 0.0018;
            case "우리":
                return 0.003;
            case "농협":
                return 0.0035;
            case "하나":
                return 0.003;
            case "BC":
                return 0.0035;
            default:
                return 0.002;
        }
    }

    public double getBrandFee(){
        switch (brand){
            case "VISA":
                return 0.011;
            case "MASTER":
                return 0.01;
            case "AMEX":
                return 0.014;
            case "Maestro":
                return 0.03;
            case "JCB":
                return 0;
            case "BCG":
                return 0;
            case "Unionpay":
                return 0.008;
            default:
                return 0.02;
        }
    }

    public int getProductPrice(double krw){
        return (int) ((price + price * (getBrandFee() + getCardFee())) * krw);
    }

    public int getCustomTax() {
        return 0;
    }
}
