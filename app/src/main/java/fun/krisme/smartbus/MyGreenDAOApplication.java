package fun.krisme.smartbus;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoMaster;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoSession;

public class MyGreenDAOApplication extends Application {

    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyGreenDAOApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        SetDatabase();
    }

    private void SetDatabase(){
        HRMOpenHelper mHelper = new HRMOpenHelper(this,"myGDDb",null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static MyGreenDAOApplication getInstances(){
        return instances;
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    public SQLiteDatabase getDb(){
        return db;
    }
}
