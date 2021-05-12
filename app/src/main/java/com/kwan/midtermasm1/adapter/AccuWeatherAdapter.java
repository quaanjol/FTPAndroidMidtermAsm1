package com.kwan.midtermasm1.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kwan.midtermasm1.R;
import com.kwan.midtermasm1.model.AccuWeatherHourlyTwelve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccuWeatherAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<AccuWeatherHourlyTwelve> list;

    public AccuWeatherAdapter(Activity activity, List<AccuWeatherHourlyTwelve> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<AccuWeatherHourlyTwelve> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.weather_hour, parent, false);
        AccuWeatherHolder holder = new AccuWeatherHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AccuWeatherHolder hd = (AccuWeatherHolder) holder;
        AccuWeatherHourlyTwelve model = list.get(position);
        hd.tvHour.setText(convertTime(model.getDateTime()));
        hd.tvTemp.setText(String.valueOf(model.getTemperature().getValue()));
        if(model.getIconPhrase().toLowerCase().contains("nắng")) {
            Glide.with(activity).load("https://i.imgur.com/om38P0E.png").into(hd.ivIcon);
        } else if(model.getIconPhrase().toLowerCase().contains("mây")) {
            Glide.with(activity).load("https://i.imgur.com/oBhIIgx.png").into(hd.ivIcon);
        } else if(model.getIconPhrase().toLowerCase().contains("mưa")) {
            Glide.with(activity).load("https://i.imgur.com/5EDbRn8.png").into(hd.ivIcon);
        } else {
            Glide.with(activity).load("https://i.imgur.com/om38P0E.png").into(hd.ivIcon);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AccuWeatherHolder extends RecyclerView.ViewHolder {
        TextView tvHour, tvTemp;
        ImageView ivIcon;

        public AccuWeatherHolder(@NonNull View itemView) {
            super(itemView);
            tvHour = itemView.findViewById(R.id.tvHour);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
