package com.gkhnl.slidingmenuinandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gkhnnl on 11/06/15.
 */
public class SlideMenuAdapter extends BaseAdapter {

    private List<SlideMenuItem> items;
    private Context ctx;

    public SlideMenuAdapter(List<SlideMenuItem> items, Context context) {
        this.items = items;
        this.ctx = context;
    }

    // Mevcut item sayısını verir
    @Override
    public int getCount() {
        return items.size();
    }

    // Position ı verilen item ı verir
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    // Item position ı verir
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Custom view yükler
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        // Her list item için custom tasarım yüklüyor
        if (view == null) {

            holder = new ViewHolder();

            view = LayoutInflater.from(ctx).inflate(R.layout.slidemenu_item, null);

            // Yeni tasarım içindeki title textine ulaşıp, veriyi set ediyor
            holder.txt_title = (TextView) view.findViewById(R.id.txt_title);
            holder.img_icon = (ImageView) view.findViewById(R.id.img_icon);

            holder.txt_title.setText(items.get(position).getTitle());
            holder.img_icon.setImageResource(items.get(position).getIcon());

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }

    static class ViewHolder {

        public TextView txt_title;
        public ImageView img_icon;
    }
}