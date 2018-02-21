package in.paperwrk.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    ImageView imageView;
    Spinner spinner;
    TextView priceTextView;
    int espressoPrice = 15;
    int machPrice = 26;
    int ristPrice = 18;
    int cappPrice = 30;

    int quantity = 0;
    String[] arrayCoffee = new String[]{
            "Select a Coffee of your choice","Espresso", "Short Macchiato", "Ristretto","Cappuccino"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_coffee);

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
                        quantityTextView.setText(0+"");
                        priceTextView.setText("$ 0");
                        imageView.setImageResource(R.drawable.espresso);
                        quantity = 0;
                        break;
                    case 2:
                        quantityTextView.setText(0+"");
                        priceTextView.setText("$ 0");
                        imageView.setImageResource(R.drawable.machito);
                        quantity = 0;
                        break;
                    case 3:
                        quantityTextView.setText(0+"");
                        priceTextView.setText("$ 0");
                        imageView.setImageResource(R.drawable.ristereto);
                        quantity = 0;
                        break;
                    case 4:
                        quantityTextView.setText(0+"");
                        priceTextView.setText("$ 0");
                        imageView.setImageResource(R.drawable.cappuccino);
                        quantity = 0;
                        break;
                    default: break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void submitOrder(View view) {
        Toast.makeText(this,"Order Processing!",Toast.LENGTH_SHORT).show();
    }

    private void display(int number) {
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        if(spinner.getSelectedItem() == "No Selection"){
            Toast.makeText(MainActivity.this,"Action Invalid",Toast.LENGTH_SHORT).show();
        }
        else {
            quantity++;
            display(quantity);
            switch (spinner.getSelectedItemPosition()){
                case 1 :
                    displayPrice(quantity*espressoPrice);
                    break;
                case 2 :
                    displayPrice(quantity*machPrice);
                    break;
                case 3 :
                    displayPrice(quantity*ristPrice);
                    break;
                case 4 :
                    displayPrice(quantity*cappPrice);
                    break;
            }
        }
    }

    public void decrement(View view) {
        if(spinner.getSelectedItem() == "No Selection"){
            Toast.makeText(MainActivity.this,"Action Invalid",Toast.LENGTH_SHORT).show();
        }
        else {
            quantity--;
            display(quantity);
            switch (spinner.getSelectedItemPosition()){
                case 1 :
                    displayPrice(quantity*espressoPrice);
                    break;
                case 2 :
                    displayPrice(quantity*machPrice);
                    break;
                case 3 :
                    displayPrice(quantity*ristPrice);
                    break;
                case 4 :
                    displayPrice(quantity*cappPrice);
                    break;
            }
        }
    }

}
