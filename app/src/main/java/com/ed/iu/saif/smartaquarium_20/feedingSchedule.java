package com.ed.iu.saif.smartaquarium_20;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class feedingSchedule extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    final Calendar myCalendar = Calendar.getInstance();

    FloatingActionButton fabbtn;
    TextView textView;

    public static RecyclerView lv;
    DBhelper dBhelper;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding_schedule);

        dBhelper=new DBhelper(this,"",null,1);

        dBhelper.showValues();



        lv=(RecyclerView) findViewById(R.id.lva);
        fabbtn=(FloatingActionButton)findViewById(R.id.fabbtn);

        lv.setHasFixedSize(true);
        lv.setLayoutManager(new LinearLayoutManager(this));





        lv.setAdapter(new AdapterFeed(DBhelper.listItems,this));


        //add new time of feed
        fabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"time picker");
                dBhelper.showValues();



            }
        });
    }


    public void alert(Calendar c){
         AlarmManager mgrAlarm = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
         ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();

        Intent intent = new Intent(feedingSchedule.this, Alertreciever.class);

// Loop counter `i` is used as a `requestCode`
        PendingIntent pendingIntent = PendingIntent.
                getBroadcast(getApplicationContext(), 1, intent, 0);

// Single alarms in 1, 2, ..., 10 minutes (in `i` minutes)

        mgrAlarm.setExact(AlarmManager.RTC_WAKEUP,
                c.getTimeInMillis(),
                pendingIntent);
        intentArray.add(pendingIntent);


    }


    public static int getAlarmId(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int alarmId = preferences.getInt("ALARM", 1);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("ALARM", alarmId + 1).apply();
        return alarmId;
    }



    @Override
    public void onTimeSet(TimePicker view, final int hourOfDay, final int minute) {


//        Calendar c= Calendar.getInstance();
//        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
//        c.set(Calendar.MINUTE,minute);
//        c.set(Calendar.SECOND,0);
//        alert(c);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

//            AlarmManager mgrAlarm = (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);





            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfWeek) {



                // TODO Auto-generated method stub
                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                Date date = new Date(year, monthOfYear, dayOfWeek-1);
                String dayOfWeekk = simpledateformat.format(date);
                Toast.makeText(feedingSchedule.this, dayOfWeekk+"", Toast.LENGTH_SHORT).show();



                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND,0);
                Intent intent = new Intent(feedingSchedule.this, Alertreciever.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(feedingSchedule.this, getAlarmId(getApplicationContext()), intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);






                if(dayOfWeekk.equals("Monday"))
                {
                    setalarm(hourOfDay,minute,2);

                }
                else if(dayOfWeekk.equals("Tuesday"))
                {
                    setalarm(hourOfDay,minute,3);

                }
                else if(dayOfWeekk.equals("Wednesday"))
                {
                    setalarm(hourOfDay,minute,4);

                }
                else if(dayOfWeekk.equals("Thursday"))
                {
                    setalarm(hourOfDay,minute,5);

                }
                else if(dayOfWeekk.equals("Friday"))
                {
                    setalarm(hourOfDay,minute,6);

                }
                else if(dayOfWeekk.equals("Saturday"))
                {
                    setalarm(hourOfDay,minute,7);

                }
                else if(dayOfWeekk.equals("Sunday"))
                {
                    setalarm(hourOfDay,minute,1);

                }



            }

        };

        new DatePickerDialog(this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_WEEK)).show();

    }

    public void setalaraminstances(int minute,int hourOfDay,int day){
        myCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        myCalendar.set(Calendar.MINUTE,minute);
        myCalendar.set(Calendar.SECOND,0);
        myCalendar.set(Calendar.DAY_OF_WEEK,day);

    }

    public void setalarm( int hourOfDay, int minute,int day){

        dBhelper=new DBhelper(this,"",null,1);

        if(hourOfDay>12)
        {
            dBhelper.insert((hourOfDay-12)+":"+minute+" PM",day);
        }else{
            dBhelper.insert((hourOfDay)+":"+minute+" AM",day);
        }

        dBhelper.showValues();
        lv.setAdapter(new AdapterFeed(DBhelper.listItems,getApplicationContext()));
    }


}

