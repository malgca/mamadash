package app.dash.data;

import android.provider.BaseColumns;

/**
 * Contract detailing the Database Schema's used in Dash.
 * Created by OG Malusi Gcakasi on 2016-03-11.
 */
public final class DashDBContract {

    /** Empty constructor in case of unintended instantiation */
    public DashDBContract() {}

    /** Schema for customer table */
    public static abstract class Customers implements BaseColumns {
        public static final String tableName = "CUSTOMERS";

        public static final String customerID = "CustomerID";
        public static final String customerFirstName = "CustomerFirstName";
        public static final String customerMiddleName = "CustomerMiddleName";
        public static final String customerLastName = "CustomerLastName";
        public static final String customerEmailAddress = "CustomerEmailAddress";
        public static final String customerPhoneNumber = "CustomerPhoneNumber";
    }

    /** Schema for customer social ID over Facebook, Twitter or Instagram */
    public static abstract class CustomerSocialID implements BaseColumns {
        public static final String tableName = "CUSTOMER_SOCIAL_IDS";

        public static final String customerSocialID = "CustomerID";

        public static final String customerFacebookID = "CustomerFacebookID";
        public static final String customerTwitterID = "CustomerTwitterID";
        public static final String customerInstagramID = "CustomerInstagramID";

        public static final String customerID = "CustomerID";
    }

    /** Schema for a typical customer profile*/
    public static abstract class CustomerProfileDetails implements BaseColumns {
        public static final String tableName = "CUSTOMER_PROFILE_DETAILS";

        public static final String customerID = "CustomerID";

        public static final String customerGender = "CustomerGender";
        public static final String customerAddress = "CustomerAddress";
        public static final String customerDescription = "CustomerDescription";
        public static final String customerTimeZone = "CustomerTimeZone";
        public static final String customerLanguage = "CustomerLanguage";
        public static final String customerNicknames = "CustomerNickNames";
    }

    /** Schema for Customer Credit Card Details*/
    public static abstract class CustomerCreditCardDetails implements BaseColumns {
        public static final String tableName = "CUSTOMER_CREDIT_CARD_DETAILS";

        public static final String customerID = "CustomerID"; // ID to tie this to a particular customer

        public static final String cardID = "CardID"; // ID and Card number should both be identifiers.
        public static final String cardNumber = "CardNumber";

        public static final String cardBrand = "CardBrand";
        public static final String cardExpirationMonth = "CardExpirationMonth";
        public static final String cardExpirationYear = "CardExpirationYear";
        public static final String cardFirstName = "CardFirstName";
        public static final String cardLastName = "CardLastName";
        public static final String cardCountry = "CardCountry";
        public static final String cardPostalCode = "CardPostalCode";
    }

    /** Schema for a brand of store, such as Nandos or RocoMamas*/
    public static abstract class Brands implements BaseColumns {
        public static final String tableName = "BRANDS";

        public static final String brandID = "BrandID";
        public static final String brandName = "BrandName";
        public static final String brandDescription = "BrandDescription";
        public static final String brandPrimaryColour = "BrandPrimaryColour";
        public static final String brandSecondaryColour = "BrandSecondaryColour";
        public static final String brandTertiaryColour = "BrandTertiaryColour";
    }

    /** Schema for your local outlet */
    public static abstract class Outlets implements BaseColumns {
        public static final String tableName = "OUTLETS";

        public static final String outletID = "OutletID";
        public static final String outletName = "OutletName";
        public static final String outletDescription = "OutletDescription";
        public static final String outletLocationX = "OutletLocationX";
        public static final String outletLocationY = "OutletLocationY";

        public static final String brandID = "BrandID"; // ID to associate with a particular brand.
    }

    /** Schem afor a menu*/
    public static abstract class MenuItems implements BaseColumns {
        public static final String tableName = "MENUITEMS";

        public static final String menuItemID = "MenuItemID";
        public static final String menuItemName = "MenuItemName";
        public static final String menuItemDescription = "MenuItemDescription";
        public static final String menuItemPrice = "MenuItemPrice";

        // Used in the particular edge case when something is available only from a single store.
        public static final String storeID = "StoreID"; // ID to associate with a particular store.
        public static final String brandID = "BrandID"; // ID to associate with a particular brand.
    }

    /** Schema for a bill */
    public static abstract class Bills implements BaseColumns {
        public static final String tableName = "BILLS";

        public static final String billID = "BillID";
        public static final String billDate = "BillDate";
        public static final String billTime = "BillTime";
        public static final String billTip = "BillTip";

        // Brand of the Bill
        public static final String brandID = "BrandID"; //ID to be associated with a particular brand
        public static final String brandVAT = "BrandVAT";

        // Customer who ordered the menu items
        public static final String customerID = "CustomerID"; // ID to associate with a particular customer

        // The order for which the people are getting the bill
        public static final String orderID = "OrderID"; //ID to associate with a particular order

    }

    /** Schema for a single order*/
    public static abstract class Orders implements BaseColumns {
        public static final String tableName = "ORDERS";

        public static final String orderID = "BillID";
        public static final String orderDate = "BillDate";
        public static final String orderTime = "BillTime";

        // What was ordered
        public static final String menuItemID = "MenuItemID"; // ID to associate with a particular menu item
        public static final String menuItemQuantity = "MenuItemQuantity";
    }

    /** Schema for a review of a store */
    public static abstract class Reviews implements BaseColumns {
        public static final String tableName = "REVIEWS";

        public static final String reviewID = "ReviewID";
        public static final String reviewDate = "ReviewDate";
        public static final String reviewTime = "ReviewTime";
        public static final String reviewRating = "ReviewRating";
        public static final String reviewDescription = "ReviewDescription";

        // details of reviewer
        public static final String reviewerName = "ReviewerName";
        public static final String reviewerEmailAddress = "ReviewerEmailAddress";
    }
}
