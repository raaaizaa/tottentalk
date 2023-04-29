package com.example.tottentalk;

import java.util.ArrayList;
import java.util.List;

public class ticket {
    private String name;
    private String date;
    private static List<ticket> ticketList = new ArrayList<>();

    public ticket(String name, String date) {
        this.name = name;
        this.date = date;
        ticketList.add(this);
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public static List<ticket> getTicketList() {
        return ticketList;
    }

    @Override
    public String toString() {
        return "ticket: " + name + " on " + date;
    }
}
