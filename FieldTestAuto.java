/**
 * 
 */
package com.cdn.aquanmanager.testing;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

import com.cdn.aquanmanager.AquaLauncher;
import com.cdn.aquanmanager.R.xml;
import com.cdn.aquanmanager.control.ContentView;
import com.cdn.aquaplayer.player.AquaWebPlayer;
import com.newin.common.widget.IconTextView;
import com.newin.nplayer.data.SettingManager;
import com.robotium.solo.Solo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author soonwon.ahn
 */

public class FieldTestAuto extends ActivityInstrumentationTestCase2<AquaLauncher> {
	private Solo solo;
	public static String TAG = "CDNPLAYER FIELD TEST";
	
	public static String testDate_pre = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1)
	+ String.valueOf(Calendar.getInstance().get(Calendar.DATE))
	+ String.valueOf(Calendar.getInstance().get(Calendar.HOUR))
	+ String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
	
	public final static String testDate = testDate_pre;
	
	public void log(String msg) {
		Log.d(TAG, msg);
	}

	public FieldTestAuto() {
		super(AquaLauncher.class);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		// super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		// super.tearDown();

		solo.finishOpenedActivities();
		try {
			solo.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exitApp() {
		log("exitApp");
		solo.goBack();
		solo.sleep(5000);
		if (solo.waitForView(android.R.id.button1, 1, 2000)) {
			log("Dialog Open");
			final Button button_ok = (Button) solo.getView(android.R.id.button1);
			button_ok.callOnClick();

		}
		solo.sleep(5000);
		log("exitApp end");

	}

	public void testPlayerTest_1() {
//		testDate_pre = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1)
//				+ String.valueOf(Calendar.getInstance().get(Calendar.DATE))
//				+ String.valueOf(Calendar.getInstance().get(Calendar.HOUR))
//				+ String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
		
//		String datePath = "/storage/emulated/0/Robotium-Screenshots/";
		File file = new File("/storage/emulated/0/Robotium-Screenshots/testdate.txt");
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			fw.write(testDate);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(fw != null) {
			try {
				fw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*
		 * 
		 * ���⼭���� �÷��̸���Ʈ ���� Field Test �� �����մϴ�. case number : 15,
		 */
		testFieldTestPlayList("http://10.192.235.104/media/auto/player15.asp", 15);
		
		/*
		 *
		 * ���⼭���� ��Ʈ���� ���� Field Test �� �����մϴ�. case number : 1, 2, 3, 7, 8, 9, 14, 17, 18
		 */
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player1.asp", 1);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player2.asp", 2);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player3.asp", 3);
		 testFieldTestSmi("http://10.192.235.104/media/auto/player6.asp", 6);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player7.asp", 7);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player8.asp", 8);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player9.asp", 9);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player14.asp", 14);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player17.asp", 17);
		 testFieldTestStreaming("http://10.192.235.104/media/auto/player18.asp", 18);
		
		//��� ��� ���� Field Test �� �����մϴ�. case number : ����
//		testFieldTestSpeed("http://10.192.235.104/media/auto/player_speed.asp", "13_1");

		/*
		 * ���⼭���� �ϸ�ũ ���� Field Test �� �����մϴ�. case number : 5
		 *�� ���� ���� �ϸ�ũ ���� Test�� �������Ƿ�, �� �Լ��� �ּ� ó���ص� �ǰڴ�.
		 */
		 testFieldTestBookmark("http://10.192.235.104/media/auto/player5.asp", 5);
		
		/* ���⼭���� �ٿ�ε� ���� Test �� �����մϴ�. case number : ���� */
		testDownload("http://10.192.235.104/media/auto/down1.asp", "download");
		
		/*
		 * ���⼭���� �󼼺��� �� content ��� �� UI �� �޴� Ȯ�� ���� Test �� �����մϴ�.
		 * case number : ����
		 */		
		testContentInfoAndUI("notyet");
		
		/*
		 * ���⼭���� �ϸ�ũ ���� Test �� �����մϴ�. case number : ���� ( bookmark )
		 */
		testBookmarks("bookmark");
		
		/*
		 * ���⼭���� ��� ���� ���� Test �� �����մϴ�. case number : ���� ( lock ) 
		 */
		testLock("http://10.192.235.104/media/auto/player5.asp", "lock");
		
		//��� ������ Ŭ�� ���� �׽�Ʈ�� �����մϴ�.
		testIconClick("http://10.192.235.104/media/auto/player5.asp", "iconClick");

		solo.waitForActivity("AquaContent", 5000); //���̸��� ������ �ִ� ��Ƽ��Ƽ�� 5000 ��ٸ�.
		log("AquaContent wait End");
		SettingManager.setAutoHideMenu(getActivity(), false);
		solo.sleep(5000);
		log("AquaContent wait end");
		solo.goBack();
		log("backey send");
		solo.sleep(5000);
		exitApp();
	}

	public void testFieldTestStreaming(String uri, int caseNumber) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(6000);
		solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
		solo.sleep(4000);
	}
	
	//�ڸ� �˻��ϴ� �Լ� 
	public void testFieldTestSmi(String uri, int caseNumber) {
		//URI�� ����ִ� �뵵 
 		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		
		//��� ���̽��� ������ ���� 
		log("Field Test case " + caseNumber + " opened");
		
		//URI�� ����ִ� �뵵
		instrumentationContext.startActivity(browserIntent);
		
		//��ٸ��� ĸ���ϴ� ���� 
		solo.sleep(10000);
		solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
		solo.sleep(4000);
	}

	public void testFieldTestPlayList(String uri, int caseNumber) {
		solo = new Solo(getInstrumentation(), getActivity()); 
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.assertCurrentActivity("message", AquaWebPlayer.class);
		
		//playlist_tv �� Robotium ������ũ�� solo�� getView(����ƾظŴ��� ������ ��ü�� Ư�� ��ü ����)
		final TextView playlist_tv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_PLAY_LIST);
		if (playlist_tv != null) { //playlist button�� �ִ��� ������ �˻���
			try {
					runTestOnUiThread(new Runnable() {
					//�ݵ�� thread �ȿ��� callOnClick() �� ������Ѵ�.
						@Override
						public void run() {
						// TODO Auto-generated method stub
						log("case 15 �÷��̸���Ʈ �ؽ�Ʈ�� Ŭ��");
						playlist_tv.callOnClick();
					}
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
		if (solo.waitForView(android.R.id.button1, 1, 2000)) //waitForView�� �� ���̵� ���� ã����, button1�� ����ƸŴ��� �����ϴ� ��ư�� ���̵��� �״ϱ� �̰� ���� 
		{
			//Robotium�� ���𰡸� ���� �� ������ final �� ��������� �մϴ�.
			final Button button_ok = (Button) solo.getView(android.R.id.button1);
			button_ok.callOnClick();
			log("case 15 �÷��̸���Ʈ off Ŭ�� �õ�");
		}
	}
	
//	public void testFieldTestSpeed(String uri, String caseNumber) {
//		solo = new Solo(getInstrumentation(), getActivity());
//		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		Context instrumentationContext = getInstrumentation().getContext();
//		log("Field Test case " + caseNumber + " opened");
//		instrumentationContext.startActivity(browserIntent);
//		solo.assertCurrentActivity("message", AquaWebPlayer.class);
//		
//		final IconTextView speed_plus = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_PLAYBACKRATE_PLUS);
////		final ImageButton speed_plus = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.btn_playback_rate_plus);
//		if (speed_plus != null) {
//			try {
//				runTestOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						solo.sleep(6000);
//						log("case 13_1 ��� ��ư Ŭ�� �õ�");
//						log("case 13 speed_plus? : " + speed_plus);
//						speed_plus.callOnClick();
//						speed_plus.callOnClick();
//						speed_plus.callOnClick();
//						speed_plus.callOnClick();
//						
////						solo.clickOnView(speed_plus);
////						solo.clickOnView(speed_plus);
////						solo.clickOnView(speed_plus);
////						solo.clickOnView(speed_plus);
//						
//					}
//					
//				});
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//		}
//		
//		solo.sleep(60000);	//1 ��
//		solo.takeScreenshot("Field+Test+case13_1" + "+" + testDate);
//		
//		//��� ��ư�� Ŭ���Ͽ� 2.0 x �� ���� ������,
//		//10 �� ������ ( sleep() )
//		//ĸó�غ���.
//	}

	public void testFieldTestBookmark(String uri, int caseNumber) {
		solo = new Solo(getInstrumentation(), getActivity());
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.assertCurrentActivity("message", AquaWebPlayer.class);

		final ImageButton bookmark_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt != null) {
			try {
					runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 5 �ϸ�ũ ��ư Ŭ��");
						bookmark_bt.callOnClick();
					}
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		//bookmark_lv �ϸ�ũ ����Ʈ
		final ListView bookmark_lv = (ListView) solo.getView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);	
		if (bookmark_lv != null) {
			try {
					runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						solo.takeScreenshot("Field+Test+case5_1" + "+" + testDate);
						
//						final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//						if (bookmark_mv != null) {
//							try {
//								runTestOnUiThread(new Runnable() {
//
//									@Override
//									public void run() {
//										// TODO Auto-generated method stub
//										log("case 5 �ϸ�ũ ���� �̵�");
//										bookmark_mv.callOnClick();
//										solo.takeScreenshot("Field+Test+case5_2" + "+" + testDate);
//									}
//									
//								});
//							} catch (Throwable e) {
//								e.printStackTrace();
//							}

						// bookmark_lv.getChildAt(0).performClick();

					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}   

		final View bookmark_row = bookmark_lv.getChildAt(0);
		final TextView bookmark_mv = (TextView) bookmark_row.findViewById(com.cdn.aquanmanager.R.id.tv_bookmark1);
//		if (bookmark_row != null) {
//			try {
//				runTestOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						log("case 5 �ϸ�ũ ���� �̵�");
//						log("case 5 �ϸ�ũ ���� �̸� : " + bookmark_row.toString());
//						solo.clickOnView(bookmark_row);
//						bookmark_row.performClick();
//						bookmark_row.callOnClick();
//					}
//
//				});
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//		}
		if(bookmark_mv != null) {
			try {
				runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("case 5 �ϸ�ũ ���� �̵�");
					bookmark_mv.callOnClick();
					solo.sleep(6000);
//					solo.takeScreenshot("Field+Test+case5_2" + "+" + testDate);
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}
		
//		final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//		if (bookmark_mv != null) {
//			try {
//				runTestOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						log("case 5 �ϸ�ũ ���� �̵�");
//						bookmark_mv.callOnClick();
//						solo.takeScreenshot("Field+Test+case5_2" + "+" + testDate);
//					}
//					
//				});
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//		}

		solo.sleep(4000);
	}
	
	public void testDownload(String uri, String caseNumber) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(5000);
		solo.takeScreenshot("Field+Test+case+" + caseNumber + "+" + testDate);	//Mb �� ���ϸ� ���� �ؽ�Ʈ�� �߸����� ǥ�õǴ��� Ȯ��
		solo.waitForView(com.cdn.aquanmanager.R.id.content_list);
		
		final ImageButton downstop_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.download);
		if (downstop_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case �ٿ�ε� �Ͻ����� ��ư Ŭ�� �õ�");
						solo.clickOnView(downstop_bt);
						solo.sleep(5000);
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		solo.sleep(15000);
//		solo.assertCurrentActivity("message", AquaWebPlayer.class);
	}
	
	public void testContentInfoAndUI(String caseNumber) {
//		solo = new Solo(getInstrumentation(), getActivity());
//		solo.waitForActivity("AquaActivity", 5000);
//		log("AquaActivity wait end");
//		solo.sleep(3000);
//		solo.waitForView(com.cdn.aquanmanager.R.id.content_info);
//		solo.sleep(3000);
//		log("Field Test case " + caseNumber + " opened");
		
		solo.waitForActivity("AquaContent", 5000);
		log("AquaContent wait end");
		solo.sleep(5000);
		solo.waitForView(com.cdn.aquanmanager.R.id.list);
		final ImageButton videoTab_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.list);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("videolistTab button click");
					videoTab_bt.callOnClick();
					log("case notyet videotab opened");
				}
				
			});
		} catch(Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		if(solo.waitForText("Auto")) {
			solo.clickOnText("Auto");
			solo.sleep(2000);
		}
		if(solo.waitForText("Download")) {
			solo.clickOnText("Download");
			solo.sleep(2000);
		}
		if(solo.waitForText("Case1")) {
			solo.clickOnText("Case1");
			solo.sleep(3000);
			solo.takeScreenshot("Field+Test+case+contentInfo_1+" + testDate);	//���� ���� �ؽ�Ʈ�� �߸����� ǥ�õǴ��� Ȯ��
			//���� �Լ����� �� �ٿ���� content �̹Ƿ�, ĸó ���Ͽ��� ��������� ����־���� 
			solo.sleep(2000);
		}
		
		solo.waitForView(com.cdn.aquanmanager.R.id.content_info);
		final ImageButton play_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.content_play);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					play_bt.callOnClick();
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(13000);
		solo.takeScreenshot("Field+Test+case+contentInfo_2+" + testDate);	//�󼼺��� ��� ��ư���� content ����Ǵ��� Ȯ��. 11 �� ���� ĸ�ĵǾ�� ��.
		//&& UI ���� �߸� �� ��ħ ������ ������ Ȯ��
		solo.sleep(2000);
		
		solo.goBack();
		solo.sleep(2000);
		solo.takeScreenshot("Field+Test+case+contentInfo_3+" + testDate);	//�󼼺��⿡�� ��������� ������ Ȯ��. 13 �� ���� ĸ�ĵǾ�� ��.
		//&& �ڷΰ��� Ű Ŭ�� �� ��� ����Ǵ��� Ȯ��
		solo.sleep(2000);
		
		solo.goBack();
		solo.sleep(2000);
		solo.takeScreenshot("Field+Test+case+contentInfo_4+" + testDate);	//�󼼺��⿡�� �������� �� �ִ���, ī�װ� ȭ���� ĸ�ĵǾ����� Ȯ��.	
		solo.sleep(2000);
		
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					play_bt.callOnClick();
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		solo.takeScreenshot("Field+Test+case+contentInfo_5+" + testDate);	//���� ��������� ���� �ִ� ������ �̾�� �Ǵ��� Ȯ��.
		//&& �󼼺��� ������ ���� ��� ��, content ��Ͽ��� ����ص� �̾�Ⱑ �Ǵ��� Ȯ��.
		solo.sleep(3000);
		
		if(solo.waitForText("��")) {
			solo.clickOnText("��");
			solo.sleep(3000);
		}
		solo.takeScreenshot("Field+Test+case+contentInfo_6+" + testDate);	//&& �̾�� �� ���� ����ð��� ��������� �������� Ȯ��. 15 �� ���� ĸ�ĵǾ�� ��.
		solo.sleep(1000);
		
		final IconTextView close_bt = (IconTextView) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_CLOSE);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("AquaPlayer close button click");
					close_bt.callOnClick();
				}	
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(1000);
		solo.takeScreenshot("Field+Test+case+closeBT+" + testDate);	//���� ��ư�� Ŭ�� �� ��� ����Ǵ��� Ȯ��	
	}
	
	//�ϸ�ũ ���� QA
	public void testBookmarks(String caseNumber) {
		solo.waitForActivity("AquaContent", 5000);
		log("AquaContent wait end");
		solo.sleep(5000);
		solo.waitForView(com.cdn.aquanmanager.R.id.list);
		final ImageButton videoTab_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.list);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("videolistTab button click");
					videoTab_bt.callOnClick();
					log("case notyet videotab opened");
				}
				
			});
		} catch(Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		if(solo.waitForText("Auto")) {
			solo.clickOnText("Auto");
			solo.sleep(3000);
		}
		if(solo.waitForText("Download")) {
			solo.clickOnText("Download");
			solo.sleep(3000);
		}
		if(solo.waitForText("Case1")) {
			solo.clickOnText("Case1");
			solo.sleep(3000);
		}
		solo.waitForView(com.cdn.aquanmanager.R.id.content_info);
		final ImageButton play_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.content_play);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					play_bt.callOnClick();
					log("play button click");
					log("Test case bookmarks opened");					
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(6000);
		if(solo.waitForText("��")) {
			solo.clickOnText("��");
			log("case �̾�� �� Ŭ��");
			solo.sleep(3000);
		}
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		final ImageButton bookmarkMenu = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		try {
			runTestOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("AquaWebPlayer bookmark click");
					bookmarkMenu.callOnClick();
				}
			});				

		} catch (Throwable e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
		}	
		solo.sleep(2000);
		
		solo.waitForView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);
		ListView bookmarkList = (ListView)solo.getView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);
		//�ϸ�ũ �߰�
		if(solo.waitForView(com.cdn.aquanmanager.R.id.bookmarktitle,1,2000)){
			final View bookAdd = solo.getView(com.cdn.aquanmanager.R.id.bookmarktitle);
			boolean loopout=false;
			for(int k=0; k<32; k++){
				log("AquaWebPlayer bookmark ==="+bookmarkList.getAdapter().getCount());
				log("AquaWebPlayer bookMark Add click");
				try {
					runTestOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							log("AquaWebPlayer bookmark Add click");
							bookAdd.callOnClick();							

						}
					});				

				} catch (Throwable e) {
					// TODO Auto-generated catch block//
					e.printStackTrace();
				}
				if(loopout==true){
					log("AquaWebPlayer Max bookMark loop out");
					break;
				}
				solo.sleep(3000);				
				log("AquaWebPlayer bookmark ==="+bookmarkList.getAdapter().getCount());
				if(bookmarkList.getAdapter().getCount()==30){
					solo.takeScreenshot("Field+Test+case+bookmarkOrder+" + testDate);	//�ϸ�ũ���� �ð� ������ ���ĵǴ��� Ȯ��						
					//�ϸ�ũ �������� �̵��ϰ� �ʹ�.
//					final View bookmark_row = bookmark_lv.getChildAt(0);
//					final TextView bookmark_mv = (TextView) bookmark_row.findViewById(com.cdn.aquanmanager.R.id.tv_bookmark1);
//					if(solo.waitForText("Ȯ��")) {
//						solo.clickOnText("Ȯ��");
//						log("�ϸ�ũ 30 �� �ʰ� �˸� â �ݱ�");
//						solo.sleep(1000);
//					}
//					final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//					try {
//						runTestOnUiThread(new Runnable() {
//			
//							@Override
//							public void run() {
//								// TODO Auto-generated method stub
//								bookmark_mv.callOnClick();
//								log("case bookmark moved");
//							}				
//						});
//					} catch (Throwable e) {
//						e.printStackTrace();
//					}
//					
					loopout=true;					
				}				
			}			
		}
		
