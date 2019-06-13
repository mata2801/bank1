package entity;

class Transation {
    private long id;
    private int type;
    private double amount;
    private String content;
    private long senderAccountNumber;
    private long receiverAccountNumber;
    private long createdAt;
    private long updatedAt;
    private int status;

    public Transation() {
    }

    public Transation(int type, double amount, String content, long senderAccountNumber, long receiverAccountNumber) {
        long now = System.currentTimeMillis();
        this.id = now;
        this.type = type;
        this.amount = amount;
        this.content = content;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.createdAt = now;
        this.updatedAt = now;
        this.status = Status.PROCESSING.getStatus();
    }


    public enum TransactionType {
        DEPOSIT(1), WITHDRAW(2), TRANSFER(3);
        int code;

        TransactionType(int code) {
            this.code = code;
        }

        public int getType(){
            return code;
        }

        public static TransactionType findByType(int code){
            for (TransactionType type : TransactionType.values()) {
                if (type.getType() == code) return type;
            }
            return null;
        }
    }


    public enum Status{
        PROCESSING(1), DONE(2), REJECT(0), DELETED(-1);
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
        if (status == null) status = Status.DELETED;
        this.status = status.getStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(long senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
