package com.example.facultycomms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDbHelper extends SQLiteOpenHelper {

    //information of database

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "register.db";

    // Table Names
    private static final String TABLE_PARENT = "Parent";
    private static final String TABLE_STAFF = "Staff";

    //common column names
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_EMAIL_ID = "email_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_PASSWORD = "password";


    // PARENT Table - column names
    //private static final String KEY_PARENT_ID = "parent_id";
    private static final String KEY_STUDENT_NAME = "student_name";
    private static final String KEY_ROLL_NUMBER = "roll_number";
    private static final String KEY_PARENT_NAME = "parent_name";
    private static final String KEY_DEGREE = "degree";


    // STAFF Table - column names
    private static final String KEY_STAFF_NAME = "staff_name";
    private static final String KEY_STAFF_ID = "staff_id";

    //initialize the database
    UserDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_TABLE_PARENT = "CREATE TABLE " + TABLE_PARENT + "(" + KEY_ROLL_NUMBER + " INTEGER PRIMARY KEY," + KEY_STUDENT_NAME + " TEXT, " + KEY_MOBILE + "INTEGER," + KEY_EMAIL_ID + "TEXT," + KEY_DEGREE + "TEXT," + KEY_PARENT_NAME + "TEXT," + KEY_USER_NAME + "TEXT," + KEY_PASSWORD + "TEXT);";
    private static final String CREATE_TABLE_STAFF = "CREATE TABLE " + TABLE_STAFF + "(" + KEY_STAFF_ID + " INTEGER PRIMARY KEY," + KEY_STAFF_NAME + " TEXT, " + KEY_MOBILE + "INTEGER," + KEY_EMAIL_ID + "TEXT," + KEY_USER_NAME + "TEXT," + KEY_PASSWORD + "TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PARENT);
        db.execSQL(CREATE_TABLE_STAFF);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAFF);

        // create new tables
        onCreate(db);

    }

    public void addParent(Parent parent) {
        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_NAME, parent.getStudent_name());
        values.put(KEY_ROLL_NUMBER, parent.getRoll_number());
        values.put(KEY_MOBILE, parent.getMobile());
        values.put(KEY_EMAIL_ID, parent.getEmail_id());
        values.put(KEY_DEGREE, parent.getDegree());
        values.put(KEY_PARENT_NAME, parent.getParent_name());
        values.put(KEY_USER_NAME, parent.getUser_name());
        values.put(KEY_PASSWORD, parent.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PARENT, null, values);
        db.close();
    }

    public void addStaff(Staff staff) {
        ContentValues values = new ContentValues();
        values.put(KEY_STAFF_ID, staff.getStaff_id());
        values.put(KEY_STAFF_NAME, staff.getStaff_name());
        values.put(KEY_MOBILE, staff.getMobile());
        values.put(KEY_EMAIL_ID, staff.getEmail_id());
        values.put(KEY_USER_NAME, staff.getUser_name());
        values.put(KEY_PASSWORD, staff.getPassword());
        values.put(KEY_DEGREE, staff.getDegree());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_STAFF, null, values);
        db.close();
    }


}
