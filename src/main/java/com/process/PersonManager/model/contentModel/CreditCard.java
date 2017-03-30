package com.process.PersonManager.model.contentModel;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Кирилл on 02.02.2017.
 */
@Entity
@Table(name = "card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCard;

    @Size(min = 1,max = 50,message = "Тип карты должно быть до 50 симоволов ")
    @Pattern(regexp = "[A-Za-z]+",message = "Введите правильно тип карты")
    @Column(name = "type")
    private String type;

    @Size(min = 1,max = 30,message = "Номер карты далжен быть в пределах от 1 до 30 символов")
    @Pattern(regexp = "((\\d){1,4}\\-)*(\\d){1,4}",message = "Введите правильно номер карты")
    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person primaryPerson;

    @Column(name = "money")
    private int money;

    @ManyToOne
    @JoinColumn(name = "id_bank")
    private Bank primaryBank;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "primaryCreditCard")
    private List<Purchase> purchaseList;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPrimaryPerson() {
        return primaryPerson;
    }

    public void setPrimaryPerson(Person person) {
        this.primaryPerson = person;
    }

    public Bank getPrimaryBank() {
        return primaryBank;
    }

    public void setPrimaryBank(Bank primaryBank) {
        this.primaryBank = primaryBank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public CreditCard(String type, String number, Person primaryPerson, int money, Bank primaryBank) {
        this.type = type;
        this.number = number;
        this.primaryPerson = primaryPerson;
        this.money = money;
        this.primaryBank = primaryBank;
    }

    public CreditCard() {
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "idCard=" + idCard +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", money=" + money +
                '}';
    }
}
