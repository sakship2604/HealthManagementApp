package com.example.healthmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "HealthManagement.db";

    final static int DATABASE_VERSION = 1;
    final static String TABLE_PATIENT = "Patient";
    final static String TPCOL_1 = "Patient_Id";
    final static String TPCOL_2 = "Patient_Name";
    final static String TPCOL_3 = "Patient_email";
    final static String TPCOL_4 = "Patient_password";
    final static String TPCOL_5 = "Patient_postalCode";
    final static String TPCOL_6 = "Patient_phone";
    final static String TPCOL_7 = "Height";
    final static String TPCOL_8 = "Weight";
    final static String TPCOL_9 = "BMI";
    final static String TPCOL_10 = "Age";
    final static String TPCOL_11 = "Gender";
    final static String TPCOL_12 = "MSP";
    final static String TPCOL_13 = "Medication";
    final static String TPCOL_14 = "Diseases";

    final static String TABLE_DOCTOR = "Doctor";
    final static String TDCOL_1 = "Doctor_Id";
    final static String TDCOL_2 = "Doctor_Name";
    final static String TDCOL_3 = "Doctor_email";
    final static String TDCOL_4 = "Doctor_password";
    final static String TDCOL_5 = "Doctor_postalCode";
    final static String TDCOL_6 = "Doctor_phone";
    final static String TDCOL_7 = "Speciality";
    final static String TDCOL_8 = "Fees";

    final static String TABLE_CASHIER = "Cashier";
    final static String TCCOL_1 = "Cashier_Id";
    final static String TCCOL_2 = "Cashier_Name";
    final static String TCCOL_3 = "Cashier_email";
    final static String TCCOL_4 = "Cashier_password";

    final static String TABLE_QUERIES = "Queries";
    final static String TQCOL_1 = "Query_Id";
    final static String TQCOL_2 = "Doctor_Id";
    final static String TQCOL_3 = "Patient_id";
    final static String TQCOL_4 = "Question";
    final static String TQCOL_5 = "Solution";

    final static String TABLE_APPOINTMENTS = "Appointments";
    final static String TACOL_1 = "Appointment_Id";
    final static String TACOL_2 = "Doctor_Id";
    final static String TACOL_3 = "Patient_Id";
    final static String TACOL_4 = "Date";
    final static String TACOL_5 = "Status";
    final static String TACOL_6 = "App_Fees";
    final static String TACOL_7 = "Time_Spot";

    final static String TABLE_BILLING = "Billing";
    final static String TBCOL_1 = "Billing_Id";
    final static String TBCOL_2 = "Query_Id";
    final static String TBCOL_3 = "Cashier_Id";
    final static String TBCOL_4 = "Patient_Id";
    final static String TBCOL_5 = "Payment_Amt";
    final static String TBCOL_6 = "Payment_Status";

    final static String TABLE_ADMIN = "Admin";
    final static String TADCOL_1 = "Admin_Id";
    final static String TADCOL_2 = "Admin_email";
    final static String TADCOL_3 = "Admin_password";

    final static String TABLE_CALORIES = "Calories";
    final static String TCALCOL_1 = "Calorie_Id";
    final static String TCALCOL_2 = "Food_Name";
    final static String TCALCOL_3 = "Calories";
    final static String TCALCOL_4 = "Date";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryP = "CREATE TABLE " + TABLE_PATIENT + " (" + TPCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TPCOL_2 + " TEXT," + TPCOL_3 + " TEXT," + TPCOL_4 + " TEXT," + TPCOL_5 + " TEXT," + TPCOL_6 +
                " INTEGER," + TPCOL_7 + " DECIMAL," + TPCOL_8 + " DECIMAL," + TPCOL_9 + " DECIMAL," + TPCOL_10 + " INTEGER,"
                + TPCOL_11 + " TEXT," + TPCOL_12 + " TEXT," + TPCOL_13 + " TEXT," + TPCOL_14 + " TEXT)";

        String queryD = "CREATE TABLE " + TABLE_DOCTOR + " (" + TDCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TDCOL_2 + " TEXT," + TDCOL_3 + " TEXT," + TDCOL_4 + " TEXT," + TDCOL_5 + " TEXT," + TDCOL_6 + " INTEGER," + TDCOL_7 + " TEXT," + TDCOL_8 + " DECIMAL)";

        String queryC = "CREATE TABLE " + TABLE_CASHIER + " (" + TCCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TCCOL_2 + " TEXT," + TCCOL_3 + " TEXT," + TCCOL_4 + " TEXT)";

        String queryQ = "CREATE TABLE " + TABLE_QUERIES + " (" + TQCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TQCOL_2 + " INTEGER," + TQCOL_3 + " INTERGER," + TQCOL_4 + " TEXT," + TQCOL_5 + " TEXT" +
                "," + " FOREIGN KEY (" + TQCOL_2 + ") REFERENCES " + TABLE_DOCTOR + "(" + TDCOL_1 + ")" +
                "," + "FOREIGN KEY (" + TQCOL_3 + ") REFERENCES " + TABLE_PATIENT + "(" + TPCOL_1 + "));";

        String queryA = "CREATE TABLE " + TABLE_APPOINTMENTS + " (" + TACOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TACOL_2 + " INTEGER," + TACOL_3 + " INTEGER," + TACOL_4 + " TEXT," + TACOL_5 + " DECIMAL," + TACOL_6 + " DECIMAL," + TACOL_7 + " TEXT" +
                "," + " FOREIGN KEY (" + TACOL_2 + ") REFERENCES " + TABLE_DOCTOR + "(" + TDCOL_1 + ")" +
                "," + "FOREIGN KEY (" + TACOL_3 + ") REFERENCES " + TABLE_PATIENT + "(" + TPCOL_1 + "));";

        String queryB = "CREATE TABLE " + TABLE_BILLING + " (" + TBCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TBCOL_2 + " INTEGER," + TBCOL_3 + " INTEGER," + TBCOL_4 + " INTEGER," + TBCOL_5 + " INTEGER," + TBCOL_6 + " INTEGER" +
                "," + " FOREIGN KEY (" + TBCOL_2 + ") REFERENCES " + TABLE_QUERIES + "(" + TQCOL_1 + ")" +
                "," + " FOREIGN KEY (" + TBCOL_3 + ") REFERENCES " + TABLE_CASHIER + "(" + TCCOL_1 + ")" +
                "," + " FOREIGN KEY (" + TBCOL_4 + ") REFERENCES " + TABLE_PATIENT + "(" + TPCOL_1 + "));";

        String queryAd = "CREATE TABLE " + TABLE_ADMIN + " (" + TADCOL_1 + " INTEGER PRIMARY KEY NOT NULL," +
                TADCOL_2 + " TEXT," + TADCOL_3 + " TEXT)";

        String queryCal = "CREATE TABLE " + TABLE_CALORIES + " (" + TCALCOL_1 + " INTEGER PRIMARY KEY," +
                TCALCOL_2 + " TEXT," + TCALCOL_3 + " INTEGER, " + TCALCOL_4 + " TEXT )";

        db.execSQL(queryP);
        db.execSQL(queryD);
        db.execSQL(queryC);
        db.execSQL(queryQ);
        db.execSQL(queryA);
        db.execSQL(queryB);
        db.execSQL(queryAd);
        db.execSQL(queryCal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists " + TABLE_PATIENT);
        db.execSQL("DROP TABLE if exists " + TABLE_ADMIN);
        db.execSQL("DROP TABLE if exists " + TABLE_APPOINTMENTS);
        db.execSQL("DROP TABLE if exists " + TABLE_BILLING);
        db.execSQL("DROP TABLE if exists " + TABLE_CASHIER);
        db.execSQL("DROP TABLE if exists " + TABLE_DOCTOR);
        db.execSQL("DROP TABLE if exists " + TABLE_QUERIES);
        onCreate(db);
    }

    public boolean addPatient(String name, String email, String password, String postalCode,
                              String PhoneNo, double height,
                              double weight, String gender, double bmi, int age, String msp, String medication, String diseases) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TPCOL_2, name);
        contentValues.put(TPCOL_3, email);
        contentValues.put(TPCOL_4, password);
        contentValues.put(TPCOL_5, postalCode);
        contentValues.put(TPCOL_6, PhoneNo);
        contentValues.put(TPCOL_7, height);
        contentValues.put(TPCOL_8, weight);
        contentValues.put(TPCOL_9, bmi);
        contentValues.put(TPCOL_10, age);
        contentValues.put(TPCOL_11, gender);
        contentValues.put(TPCOL_12, msp);
        contentValues.put(TPCOL_13, medication);
        contentValues.put(TPCOL_14, diseases);

        long r = sqLiteDatabase.insert(TABLE_PATIENT, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addDoctor(String name, String email, String password, String postalCode, String phoneNo, String speciality, String fees) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TDCOL_2, name);
        contentValues.put(TDCOL_3, email);
        contentValues.put(TDCOL_4, password);
        contentValues.put(TDCOL_5, postalCode);
        contentValues.put(TDCOL_6, phoneNo);
        contentValues.put(TDCOL_7, speciality);
        contentValues.put(TDCOL_8, fees);

        long r = sqLiteDatabase.insert(TABLE_DOCTOR, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor viewDataQuery() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUERIES;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public Cursor viewPatientQuery(String patientId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUERIES + " where " + TQCOL_3 + " = " + patientId;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public boolean bookAppointment(int doctorId, int patientId, String date, int status, int fees, String timeSpot) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TACOL_2, doctorId);
        contentValues.put(TACOL_3, patientId);
        contentValues.put(TACOL_4, date);
        contentValues.put(TACOL_5, status);
        contentValues.put(TACOL_6, fees);
        contentValues.put(TACOL_7, timeSpot);

        long r = sqLiteDatabase.insert(TABLE_APPOINTMENTS, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addCashier(String name, String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TCCOL_2, name);
        contentValues.put(TCCOL_3, email);
        contentValues.put(TCCOL_4, password);

        long r = sqLiteDatabase.insert(TABLE_CASHIER, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addQueries(int doctorId, int patientId, String questions, String solutions) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TQCOL_2, doctorId);
        contentValues.put(TQCOL_3, patientId);
        contentValues.put(TQCOL_4, questions);
        contentValues.put(TQCOL_5, solutions);

        long r = sqLiteDatabase.insert(TABLE_QUERIES, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addBilling(int queryId, int cashierId, int patientId, int paymentAmt, int paymentStatus) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TBCOL_2, queryId);
        contentValues.put(TBCOL_3, cashierId);
        contentValues.put(TBCOL_4, patientId);
        contentValues.put(TBCOL_5, paymentAmt);
        contentValues.put(TBCOL_6, paymentStatus);

        long r = sqLiteDatabase.insert(TABLE_BILLING, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addAdmin(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TADCOL_2, email);
        contentValues.put(TADCOL_3, password);

        long r = sqLiteDatabase.insert(TABLE_ADMIN, null, contentValues);
        if (r > 0) {
            return true;
        } else {
            return false;
        }
    }
    //////////////////////////////////////////////////////////////////////
    // to authenticate logins
    /////////////////////////////////////////////////////////////////////

    // authenticate admin
    public boolean getAdmin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_ADMIN + " where " + TADCOL_2 + " =  \"" + email + "\"" + " AND " + TADCOL_3 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        db.close();
        return result;
    }

    public Cursor getBilling() {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_BILLING, null);
        db.close();
        return cursor;
    }

    public void updateBilling(String id, int status) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TBCOL_6, status);
        db.update(TABLE_BILLING, values, TQCOL_1 + " = ? ", new String[]{String.valueOf(id)});
        db.close();
    }


    // authenticate patient
    public boolean checkBookAppointment(int doctorId, String date, String timeSpot) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_APPOINTMENTS + " where " + TACOL_2 + " =  \"" + doctorId + "\"" + " AND " + TACOL_4 + " = \"" + date + "\"" + " AND " + TACOL_7 + " = \"" + timeSpot + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        db.close();
        return result;
    }
    // authenticate patient
    public boolean getPatient(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT + " where " + TPCOL_3 + " =  \"" + email + "\"" + " AND " + TPCOL_4 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        db.close();
        return result;
    }

    public Cursor getPatientDetails(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT + " where " + TPCOL_3 + " =  \"" + email + "\"", null);
        return cursor;
    }

    // authenticate doctor
    public boolean getDoctor(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_DOCTOR + " where " + TDCOL_3 + " =  \"" + email + "\"" + " AND " + TDCOL_4 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        db.close();
        return result;
    }

    public Cursor getDoctorDetails(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_DOCTOR + " where " + TDCOL_3 + " =  \"" + email + "\"", null);
        return cursor;
    }

    public Cursor viewDataDoctorAppointment(String doctor_id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_APPOINTMENTS + " WHERE " + TACOL_2 + " = " + doctor_id;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public Cursor viewDataQueryDoctor(String doctor_id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUERIES + " WHERE " + TQCOL_2 + " = " + doctor_id;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    // authenticate cashier
    public boolean getCashier(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_CASHIER + " where " + TCCOL_3 + " =  \"" + email + "\"" + " AND " + TCCOL_4 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        db.close();
        return result;
    }

    // to retrive from patient table
    public Cursor getPatientId(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT + " where " + TPCOL_3 + " =  \"" + email + "\"" + " AND " + TPCOL_4 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            //result = true;
        }
        db.close();

        return cursor;
    }

    // to retrive from doctor table
    public Cursor getDoctorId(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Cursor cursor = db.rawQuery("select * from " + TABLE_DOCTOR + " where " + TDCOL_3 + " =  \"" + email + "\"" + " AND " + TDCOL_4 + " = \"" + password + "\"", null);
        if (cursor.getCount() > 0) {
            result = true;
        }
        //db.close();
        return cursor;
    }

    public Cursor getQuery(int query_id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUERIES + " WHERE " + TQCOL_1 + " = " + query_id;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public Cursor viewdoctors() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_DOCTOR;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public boolean addFoodItem(String food, int cal, String date) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TCALCOL_2, food);
        values.put(TCALCOL_3, cal);
        values.put(TCALCOL_4, date);

        long r = sqLiteDatabase.insert(TABLE_CALORIES, null, values);
        if (r > 0)
            return true;
        else
            return false;
    }

    public Cursor getFoodData(String dateTodayString) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT *, SUM(calories)  FROM " + TABLE_CALORIES + " WHERE " + TCALCOL_4 + " LIKE '" + dateTodayString + "'";
        Log.i("QUERY", query);
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public Cursor onrefresh() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "DELETE  FROM " + TABLE_CALORIES;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

    public boolean updateRec(int id, String c) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TCALCOL_3, c);

        int d = sqLiteDatabase.update(TABLE_CALORIES, values, "id=?",
                new String[]{Integer.toString(id)});
        if (d > 0)
            return true;
        else
            return false;
    }

    public ArrayList<doctors_model> getAllDoctors() {
        ArrayList<doctors_model> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_DOCTOR;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int ID = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            int phone = cursor.getInt(5);
            String speciality = cursor.getString(6);
            int fees = cursor.getInt(7);
            String button1 = "Online Help";
            String button2 = "Book Appointment";
            doctors_model doctors = new doctors_model(ID, name, email, speciality, fees, phone, button1, button2);
            arrayList.add(doctors);
        }
        return arrayList;
    }


    public ArrayList<doctors_model> getDoctorsByPostalCode(String postalCode) {
        ArrayList<doctors_model> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_DOCTOR + " WHERE " + TDCOL_5 + " LIKE '" + postalCode + "%'";
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int ID = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            int phone = cursor.getInt(5);
            String speciality = cursor.getString(6);
            int fees = cursor.getInt(7);

            String button1 = "Online Help";
            String button2 = "Book Appointment";
            doctors_model doctors = new doctors_model(ID, name, email, speciality, fees, phone, button1, button2);

            arrayList.add(doctors);
        }
        return arrayList;
    }

    //get all billing for cashier
    public List<Payment_Model> getAllbills() {
        List<Payment_Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_BILLING + " where " + TBCOL_6 + " =  \"" + 1 + "\"";
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int billingID = cursor.getInt(0);
            int appointmentID = cursor.getInt(1);
            int cashierID = cursor.getInt(2);
            int patientID = cursor.getInt(3);
            int paymentAmt = cursor.getInt(4);
            int paymentStatus = cursor.getInt(5);
            Payment_Model bills = new Payment_Model(billingID, appointmentID, cashierID, patientID, paymentAmt, paymentStatus);
            arrayList.add(bills);
        }
        return arrayList;
    }

    // reset password
    public boolean resetPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        Log.d("Result", String.valueOf(result));
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT + " where " + TPCOL_3 + " =  \"" + email + "\"", null);
        if (cursor.getCount() > 0) {
            ContentValues values = new ContentValues();
            values.put(TPCOL_4, password);
            result = true;
            db.update(TABLE_PATIENT, values, TPCOL_3 + " =  \"" + email + "\"", null);
        }
        db.close();
        Log.d("Result", String.valueOf(result));
        return result;

    }

    // delete records of patient
    public void deletePatient(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            int b = db.delete(TABLE_PATIENT, TPCOL_3 + " =  \"" + email + "\"", null);
            Log.d("HERE", String.valueOf(b));
        } catch (Exception e) {
            Log.d("HERE", String.valueOf(e.getMessage()));
        }
    }

    // to delete doctor's records
    public void deleteDoctor(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            db.delete(TABLE_DOCTOR, TDCOL_3 + " =  \"" + email + "\"", null);
        } catch (Exception e) {
            Log.d("HERE", e.getMessage());
        }
    }

    // to delete cashier records

    public void deleteCashier(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            db.delete(TABLE_CASHIER, TCCOL_3 + " =  \"" + email + "\"", null);
        } catch (Exception e) {

        }
    }

    // to update patient records
    public void updatePatient(String name, String email, String postalCode,
                              String PhoneNo, double height,
                              double weight, String gender, int age, String msp, String medication, String diseases) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(TPCOL_2, name);
            values.put(TPCOL_3, email);
            values.put(TPCOL_5, postalCode);
            values.put(TPCOL_6, PhoneNo);
            values.put(TPCOL_7, height);
            values.put(TPCOL_8, weight);
            values.put(TPCOL_11, gender);
            values.put(TPCOL_10, age);
            values.put(TPCOL_12, msp);
            values.put(TPCOL_13, medication);
            values.put(TPCOL_14, diseases);

            db.update(TABLE_PATIENT, values, TPCOL_3 + " = ? ", new String[]{String.valueOf(email)});
        } catch (Exception e) {
            Log.d("Update Tasks: ", e.getMessage());
        }
    }

    public void updateDoctor(String name, String email, String postalCode, String PhoneNo, String speciality, String fees) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(TDCOL_2, name);
            values.put(TDCOL_3, email);
            values.put(TDCOL_5, postalCode);
            values.put(TDCOL_6, PhoneNo);
            values.put(TDCOL_7, speciality);
            values.put(TDCOL_8, fees);

            db.update(TABLE_DOCTOR, values, TDCOL_3 + " = ? ", new String[]{String.valueOf(email)});
        } catch (Exception e) {
            Log.d("Update Tasks: ", e.getMessage());
        }
    }

    public void updateCashier(String name, String email) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(TCCOL_2, name);
            values.put(TCCOL_3, email);
            db.update(TABLE_CASHIER, values, TCCOL_3 + " = ? ", new String[]{String.valueOf(email)});
        } catch (Exception e) {
            Log.d("Update Tasks: ", e.getMessage());
        }
    }

    public boolean updateQuery(String solution, String query_id) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(TQCOL_5, solution);
            db.update(TABLE_QUERIES, values, TQCOL_1 + " = ? ", new String[]{String.valueOf(query_id)});
            return true;
        } catch (Exception e) {
            Log.d("Update Tasks: ", e.getMessage());
            return false;
        }
    }
}

