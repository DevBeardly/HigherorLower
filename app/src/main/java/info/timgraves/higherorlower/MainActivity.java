package info.timgraves.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int num;
    private int userNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = newNum();
    }

    public int newNum() {
        Random r = new Random();
        return r.nextInt(21);
    }

    public void newNum(View view) {
        num = newNum();
    }

    public void guessNumber(View view) {


        Log.i(TAG, "num = " + num);

        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        String n = guessEditText.getText().toString();
        userNum = Integer.parseInt(n);

        // Toast.makeText(MainActivity.this, "User entered: " + userNum, Toast.LENGTH_LONG).show();

        if (userNum == num) {
            Toast.makeText(MainActivity.this, "You guessed it!", Toast.LENGTH_LONG).show();
        } else if (userNum > num) {
            Toast.makeText(MainActivity.this, "Lower!", Toast.LENGTH_SHORT).show();
        } else if (userNum < num) {
            Toast.makeText(MainActivity.this, "Higher!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "WTF DID YOU DO?!", Toast.LENGTH_LONG).show();
        }

    }
}
