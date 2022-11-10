package com.example.teacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Spinner classesSpin;
    ListView studentsLv;

    TextView firstNameTxt, lastNameTxt, dofTxt, phoneNumberTxt;

    //variables
    String[] classes = {"Choose class", "Yud1", "Yud2", "Yud3", "Yud4"};

    String[][] firstName = {
            {"Shay", "Dan", "Idan", "Inbar", "Dorel", "Orel", "Nisim", "Erel", "Yonatan", "Maya"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"},
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}
    };

    String[][] lastName = {
            {"Shteyman", "Zhuravlov", "Bunkin", "Menahem", "Gedj", "Gabay", "Krief", "Ben-Baruch", "Iluz", "Mayzus"},
            {"11", "22", "33", "44", "55", "66", "77", "88", "99", "100"},
            {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"},
            {"AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ"}
    };

    String[][] dof = {
            {"14/01", "2/04", "23/09", "12/02", "8/07", "8/09", "7/12", "30/11","16/03", "5/03"},
            {"11/11", "22/22", "33/33", "44/44", "55/55", "66/66", "77/77", "88/88", "99/99", "100/100"},
            {"aa/aa", "bb/bb", "cc/cc", "dd/dd", "ee/ee", "ff/ff", "gg/gg", "hh/hh", "ii/ii", "jj/jj"},
            {"AA/AA", "BB/BB", "CC/CC", "DD/DD", "EE/EE", "FF/FF", "GG/GG", "HH/HH", "II/II", "jj/jj"}
    };


    String[][] phoneNumbers = {
            {"0532230985", "0586651505", "0544771608", "0547456674", "0586910852", "0587161658", "0542509918", "0522228615", "0502120264", "0522030883"},
            {"1111111111", "222222222", "3333333333", "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999", "10101010101010101010"},
            {"aaaaaaaaaa", "bbbbbbbbb", "cccccccccc", "dddddddddd", "eeeeeeeeee", "ffffffffff", "gggggggggg", "hhhhhhhhhh", "iiiiiiiiii", "jjjjjjjjjj"},
            {"AAAAAAAAAA", "BBBBBBBBB", "CCCCCCCCCC", "DDDDDDDDDD", "EEEEEEEEEE", "FFFFFFFFFF", "GGGGGGGGGG", "HHHHHHHHHH", "IIIIIIIIII", "JJJJJJJJJJ"},
    };

    int posGlobal;

    ArrayAdapter<String> spinnerAdp;
    ArrayAdapter<String> listViewAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classesSpin = (Spinner) findViewById(R.id.classSpinner);
        studentsLv = (ListView) findViewById(R.id.studentsListView);

        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        dofTxt = (TextView) findViewById(R.id.dofTxt);
        phoneNumberTxt = (TextView) findViewById(R.id.phoneNumberTxt);


        spinnerAdp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classes);

        classesSpin.setAdapter(spinnerAdp);


        classesSpin.setOnItemSelectedListener(this);
        studentsLv.setOnItemClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        posGlobal = i;

        if(i == 1)
        {
            listViewAdp = new ArrayAdapter<>(this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstName[0]);
        }
        else if(i == 2)
        {
            listViewAdp = new ArrayAdapter<>(this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstName[1]);
        }
        else if(i == 3)
        {
            listViewAdp = new ArrayAdapter<>(this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstName[2]);
        }
        else if(i == 4)
        {
            listViewAdp = new ArrayAdapter<>(this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstName[3]);
        }

        studentsLv.setAdapter(listViewAdp);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        if(posGlobal != 0)
        {
            firstNameTxt.setText("First name: " + firstName[posGlobal - 1][i]);
            lastNameTxt.setText("Last name: " + lastName[posGlobal - 1][i]);
            dofTxt.setText("Date of birth: " + dof[posGlobal - 1][i]);
            phoneNumberTxt.setText("Phone number: " + phoneNumbers[posGlobal - 1][i]);
        }
    }
}