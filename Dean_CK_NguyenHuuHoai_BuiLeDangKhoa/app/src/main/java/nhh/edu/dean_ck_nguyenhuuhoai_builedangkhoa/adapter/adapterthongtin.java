package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.R;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;

public class adapterthongtin extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TaiKhoan> taiKhoanList;

    public adapterthongtin(Context context, int layout, List<TaiKhoan> taiKhoanList) {
        this.context = context;
        this.layout = layout;
        this.taiKhoanList = taiKhoanList;
    }

    @Override
    public int getCount() {
        return taiKhoanList.size();
    }

    @Override
    public Object getItem(int position) {
        return taiKhoanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; // có thể trả position hoặc 0
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }

        TextView txtTenTaiKhoan = convertView.findViewById(R.id.TEXT_NAME);
        TextView txtEmail = convertView.findViewById(R.id.TeXT_Gmail);

        TaiKhoan taiKhoan = taiKhoanList.get(position);

        txtTenTaiKhoan.setText(taiKhoan.getTenTaiKhoan()); // sửa tên getter
        txtEmail.setText(taiKhoan.getEmail()); // sửa tên getter

        return convertView;
    }
}
