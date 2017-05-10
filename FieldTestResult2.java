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

public class FieldTestResult2 extends Activity {
public static String TAG = "CDNPLAYER CAPTURE";

String testDate = "";
	
	public void log(String msg) {
		Log.d(TAG, msg);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_field_test_result2);
		
		Button bt_webpage = (Button)findViewById(R.id.bt_webpage);
		bt_webpage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.192.234.124/MediaTeam/TFieldAuto/streaming.html"));
				startActivity(it);
			}
		});
		
		Button bt_prepage = (Button)findViewById(R.id.bt_prepage);
		bt_prepage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(FieldTestResult2.this, FieldTestResult.class);
				startActivity(it);
			}
		});
		
		showExampleImage();
		showCapturedImage();
		
	}
	
	public void showExampleImage() {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = 2;
		
		Bitmap ex_8 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase8, opts);
		Bitmap ex_14 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase14, opts);
		Bitmap ex_15 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase15, opts);
		Bitmap ex_17 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase17, opts);
		Bitmap ex_18 = BitmapFactory.decodeResource(getResources(), R.drawable.fieldtestcase18, opts);
		
		ImageView fieldtestcase8 = (ImageView)findViewById(R.id.fieldtestcase8);
		ImageView fieldtestcase14 = (ImageView)findViewById(R.id.fieldtestcase14);
		ImageView fieldtestcase15 = (ImageView)findViewById(R.id.fieldtestcase15);
		ImageView fieldtestcase17 = (ImageView)findViewById(R.id.fieldtestcase17);
		ImageView fieldtestcase18 = (ImageView)findViewById(R.id.fieldtestcase18);
		
		fieldtestcase8.setImageBitmap(ex_8);
		fieldtestcase14.setImageBitmap(ex_14);
		fieldtestcase15.setImageBitmap(ex_15);
		fieldtestcase17.setImageBitmap(ex_17);
		fieldtestcase18.setImageBitmap(ex_18);
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
		
		File img_8 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case8+" + testDate + ".jpg");
		File img_14 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case14+" + testDate + ".jpg");
		File img_15 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case15+" + testDate + ".jpg");
		File img_17 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case17+" + testDate + ".jpg");
		File img_18 = new File("/storage/emulated/0/Robotium-Screenshots/Field+Test+case18+" + testDate + ".jpg");
		
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = 2;
		
		if(img_8.exists()) {
			log("8번 이미지 존재");
			Bitmap bm_8 = BitmapFactory.decodeFile(img_8.getAbsolutePath(), opts);
			ImageView iv_8 = (ImageView)findViewById(R.id.iv_8);
			iv_8.setImageBitmap(bm_8);
		}
		
		if(img_14.exists()) {
			log("14번 이미지 존재");
			Bitmap bm_14 = BitmapFactory.decodeFile(img_14.getAbsolutePath(), opts);
			ImageView iv_14 = (ImageView)findViewById(R.id.iv_14);
			iv_14.setImageBitmap(bm_14);	
		}
		
		if(img_15.exists()) {
			log("15번 이미지 존재");
			Bitmap bm_15 = BitmapFactory.decodeFile(img_15.getAbsolutePath(), opts);
			ImageView iv_15 = (ImageView)findViewById(R.id.iv_15);
			iv_15.setImageBitmap(bm_15);	
		}
		
		if(img_17.exists()) {
			log("17번 이미지 존재");
			Bitmap bm_17 = BitmapFactory.decodeFile(img_17.getAbsolutePath(), opts);
			ImageView iv_17 = (ImageView)findViewById(R.id.iv_17);
			iv_17.setImageBitmap(bm_17);
		}
		
		if(img_18.exists()) {
			log("18번 이미지 존재");
			Bitmap bm_18 = BitmapFactory.decodeFile(img_18.getAbsolutePath(), opts);
			ImageView iv_18 = (ImageView)findViewById(R.id.iv_18);
			iv_18.setImageBitmap(bm_18);
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
