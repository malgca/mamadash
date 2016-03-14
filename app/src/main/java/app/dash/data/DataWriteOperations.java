package app.dash.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Write operations for the local Dash database
 * Created by OG Malusi Gcakasi on 2016-03-04.
 */
public class DataWriteOperations {

    /**
     * Constructor for the Dash Read Operations class.
     */
    public DataWriteOperations() {}

    /**
     * Inserts entries into a specified table in the Dash database.
     * @param dashContext Current context of the Dash application
     * @param tableName Name of the table in which data will be inserted
     * @param tableValues Values to be inserted into a specified table
     * */
    public long insertDashTableEntry(Context dashContext, String tableName, String[] tableValues) {
        DashDBHelper dashDBHelper = new DashDBHelper(dashContext);
        SQLiteDatabase dashDB = dashDBHelper.getWritableDatabase();
        long dbReturnFlag = 0;

        switch(tableName) {
            case DashDBContract.Customers.tableName:
                dbReturnFlag = this.insertCustomerEntry(dashDB, tableValues);
                break;
            case DashDBContract.MenuItems.tableName:
                dbReturnFlag = this.insertMenuItemEntry(dashDB, tableValues);
                break;
            case DashDBContract.Orders.tableName:
                dbReturnFlag = this.insertOrderEntry(dashDB, tableValues);
                break;
            case DashDBContract.Bills.tableName:
                dbReturnFlag = this.insertBillEntry(dashDB, tableValues);
                break;
            case DashDBContract.Outlets.tableName:
                dbReturnFlag = this.insertOutletEntry(dashDB, tableValues);
                break;
            case DashDBContract.Reviews.tableName:
                dbReturnFlag = this.insertReviewEntry(dashDB, tableValues);
                break;
            case DashDBContract.CustomerCreditCardDetails.tableName:
                dbReturnFlag = this.insertCustomerCreditCardDetailsEntry(dashDB, tableValues);
                break;
            case DashDBContract.CustomerProfileDetails.tableName:
                dbReturnFlag = this.insertCustomerProfileDetailsEntry(dashDB, tableValues);
                break;
            case DashDBContract.CustomerSocialID.tableName:
                dbReturnFlag = this.insertCustomerSocialIDEntry(dashDB, tableValues);
                break;
            case DashDBContract.Brands.tableName:
                dbReturnFlag = this.insertBrandEntry(dashDB, tableValues);
                break;
        }

        dashDB.close();
        return dbReturnFlag;
    }

    /**
     * Update a specified entry in the Dash database.
     * @param dashContext Current context of the Dash application
     * @param tableName Name of the table in which data will be updated
     * @param searchColumnName Name of the column on which to search the database for the old
     *                         value
     * @param rowID ID of the specific row in the table that is to be changed
     * @param putValue Value to put into the table */
    public int updateDashTableEntry(Context dashContext, String tableName,
                                    String searchColumnName, String rowID, String putValue) {
        DashDBHelper dashDBHelper = new DashDBHelper(dashContext);
        SQLiteDatabase dashDB = dashDBHelper.getReadableDatabase();
        int dbReturnFlag;

        // New value for one column
        ContentValues tableContent = new ContentValues();
        tableContent.put(searchColumnName, putValue);

        // Which row to update, based on the ID
        String selection = searchColumnName + " LIKE ?";
        String[] selectionArgs = { String.valueOf(rowID) };

        dbReturnFlag = dashDB.update(tableName, tableContent, selection, selectionArgs);
        dashDB.close();
        return dbReturnFlag;
    }

    /**
     * Deletes a single entry from a table in the Dash database.
     * @param dashContext Current context of the Dash application
     * @param tableName Name of the table in which data will be deleted
     * @param searchColumnName Name of the column on which to search the database for the
     *                         value to delete
     * @param rowID ID of the specific row in the table that is to be changed */
    public void deleteDashTableEntry(Context dashContext, String tableName,
                                     String searchColumnName, String rowID) {
        DashDBHelper dashDBHelper = new DashDBHelper(dashContext);
        SQLiteDatabase dashDB = dashDBHelper.getReadableDatabase();

        String selection = searchColumnName + "LIKE ?";
        String[] selectionArgs = { String.valueOf(rowID) };

        dashDB.delete(tableName, selection, selectionArgs);
        dashDB.close();
    }

