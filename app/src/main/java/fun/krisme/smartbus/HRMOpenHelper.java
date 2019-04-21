package fun.krisme.smartbus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoMaster;

public class HRMOpenHelper extends DaoMaster.OpenHelper {
    public HRMOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);//name数据库名称
    }
}
