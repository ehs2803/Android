package com.example.orientationandalarmandprogress;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView textView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출됨.");

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                Toast.makeText(getApplicationContext(),
                        "입력된 값을 변수에 저장했습니다 : " + name,
                        Toast.LENGTH_LONG).show();
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            Toast.makeText(getApplicationContext(), "값을 복원했습니다 : " + name, Toast.LENGTH_LONG).show();
        }

        // 대화상자
        textView = findViewById(R.id.textView);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage();
            }
        });

        // 프로그레스바
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다.");
                dialog.show();
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //showToast("onStart 호출됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop 호출됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy 호출됨.");
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    public void onButton1Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }

    public void onButton2Clicked(View v) {
        Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
    }

    private void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                String message = "예 버튼이 눌렸습니다. ";
                textView.setText(message);
            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                String message = "취소 버튼이 눌렸습니다. ";
                textView.setText(message);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                String message = "아니오 버튼이 눌렸습니다. ";
                textView.setText(message);
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
    }
}