package in.paperwrk.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    ImageView imageView;
    TextView priceTextView;
    String[] arrayCoffee = new String[]{
            "No Selection","Espresso", "Short Macchiato", "Ristretto","Cappuccino"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_coffee);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,arrayCoffee);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        imageView = findViewById(R.id.imageView);
        quantityTextView = findViewById(R.id.quantity_text_view);
        priceTextView = findViewById(R.id.price_text_view);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1:
                        imageView.setImageResource(R.drawable.espresso);
                        quantityTextView.setText("1");
                        priceTextView.setText("$15");
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.machito);
                        quantityTextView.setText("1");
                        priceTextView.setText("$26");
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.ristereto);
                        quantityTextView.setText("1");
                        priceTextView.setText("$18");
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.cappuccino);
                        quantityTextView.setText("1");
                        priceTextView.setText("$30");
                        break;
                    default: break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

/*

    */
/**
     * This method is called when the order button is clicked.
     *//*

    public void submitOrder(View view) {
        int quantity = 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    */
/**
     * This method displays the given quantity value on the screen.
     *//*

    private void display(int number) {
        quantityTextView.setText("" + number);
    }

    */
/**
     * This method displays the given price on the screen.
     *//*

    private void displayPrice(int number) {
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        int quantity = 3;
        display(quantity);
    }

    public void decrement(View view) {
        int quantity = 1;
        display(quantity);
    }
*/

}
