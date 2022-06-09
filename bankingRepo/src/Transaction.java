public class Transaction {

    private String typeOfTransaction;
    private int amountOfTransaction;

    Transaction(String defaultTypeOfTransaction, int defaultAmountOfTransaction) {
        this.typeOfTransaction = defaultTypeOfTransaction;
        this.amountOfTransaction = defaultAmountOfTransaction;
    }

    // todo: remove custom constructor, use default and use setter methods to initialise a transaction

    public void setTypeOfTransaction(String type) {
        typeOfTransaction = type;
    }

    public String getTypeOfTransaction() {
        return this.typeOfTransaction;
    }

    public int getAmountOfTransaction() {
        return amountOfTransaction;
    }

    public void setAmountOfTransaction(int amountOfTransaction) {
        this.amountOfTransaction = amountOfTransaction;
    }

    public String transactionDescription() {
        return typeOfTransaction + ' ' + amountOfTransaction + " $";
    }
}




