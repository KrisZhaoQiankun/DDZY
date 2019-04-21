package fun.krisme.smartbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import util.ToastUtil;

public class RegistActivity extends AppCompatActivity {

    private UserDao userDao;
    private List<User> userList;
    private TextView mTvTitle;
    private EditText mEtUsername,mEtPassword,mEtRePassword;
    private Button mBtnLogin,mBtnRegist;
    private boolean busername = true;
    private boolean bpassword = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        mTvTitle = findViewById(R.id.tv_regist_title);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mEtRePassword = findViewById(R.id.et_repassword);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegist = findViewById(R.id.btn_regist);
        userList = new ArrayList<User>();
        userDao = MyGreenDAOApplication.getInstances().getDaoSession().getUserDao();

        mEtUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!"".equals(mEtUsername)){
                    if(queryOneByName(mEtUsername.getText().toString())){
                        ToastUtil.showMsg(getApplicationContext(),"用户名已存在，请重新输入！");
                        busername = false;
                    }else{
                        busername = true;
                    }
                }
            }
        });

        mEtRePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!"".equals(mEtPassword.getText().toString().trim())&&!"".equals(mEtRePassword.getText().toString().trim())){
                    if(!(mEtPassword.getText().toString().equals(mEtRePassword.getText().toString()))) {
                        ToastUtil.showMsg(getApplicationContext(),"两次密码输入不一致");
                        bpassword = false;
                    }else{
                        bpassword = true;
                    }
                }
            }
        });

        mBtnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (busername==true&&bpassword==true){
                    User user = new User();
                    user.setName(mEtUsername.getText().toString().trim());
                    user.setPassword(mEtPassword.getText().toString().trim());
                    user.setUsercode(mEtUsername.getText().toString().trim());
                    insertOne(user);
                    ToastUtil.showMsg(getApplicationContext(),"注册成功");
                    Intent intent = new Intent(RegistActivity.this,MainActivity.class);
                    startActivity(intent);
                }else if (busername==true&&bpassword==false){
                    ToastUtil.showMsg(getApplicationContext(),"两次密码输入不一致，请重新输入！");
                }else if (busername==false&&bpassword==true){
                    ToastUtil.showMsg(getApplicationContext(),"用户名已存在，请重新输入！");
                }else{
                    ToastUtil.showMsg(getApplicationContext(),"用户名和密码输入错误，请重新输入！");
                }

            }
        });




//        测试
//        userDao.deleteAll();
//        iinsertOne();
//        queryOneByName();
//        insertMany();
//        updateUser();

//        deleteByName();
//        userDao.deleteByKey(new Long ((long)9));
//        queryList();

    }


    //根据用户名删除
    private void deleteByName(){
        QueryBuilder qb = userDao.queryBuilder();
        List<User> userList = qb.where(UserDao.Properties.Name.eq("kris")).list();
        for (User user:userList){
            userDao.delete(user);
        }
    }


    //更新
    private void updateUser(){
        User user = userDao.queryBuilder().where(UserDao.Properties.Name.eq("kris")).build().unique();
        user.setPassword("111");
        userDao.update(user);

    }

    //插入单个结果
    private void insertOne(User user){
        userDao.insert(user);
    }

    //插入多个结果
    public void insertMany(){
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setName("kris");
        user1.setUsercode("001");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setName("kris2");
        user2.setUsercode("002");
        user2.setPassword("123456");
        User user3 = new User();
        user3.setName("kris3");
        user3.setUsercode("003");
        user3.setPassword("123456");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userDao.insertInTx(userList);

    }

    //根据名字查询单个结果
    private boolean queryOneByName(String name){
        User user = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        if (user != null){
            return true;
        }
        return false;
    }


    //查询所有结果
    private void queryList(){
        String result="显示结果为："+"\n\n";
        List<User> userList = userDao.loadAll();
        int i = 0;
        for(User user:userList){
            i = i+1;
            result = result+"第"+String.valueOf(i)+"条："+String.valueOf(user.getPassword());
        }
        mTvTitle.setText(result);
    }
}
