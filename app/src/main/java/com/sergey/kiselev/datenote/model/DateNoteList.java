package com.sergey.kiselev.datenote.model;

import android.content.Context;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DateNoteList {
    private static List<DateNoteElement> dateNotes;
    private static DateNoteList ourInstance;

    public static DateNoteList getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new DateNoteList(context);
        }
        return ourInstance;
    }

    private DateNoteList(Context context) {
        initDateNoteList(context);
    }

    private void initDateNoteList(Context context) {
        dateNotes = new ArrayList<>();

        dateNotes.add(new DateNoteSeparator("Вчера"));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-09"), "Пробная заметка 1. Заголовок также многострочный для того чтобы увидеть как это", "Это тестовая пробная заметка 1"));
        dateNotes.add(new DateNoteSeparator("Сегодня"));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-10"), "Пробная заметка 2", "Это тестовая пробная заметка 2. Длиной в несколько строк, для того, чтобы определить сколько именно места займет. Следует убедиться как это выглядит когда больше одной строки"));
        dateNotes.add(new DateNoteSeparator("На следующей неделе"));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-11"), "Пробная заметка 3", "Это тестовая пробная заметка 3",true));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-12"), "Пробная заметка 4. Заголовок также многострочный для того чтобы увидеть как это", "Это тестовая пробная заметка 4. Длиной в несколько строк, для того, чтобы определить сколько именно места займет. Следует убедиться как это выглядит когда больше одной строки"));
        dateNotes.add(new DateNoteSeparator("Далее"));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-13"), "Пробная заметка 5", "Это тестовая пробная заметка 5", true));
        dateNotes.add(new DateNoteSimple(Date.valueOf("2018-08-14"), "Пробная заметка 6", "Это тестовая пробная заметка 6",true));
    }

    public DateNoteElement getDateNote(int index) {
        return dateNotes.get(index);
    }

    public List<DateNoteElement> getAllDateNotes() {
        return dateNotes;
    }

    public void setDateNote(int index, DateNoteSimple dateNote) {
        dateNotes.set(index, dateNote);
    }
}
