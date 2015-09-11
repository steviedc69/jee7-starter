package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
@Entity
@NamedQueries(
        @NamedQuery(name = Passenger.FIND_ALL, query = "select p from Passenger p")
)
public class Passenger implements Serializable{

    public static final String FIND_ALL = "Passeger.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false,updatable = false)
    private String ssn;
    @Basic(optional = false)
    @Column(length = 50)
    private String firstName;
    @Basic(optional = false)
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private int age;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.DETACH)
    private Collection<Ticket> tickets;
    private Integer aantalPrefs;
    private Integer aantalCredits;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerType passengerType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    @Embedded
    private Adress adress;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<CreditCard> creditCardList;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tags")
    private List<String>preferences;

    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles,String date, PassengerType type,Adress adress) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.setDateOfBirth(date);
        this.passengerType = type;
        flightTime = new Date();
        this.setAge(getDateOfBirth());
        addCreditCardToList(new CreditCard("2121323131", "12/08", 1522, CreditCardType.VISA));
        addPreference("none");
        this.adress = adress;
        this.aantalCredits = getCreditCardCount();
        this.aantalPrefs= getPrefListCount();
        this.tickets = new ArrayList<>();

    }

    public void buyTicket(Ticket ticket)
    {
        if(tickets == null)
        {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);
        ticket.setPassenger(this);
    }

    public int getAantalPrefs() {
        return aantalPrefs;
    }

    public void setAantalPrefs(int aantalPrefs) {
        this.aantalPrefs = aantalPrefs;
    }

    public int getAantalCredits() {
        return aantalCredits;
    }

    public void setAantalCredits(int aantalCredits) {
        this.aantalCredits = aantalCredits;
    }

    public void addCreditCardToList(CreditCard card)
    {
        if(creditCardList == null)
        {
            creditCardList=new ArrayList<>();
        }

        creditCardList.add(card);
    }
    public int getCreditCardCount()
    {
        return this.creditCardList.size();
    }

    public void addPreference(String pref)
    {
        if(preferences == null)
        {
            preferences = new ArrayList<>();
        }

        preferences.add(pref);
    }
    public int getPrefListCount()
    {
        return preferences.size();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateOfBirth = format.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    private void setAge(Date dateOfBirth)
    {
        Date now = new Date();
        int year = now.getYear();
        int birthYear = dateOfBirth.getYear();
        age = year - birthYear;
    }

    public int getAge()
    {

        return this.age;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public Long getId() {
        return id;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

}