//		solo.takeScreenshot("���Ⱑ ��ü ����?" + testDate);	//���� ��ġ : " Ȯ�� " �ߴ� �˸� â
//		if (solo.waitForText("Ȯ��")) {
//			solo.clickOnText("Ȯ��");
//			log("�ϸ�ũ 30 �� �ʰ� �˸� â �ݱ�");
//			solo.sleep(1000);
//		}
//		final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//		try {
//			runTestOnUiThread(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					bookmark_mv.callOnClick();
//					log("case bookmark moved");
//				}
//			});
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
		
		//�ϸ�ũ �������� �̵��ϰ� �ʹ�.	
//		final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//		try {
//			runTestOnUiThread(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					bookmark_mv.callOnClick();
//					log("case bookmark moved");
//				}				
//			});
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
		if (solo.waitForText("Ȯ��")) {
			solo.takeScreenshot("Field+Test+case+bookmarkLimit+" + testDate);	//�ϸ�ũ�� �ѵ����� 30������ �߰��Ǵ��� Ȯ��
			solo.clickOnText("Ȯ��");
			log("�ϸ�ũ 30 �� �ʰ� �˸� â �ݱ�");
			solo.sleep(1000);
		}
		solo.goBack();
		solo.sleep(2000);
		solo.goBack();
		solo.sleep(2000);
