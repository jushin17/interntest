package xysmedia.barcode_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

/**
 * Created by Jiung on 2016-02-23.
 */
public class CustomerActivity extends AppCompatActivity {
    private int MY_SCAN_REQUEST_CODE = 100;
    private String cardnum;
    private String expMonth;
    private String expYear;
    private String cvn;
    private EditText card_number;
    private EditText cvn_number;
    private Spinner exp_month;
    private Spinner exp_year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_activity_proto);

        final EditText b_fname = (EditText)findViewById(R.id.b_fname);
        final EditText b_lname = (EditText)findViewById(R.id.b_lname);
        final EditText b_company = (EditText)findViewById(R.id.b_company);
        final EditText b_addr = (EditText)findViewById(R.id.b_addr);
        final EditText b_addr2 = (EditText)findViewById(R.id.b_addr2);
        final EditText b_city = (EditText)findViewById(R.id.b_city);
        final EditText b_state = (EditText)findViewById(R.id.b_state);
        final EditText b_zip = (EditText)findViewById(R.id.b_zip);
        final Spinner b_country = (Spinner)findViewById(R.id.b_country);
        final EditText b_tel = (EditText)findViewById(R.id.b_tel);

        final EditText s_fname = (EditText)findViewById(R.id.s_fname);
        final EditText s_lname = (EditText)findViewById(R.id.s_lname);
        final EditText s_company = (EditText)findViewById(R.id.s_company);
        final EditText s_addr = (EditText)findViewById(R.id.s_addr);
        final EditText s_addr2 = (EditText)findViewById(R.id.s_addr2);
        final EditText s_city = (EditText)findViewById(R.id.s_city);
        final EditText s_state = (EditText)findViewById(R.id.s_state);
        final EditText s_zip = (EditText)findViewById(R.id.s_zip);
        final Spinner s_country = (Spinner)findViewById(R.id.s_country);
        final EditText s_tel = (EditText)findViewById(R.id.s_tel);

        card_number = (EditText) findViewById(R.id.card_number);
        cvn_number = (EditText) findViewById(R.id.cvn);
        exp_month = (Spinner) findViewById(R.id.ex_month);
        exp_year = (Spinner) findViewById(R.id.ex_year);
        final Spinner credit_card_type = (Spinner) findViewById(R.id.card_type);

        Button cardread_camera = (Button) findViewById(R.id.card_reader_camera);
        cardread_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanActivity = new Intent(CustomerActivity.this, CardIOActivity.class);
                scanActivity.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
                scanActivity.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, true); // default: false
                scanActivity.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false
                scanActivity.putExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, false); // default: false
                scanActivity.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, false); // default: false

                // hides the manual entry button
                // if set, developers should provide their own manual entry mechanism in the app
                scanActivity.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, false); // default: false

                // matches the theme of your application
                scanActivity.putExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false); // default: false

                // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
                startActivityForResult(scanActivity, MY_SCAN_REQUEST_CODE);



            }
        });


        CheckBox sync = (CheckBox)findViewById(R.id.addr_sync);

        sync.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s_fname.setText(b_fname.getText().toString());
                    s_lname.setText(b_lname.getText().toString());
                    s_company.setText(b_company.getText().toString());
                    s_addr.setText(b_addr.getText().toString());
                    s_addr2.setText(b_addr2.getText().toString());
                    s_city.setText(b_city.getText().toString());
                    s_state.setText(b_state.getText().toString());
                    s_zip.setText(b_zip.getText().toString());
                    s_country.setSelection(b_country.getSelectedItemPosition());
                    s_tel.setText(b_tel.getText().toString());

                } else {
                    s_fname.getText().clear();
                    s_lname.getText().clear();
                    s_company.getText().clear();
                    s_addr.getText().clear();
                    s_addr2.getText().clear();
                    s_city.getText().clear();
                    s_state.getText().clear();
                    s_zip.getText().clear();
                    s_country.setSelection(0);
                    s_tel.getText().clear();
                }

            }

        });
    }

    public void onScanPress(View v) {
        // This method is set up as an onClick handler in the layout xml
        // e.g. android:onClick="onScanPress"

        Intent scanIntent = new Intent(this, CardIOActivity.class);

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, true); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, false); // default: false

        // hides the manual entry button
        // if set, developers should provide their own manual entry mechanism in the app
        scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, false); // default: false

        // matches the theme of your application
        scanIntent.putExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false); // default: false

        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cardnum = new String();
        expMonth = new String();
        expYear = new String();
        cvn = new String();
        String resultStr;
        if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);

            // Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
            resultStr = "Card Number: " + scanResult.cardNumber + "\n";
            cardnum = scanResult.cardNumber;
            // Do something with the raw number, e.g.:
            // myService.setCardNumber( scanResult.cardNumber );

            if (scanResult.isExpiryValid()) {
                resultStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n";
                expMonth = String.valueOf(scanResult.expiryMonth);
                expYear = String.valueOf(scanResult.expiryYear);
            }

            if (scanResult.cvv != null) {
                // Never log or display a CVV
                resultStr += "CVV has " + scanResult.cvv + " digits.\n";
                cvn = String.valueOf(scanResult.cvv);
            }

            if (scanResult.postalCode != null) {
                resultStr += "Postal Code: " + scanResult.postalCode + "\n";
            }

            if (scanResult.cardholderName != null) {
                resultStr += "Cardholder Name : " + scanResult.cardholderName + "\n";
            }
        } else {
            resultStr = "Scan was canceled.";
        }
        Toast.makeText(CustomerActivity.this, resultStr, Toast.LENGTH_LONG).show();
        card_number.setText(cardnum);
        cvn_number.setText(cvn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.month,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exp_month.setAdapter(adapter);
        if (!expMonth.equals(null)) {
            int spinnerPosition = adapter.getPosition(expMonth);
            exp_month.setSelection(spinnerPosition);
        }

        adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exp_year.setAdapter(adapter);
        if (!expYear.equals(null)) {
            int spinnerPosition = adapter.getPosition(expYear);
            exp_year.setSelection(spinnerPosition);
        }
    }

}
