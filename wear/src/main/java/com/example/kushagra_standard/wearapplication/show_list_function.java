package com.example.kushagra_standard.wearapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.TextView;
import android.support.wear.widget.WearableRecyclerView;

public class show_list_function extends WearableActivity  implements WearableListView.ClickListener {

    private TextView mTextView;
    String[] elements = { "List Item 1", "List Item 2"};
    int[] images_array = {R.drawable.eurocoin,R.drawable.payments};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_function);

        WearableListView listView =
                (WearableListView) findViewById(R.id.wearable_list);
        listView.setAdapter(new Adapter(this, elements,images_array));

        listView.setClickListener(this);
        // Enables Always-on
        setAmbientEnabled();
    }
        // WearableListView click listener
        @Override
        public void onClick(WearableListView.ViewHolder v) {
        Integer tag = (Integer) v.itemView.getTag();
        if (tag==0)
        {

        }
            if (tag==1)
            {
                Intent intent = new Intent(this,actvity_pay.class);
                startActivity(intent);

            }

            // use this data to complete some action ...
    }

        @Override
        public void onTopEmptyRegionClick() {
    }
    public void showBalance(View v)
    {
        Intent intent = new Intent(this,balanceactivity.class);
        startActivity(intent);

    }
    public void fundTransfer(View v)
    {
        Intent intent = new Intent(this,actvity_pay.class);
        startActivity(intent);

    }
    public void createGoal(View v)
    {
        Intent intent = new Intent(this,creategoal.class);
        startActivity(intent);

    }
}
