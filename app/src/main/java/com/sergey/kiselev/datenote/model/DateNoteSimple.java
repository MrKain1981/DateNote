package com.sergey.kiselev.datenote.model;

import java.util.Date;

public class DateNoteSimple extends DateNoteElement{
    private int id;
    private String description;
    private Date date;


    public DateNoteSimple(Date date, String title, String description) {
        super(ElementType.DATE_NOTE, title);
        this.date = date;
        this.description = description;
    }

    public DateNoteSimple(Date date, String title, String description, Boolean checker) {
        super(ElementType.DATE_NOTE, title);
        this.date = date;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
}
