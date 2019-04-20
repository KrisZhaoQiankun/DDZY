package fun.krisme.smartbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChiefActivity extends AppCompatActivity {

    private Button mBtnfs,mBtntd,mBtnss,mBtnTraining,mBtnConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chief);
        mBtnfs = findViewById(R.id.btn_fs);
        mBtntd = findViewById(R.id.btn_td);
        mBtnss = findViewById(R.id.btn_ss);
        mBtnTraining = findViewById(R.id.btn_training);
        mBtnConsult = findViewById(R.id.btn_consult);
        setListeners();

    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnfs.setOnClickListener(onClick);
        mBtntd.setOnClickListener(onClick);
        mBtnss.setOnClickListener(onClick);
        mBtnTraining.setOnClickListener(onClick);
        mBtnConsult.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_fs:
                    //跳转到fs演示界面
                    intent = new Intent(ChiefActivity.this, FinancialSharingActivity.class);
                    break;
                case R.id.btn_td:
                    //跳转到btn_td演示界面
                    intent = new Intent(ChiefActivity.this, TaxDeputyActivity.class);
                    break;
                case R.id.btn_ss:
                    //跳转到btn_ss演示界面
                    intent = new Intent(ChiefActivity.this, SocialSecurityActivity.class);
                    break;
                case R.id.btn_training:
                    //跳转到btn_training演示界面
                    intent = new Intent(ChiefActivity.this, TrainingActivity.class);
                    break;
                case R.id.btn_consult:
                    //跳转到btn_consult演示界面
                    intent = new Intent(ChiefActivity.this, ConsultActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
