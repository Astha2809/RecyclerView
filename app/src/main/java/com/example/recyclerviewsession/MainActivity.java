package com.example.recyclerviewsession;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager layoutManager;
    String[] ar = new String[10];
    boolean isScrolling=false;
    int currentItems,totalItems,scrolledOutItem;
    ProgressBar progressBar;
    ArrayList<String> arrayList=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ar[0] = "astha";
        ar[1] = "priya";
        ar[2] = "bharat";
        ar[3] = "akansha";
        ar[4] = "ujjwal";
        ar[5] = "xyz";
        ar[6] = "abc";
        ar[7] = "def";
        ar[8] = "ghi";
        ar[9] = "jkl";
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(ar, this.getBaseContext());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = layoutManager.getChildCount();
                totalItems = layoutManager.getItemCount();
                scrolledOutItem = layoutManager.findFirstVisibleItemPosition();
                if (isScrolling && (scrolledOutItem + currentItems == totalItems)) {
                    isScrolling = false;
                    fetchdata();
                }
            }
        });

        }
        private void fetchdata(){
            progressBar.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<5;i++){
                        arrayList.add(Math.floor(Math.random()*100)+"");
                        mAdapter.notifyDataSetChanged();
                    }


                }
            },5000);
        }

        }




class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context mainActivity;
    private String[] mDataset;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(mainActivity);
        View v = lf.inflate(R.layout.text, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.textView.setText(mDataset[position]);

        ((TextView) holder.v.findViewById(R.id.textview)).setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View v;

        public MyViewHolder(View v) {
            super(v);
            this.v = v;
        }

    }

    public MyAdapter(String[] myDataset, Context mainActivity) {
        this.mDataset = myDataset;
        this.mainActivity = mainActivity;
    }

}

