package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.setTitle(R.string.page_calculator);
    }

    public void Cliquer(View view) {
        Button btn = (Button) view;
        String value = (String) btn.getText();
        TextView screen = (TextView) findViewById(R.id.txt_screen) ;
        String val = screen.getText().toString();
        if (isNumeric(value)){
            screen.setText(screen.getText()+value);
        }else {
            switch (value){
                case "AC":
                    screen.setText("");
                    break;
                case "+":
                    screen.setText(screen.getText()+"+");
                    break;
                case "-":
                    screen.setText(screen.getText()+"-");
                    break;
                case "*":
                    screen.setText(screen.getText()+"*");
                    break;
                case "/":
                    screen.setText(screen.getText()+"/");
                    break;
                case "+/-":
                    screen.setText(screen.getText()+"(-");
                    break;
                case "=":
                    String[] plus= stringtoarray(val,"+");
                    String[] moins= stringtoarray(val,"-");
                    String[] fois= stringtoarray(val,"*");
                    String[] div= stringtoarray(val,"/");
                    String[] mod= stringtoarray(val,"%");
                    int i=0;
                            double result=0;
                    if(plus.length > 1){
                        for (String str : plus){
                            result+=Integer.parseInt(str.trim());
                        }
                        screen.setText(String.valueOf(result));

                    }else if(moins.length > 1){
                        for (i = 0; i<moins.length; i++){
                            if (i==0){
                                result=Integer.parseInt(moins[i].trim());
                            }else {
                                result-=Integer.parseInt(moins[i].trim());
                            }
                        }
                        screen.setText(String.valueOf(result));

                    }else if (fois.length > 1){
                        result = 1;
                        for (String str : fois){
                            result*=Integer.parseInt(str.trim());
                        }
                        screen.setText(String.valueOf(result));


                    }else if (div.length > 1){
                        for (i = 0; i< div.length; i++){
                            if (i==0){
                                result=Integer.parseInt(div[i].trim());
                            }else {
                                result/=Integer.parseInt(div[i].trim());
                            }
                        }
                        screen.setText(String.valueOf(result));

                    }else if (mod.length > 1){
                        for (i = 0; i< mod.length; i++){
                            if (i==0){
                                result=Integer.parseInt(mod[i].trim());
                            }else {
                                result%=Integer.parseInt(mod[i].trim());
                            }
                        }
                        screen.setText(String.valueOf(result));
                    }
                    break;
                case "%":
                    screen.setText(screen.getText()+"%");
                    break;

            }
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static String[] stringtoarray (String str, String signe){
       return str.split(Pattern.quote(signe));
    }
}
