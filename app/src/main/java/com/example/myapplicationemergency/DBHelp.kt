package com.example.myapplicationemergency

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASENAME = "MY_DATABASES"
val TABLENAME = "Users"
val COL_USERNAME = "username"
val COL_PHONE = "phone"
val COL_PASSWORD = "password"
val COL_EMAIL = "email"
val COL_ADDRESS = "address"
val COL_ID = "id"
class DBHelp(var context: Context): SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME +
                " text, "+ COL_EMAIL + " text, " + COL_PASSWORD + " text, " + COL_ADDRESS + " text, " + COL_PHONE + " text)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertData(user: User) {

        val database = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_USERNAME, user.username)
        contentValues.put(COL_PHONE, user.phone)
        contentValues.put(COL_PASSWORD, user.password)
        contentValues.put(COL_EMAIL, user.email)
        contentValues.put(COL_ADDRESS, user.address)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun readPhone(username: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + username+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_PHONE))
        }
        result.close()
        return st
    }
    fun readAddress(username: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + username+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_ADDRESS))
        }
        result.close()
        return st
    }
    fun readEmail(username: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + username+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_EMAIL))
        }
        result.close()
        return st
    }
    fun readPassword(username: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + username+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_PASSWORD))
        }
        result.close()
        return st
    }

    fun updatePassword(pass: String, username: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_PASSWORD, pass)
        database.update(TABLENAME,  contentValues, "username =? " , arrayOf(username))

    }
    fun updateAddress(address: String, username: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_ADDRESS, address)
        database.update(TABLENAME,  contentValues, "username =? " , arrayOf(username))

    }
    fun updateEmail(email: String, username: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_EMAIL, email)
        database.update(TABLENAME,  contentValues, "username =? " , arrayOf(username))

    }
    fun updatePhone(phone: String, username: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_PHONE, phone)
        database.update(TABLENAME,  contentValues, "username =? " , arrayOf(username))

    }
}