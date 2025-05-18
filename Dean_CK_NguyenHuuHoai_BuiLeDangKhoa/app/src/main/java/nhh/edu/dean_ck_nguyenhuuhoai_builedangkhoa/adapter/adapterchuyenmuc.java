package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.R;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.chuyenmuc;

public class adapterchuyenmuc extends BaseAdapter {

    private Context context;
    private int layout;
    private List<chuyenmuc> chuyenmucList;

    public adapterchuyenmuc(Context context, int layout, List<chuyenmuc> chuyenmucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenmucList = chuyenmucList;
    }

    @Override
    public int getCount() {
        return chuyenmucList.size();
    }

    @Override
    public Object getItem(int position) {
        return chuyenmucList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.imgchuyenmuc);
            holder.txt = convertView.findViewById(R.id.textviewTenchuyenmuc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        chuyenmuc cm = chuyenmucList.get(position);
        holder.txt.setText(cm.getTenchuyenmuc());

        String hinhanh = cm.getHinhanhchuyenmuc();
        if (hinhanh != null && !hinhanh.isEmpty()) {
            holder.img.setVisibility(View.VISIBLE);

            // Dùng Picasso để tải ảnh từ URL
            Picasso.get()
                    .load(hinhanh)
                    .into(holder.img);
        } else {
            holder.img.setVisibility(View.GONE);
        }


        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView txt;
    }
}
