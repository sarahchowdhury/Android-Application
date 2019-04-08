package bd.ac.uiu.mcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHandler {
    public static final String u_id = "u_id";
    public static final String u_name = "u_name";
    public static final String u_email = "u_email";
    public static final String u_phone = "u_phone";
    public static final String u_age = "u_age";
    public static final String u_image = "u_image";

    public static final String DATABASE_NAME = "validationform";
    public static final String USER_TABLE = "user";

    //database version
    public static final int DATABASE_VERSION =1;
    public Context context;
    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public DataBaseHandler(Context context){
        this.context=context;
    }

    public void insert(User u) {
        ContentValues cv=new ContentValues();
        cv.put(u_image,u.getImage());
        cv.put(u_name,u.getName());
        cv.put(u_email,u.getEmail());
        cv.put(u_phone,u.getPhone());
        cv.put(u_age,u.getAge());


        database.insert(USER_TABLE,null,cv);
    }
    public ArrayList<User> getUser(){
        ArrayList<User> users=new ArrayList<>();

        Cursor cursor=database.query(USER_TABLE,null,null,null,null,null,null);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            User user = new User(
                    cursor.getString(cursor.getColumnIndex(u_name)),
                    cursor.getString(cursor.getColumnIndex(u_email)),
                    cursor.getString(cursor.getColumnIndex(u_phone)),
                    cursor.getString(cursor.getColumnIndex(u_age)),
                    cursor.getInt(cursor.getColumnIndex(u_id)),
                    cursor.getInt(cursor.getColumnIndex(u_image)));
            users.add(user);
        }
        return users;
    }


    public static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("CREATE TABLE " + USER_TABLE + "( "
                    + u_id + "  INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + u_image + " INTEGER, "
                    + u_name + " TEXT NOT NULL, "
                    + u_email + " TEXT NOT NULL, "
                    + u_phone + " TEXT NOT NULL, "
                    + u_age + " TEXT NOT NULL);");
        }




        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            onCreate(sqLiteDatabase);
        }
    }
    public void open(){

        dbHelper= new DBHelper(context);
        database=dbHelper.getWritableDatabase();

    }

    public void close(){
        database.close();
    }
}
