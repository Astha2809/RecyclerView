package com.example.recyclerviewsession;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewsession.POJO.NewsModel;

import java.util.ArrayList;

public class NewsLayout extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<NewsModel> newsModelArrayList = new ArrayList<>();
    NewsAdapter newsadapter;
    ArrayList<String> titleArrayList = new ArrayList<>();
    ArrayList<String> descriptionArrayList = new ArrayList<>();
    ArrayList<String> timeArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerview = findViewById(R.id.recycler2);
        newsadapter = new NewsAdapter(this, newsModelArrayList);
        recyclerview.setAdapter(newsadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        addData();

    }

    private void addData() {
        for (int i = 0; i < 10; i++) {
            titleArrayList.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            descriptionArrayList.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            timeArrayList.add("20200227T02:41:00+00:00");
        }
        for (int i = 0; i < 10; i++) {
            String title1 = titleArrayList.get(i);
            String desc = descriptionArrayList.get(i);
            String time1 = timeArrayList.get(i);
            if (i == 0) {
                newsModelArrayList.add(new NewsModel(0, R.drawable.food1, title1, desc, time1));
            } else if (i == 1) {
                newsModelArrayList.add(new NewsModel(1, R.drawable.food1, title1, desc, time1));
            } else if (i % 2 == 0)
                newsModelArrayList.add(new NewsModel(2, R.drawable.food1, title1, desc, time1));

            else
                newsModelArrayList.add(new NewsModel(1, R.drawable.food1, title1, desc, time1));

        }

    }

    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        ArrayList<NewsModel> newsModelArrayList;
        Context context;

        public NewsAdapter(Context context, ArrayList<NewsModel> newsModelArrayList) {
            this.context = context;
            this.newsModelArrayList = newsModelArrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case NewsModel.IMAGE_ONLY:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image, parent, false);
                    return new MyViewHolder0(view);
                case NewsModel.IMAGE_TEXT:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textimage, parent, false);
                    return new MyViewHolder1(view);
                default:

                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.textonly, parent, false);
                    return new MyViewHolder2(view);



            }

            //return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            NewsModel newsModel = newsModelArrayList.get(position);
            String heading = newsModel.getHeading();
            String desc = newsModel.getSubheading();
            String time = newsModel.getTime();
            int image = newsModel.getImages();

            switch (newsModel.type) {
                case NewsModel.IMAGE_ONLY:
                    int image1 = newsModel.getImages();
                    ((MyViewHolder0) holder).imageView.setImageResource(image1);
                    break;
                case NewsModel.IMAGE_TEXT:
                    MyViewHolder1 myViewHolder1 = ((MyViewHolder1)holder);
                    myViewHolder1.mainHeading.setText(heading);
                    myViewHolder1.heading.setText(desc);
                    myViewHolder1.time.setText(time);
                    myViewHolder1.imageView.setImageResource(image);
                    break;
                case NewsModel.TEXT_ONLY:
                    MyViewHolder2 myViewHolder2 = ((MyViewHolder2)holder);
                    myViewHolder2.mainHeading.setText(heading);
                    myViewHolder2.heading.setText(desc);

                    break;

            }

        }

        @Override
        public int getItemViewType(int position) {
            switch (newsModelArrayList.get(position).type) {
                case 0:
                    return NewsModel.IMAGE_ONLY;
                case 1:
                    return NewsModel.IMAGE_TEXT;
                case 2:
                    return NewsModel.TEXT_ONLY;
                default:
                    return -1;

            }


        }

        @Override
        public int getItemCount() {
            return newsModelArrayList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

        public class MyViewHolder0 extends ViewHolder {
            ImageView imageView;
            CardView cardView;

            public MyViewHolder0(View view) {
                super(view);
                imageView = itemView.findViewById(R.id.image);
                cardView = itemView.findViewById(R.id.card1);

            }
        }

        public class MyViewHolder1 extends ViewHolder {
            TextView mainHeading;
            TextView heading;
            TextView time;
            ImageView imageView;

            public MyViewHolder1(@NonNull View itemView) {
                super(itemView);
                mainHeading = itemView.findViewById(R.id.textView2);
                heading = itemView.findViewById(R.id.textView3);
                time = itemView.findViewById(R.id.time);
                imageView = itemView.findViewById(R.id.imageView);

            }
        }

        public class MyViewHolder2 extends ViewHolder {
            TextView mainHeading;
            TextView heading;

            public MyViewHolder2(@NonNull View itemView) {
                super(itemView);
                mainHeading = itemView.findViewById(R.id.textView7);
                heading = itemView.findViewById(R.id.textView8);
            }
        }
    }


}




