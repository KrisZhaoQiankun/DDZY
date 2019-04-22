package fun.krisme.smartbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.UserDao;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import util.DBUtil;
import util.HttpUtil;
import util.ToastUtil;
import util.test;

public class MainActivity extends AppCompatActivity implements Callback<String> {

    private Button mBtnLogin,mBtnRegist;
    private EditText mEtUsername,mEtPassword;

    private UserDao userDao;
    private List<User> userList;
    private RemoteUser remoteUser;
    test test;
    private DBUtil db;
    private TextView mTvMainText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HttpUtil httpUtil = new HttpUtil();
//        try {
//            httpUtil.getConnection();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//      --------------Retrofit-----
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http:www.baidu.com")
//                .addConverterFactory(
//                        new Converter.Factory() {
//                            @Override
//                            public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//                                return new Converter<ResponseBody, Object>() {
//                                    @Override
//                                    public Object convert(ResponseBody value) throws IOException {
//                                        return value.string();
//                                    }
//                                };
//                            }
//                        }
//                ).build();
//        Service service = retrofit.create(Service.class);
//        Call<String> call = service.getBaidu();
//        call.enqueue(this);
//        mTvMainText = findViewById(R.id.main_text);



//        ----------------------------------------




        userList = new ArrayList<User>();
        userDao = MyGreenDAOApplication.getInstances().getDaoSession().getUserDao();


        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegist = findViewById(R.id.btn_regist);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);

//        安卓直连远程数据库失败
//        remoteUser = new RemoteUser();
//        remoteUser.setUsername(mEtUsername.getText().toString().trim());
//        remoteUser.setPassword(mEtPassword.getText().toString().trim());
//        test = new test();
//        final boolean b = test.check(remoteUser);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBUtil();
                if (db.check(mEtUsername.getText().toString().trim(),mEtPassword.getText().toString().trim())){
                    Intent intent = new Intent(MainActivity.this,ChiefActivity.class);
                    startActivity(intent);
                }else {
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"账号或者密码错误，请重新输入",Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    mEtUsername.setText("");
                    mEtPassword.setText("");
                }
            }
        });
        mBtnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResponse(Call<String> call, Response<String> response) {
//        mTvMainText.setText(response.body());
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        ToastUtil.showMsg(MainActivity.this,"请求失败"+call.request().url());
        t.printStackTrace();
    }
}
