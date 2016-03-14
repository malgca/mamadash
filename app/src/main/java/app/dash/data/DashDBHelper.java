package app.dash.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Basic class for creating the database for the Dash application
 * Created by Malusi Gcakasi on 2016-03-04.
 */
public class DashDBHelper extends SQLiteOpenHelper {
    public static final int dbVersion = 1;
    public static final String dbName = "Dash DB";

    /** Constructor for Dash Database Helper.
    * @param context Current context of the Dash application
     * */
    public DashDBHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    /** Executed when the Dash Database is created.
     * Creates all Dash tables with no data in them.
     * @param dashDB Reference to the Dash application database
     * */
    public void onCreate(SQLiteDatabase dashDB) {
        this.createDashDBTables(dashDB);
    }

    /** Executed when the Dash Databse is upgraded.
     * Deletes the Database and then recreates it with no data in it.
     *
     * PRE-CONDITION: Make sure that all the data that must be saved,
     * is saved before using this method.
     *
     * @param dashDB Reference to the Dash Application database
     * @param oldVersion Version number of the old version of the Dash database
     * @param newVersion Version number of the new version of the Dash database
     * */
    public void onUpgrade(SQLiteDatabase dashDB, int oldVersion, int newVersion) {
        dashDB.execSQL(DeleteDashDBTables());
        onCreate(dashDB);
    }

    /** Executed when the Dash Databse is upgraded.
     * Deletes the Database and then recreates it with no data in it.
     *
     * PRE-CONDITION: Make sure that all the data that must be saved,
     * is saved before using this method.
     *
     * @param dashDB Reference to the Dash application database
     * @param oldVersion Version number of the old version of the Dash database
     * @param newVersion Version number of the new version of the Dash database*/
    public void onDowngrade(SQLiteDatabase dashDB, int oldVersion, int newVersion) {
        onUpgrade(dashDB, oldVersion, newVersion);
    }

