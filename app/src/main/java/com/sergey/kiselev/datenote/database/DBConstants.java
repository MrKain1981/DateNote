package com.sergey.kiselev.datenote.database;

public interface DBConstants {
    String DB_NAME = "DateNoteDB";
    String SCRIPT_CREATE_DATENOTES = "create table datenotes (_id integer primary key autoincrement, str_date text, name text, description text, num_date integer);";
}