//		solo.takeScreenshot("���� ��ġ��?" + testDate);	//���� ��ġ : �󼼺���
		
		solo.waitForView(com.cdn.aquanmanager.R.id.content_info);
//		final ImageButton play_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.content_play);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					play_bt.callOnClick();
					log("play button click");
					log("Test case bookmarks opened");					
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(6000);
		if(solo.waitForText("��")) {
			solo.clickOnText("��");
			log("case �̾�� �� Ŭ��");
			solo.sleep(3000);
		}
		   
		final ImageButton bookmark_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 5 �ϸ�ũ ��ư Ŭ��");
						bookmark_bt.callOnClick();
					}
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		final ListView bookmark_lv = (ListView) solo.getView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);	
		if (bookmark_lv != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						solo.takeScreenshot("Field+Test+case+bookmarkRemain_1+" + testDate);	//�ϸ�ũ ������ ��� ���� ���Ŀ��� �����Ǵ��� Ȯ��
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} 
		
		//�ϸ�ũ�� ����
		for (int i=0; i<3; i++) {
			View listRow=bookmark_lv.getChildAt(0);	
			if(listRow==null){
				log("AquaWebPlayer bookmark row null");
				break;
			}
			final ImageButton delBtn=(ImageButton) listRow.findViewById( com.cdn.aquanmanager.R.id.ib_bookmark1);
			try {

				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("AquaContent bookmark delBtn click");
						delBtn.callOnClick();

					}
				});				

			} catch (Throwable e) {
				// TODO Auto-generated catch block//
				e.printStackTrace();
			}
			solo.takeScreenshot("Field+Test+case+bookmarkRemove+" + testDate);	//�ϸ�ũ ������ �������� Ȯ��
			solo.sleep(2000);
		}
		
		//���ο� ������ �ٿ�ε�
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.192.235.104/media/auto/down2.asp"));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(5000);
		if (solo.waitForText("Ȯ��")) {
			solo.clickOnText("Ȯ��");
			solo.sleep(1000);
		}
		
		solo.waitForActivity("AquaContent", 5000);
		log("AquaContent wait end");
		solo.sleep(5000);
		solo.waitForView(com.cdn.aquanmanager.R.id.list);
		final ImageButton videoTab_bt2 = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.list);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("videolistTab button click");
					videoTab_bt2.callOnClick();
					log("case notyet videotab opened");
				}
				
			});
		} catch(Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		if(solo.waitForText("��")) {
			solo.clickOnText("��");
			solo.sleep(3000);
		}
		if(solo.waitForText("Let it go")) {
			solo.clickOnText("Let it go");
			solo.sleep(3000);
		}
		
		solo.waitForView(com.cdn.aquanmanager.R.id.content_info);
		final ImageButton play_bt2 = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.content_play);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					play_bt2.callOnClick();
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		
		if(solo.waitForText("��")) {
			solo.clickOnText("��");
			log("case �̾�� �� Ŭ��");
			solo.sleep(3000);
		}
		   
		final ImageButton bookmark_bt2 = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt2 != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case �ϸ�ũ ��ư Ŭ��");
						bookmark_bt2.callOnClick();
					}
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		final ListView bookmark_lv2 = (ListView) solo.getView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);	
		if (bookmark_lv2 != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						solo.takeScreenshot("Field+Test+case+bookmarkNotSame+" + testDate);	//�ϸ�ũ ������ ��� ���� ���Ŀ��� �����Ǵ��� Ȯ��
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void testLock(String uri, String caseNumber) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(6000);
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_LOCK_UI);
		final IconTextView lock_bt = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_LOCK_UI);
		if (lock_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						lock_bt.callOnClick();
					}
					
				});
			}catch (Throwable e) {
				e.printStackTrace();
			}
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "+" + testDate);	//��� �������� Ŭ�� ��, ȭ���� ��ݵǴ��� Ȯ��
			solo.sleep(2000);
		}
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_UNLOCK);
		final com.newin.common.widget.IconButton lock_bt2 = (com.newin.common.widget.IconButton)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_UNLOCK);
		if (lock_bt2 != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						lock_bt2.callOnClick();
					}
					
				});
			}catch (Throwable e) {
				e.printStackTrace();
			}
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "End+" + testDate);	//��� ������ ������ ��� ������ Ŭ�� �ÿ��� �Ͼ���� Ȯ��
			solo.sleep(5000);
		}
		
	}
	
	public void testIconClick(String uri, String caseNumber) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(6000);
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_FORWARD);
		final IconTextView forward_bt = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_FORWARD);
		if (forward_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						forward_bt.callOnClick();
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Forward+" + testDate);	//������ >> Ŭ�� ��, �������Ⱑ �̵��ϴ��� Ȯ��
			solo.sleep(3000);
		}
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_BACKWARD);
		final IconTextView backward_bt = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_BACKWARD);
		if (backward_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						backward_bt.callOnClick();
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Backward+" + testDate);	//������ << Ŭ�� ��, �ǰ��Ⱑ �̵��ϴ��� Ȯ��
			solo.sleep(2000);
		}
				
	}
	
	public void main(String[] args) throws Exception {
		testPlayerTest_1();
		
	}

}
