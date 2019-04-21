package fun.krisme.smartbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.UserDao;

import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin,mBtnRegist;
    private EditText mEtUsername,mEtPassword;

    private UserDao userDao;
    private List<User> userList;
    private DBUtil db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBUtil();
        userList = new ArrayList<User>();
        userDao = MyGreenDAOApplication.getInstances().getDaoSession().getUserDao();

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegist = findViewById(R.id.btn_regist);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


}
