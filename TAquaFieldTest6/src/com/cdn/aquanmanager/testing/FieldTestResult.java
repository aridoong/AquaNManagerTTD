package com.cdn.aquanmanager.testing;

import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

public class FieldTestResult extends Activity {
	public static String TAG = "CDNPLAYER CAPTURE";
	
//	public String testDate = new FieldTestAuto().testDate;
//	String testDate = FieldTestAuto.testDate;
	String testDate = "";
	
	public void log(String msg) {
		Log.d(TAG, msg);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_field_test_result);
		
//		log("이번 testDate 는 : " + testDate);
		
		Button bt_webpage = (Button)findViewById(R.id.bt_webpage);
		bt_webpage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.192.234.124/MediaTeam/TFieldAuto/streaming.html"));
				startActivity(it);
			}
		});
		
		Button bt_nextpage = (Button)findViewById(R.id.bt_nextpage);
		bt_nextpage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(FieldTestResult.this, FieldTestResult2.class);
				startActivity(it);
			}
		});
		
		showExampleImage();
		showCapturedImage();
	}
	
	public void showExampleImage() {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = 2;
		
		Bitmap ex_1 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase1, opts);
		Bitmap ex_2 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase2, opts);
		Bitmap ex_3 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase3, opts);
		Bitmap ex_5_1 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase5_1, opts);
		Bitmap ex_7 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase7, opts);
		
		ImageView fieldtestcase1 = (ImageView)findViewById(R.id.fieldtestcase1);
		ImageView fieldtestcase2 = (ImageView)findViewById(R.id.fieldtestcase2);
		ImageView fieldtestcase3 = (ImageView)findViewById(R.id.fieldtestcase3);
		ImageView fieldtestcase5_1 = (ImageView)findViewById(R.id.fieldtestcase5_1);
		ImageView fieldtestcase7 = (ImageView)findViewById(R.id.fieldtestcase7);
		
		fieldtestcase1.setImageBitmap(ex_1);
		fieldtestcase2.setImageBitmap(ex_2);
		fieldtestcase3.setImageBitmap(ex_3);
		fieldtestcase5_1.setImageBitmap(ex_5_1);
		fieldtestcase7.setImageBitmap(ex_7);
	}
	
	public void showCapturedImage() {
		
		File file = new File("/storage/emulated/0/Robotium-Screenshots/testdate.txt");
		FileReader fr = null;
		char[] cbuf = new char[512];
		int size = 0;
		
		try {
			fr = new FileReader(file);
			while((size = fr.read(cbuf)) != -1) {
				for (int i=0; i<size; i++)
					testDate += cbuf[i];
				
				log("읽어들인 testDate 는 : " + testDate);
			}
			
			if (fr != null)
				fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		File img_1 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case1+" + testDate + ".jpg");
		File img_2 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case2+" + testDate + ".jpg");
		File img_3 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case3+" + testDate + ".jpg");
		File img_5_1 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case5_1+" + testDate + ".jpg");
		File img_7 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case7+" + testDate + ".jpg");
		
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = 2;
		
		if(img_1.exists()) {
			log("1번 이미지 존재");
			Bitmap bm_1 = BitmapFactory.decodeFile(img_1.getAbsolutePath(), opts);
			ImageView iv_1 = (ImageView)findViewById(R.id.iv_1);
			iv_1.setImageBitmap(bm_1);	
		}
		
		if(img_2.exists()) {
			log("2번 이미지 존재");
			Bitmap bm_2 = BitmapFactory.decodeFile(img_2.getAbsolutePath(), opts);
			ImageView iv_2 = (ImageView)findViewById(R.id.iv_2);
			iv_2.setImageBitmap(bm_2);	
		}
		
		if(img_3.exists()) {
			log("3번 이미지 존재");
			Bitmap bm_3 = BitmapFactory.decodeFile(img_3.getAbsolutePath(), opts);
			ImageView iv_3 = (ImageView)findViewById(R.id.iv_3);
			iv_3.setImageBitmap(bm_3);		
		}
		
		if(img_5_1.exists()) {
			log("5번 이미지 존재");
			Bitmap bm_5_1 = BitmapFactory.decodeFile(img_5_1.getAbsolutePath(), opts);
			ImageView iv_5_1 = (ImageView)findViewById(R.id.iv_5_1);
			iv_5_1.setImageBitmap(bm_5_1);		
		}
		
		if(img_7.exists()) {
			log("7번 이미지 존재");
			Bitmap bm_7 = BitmapFactory.decodeFile(img_7.getAbsolutePath(), opts);
			ImageView iv_7 = (ImageView)findViewById(R.id.iv_7);
			iv_7.setImageBitmap(bm_7);
		}
		
		
	}
	

public static void recursiveRecycle(View root) {
    if (root == null)
        return;
    root.setBackgroundDrawable(null);
    if (root instanceof ViewGroup) {
        ViewGroup group = (ViewGroup)root;
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            recursiveRecycle(group.getChildAt(i));
        }

        if (!(root instanceof AdapterView)) {
            group.removeAllViews();
        }

    }
   
    if (root instanceof ImageView) {
        ((ImageView)root).setImageDrawable(null);
    }

    root = null;
    return;
}

@Override
protected void onDestroy() {
	FieldTestResult.recursiveRecycle(getWindow().getDecorView());
    System.gc();

    super.onDestroy();
}

}
