package app.dash.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * Read operations for the local Dash database.
 * What a treat!
 * Created by Malusi Gcakasi on 2016-03-04.
 */
public class DataReadOperations {

    /**
     * Constructor for the Dash Read Operations class.
     */
    public DataReadOperations() {}

    /** Executed to run a query against a Dash table and retrieve some information.
     * @param dashContext
     * @param tableName Name of the Dash database table to be queried
     * @param dbColumns A string array of the columns returned by the query
     * @param whereColumns Columns to be used in the WHERE statement
     * @param whereValues Values to be searched for in the WHERE statement
     * @param rowGroupings Representation of how to group returned by query
     * @param rowFilter Designation for filtering rows returned by query
     * @param sortOrder Order in which to sort rows returned by query */
    public Cursor runDBQuery(Context dashContext, String tableName, String[] dbColumns,
                             String whereColumns, String[] whereValues, String rowGroupings,
                             String rowFilter, String sortOrder) {
        DashDBHelper dashDBHelper = new DashDBHelper(dashContext);
        SQLiteDatabase dashDB = dashDBHelper.getReadableDatabase();

        Cursor dashCursor = dashDB.query(tableName, dbColumns, whereColumns, whereValues, rowGroupings,
                rowFilter, sortOrder);

        dashDB.close();

        return dashCursor;

        // use this code to execute
        /*cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(FeedEntry._ID)
        );*/
    }
}
