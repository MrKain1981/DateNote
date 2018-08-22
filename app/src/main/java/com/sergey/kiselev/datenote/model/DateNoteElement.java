package com.sergey.kiselev.datenote.model;

public class DateNoteElement {
    private ElementType elementType;
    private String title;

    public DateNoteElement(ElementType elementType, String title) {
        this.elementType = elementType;
        this.title = title;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
