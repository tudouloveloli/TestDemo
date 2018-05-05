package me.microcool.okhttpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;

/**
 * @author gaoshiwei
 * @date 2017/12/11
 */

public class OkHttpActivity extends BaseActivity {
    private static final String TAG = "ShiweiGao";
    public static final String GET_URL = "https://github.com/tudouloveloli/DataAnalysisTest/blob/master/get_data.json";
    public static final String POST_URL = "https://api.github.com/users/";
    public static final String LOCAL_URL = "http://192.168.1.102/uploadfile/";

    // 定义上传文件类型
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    public static final String DOWNLOAD_URL = "http://upload-images.jianshu.io/upload_images/632860-463abca3bb6aacf1.jpg";

    @BindView(R.id.image_user)
    ImageView imageUser;
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.btn_upload)
    Button btnUpload;
    @BindView(R.id.btn_download)
    Button btnDownload;
    private OkHttpClient client = new OkHttpClient();
    private Request requestOkhttp;

    @Override
    public int layoutID() {
        return R.layout.layout_okhttp;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     * 多文件上传
     */
    private void mulitUpload() {
//        RequestBody requestBody = new MultipartBody.Builder()
//                .addFormDataPart("title", "nihao")
//                .addFormDataPart("image", MediaType.parse(MEDIA_TYPE_PNG,))
//                .build();
//
//        Request request = new Request.Builder()
//                .addHeader()
//                .post()
//                .build()
    }


    /**
     * 文件下载
     */
    private void downloadFile() {
        final Request request = new Request.Builder()
                .url(DOWNLOAD_URL)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: downlaod fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                File file = new File("/sdcard/shiwei.jpg");
                fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int lenth = 0;
                while ((lenth = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, lenth);
                }
                fileOutputStream.flush();
                try {

                } catch (Exception e) {
                    Log.d(TAG, "exception");

                } finally {
                    inputStream.close();
                    fileOutputStream.close();
                }
                Log.d(TAG, "download file ok ");
            }
        });
    }

    /**
     * 文件上传
     */
    private void uploadFile() {
        File file = new File("/sdcard/test.md");
        Request request = new Request.Builder()
                .url(LOCAL_URL)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: upload fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: uploadd success");
            }
        });
    }

    /**
     * post
     */
    private void psotRequest() {

        RequestBody body = new FormBody.Builder()
                .add("current_user_url", "tudouloveloli")
                .build();
        Request request = new Request.Builder()
                .url(POST_URL)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "NOT Find");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String mess = response.body().string();
                Log.d(TAG, "Post message: " + mess);
            }
        });
    }

    /**
     * get
     */
    public void getRequest() {
        requestOkhttp = new Request.Builder()
                .url(GET_URL)
                .build();
        client.newCall(requestOkhttp).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.d(TAG, "onResponse:success ");
//                byte[] message = response.body().bytes();


            }
        });
    }

    @OnClick({R.id.btn_get, R.id.btn_post, R.id.btn_upload, R.id.btn_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                psotRequest();
                break;
            case R.id.btn_upload:
                uploadFile();
                break;
            case R.id.btn_download:
                downloadFile();
                break;
        }
    }
}
