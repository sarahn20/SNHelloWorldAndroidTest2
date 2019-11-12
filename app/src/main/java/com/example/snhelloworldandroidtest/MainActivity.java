package com.example.snhelloworldandroidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }
    public void onClickMeButtonPressed(View v)
    {
        EditText N1 = this.findViewById(R.id.N1);
        long Numerator1 = Long.parseLong(N1.getText().toString());

        EditText D1 = this.findViewById(R.id.D1);
        long Denominator1 = Long.parseLong(D1.getText().toString());

        EditText N2 = this.findViewById(R.id.N2);
        long Numerator2 = Long.parseLong(N2.getText().toString());

        EditText D2 = this.findViewById(R.id.D2);
        long Denominator2 = Long.parseLong(D2.getText().toString());

        Fraction firstFraction = new Fraction(Numerator1,Denominator1);
        Fraction secondFraction = new Fraction(Numerator2,Denominator2);

        firstFraction.add(secondFraction);
        firstFraction.reduceEuclidean();

        TextView NumeratorAnswer = this.findViewById(R.id.NumeratorAnswer);
        NumeratorAnswer.setText(Long.toString(firstFraction.numerator));

        TextView DenominatorAnswer = this.findViewById(R.id.DenominatorAnswer);
        DenominatorAnswer.setText(Long.toString(firstFraction.denominator));
    }
}
