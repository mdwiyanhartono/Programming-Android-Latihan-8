package dwiyanhartono.com.latihan8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox Ck1, Ck2, Ck3;
    Button Submit;
    RadioGroup RGMakanan;
    RadioButton RBMakanan,RBMakan1,RBMakan2,RBMakan3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set();
    }

    private void set() {
        Ck1 = findViewById(R.id.checkBoxBand1);
        Ck2 = findViewById(R.id.checkBoxBand2);
        Ck3 = findViewById(R.id.checkBoxBand3);
        Submit = findViewById(R.id.buttonSubmit);
        RBMakan1 = findViewById(R.id.radioButtonMakan1);
        RBMakan2 = findViewById(R.id.radioButtonMakan2);
        RBMakan3 = findViewById(R.id.radioButtonMakan3);
        RGMakanan = findViewById(R.id.RadioGroupMakan);
        Ck1.setChecked(false);
        Ck2.setChecked(false);
        Ck3.setChecked(false);
        RBMakan1.setChecked(false);
        RBMakan2.setChecked(false);
        RBMakan3.setChecked(false);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Band = "";
                if (Ck1.isChecked()) {
                    Band = getString(R.string.checkBoxBand1);
                }
                if (Ck2.isChecked()) {
                    if (Ck1.isChecked()) {
                        Band = Band + ", " + getString(R.string.checkBoxBand2);
                    } else {
                        Band = getString(R.string.checkBoxBand2);
                    }
                }
                if (Ck3.isChecked()) {
                    if (Ck2.isChecked() || Ck1.isChecked()) {
                        Band = Band + ", " + getString(R.string.checkBoxBand3);
                    } else {
                        Band = getString(R.string.checkBoxBand3);
                    }
                }
                if (Band.equals("")) {
                    Band = "Tidak Ada";
                }
                int Sel_ID = RGMakanan.getCheckedRadioButtonId();
                String Makanan = "";
                if (Sel_ID > 0) {
                    RBMakanan = findViewById(Sel_ID);
                    Makanan = RBMakanan.getText().toString();
                } else {
                    Makanan = "Anda tidak memilih makanan.";
                }
                String Pesan = "Band favorite adalah: " + Band + "\n" +
                        "Makanan favorite adalah: " + Makanan;
                AlertDialog.Builder aldo = new AlertDialog.Builder(MainActivity.this);
                aldo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onResume();
                    }
                });
                aldo.setTitle("Informasi");
                aldo.setMessage(Pesan);
                AlertDialog Alert = aldo.create();
                Alert.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        set();
    }
}