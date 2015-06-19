package in.itiffin.itiffin.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.itiffin.itiffin.R;

/**
 * Created by Lingaraj on 12/5/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private LayoutInflater mInflater;

    private List items = new ArrayList();

    public ImageAdapter(Context context,List items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override

    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
       /* ImageClass s = items.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(s.getName());
        if (s.getImage() != null) {
            holder.pic.setImageBitmap(s.getImage());
        } else {
            // MY DEFAULT IMAGE
            holder.pic.setImageResource(R.drawable.generic_profile_man);
        }*/
        return convertView;
    }

    static class ViewHolder {
        TextView name;

        ImageView pic;
    }



    public void notifyDataSetChanged() {

    }
}
