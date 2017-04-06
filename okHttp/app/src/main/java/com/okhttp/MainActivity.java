package com.okhttp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.http.okhttp.callback.ResultCallback;
import com.http.okhttp.request.OkHttpRequest;
import com.squareup.okhttp.Request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGet;
    private Button btnPost;
    private Button btnDownLoad;
    private Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
        btnGet = (Button) findViewById(R.id.btn_get);
        btnPost = (Button) findViewById(R.id.btn_post);
        btnDownLoad = (Button) findViewById(R.id.btn_download);
        btnUpload = (Button) findViewById(R.id.btn_upload);
    }


    private void initEvent() {
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnDownLoad.setOnClickListener(this);
        btnUpload.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                doGet();
                break;
            case R.id.btn_post:
                doPost();
                break;
            case R.id.btn_download:
                doDownload();
                break;
            case R.id.btn_upload:
                doUpload();
                break;
        }
    }

    private void doGet() {
        String url = "";
        new OkHttpRequest.Builder().url(url).get(new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });

    }


    private void doPost() {
        String url = "";
        Map<String, String> params = new HashMap<>();
        params.put("name", "zhq");
        params.put("age", "26");
        new OkHttpRequest.Builder().url(url).get(new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });
    }

    private void doDownload() {
        String url = "";
        new OkHttpRequest.Builder()
                .url(url)
                .destFileDir(Environment.getExternalStorageDirectory().getAbsolutePath())
                .destFileName("")
                .download(new ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Object response) {

                    }

                    @Override
                    public void onProgress(float progress) {
                    }
                });
    }

    private void doUpload() {
        File file = new File(Environment.getExternalStorageDirectory(), "***.png");
        if (!file.exists()) {
            Toast.makeText(MainActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "";
        new OkHttpRequest.Builder()
                .url(url)
                .files(new Pair<String, File>("file", file))//
                .upload(new ResultCallback<String>() {


                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }

                    @Override
                    public void onProgress(float progress) {

                    }
                });

    }


}
