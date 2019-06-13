package com.ed.iu.saif.smartaquarium_20;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import static com.ed.iu.saif.smartaquarium_20.feedingSchedule.lv;

public class AdapterFeed extends RecyclerView.Adapter<AdapterFeed.HolderForFeed> {



    private List<ListItem> listItem;
    private Context context;


    public AdapterFeed(List<ListItem> listItems, Context context) {

        this.listItem=listItems;
        this.context=context;

    }

    @NonNull
    @Override
    public HolderForFeed onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.feedinglist,parent,false);

        return new HolderForFeed(view);
    }

    Calendar myCalendar = Calendar.getInstance();
    @Override
    public void onBindViewHolder(@NonNull HolderForFeed holderForFeed, int i) {


        final ListItem lt=listItem.get(i);
        holderForFeed.time.setText(lt.getName());


        if(Calendar.MONDAY==lt.getDays())
        {
            holderForFeed.mon.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.mon.setTextColor(Color.WHITE);
        }
        else if(Calendar.TUESDAY==lt.getDays()){
            holderForFeed.tue.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.tue.setTextColor(Color.WHITE);
        }
        else if(Calendar.WEDNESDAY==lt.getDays()){
            holderForFeed.wed.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.wed.setTextColor(Color.WHITE);
        }
        else if(Calendar.THURSDAY==lt.getDays()){
            holderForFeed.thur.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.thur.setTextColor(Color.WHITE);
        }
        else if(Calendar.FRIDAY==lt.getDays()){
            holderForFeed.fir.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.fir.setTextColor(Color.WHITE);
        }
        else if(Calendar.SATURDAY==lt.getDays()){
            holderForFeed.sat.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.sat.setTextColor(Color.WHITE);
        }
        else if(Calendar.SUNDAY==lt.getDays()){
            holderForFeed.sun.setBackgroundResource(R.drawable.roundbuttonblack);
            holderForFeed.sun.setTextColor(Color.WHITE);
        }

        holderForFeed.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dBhelper=new DBhelper(v.getContext(),"",null,1);
                dBhelper.delete(lt.getID());
                dBhelper.showValues();
                lv.setAdapter(new AdapterFeed(DBhelper.listItems,v.getContext()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class HolderForFeed extends RecyclerView.ViewHolder {
        TextView time,days;
        Button mon,tue,wed,thur,fir,sat,sun;
        ImageView btndel;

        public HolderForFeed(@NonNull View itemView) {

            super(itemView);



                time=itemView.findViewById(R.id.tvtime);
                btndel=itemView.findViewById(R.id.btndel);
//                days=itemView.findViewById(R.id.tvtime);
            mon=itemView.findViewById(R.id.btnmonday);
            tue=itemView.findViewById(R.id.btntuesday);
            wed=itemView.findViewById(R.id.btnwedday);
            thur=itemView.findViewById(R.id.btnthursday);
            fir=itemView.findViewById(R.id.btnfriday);
            sat=itemView.findViewById(R.id.btnsatday);
            sun=itemView.findViewById(R.id.btnsunday);


            }
        }
    }