    // Insert a single row entry into the Dash database Customers table.
    private long insertCustomerEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Customers.customerID, tableValues[0]);
        tableContent.put(DashDBContract.Customers.customerFirstName, tableValues[1]);
        tableContent.put(DashDBContract.Customers.customerMiddleName, tableValues[2]);
        tableContent.put(DashDBContract.Customers.customerLastName, tableValues[3]);
        tableContent.put(DashDBContract.Customers.customerEmailAddress, tableValues[4]);
        tableContent.put(DashDBContract.Customers.customerPhoneNumber, tableValues[5]);

        return dashDB.insert(DashDBContract.Customers.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database CustomerSocialIDs table.
    private long insertCustomerSocialIDEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.CustomerSocialID.customerSocialID, tableValues[0]);
        tableContent.put(DashDBContract.CustomerSocialID.customerFacebookID, tableValues[1]);
        tableContent.put(DashDBContract.CustomerSocialID.customerInstagramID, tableValues[2]);
        tableContent.put(DashDBContract.CustomerSocialID.customerTwitterID, tableValues[3]);
        tableContent.put(DashDBContract.CustomerSocialID.customerID, tableValues[4]);

        return dashDB.insert(DashDBContract.CustomerSocialID.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database CustomerProfileDetails table.
    private long insertCustomerProfileDetailsEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.CustomerProfileDetails.customerID, tableValues[0]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerAddress, tableValues[1]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerDescription, tableValues[2]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerGender, tableValues[3]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerLanguage, tableValues[4]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerTimeZone, tableValues[5]);
        tableContent.put(DashDBContract.CustomerProfileDetails.customerNicknames, tableValues[6]);

        return dashDB.insert(DashDBContract.CustomerProfileDetails.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database CustomerCreditCardDetails table.
    private long insertCustomerCreditCardDetailsEntry(SQLiteDatabase dashDB,
                                                      String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardID, tableValues[0]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardNumber, tableValues[1]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardBrand, tableValues[2]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardExpirationMonth,
                tableValues[3]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardExpirationYear,
                tableValues[4]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardFirstName, tableValues[5]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardLastName, tableValues[6]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardCountry, tableValues[7]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.cardPostalCode, tableValues[8]);
        tableContent.put(DashDBContract.CustomerCreditCardDetails.customerID, tableValues[9]);

        return dashDB.insert(DashDBContract.CustomerCreditCardDetails.tableName, null,
                tableContent);
    }

    // Insert a single row entry into the Dash database Brands table.
    private long insertBrandEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Brands.brandID, tableValues[0]);
        tableContent.put(DashDBContract.Brands.brandName, tableValues[1]);
        tableContent.put(DashDBContract.Brands.brandDescription, tableValues[2]);
        tableContent.put(DashDBContract.Brands.brandPrimaryColour, tableValues[3]);
        tableContent.put(DashDBContract.Brands.brandSecondaryColour, tableValues[4]);
        tableContent.put(DashDBContract.Brands.brandTertiaryColour, tableValues[5]);

        return dashDB.insert(DashDBContract.Brands.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database Outlets table.
    private long insertOutletEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Outlets.outletID, tableValues[0]);
        tableContent.put(DashDBContract.Outlets.outletName, tableValues[1]);
        tableContent.put(DashDBContract.Outlets.outletDescription, tableValues[2]);
        tableContent.put(DashDBContract.Outlets.outletLocationX, tableValues[3]);
        tableContent.put(DashDBContract.Outlets.outletLocationY, tableValues[4]);
        tableContent.put(DashDBContract.Outlets.brandID, tableValues[5]);

        return dashDB.insert(DashDBContract.Outlets.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database MenuItems table.
    private long insertMenuItemEntry (SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.MenuItems.menuItemID, tableValues[0]);
        tableContent.put(DashDBContract.MenuItems.menuItemName, tableValues[1]);
        tableContent.put(DashDBContract.MenuItems.menuItemPrice,
                Double.parseDouble(tableValues[3]));
        tableContent.put(DashDBContract.MenuItems.menuItemDescription, tableValues[2]);
        tableContent.put(DashDBContract.MenuItems.storeID, tableValues[4]);
        tableContent.put(DashDBContract.MenuItems.brandID, tableValues[5]);

        return dashDB.insert(DashDBContract.MenuItems.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database Reviews table.
    private long insertReviewEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Reviews.reviewID, tableValues[0]);
        tableContent.put(DashDBContract.Reviews.reviewDate, tableValues[1]);
        tableContent.put(DashDBContract.Reviews.reviewTime, tableValues[2]);
        tableContent.put(DashDBContract.Reviews.reviewDescription, tableValues[3]);
        tableContent.put(DashDBContract.Reviews.reviewerName, tableValues[4]);
        tableContent.put(DashDBContract.Reviews.reviewerEmailAddress, tableValues[5]);
        tableContent.put(DashDBContract.Reviews.reviewRating, Integer.parseInt(tableValues[6]));

        return dashDB.insert(DashDBContract.Reviews.tableName, DashDBContract.Customers.customerID, tableContent);
    }

    // Insert a single row entry into the Dash database Orders table.
    private long insertOrderEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Orders.orderID, tableValues[0]);
        tableContent.put(DashDBContract.Orders.orderDate, tableValues[1]);
        tableContent.put(DashDBContract.Orders.orderTime, tableValues[2]);
        tableContent.put(DashDBContract.Orders.menuItemID, tableValues[3]);
        tableContent.put(DashDBContract.Orders.menuItemQuantity,
                Integer.parseInt(tableValues[4]));

        return dashDB.insert(DashDBContract.Orders.tableName, null, tableContent);
    }

    // Insert a single row entry into the Dash database Bills table.
    private long insertBillEntry(SQLiteDatabase dashDB, String[] tableValues) {
        ContentValues tableContent = new ContentValues();

        tableContent.put(DashDBContract.Bills.billID, tableValues[0]);
        tableContent.put(DashDBContract.Bills.billDate, tableValues[1]);
        tableContent.put(DashDBContract.Bills.billTime, tableValues[2]);
        tableContent.put(DashDBContract.Bills.billTip, tableValues[3]);
        tableContent.put(DashDBContract.Bills.brandID,
                Integer.parseInt(tableValues[4]));
        tableContent.put(DashDBContract.Bills.brandVAT, tableValues[5]);
        tableContent.put(DashDBContract.Bills.customerID, tableValues[6]);
        tableContent.put(DashDBContract.Bills.orderID, tableValues[7]);

        return dashDB.insert(DashDBContract.Bills.tableName, null, tableContent);
    }
}
