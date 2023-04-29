package com.example.tottentalk.javaclass;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ticket {

    private final String name, date, orderedDate;
    private static final List<ticket> ticketList = new ArrayList<>();

    public ticket(String name, String date, String orderedDate) {
        this.name = name;
        this.date = date;
        this.orderedDate = orderedDate;
        ticketList.add(this);
    }

    public static List<ticket> getTicketList() {
        return ticketList;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " (" + date + ") on " + orderedDate;
    }
}
