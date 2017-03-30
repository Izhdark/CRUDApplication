package com.process.PersonManager.model.contentModel;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by Кирилл on 02.02.2017.
 */
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPurchase;

    @Column(name = "date")
    private Date date;

    //@Pattern(regexp = "(\\d)+",message = "Должны быть только цифры")
    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "id_card")
    private CreditCard primaryCreditCard;

    @Pattern(regexp = "([А-аЯ-я]|[A-aZ-z]|\\d)+")
    @Size(min = 3,max = 20,message = "Название магазина должно быть от 3 до 20 символов")
    @Column(name = "store_name")
    private String store_name;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public CreditCard getPrimaryCreditCard() {
        return primaryCreditCard;
    }

    public void setPrimaryCreditCard(CreditCard primaryCreditCard) {
        this.primaryCreditCard = primaryCreditCard;
    }

    public Purchase(Date date, int cost,String store_name) {
        this.date = date;
        this.cost = cost;
        this.store_name = store_name;
    }

    public Purchase() {
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "idPurchase=" + idPurchase +
                ", date=" + date +
                ", cost=" + cost +
                ", primaryCreditCard=" + primaryCreditCard +
                ", store_name='" + store_name + '\'' +
                '}';
    }
}
