package com.realdolmen.course.domain;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * Created by SDOAX36 on 9/09/2015.
 */
@Entity
@SecondaryTables({
        @SecondaryTable(name = "t_ffm"),
        @SecondaryTable(name= "t_image")
})
public class Passenger {

    @EmbeddedId
    private PassengerId id;

    @Basic(optional = false)
    private String firstName;

    @Column(table = "t_ffm")
    private Integer frequentFlyerMiles;

    @Column(table="t_image")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;

    public Passenger() {
    }

    public Passenger(PassengerId id, String firstName, Integer frequentFlyerMiles) {
        this.id = id;
        this.firstName = firstName;

        this.frequentFlyerMiles = frequentFlyerMiles;
        setPicture();
    }

    public PassengerId getId() {
        return id;
    }

    public void setId(PassengerId id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public void setPicture()
    {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\sdoax36\\jee7-starter\\ejb-module\\src\\main\\resources\\profile.jpg"));
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(image,"jpg",stream);
            picture = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
