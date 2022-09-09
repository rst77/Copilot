package com.r13a.copilot.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.r13a.copilot.R;

import java.util.Calendar;
import java.util.Locale;

public class RacePlanningActivity extends AppCompatActivity {

    private EditText mRaceTitle, mRaceDate, mTotalDistance, mMaxDuration, mDesireDuration;
    private TextView mDesireSpeedAvg, mMinSpeedAvg;
    
    private int currentTotalDistance, currentMaxDuration, currentDesireDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_planning);

        mRaceTitle      = findViewById(R.id.editTextRaceTitle);
        mRaceDate       = findViewById(R.id.editTextRaceDate);
        mTotalDistance  = findViewById(R.id.editTextTotalDistance);
        mMaxDuration    = findViewById(R.id.editTextMaxDuration);
        mDesireDuration = findViewById(R.id.editTextDesireDuration);

        mMinSpeedAvg    = findViewById(R.id.textMinSpeedAvg);
        mDesireSpeedAvg = findViewById(R.id.textDesiredSpeedAvg);


        // Configura o formatador de data.
        setDateFormater();

        // Configura o calculador de média mínima.
        setTotalDistanceKeyWatcher();

    }

    /**
     * Calcula as médias horárias necessárias para se atingir os objetivos nos temos informados.
     */
    public void setTotalDistanceKeyWatcher() {

        mTotalDistance.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                int valor = Integer.parseInt(s.toString());

                if (valor != currentTotalDistance) {
                    currentTotalDistance = valor;

                    if (valor == 0) {
                        mMinSpeedAvg.setText("0");
                        mDesireSpeedAvg.setText("0");
                    }

                    // Ajusta a média mínima para se atingir a distancia na duração maxima
                    if (currentMaxDuration > 0) {
                        int media = valor / currentMaxDuration;
                        mMinSpeedAvg.setText(media);
                    }

                    // Ajusta o valor da média mínima necessária para fechar a prova na duração desejada.
                    if (currentDesireDuration > 0) {
                        int media = valor / currentDesireDuration;
                        mDesireSpeedAvg.setText(media);
                    }

                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }

    /**
     * Formata a data de acordo com o padrão.
     */
    public void setDateFormater() {

        mRaceDate.addTextChangedListener(new TextWatcher() {
            String current = "";
            String ddmmyyyy = "DDMMAAAA";
            Calendar cal = Calendar.getInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    mRaceDate.setText(current);
                    mRaceDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}