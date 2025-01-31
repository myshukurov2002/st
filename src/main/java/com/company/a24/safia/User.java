package com.company.a24.safia;

public class User {
    private  long chatId;
    private String fullName;
    private String phoneNumber;
    private String classNumber;

    private  BotState state;

    private String Buyurtma_Shop;

    private String Raqam_M;

    private String Katta_Pirog;

    private String Katta_Tort;

    private String Dumaloq_Tort;
    private String Tartaletka;

    public String getKatta_Tort() {
        return Katta_Tort;
    }

    public void setKatta_Tort(String katta_Tort) {
        Katta_Tort = katta_Tort;
    }

    public String getKatta_Pirog() {
        return Katta_Pirog;
    }

    public void setKatta_Pirog(String katta_Pirog) {
        Katta_Pirog = katta_Pirog;
    }

    public String getRaqam_M() {
        return Raqam_M;
    }

    public void setRaqam_M(String raqam_M) {
        Raqam_M = raqam_M;
    }

    public String getBuyurtma_Shop() {
        return Buyurtma_Shop;
    }

    public void setBuyurtma_Shop(String buyurtma_Shop) {
        Buyurtma_Shop = buyurtma_Shop;
    }

    public String getShop_M() {
        return Shop_M;
    }

    public void setShop_M(String shop_M) {
        Shop_M = shop_M;
    }

    private String Shop_M;



    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public BotState getState() {
        return state;
    }

    public void setState(BotState state) {
        this.state = state;
    }

    public String getDumaloq_Tort() {
        return Dumaloq_Tort;
    }

    public void setDumaloq_Tort(String dumaloq_Tort) {
        Dumaloq_Tort = dumaloq_Tort;
    }

    public String getTartaletka() {
        return Tartaletka;
    }

    public void setTartaletka(String tartaletka) {
        Tartaletka = tartaletka;
    }
}