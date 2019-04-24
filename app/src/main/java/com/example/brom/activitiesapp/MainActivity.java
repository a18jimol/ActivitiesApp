package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    private String[] extraMessage;
    public static final String EXTRA_MESSAGE = "hejhej";
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;
    private ArrayList<Mountain> mountainData=new ArrayList<>();
    private ArrayAdapter<Mountain> mountainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ger listData värdet av arrayen mountainNames
        listData=new ArrayList<>(Arrays.asList(mountainNames));
        // skriver ut alla berg i listan
        for(int i=0; i<3; i++) {
            mountainData.add(new Mountain(mountainNames[i], mountainLocations[i], mountainHeights[i]));
        }
        mountainAdapter=new ArrayAdapter<Mountain>(this,R.layout.list_item_textview,R.id.list_item_textview, mountainData);

        adapter=new ArrayAdapter<String>(this,R.layout.list_item_textview,R.id.list_item_textview, listData);

        // kopplar arrayen med listView
        ListView my_listview=(ListView) findViewById(R.id.my_listview);
        my_listview.setAdapter(mountainAdapter);



        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // skaper en variabel som hämtar data från arrayerna efter värdet på i
                /*String temp = ""    + mountainNames[i] + " "
                        + mountainLocations[i] + " "
                        + mountainHeights[i];*/
                String temp = mountainData.get(i).info();
               // Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MountainDetailsActivity.class);
                String allt = mountainData.get(i).info();
                intent.putExtra(EXTRA_MESSAGE,allt );
                startActivity(intent);




            }
        });


        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "Mountain
        // 3. Create a new Layout file for the Mountain called
        //    "activity_mountaindetails". Mountain must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the Mountain with the data from the Intent created in step
        //    6
        // 8. From the Mountain you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    Mountain.
    }
}