    // Creates Dash Tables out of thin air
    private void createDashDBTables(SQLiteDatabase dashDB) {
        // Create Dash Customers Table
        String createDashCustomersTable = "CREATE TABLE "
                + DashDBContract.Customers.tableName + "( "
                + DashDBContract.Customers.customerID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Customers.customerFirstName + " VARCHAR(100), "
                + DashDBContract.Customers.customerMiddleName + " VARCHAR(100), "
                + DashDBContract.Customers.customerLastName + " VARCHAR(100), "
                + DashDBContract.Customers.customerEmailAddress + " VARCHAR(255), "
                + DashDBContract.Customers.customerPhoneNumber + " VARCHAR(15)) ";

        // Create Dash CustomerSocialID Table
        String createDashCustomerSocialIDsTable = "CREATE TABLE "
                + DashDBContract.CustomerSocialID.tableName + "( "
                + DashDBContract.CustomerSocialID.customerSocialID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.CustomerSocialID.customerFacebookID + " VARCHAR(255), "
                + DashDBContract.CustomerSocialID.customerInstagramID + " VARCHAR(255), "
                + DashDBContract.CustomerSocialID.customerTwitterID + " VARCHAR(150), "
                + DashDBContract.CustomerSocialID.customerID + " VARCHAR(255)) ";

        // Create Dash CustomerProfileDetails Table
        String createDashCustomerProfileDetailsTable = "CREATE TABLE "
                + DashDBContract.CustomerProfileDetails.tableName + "( "
                + DashDBContract.CustomerProfileDetails.customerID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.CustomerProfileDetails.customerAddress + " TEXT, "
                + DashDBContract.CustomerProfileDetails.customerDescription + " TEXT, "
                + DashDBContract.CustomerProfileDetails.customerGender + " VARCHAR(10), "
                + DashDBContract.CustomerProfileDetails.customerLanguage + " VARCHAR(50), "
                + DashDBContract.CustomerProfileDetails.customerTimeZone + " VARCHAR(20), "
                + DashDBContract.CustomerProfileDetails.customerNicknames + " TEXT) ";

        // Create Dash CustomerCreditCardDetails Table
        String createDashCustomerCreditCardDetailsTable = "CREATE TABLE "
                + DashDBContract.CustomerCreditCardDetails.tableName + "( "
                + DashDBContract.CustomerCreditCardDetails.cardID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.CustomerCreditCardDetails.cardNumber + " VARCHAR(20), "
                + DashDBContract.CustomerCreditCardDetails.cardBrand + " VARCHAR(100), "
                + DashDBContract.CustomerCreditCardDetails.cardExpirationMonth + " INTEGER, "
                + DashDBContract.CustomerCreditCardDetails.cardExpirationYear + " INTEGER, "
                + DashDBContract.CustomerCreditCardDetails.cardFirstName + " VARCHAR(100), "
                + DashDBContract.CustomerCreditCardDetails.cardLastName + " VARCHAR(100), "
                + DashDBContract.CustomerCreditCardDetails.cardCountry + " VARCHAR(200), "
                + DashDBContract.CustomerCreditCardDetails.cardPostalCode + " VARCHAR(20), "
                + DashDBContract.CustomerCreditCardDetails.customerID + " VARCHAR(255)) ";

        // Create Dash Brands Table
        String createDashBrandsTable = "CREATE TABLE "
                + DashDBContract.Brands.tableName + "( "
                + DashDBContract.Brands.brandID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Brands.brandName + " VARCHAR(255), "
                + DashDBContract.Brands.brandDescription + " TEXT, "
                + DashDBContract.Brands.brandPrimaryColour + " VARCHAR(20), "
                + DashDBContract.Brands.brandSecondaryColour + " VARCHAR(20), "
                + DashDBContract.Brands.brandTertiaryColour + " VARCHAR(20)) ";

        // Create Dash Outlets Table
        String createDashOutletsTable = "CREATE TABLE "
                + DashDBContract.Outlets.tableName + "( "
                + DashDBContract.Outlets.outletID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Outlets.outletName + " VARCHAR(255), "
                + DashDBContract.Outlets.outletDescription + " TEXT, "
                + DashDBContract.Outlets.outletLocationX + " VARCHAR(50), "
                + DashDBContract.Outlets.outletLocationY + " VARCHAR(50), "
                + DashDBContract.Outlets.brandID + " VARCHAR(255)) ";

        // Create Dash MenuItems Table
        String createDashMenuItemsTable = "CREATE TABLE "
                + DashDBContract.MenuItems.tableName + "( "
                + DashDBContract.MenuItems.menuItemID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.MenuItems.menuItemName + " VARCHAR(255), "
                + DashDBContract.MenuItems.menuItemDescription + " TEXT, "
                + DashDBContract.MenuItems.menuItemPrice + " FLOAT(10,2), "
                + DashDBContract.MenuItems.storeID + " VARCHAR(255), "
                + DashDBContract.MenuItems.brandID + " VARCHAR(255)) ";

        // Create Dash Reviews Table
        String createDashReviewsTable = "CREATE TABLE "
                + DashDBContract.Reviews.tableName + "( "
                + DashDBContract.Reviews.reviewID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Reviews.reviewDate + " VARCHAR(20), "
                + DashDBContract.Reviews.reviewTime + " VARCHAR(20), "
                + DashDBContract.Reviews.reviewDescription + " TEXT, "
                + DashDBContract.Reviews.reviewerName + " VARCHAR(100), "
                + DashDBContract.Reviews.reviewerEmailAddress + " VARCHAR(255), "
                + DashDBContract.Reviews.reviewRating + " INTEGER) ";

        // Create Dash Orders Table
        String createDashOrdersTable = "CREATE TABLE "
                + DashDBContract.Orders.tableName + "( "
                + DashDBContract.Orders.orderID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Orders.orderDate + " VARCHAR(20), "
                + DashDBContract.Orders.orderTime + " VARCHAR(20), "
                + DashDBContract.Orders.menuItemID + " VARCHAR(255), "
                + DashDBContract.Orders.menuItemQuantity + " INTEGER)";

        // Create Dash Bill Table
        String createDashBillsTable = "CREATE TABLE "
                + DashDBContract.Bills.tableName + "( "
                + DashDBContract.Bills.billID + " VARCHAR(255) PRIMARY KEY, "
                + DashDBContract.Bills.billDate + " VARCHAR(20), "
                + DashDBContract.Bills.billTime + " VARCHAR(20), "
                + DashDBContract.Bills.billTip + " FLOAT(10,2), "
                + DashDBContract.Bills.brandID + " VARCHAR(255), "
                + DashDBContract.Bills.brandVAT + " INTEGER, "
                + DashDBContract.Bills.customerID + " VARCHAR(255), "
                + DashDBContract.Bills.orderID + " VARCHAR(255))";

        dashDB.execSQL(createDashCustomersTable);
        dashDB.execSQL(createDashCustomerSocialIDsTable);
        dashDB.execSQL(createDashCustomerProfileDetailsTable);
        dashDB.execSQL(createDashCustomerCreditCardDetailsTable);
        dashDB.execSQL(createDashBrandsTable);
        dashDB.execSQL(createDashOutletsTable);
        dashDB.execSQL(createDashMenuItemsTable);
        dashDB.execSQL(createDashOrdersTable);
        dashDB.execSQL(createDashBillsTable);
        dashDB.execSQL(createDashReviewsTable);
    }

    // Deletes all entries in the Dash table by dropping everything.
    // Used with Upgrade and Downgrade commands
    private String DeleteDashDBTables() {
        return "DROP TABLE IF EXISTS "
                + DashDBContract.Bills.tableName + ", "
                + DashDBContract.Brands.tableName + ","
                + DashDBContract.CustomerCreditCardDetails.tableName + ","
                + DashDBContract.CustomerProfileDetails.tableName + ","
                + DashDBContract.CustomerSocialID.tableName + ","
                + DashDBContract.Customers.tableName + ","
                + DashDBContract.MenuItems.tableName + ","
                + DashDBContract.Outlets.tableName + ","
                + DashDBContract.Reviews.tableName + ","
                + DashDBContract.Orders.tableName;
    }

}
