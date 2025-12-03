
package com.example.task9;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        answer = findViewById(R.id.answer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();

        int id = item.getItemId();

        if (id == R.id.clear) {
            num1.setText("");
            num2.setText("");
            answer.setText("");
            return true;
        }

        if (s1.isEmpty() || s2.isEmpty()) {
            answer.setText("יש להזין שני מספרים");
            return true;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double result = 0;

        if (id == R.id.add) {
            result = a + b;
        }
        else if (id == R.id.sub) {
            result = a - b;
        }
        else if (id == R.id.mul) {
            result = a * b;
        }
        else if (id == R.id.div) {
            if (b == 0) {
                answer.setText("אי אפשר לחלק באפס");
                return true;
            }
            result = a / b;
        }

        answer.setText(String.valueOf(result));
        return true;
    }
}
