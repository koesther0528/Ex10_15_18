package kr.hs.emirim.ko502804.ex10_15_18;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1 = findViewById(R.id.edit1);
    EditText edit2 = findViewById(R.id.edit2);
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        rg = findViewById(R.id.rg);
        Button btnPlus = findViewById(R.id.btn_plus);

        btnPlus.setOnClickListener(btnListener);


    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            char op = 0;
            switch (rg.getCheckedRadioButtonId()){
                case R.id.radio_plus:
                    op = '+';
                    break;
                case R.id.radio_minus:
                    op = '-';
                    break;
                case R.id.radio_multi:
                    op = '*';
                    break;
                case R.id.radio_divide:
                    op = '/';
                    break;
            }
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
            intent.putExtra("op", op);
            startActivityForResult(intent, 0);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "합계: " + result, Toast.LENGTH_SHORT).show();
        }
    }
}