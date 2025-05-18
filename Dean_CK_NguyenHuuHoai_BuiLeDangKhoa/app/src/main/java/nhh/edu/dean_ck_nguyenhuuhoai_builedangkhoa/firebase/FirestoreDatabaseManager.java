package nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.TaiKhoan;
import nhh.edu.dean_ck_nguyenhuuhoai_builedangkhoa.model.Truyen;

public class FirestoreDatabaseManager {

    private static final String TAG = "FirestoreManager";
    private FirebaseFirestore db;
    private CollectionReference taiKhoanRef;
    private CollectionReference truyenRef;

    public FirestoreDatabaseManager() {
        db = FirebaseFirestore.getInstance();
        taiKhoanRef = db.collection("TaiKhoan");
        truyenRef = db.collection("Truyen");
    }

    // Phương thức lấy tất cả các tài khoản (thay vì Cursor trả về callback)
    public void getData(final OnTaiKhoanDataListener listener){
        taiKhoanRef.get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        List<TaiKhoan> list = new ArrayList<>();
                        for(DocumentSnapshot doc : task.getResult()){
                            TaiKhoan tk = doc.toObject(TaiKhoan.class);
                            list.add(tk);
                        }
                        listener.onSuccess(list);
                    } else {
                        listener.onFailure(task.getException());
                    }
                });
    }

    // Phương thức add tài khoản vào database
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        taiKhoanRef.add(taiKhoan)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "Thêm tài khoản thành công, ID: "+documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Lỗi thêm tài khoản", e));
    }

    // Lấy 3 truyện mới nhất
    public void getData1(final OnTruyenDataListener listener){
        truyenRef.orderBy("ID", Query.Direction.DESCENDING)
                .limit(3)
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        List<Truyen> list = new ArrayList<>();
                        for(DocumentSnapshot doc : task.getResult()){
                            Truyen truyen = doc.toObject(Truyen.class);
                            list.add(truyen);
                        }
                        listener.onSuccess(list);
                    } else {
                        listener.onFailure(task.getException());
                    }
                });
    }

    // Lấy tất cả truyện
    public void getData2(final OnTruyenDataListener listener){
        truyenRef.get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        List<Truyen> list = new ArrayList<>();
                        for(DocumentSnapshot doc : task.getResult()){
                            Truyen truyen = doc.toObject(Truyen.class);
                            list.add(truyen);
                        }
                        listener.onSuccess(list);
                    } else {
                        listener.onFailure(task.getException());
                    }
                });
    }

    // Add Truyện
    public void AddTruyen(Truyen truyen){
        truyenRef.add(truyen)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "Thêm truyện thành công, ID: "+documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Lỗi thêm truyện", e));
    }

    // delete Truyện theo ID
    public void Delete(int i, final OnDeleteListener listener){
        truyenRef.whereEqualTo("ID", i).get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        QuerySnapshot snapshots = task.getResult();
                        if(snapshots.isEmpty()){
                            listener.onFailure(new Exception("Không tìm thấy truyện có ID = "+i));
                            return;
                        }
                        for(DocumentSnapshot doc : snapshots){
                            truyenRef.document(doc.getId()).delete()
                                    .addOnSuccessListener(aVoid -> Log.d(TAG, "Xóa truyện thành công, ID: "+i))
                                    .addOnFailureListener(e -> Log.w(TAG, "Lỗi xóa truyện", e));
                        }
                        listener.onSuccess();
                    } else {
                        listener.onFailure(task.getException());
                    }
                });
    }

    // Interfaces callback
    public interface OnTaiKhoanDataListener {
        void onSuccess(List<TaiKhoan> list);
        void onFailure(Exception e);
    }

    public interface OnTruyenDataListener {
        void onSuccess(List<Truyen> list);
        void onFailure(Exception e);
    }

    public interface OnDeleteListener {
        void onSuccess();
        void onFailure(Exception e);
    }
}
