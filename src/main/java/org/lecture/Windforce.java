package org.lecture;

import java.math.BigDecimal;
import java.util.Date;

/**
 * In the Windforce class all importnt informations will be set.
 */
public class Windforce {
    Date dateTime;
    String bearing;
    String station;
    double temp;
    String weather;
    int id;
    double windforce;
    BigDecimal Knoten;
    int beaufort;

    /**
     * Here the constructor of all informations will be created.
     */

    public Windforce(int id, Date dateTime, String bearing, String station, double temp, String weather, double windforce) {
        this.dateTime = dateTime;
        this.bearing = bearing;
        this.station = station;
        this.temp = temp;
        this.weather = weather;
        this.id = id;
        this.windforce = windforce;
    }

    public Windforce() {

    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getBearing() {
        return bearing;
    }

    public String getStation() {
        return station;
    }

    public double getTemp() {
        return temp;
    }

    public String getWeather() {
        return weather;
    }

    public int getId() {
        return id;
    }

    public double getWindforce() {
        return windforce;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWindforce(double windforce) {
        this.windforce = windforce;
    }

    public BigDecimal getKnoten() {
        return Knoten;
    }

    public void setKnoten(BigDecimal knoten) {
        Knoten = knoten;
    }

    public int getBeaufort() {
        return beaufort;
    }

    public void setBeaufort(int beaufort) {
        this.beaufort = beaufort;
    }
}
