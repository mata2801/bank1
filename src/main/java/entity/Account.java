package entity;

import model.AccountModel;

import java.util.Calendar;

public class Account {
    private static final AccountModel model = new AccountModel();
    private long id;
    private String username;
    private String password;
    private long accountNumber;
    private String identityCard;
    private double balance;
    private String phone;
    private String email;
    private String fullName;
    private int gender;
    private long createdAt;
    private long updatedAt;
    private int stauts;

    public Account() {
    }

    public Account(String username, String password, String identityCard, String phone, String email, String fullName, int gender) {
        long now = Calendar.getInstance().getTimeInMillis();
        this.id = now;
        this.username = username;
        this.password = password;
        this.accountNumber = now;
        this.identityCard = identityCard;
        this.balance = 100000;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.gender = Gender.findByCode(gender).getGender();
        this.createdAt = now;
        this.updatedAt = now;
        this.stauts = Status.PENDING.getStatus();
    }

    public Account(String username, String password, int stauts) {
        this.username = username;
        this.password = password;
        this.stauts = stauts;
    }

    public Account(long id, String username, String password, long accountNumber, String identityCard, double balance, String phone, String email, String fullName, int gender, long createdAt, long updatedAt, int stauts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.identityCard = identityCard;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.stauts = stauts;
    }

    public enum Status{
        PENDING(0), COMPLETED(1), DELETED(-1);
        public static final Transation.Status ACTIVE = ;
        public static Status PENDING;
        int code;

        Status(int code) {
            this.code = code;
        }

        public int getStatus(){
            return code;
        }

        public static Status findByType(int code){
            for (Status status : Status.values()) {
                if (status.getStatus() == code) return status;
            }
            return null;
        }
    }

    public void setStatus(Status status){
        if (status == null) status = Status.PENDING;
        this.stauts = status.getStatus();
    }

    public enum Gender{
        Male(1), Female(0), Other(2);
        int gender;

        Gender(int gender) {
            this.gender = gender;
        }

        public int getGender(){
            return gender;
        }

        public static Gender findByCode(int code){
            for (Gender gender : Gender.values()) {
                if (gender.getGender() == code) return gender;
            }
            return null;
        }
    }

    public void setGender(Gender gender){
        if (gender == null) gender = Gender.Other;
        this.stauts = gender.getGender();
    }


    public boolean checkLogin(){
        Account a = model.findByUsernameAndStatus(this.username, Status.findByType(this.stauts));
        return this.username.equals(a.getUsername()) && this.password.equals(a.getPassword());
    }

    public boolean register(){
        return model.insertAccount(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }
}
