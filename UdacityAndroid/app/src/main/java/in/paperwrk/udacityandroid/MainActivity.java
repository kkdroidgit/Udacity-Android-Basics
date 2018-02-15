package in.paperwrk.udacityandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.thefinestartist.finestwebview.FinestWebView;

import java.util.ArrayList;
import java.util.Collections;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {


    private Integer[] IMAGES = {R.drawable.udacity_one,
            R.drawable.udacity_two, R.drawable.ud3, R.drawable.ud4};
    private ArrayList<Integer> ImagesArray = new ArrayList<>();
    private TextView phoneNo;
    private TextView website;
    private TextView address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();

        phoneNo = findViewById(R.id.phone_No);
        website = findViewById(R.id.website);
        address = findViewById(R.id.address);

        phoneNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "650-555-5555"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);



                }
                startActivity(intent);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FinestWebView.Builder(MainActivity.this).show("https://udacity.com");
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                startActivity(intent);
            }
        });
    }


    private void initPager() {
        Collections.addAll(ImagesArray, IMAGES);

        ViewPager viewPager = findViewById(R.id.pager);
        CircleIndicator circleIndicator = findViewById(R.id.indicator);

        viewPager.setAdapter(new ViewPagerAdapter(this,ImagesArray));
        circleIndicator.setViewPager(viewPager);
    }



}
