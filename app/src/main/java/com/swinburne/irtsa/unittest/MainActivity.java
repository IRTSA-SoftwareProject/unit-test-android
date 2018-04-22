package com.swinburne.irtsa.unittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextToChange;
    private Button mTextChangeButton;
    private Button mInsertColorFragmentButton;
    private ColourFragment mColourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
    }

    private void initialiseUI() {
        //Initialise member variables representing UI elements.
        mTextToChange = findViewById(R.id.textToChange);
        mTextChangeButton = findViewById(R.id.changeTextButton);
        mInsertColorFragmentButton = findViewById(R.id.insertFragmentButton);
        mColourFragment = new ColourFragment();

        //A listener for the button that changes the TextView text.
        mTextChangeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mTextToChange.setText("You pressed the button!"); //Change TextView to display new text.
            }
        });

        //A listener for the button that inserts the colour fragment.
        mInsertColorFragmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Insert the mColourFragment into the FrameLayout that has ID fragmentColorContainer
                getFragmentManager().beginTransaction().replace(R.id.fragmentColorContainer, mColourFragment).commit();
            }
        });
    }
}
