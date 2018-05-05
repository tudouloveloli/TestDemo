package com.gsw.contentproviderdemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.gsw.contentprovierdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoshiwei
 */
public class ReadContactsActivity extends AppCompatActivity {

    private static final String TAG = "ReadContactsActivity";

    private Context mContext;
    PeopleAdapter adapter;
    List<PeopleBO> mList = new ArrayList<>();
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contacts);
        mContext = ReadContactsActivity.this;
        mListView = (ListView) findViewById(R.id.list_hpeople);
        adapter = new PeopleAdapter(mContext, mList);
        mListView.setAdapter(adapter);
        // permission
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ReadContactsActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            Log.d(TAG, "read_contacts ");
            readContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts();
                } else {
                    Toast.makeText(mContext, "你拒绝了权限，无法继续操作", Toast.LENGTH_SHORT).show();
                }
        }
    }

    /**
     * 读取联系人
     */
    private void readContacts() {

        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // 获取联系人姓名
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    PeopleBO bo = new PeopleBO();
                    bo.setUserName(name);
                    bo.setPhoneNumber(phone);
                    mList.add(bo);
                }
                adapter.notifyDataSetChanged();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
