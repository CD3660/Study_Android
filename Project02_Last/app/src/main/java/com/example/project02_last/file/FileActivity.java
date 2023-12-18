package com.example.project02_last.file;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.common.CommonRetroClient;
import com.example.project02_last.common.CommonService;
import com.example.project02_last.databinding.ActivityFileBinding;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileActivity extends AppCompatActivity {
    ActivityFileBinding binding;
    ActivityResultLauncher<Intent> launcher;//onCreate메소드에서 초기화 시 오류 발생

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkPermission();

        new ClearCacheTask(this).execute();
        Glide.with(FileActivity.this).load("http://192.168.0.57/mid/file/test.jpg").into(binding.imgv);

        binding.imgv.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(FileActivity.this);
            builder.setTitle("사진 업로드 방식");
            builder.setSingleChoiceItems(new String[]{"갤러리", "카메라"}, -1, (dialog, i) -> {
                if (i == 0) {
                    showGallary();
                } else if (i == 1) {
                    showCamera();
                }
                dialog.dismiss();
            });
            AlertDialog dialog = builder.create();
            builder.show();
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Glide.with(FileActivity.this).load(cameraUri).into(binding.imgv);

            File cameraFile = new File(getRealPath(cameraUri));
            //Multipart
            RequestBody file = RequestBody.create(MediaType.parse("image/jpeg"), cameraFile);

            MultipartBody.Part filePart = MultipartBody.Part.createFormData("andFile", "test.jpg", file);//name:servlet구분자, 실제 파일명, 실제 파일
            CommonService service = CommonRetroClient.getRetrofit().create(CommonService.class);
            service.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });

    }

    class ClearCacheTask extends AsyncTask<Void, Void, Void> {
        private Context context;

        public ClearCacheTask(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Glide.get(context).clearDiskCache();
//            Glide.get(context).clearMemory();
            return null;
        }
    }

    final int GALLARY_REQ = 1000;
    final int CAMERA_REQ = 1001;

    public void showGallary() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent, GALLARY_REQ);
    }

    Uri cameraUri = null;
    public void showCamera() {
        //카메라로 사용자가 사진을 찍으면 우리가 미리 임시로 만들어둔 URI에 카메라 사진을 외부 저장소에 저장 후 알려줌
        cameraUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        launcher.launch(cameraIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("갤러리", "onActivityResult: " + requestCode);


        if (requestCode == GALLARY_REQ && resultCode == RESULT_OK) {
//            content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F36/ORIGINAL/NONE/image%2Fjpeg/87880695
//            /-1/1/content://media/external/images/media/36/ORIGINAL/NONE/image/jpeg/87880695
            Glide.with(this).load(data.getData()).into(binding.imgv);//불러온 이미지를 이미지뷰에 붙임
            String filePath = getRealPath(data.getData());

            //Multipart
            RequestBody file = RequestBody.create(MediaType.parse("image/jpeg"), new File(filePath));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("andFile", "test.jpg", file);//name:servlet구분자, 실제 파일명, 실제 파일
            CommonService service = CommonRetroClient.getRetrofit().create(CommonService.class);
            service.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });


        } else if (requestCode == CAMERA_REQ) {

        }
    }

    //contentReslver라는 컴포넌트를 이용하여 Uri를 통해 실제 이미지의 경로를 조회한다.
    //Android 내부에 있는 모든 요소는 전부 table 형태로 저장되어있다.
    public String getRealPath(Uri contentUri) {
        String res = null;//문자열 변수로 리턴하기 위해 변수 초기화
        String[] cols = {MediaStore.Images.Media.DATA};//컬럼이름을 받아온다.(조회시 alias)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {//안드 API26이전은 확인 불필요. 그냥 경로를 준다.
            Cursor cursor = getContentResolver().query(contentUri, cols, null, null);
            if (cursor.moveToFirst()) {
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                res = cursor.getString(column_index);
            }
        }
        Log.d("갤러리", "getRealPath: " + res);

        return res;
    }


    public final int REQ_PERMISSION = 900;
    public final int REQ_PERMISSION_DENY = 901;

    private void checkPermission() {

        String[] permissions = {Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE

        };//카메라 권한을 String으로 가져옴.


        // ContextCompat(액티비티가 아닌곳) , ActivityCompat(액티비티)
        for (int i = 0; i < permissions.length; i++) {
            //내가 모든 권한이 필요하다면 전체 권한을 하나씩 체크해서 허용 안됨이 있는경우 다시 요청을 하게 만든다.
            if (ActivityCompat.checkSelfPermission(this, permissions[i]) == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {
                    //최초 앱이 설치되고 실행 시 false가 나옴.=>사용자가 거부 후 true 재거부=>false
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("권한 요청").setMessage("권한이 반드시 필요합니다.!!미허용시 앱 사용 불가!");
                    builder.setPositiveButton("확인(권한허용)", (dialog, which) -> {
                        //2.권한 설명 후 다시보여줌.
                        ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_DENY);
                    });
                    builder.setNegativeButton("종료(권한허용불가)", (dialog, which) -> {
                        finish();
                    });
                    builder.create().show();//<==넣어줘야함.
                } else {
                    //1.
                    ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION);
                }
                break;
            }
        }

        // int result = ActivityCompat.checkSelfPermission(this , permissions[0]);
        // Log.d("권한", "checkPermission: " + result);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_GRANTED);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_DENIED);
//
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[0])){
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 필요한 권한. ");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }else{
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 x");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (REQ_PERMISSION == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    //거절된권한이있음.
                    checkPermission();
                    break;
                }
            }

            Log.d("권한", "onRequestPermissionsResult: 권한 요청 완료 ");
        } else if (REQ_PERMISSION_DENY == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    Log.d("권한", "onRequestPermissionsResult: 다시 권한요청 화면을 띄울수가 없음.2회 거절당함. ");
                    //editor.putInt("permission" , -2);
                    //3.
                    //viewSetting();
                    //checkPermission();
                }
            }

        }
    }

    public void viewSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
        startActivity(intent);

    }
}