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

public class News_Layout extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<NewsModel> al=new ArrayList<>();
    MyAdapter2 adapter1;
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> description=new ArrayList<>();
    ArrayList<String> time=new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerview=findViewById(R.id.recycler2);
        for (int i=0;i<10;i++){
            title.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            description.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            time.add("20200227T02:41:00+00:00");
        }
        for(int i=0;i<10;i++){
            String title1=title.get(i);
            String desc=description.get(i);
            String time1=time.get(i);
            if(i==0)
            {
                al.add(new NewsModel(0,R.drawable.food1,title1,desc,time1));
            }
            else if(i==1)
            {
                al.add(new NewsModel(1,R.drawable.food1,title1,desc,time1));
            }
            else if(i%2==0)
                al.add(new NewsModel(2,R.drawable.food1,title1,desc,time1));

            else
                al.add(new NewsModel(1,R.drawable.food1,title1,desc,time1));

        }
        adapter1=new MyAdapter2(this,al);
        recyclerview.setAdapter(adapter1);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


    }

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder>{
        ArrayList<NewsModel> al;
        Context context;
        public MyAdapter2(Context context,ArrayList<NewsModel> al){
            this.context=context;
            this.al=al;
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch(viewType){
            case NewsModel.IMAGE_ONLY:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image,parent,false);
                return new MyViewHolder0(view);
            case NewsModel.IMAGE_TEXT:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.textimage,parent,false);
                return new MyViewHolder1(view);
            case NewsModel.TEXT_ONLY:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.textonly,parent,false);
                return new MyViewHolder2(view);


        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel newsModel=al.get(position);
        String heading=newsModel.getHeading();
        String desc=newsModel.getSubheading();
        String time=newsModel.getTime();
        int image=newsModel.getImages();

        switch (newsModel.type)
        {
            case NewsModel.IMAGE_ONLY:
                int image1=newsModel.getImages();
                ((MyViewHolder0)holder).imageView.setImageResource(image1);
                break;
            case NewsModel.IMAGE_TEXT:
                ((MyViewHolder1)holder).mainHeading.setText(heading);
                ((MyViewHolder1)holder).heading.setText(desc);
                ((MyViewHolder1)holder).time.setText(time);
                ((MyViewHolder1)holder).imageView.setImageResource(image);
                break;
            case NewsModel.TEXT_ONLY:
                ((MyViewHolder2)holder).mainHeading.setText(heading);
                ((MyViewHolder2)holder).heading.setText(desc);

                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (al.get(position).type)
        {
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
        return al.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class MyViewHolder0 extends ViewHolder{
        ImageView imageView;
        CardView cardView;

        public MyViewHolder0(View view) {
            super(view);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.card1);

        }
    }
    public class MyViewHolder1 extends ViewHolder{
        TextView mainHeading,heading,time;
        ImageView imageView;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            mainHeading=itemView.findViewById(R.id.textView2);
            heading=itemView.findViewById(R.id.textView3);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageView);

        }
    }
    public class MyViewHolder2 extends ViewHolder{
        TextView mainHeading,heading;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            mainHeading=itemView.findViewById(R.id.textView7);
            heading=itemView.findViewById(R.id.textView8);
        }
    }
}


}




