package com.olonsoft.flexbox_layout_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // This is the text that will be rendered in the screen.
    private String textArr[] = {"dev2qa.com", "is", "a very good", "android example website", "there are", "a lot of", "android, java examples"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("FlexboxLayout Example.");


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.flex_box_recycler_view);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(MainActivity.this);
        layoutManager.setFlexDirection(FlexDirection.ROW_REVERSE);
        layoutManager.setJustifyContent(JustifyContent.FLEX_END);
        recyclerView.setLayoutManager(layoutManager);



//        // Set adapter object.
        RecylerViewAdapter viewAdapter = new RecylerViewAdapter(this.initViewItemDtoList());
        recyclerView.setAdapter(viewAdapter);
    }

    private List<Models> initViewItemDtoList()
    {
        List<Models> ret = new ArrayList<Models>();

        for(int i=0;i < this.textArr.length; i++)
        {
            Models itemDto = new Models();
            itemDto.setText(this.textArr[i]);

            ret.add(itemDto);
        }
        return ret;
    }
}
