package com.process.PersonManager.model.contentModel;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.List;

/**
 * Created by Кирилл on 02.02.2017.
 */
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 1,max = 10, message = "Название банка должно иметь до 10 символов!")
    @Pattern(regexp = "([A-Za-z]+)",message = "Введите правильно название банка")
    @Column(name = "name")
    private String name;

    @Column(name = "site")
    private String site;

    @Size(min = 1,max = 50,message = "Адрес должен иметь до 50 символов")
    @Pattern(regexp = "(\\w)*")
    @Column(name = "adress")
    private String adress;

    @Column(name = "term_of_issue_of_bank_cards")
    private Time term_of_issue_of_bank_cards;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "primaryBank")
    private List<CreditCard> creditCards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Time getTerm_of_issue_of_bank_cards() {
        return term_of_issue_of_bank_cards;
    }

    public void setTerm_of_issue_of_bank_cards(Time term_of_issue_of_bank_cards) {
        this.term_of_issue_of_bank_cards = term_of_issue_of_bank_cards;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Bank(String name, String site, String adress, Time term_of_issue_of_bank_cards) {
        this.name = name;
        this.site = site;
        this.adress = adress;
        this.term_of_issue_of_bank_cards = term_of_issue_of_bank_cards;
    }

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "idBank=" + id +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", adress='" + adress + '\'' +
                ", termsOfUssueOfBankCards=" + term_of_issue_of_bank_cards +
                ", creditCards=" + creditCards +
                '}';
    }
}
