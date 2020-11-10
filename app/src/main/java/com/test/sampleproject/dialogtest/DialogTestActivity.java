package com.test.sampleproject.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.test.sampleproject.MainActivity;
import com.test.sampleproject.R;

public class DialogTestActivity extends AppCompatActivity implements SampleDialogFragment.SampleListener {

    private SampleDialogFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test_acitivity);
        TextView dialogText = findViewById(R.id.dialog_btn);
        TextView dialogFragmentText = findViewById(R.id.dialog_fragment_btn);
        dialogText.setOnClickListener(v -> showDialog());
        dialogFragmentText.setOnClickListener(v -> showDialogFragment());
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this); // 빌더 얻기 // 제목 설정
        alertDialogBuilder.setTitle("확인취소")
                .setMessage("확인 or 취소")
                .setCancelable(false)
                .setPositiveButton("확인", (dialog, id) -> {
                    Toast.makeText(this, "확인 클릭", Toast.LENGTH_LONG).show();
                    dialog.cancel();
                })
                .setNegativeButton("취소", (dialog, id) -> {
                    Toast.makeText(this, "취소 클릭", Toast.LENGTH_LONG).show();
                    dialog.cancel();
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    private void showDialogFragment() {
        mFragment = SampleDialogFragment.getInstance("BUNDLE TEXT");
        mFragment.setSetType("SET TEXT");
        mFragment.show(getSupportFragmentManager(), "SAMPLE_DIALOG_FRAGMENT");
    }

    @Override
    public void onClicked() {
        Toast.makeText(this, "클릭", Toast.LENGTH_SHORT).show();
    }
}
