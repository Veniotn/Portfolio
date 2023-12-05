package com.example.a3_a_cruddypizza;
import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBAdapter {

    private DatabaseHelper DBHelper;
    //db helper inner class
    public static class DatabaseHelper extends SQLiteOpenHelper {


        DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        //creates adapter
        @Override
        public void onCreate(SQLiteDatabase db) {
            //create the tables
            try {
                db.execSQL(CUSTOMER_TABLE_CREATE);
                db.execSQL(PIZZA_INFO_TABLE_CREATE);
                db.execSQL(ORDER_TABLE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //upgrade db version
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //notify user of upgrade
            Log.w(TAG, "Upgraded db from version: " + oldVersion + " to: " + newVersion
                    + "dropping all old data.");
            String query = "DROP TABLE IF EXISTS customers; ";
            db.execSQL(query);
            query = "DROP TABLE IF EXISTS orders;";
            db.execSQL(query);
            query = "DROP TABLE IF EXISTS pizza_info;";
            db.execSQL(query);
            //create new db
            onCreate(db);

        }//end upgrade

    }

    //db object
    private SQLiteDatabase db;

    private Context context;
    public static final int DB_VERSION = 5;
    public static final String DB_NAME = "CruddyPizza.db";

    //sql text variables;
    public static final String CUSTOMER_TABLE = "customers";
    public static final String CUSTOMER_ID_PK = "customer_id";
    public static final String CUSTOMER_F_NAME  = "customer_f_name";
    public static final String CUSTOMER_L_NAME  = "customer_l_name";
    public static final String CUSTOMER_LOGIN  = "customer_login";
    public static final String ORDER_TABLE    = "orders";
    public static final String ORDER_ID_PK    = "id";
    public static final String ORDER_DATE     = "order_date";
    public static final String PIZZA_ID_PK    = "pizza_id";
    public static final String PIZZA_TABLE    = "pizza_info";
    public static final String PIZZA_SIZE     = "pizza_size";
    public static final String TOPPING_ONE    = "topping_one";
    public static final String TOPPING_TWO    = "topping_two";
    public static final String TOPPING_THREE  = "topping_three";

    //db create statement
    private static final String CUSTOMER_TABLE_CREATE =
            "CREATE TABLE " + CUSTOMER_TABLE +
            " (" + CUSTOMER_ID_PK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                   CUSTOMER_F_NAME  + " TEXT, " +
                   CUSTOMER_L_NAME + "  TEXT, " +
                   CUSTOMER_LOGIN + "   TEXT NOT NULL);";

    private static final String ORDER_TABLE_CREATE =
            "CREATE TABLE " + ORDER_TABLE + " ("
                 + ORDER_ID_PK    + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                   ORDER_DATE     + " TEXT," +
                   CUSTOMER_ID_PK + " INTEGER REFERENCES customers( "+CUSTOMER_ID_PK+" ), " +
                   PIZZA_ID_PK    + " INTEGER REFERENCES pizza_info( "+PIZZA_ID_PK+" ) " +
                    ");";

    private static final String PIZZA_INFO_TABLE_CREATE =
            "CREATE TABLE " + PIZZA_TABLE   + " (" +
                              PIZZA_ID_PK   + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              PIZZA_SIZE    + " INTEGER NOT NULL, " +
                              TOPPING_ONE   + " INTEGER NOT NULL, " +
                              TOPPING_TWO   + " INTEGER NOT NULL, " +
                              TOPPING_THREE + " INTEGER NOT NULL" +
                    ");";


    public DBAdapter(@Nullable Context context) {
        this.context = context;
        this.DBHelper = new DatabaseHelper(context);
    }


        //db adapter functions
        //open db
        public DBAdapter open() throws SQLException {
            db = DBHelper.getWritableDatabase();
            return this;
        }

        //close db
        public void close() {
            DBHelper.close();
        }


        //insert a single customer
        public long insertCustomer(String firstName, String lastName, String login) {
            ContentValues customerInfo = new ContentValues();
            customerInfo.put(CUSTOMER_F_NAME, firstName);
            customerInfo.put(CUSTOMER_L_NAME, lastName);
            customerInfo.put(CUSTOMER_LOGIN, login);

            return db.insert(CUSTOMER_TABLE, null, customerInfo);
        }

        public Cursor getCustomer(String customerLogin) throws SQLException{
            Cursor queryResult = db.query(true, CUSTOMER_TABLE, new String[]{CUSTOMER_ID_PK,CUSTOMER_F_NAME, CUSTOMER_L_NAME, CUSTOMER_LOGIN},
                                               CUSTOMER_LOGIN+" = '"+ customerLogin + "' ", null, null,
                                            null,null,null,null);


            return validCursor(queryResult);
        }

        public Cursor getCustomerID(String customerLogin) throws SQLException{
        Cursor queryResult = db.query(true, CUSTOMER_TABLE, new String[]{CUSTOMER_ID_PK},
                                         CUSTOMER_LOGIN + " = '"+ customerLogin + "' ",
                                   null, null, null, null, null,
                                                                                   null);

        return validCursor(queryResult);
        }

        //delete a single customer
//        public boolean deleteCustomer(long customerID) {
//            //returns true if statement returns at least 1 row deleted
//            return db.delete(CUSTOMER_TABLE, CUSTOMER_ID_PK + "=" + customerID, null) > 0;
//        }

        //insert a single order
        public long insertOrder(String orderDate, int customerID, long pizzaID) {
            ContentValues orderInfo = new ContentValues();
            orderInfo.put(ORDER_DATE, orderDate);
            orderInfo.put(CUSTOMER_ID_PK, customerID);
            orderInfo.put(PIZZA_ID_PK, (int)pizzaID);

            return db.insert(ORDER_TABLE, null, orderInfo);
        }

        //select a single order
        public Cursor getOrder(long orderID) throws SQLException{
            Cursor queryResult = db.query(true, ORDER_TABLE, new String[]{
                    ORDER_ID_PK, ORDER_DATE}, ORDER_ID_PK+" = "+orderID, null,
                    null,null,null,null,null);


            return validCursor(queryResult);
        }

        //delete single order
        public boolean deleteOrder(long orderID) {
            return db.delete(ORDER_TABLE, ORDER_ID_PK + " = " + orderID, null) > 0;
        }


        //insert single pizza
        public long
        insertPizza(int pizzaSize, int toppingOne, int toppingTwo, int toppingThree) {
            ContentValues pizzaInfo = new ContentValues();

            pizzaInfo.put(PIZZA_SIZE, pizzaSize);
            pizzaInfo.put(TOPPING_ONE, toppingOne);
            pizzaInfo.put(TOPPING_TWO, toppingTwo);
            pizzaInfo.put(TOPPING_THREE, toppingThree);

            return db.insert(PIZZA_TABLE, null, pizzaInfo);
        }

        @SuppressLint("Range")
        public int getPizzaID(int orderID){
        Cursor queryResult = db.query(true, ORDER_TABLE, new String[]{PIZZA_ID_PK},
                                           ORDER_ID_PK + " = " + orderID, null,
                                     null,null, null, null);

        if (queryResult.moveToFirst()){
            return Integer.parseInt(queryResult.getString(queryResult.getColumnIndex(DBAdapter.PIZZA_ID_PK)));
        }
        return 0;
        }


        public boolean
        updatePizza(int pizzaID, int pizzaSize, int toppingOne, int toppingTwo, int toppingThree) {
            ContentValues newPizzaInfo = new ContentValues();
            newPizzaInfo.put(PIZZA_SIZE, pizzaSize);
            newPizzaInfo.put(TOPPING_ONE, toppingOne);
            newPizzaInfo.put(TOPPING_TWO, toppingTwo);
            newPizzaInfo.put(TOPPING_THREE, toppingThree);

            return db.update(PIZZA_TABLE, newPizzaInfo, PIZZA_ID_PK + " = " + pizzaID, null) > 0;
        }


        //retrieve all orders
        public Cursor getAllOrders(long customerID) throws SQLException {

            Cursor queryResult =
                    db.query(true, ORDER_TABLE + " JOIN " + PIZZA_TABLE + " ON " +
                                    ORDER_TABLE + "." + PIZZA_ID_PK + " = " + PIZZA_TABLE + "." + PIZZA_ID_PK,
                            new String[]{
                                    ORDER_TABLE + "." + ORDER_ID_PK,
                                    ORDER_DATE,
                                    PIZZA_TABLE + "." + PIZZA_ID_PK,
                                    PIZZA_SIZE,
                                    TOPPING_ONE,
                                    TOPPING_TWO,
                                    TOPPING_THREE
                            },
                            CUSTOMER_ID_PK + "=" + customerID, null, null,
                            null, null, null, null);


            //return orders
            return validCursor(queryResult);
        }

        public Cursor validCursor(Cursor cursorToCheck){
        //keeps from repeating code
            if (cursorToCheck != null){
                cursorToCheck.moveToFirst();
            }
            return cursorToCheck;
        }

}
