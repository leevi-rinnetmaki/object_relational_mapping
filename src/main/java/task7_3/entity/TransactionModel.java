package task7_3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")

public class TransactionModel {


    @Id
    int id;
    double amount;
    @ManyToOne
    @JoinColumn(name = "source_currency_abbreviation")
    CurrencyModel sourceCurrency;
    @ManyToOne
    @JoinColumn(name = "targer_currency_abbreviation")
    CurrencyModel targerCurrency;

    public CurrencyModel getTargerCurrency() {
        return targerCurrency;
    }

    public void setTargerCurrency(CurrencyModel targerCurrency) {
        this.targerCurrency = targerCurrency;
    }

    public CurrencyModel getSourceCourrency() {
        return sourceCurrency;
    }

    public void setSourceCourrency(CurrencyModel sourceCourrency) {
        this.sourceCurrency = sourceCourrency;
    }


    public TransactionModel() {
    }

    public TransactionModel(int id, double amount, CurrencyModel sourceCurrency, CurrencyModel targerCurrency) {
        this.id = id;
        this.amount = amount;
        this.sourceCurrency = sourceCurrency;
        this.targerCurrency = targerCurrency;
    }
}
