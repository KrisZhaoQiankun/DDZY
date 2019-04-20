package fun.krisme.smartbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin,mBtnRegist;
    private EditText mEtUsername,mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegist = findViewById(R.id.btn_regist);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("user".equals(mEtUsername.getText().toString())&&"123".equals(mEtPassword.getText().toString())){
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
