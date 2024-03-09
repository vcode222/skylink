package com.example.bookingapp;

import java.util.ArrayList;

public class BookedTickets {
    private String username;
    private String departure;
    private String destination;
    private String age;
    private String date;
    private String ticketsCount;

    private static ArrayList<BookedTickets> TicketsDB = new ArrayList<BookedTickets>();

    public BookedTickets(String username, String departure, String destination, String age, String date, String ticketsCount) {
        this.setAge(age);
        this.setDate(date);
        this.setDeparture(departure);
        this.setDestination(destination);
        this.setTicketsCount(ticketsCount);
        this.setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public String getTicketsCount() {
        return ticketsCount;
    }

    public String getDate() {
        return date;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTicketsCount(String ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    public static ArrayList<BookedTickets> getTicketsDB() {
        return BookedTickets.TicketsDB;
    }

    public static void addTicket(BookedTickets newTicket) {
        BookedTickets.TicketsDB.add(newTicket);
    }

    public static ArrayList<BookedTickets> getTicketsBookedByUser(String username) {
        ArrayList<BookedTickets> res = new ArrayList<BookedTickets>();

        for (BookedTickets ticket : BookedTickets.TicketsDB) {
            if (ticket.getUsername().equals(username) == true) {
                res.add(ticket);
            }
        }

        return res;
    }

    @Override
    public String toString() {
        return "{" + "\"username\":\"" + this.getUsername() + "\",\"departure\":\"" + this.getDeparture() + "\",\"destination\":\"" + this.getDestination() + "\",\"age\":\"" + this.getAge() + "\",\"date\":\"" + this.getDate() + "\",\"ticketsCount\":\"" + this.getTicketsCount() + "\"}";
    }
}
