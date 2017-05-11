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
import com.cdn.player.activity.AquaPlaylist;
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
	private String serverIp = "10.192.236.61";
	
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
		//testFieldTestPlayList("http://" + serverIp + "/media/auto/player15.asp", 15);
		
		/*
		 *
		 * ���⼭���� ��Ʈ���� ���� Field Test �� �����մϴ�. case number : 1, 2, 3, 7, 8, 9, 14, 17, 18
		 */
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player1.asp", 1);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player2.asp", 2);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player3.asp", 3);
//		 testFieldTestSmi("http://" + serverIp + "/media/auto/player6.asp", 6);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player7.asp", 7);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player8.asp", 8);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player9.asp", 9);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player14.asp", 14);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player17.asp", 17);
//		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player18.asp", 18);
//		
//		//��� ��� ���� Field Test �� �����մϴ�. case number : ����
////		testFieldTestSpeed("http://" + serverIp + "/media/auto/player_speed.asp", "13_1");
//
//		/*
//		 * 
//		 * ���⼭���� �ϸ�ũ ���� Field Test �� �����մϴ�. case number : 5
//		 *
//		 *�� ���� ���� �ϸ�ũ ���� Test�� �������Ƿ�, �� �Լ��� �ּ� ó���ص� �ǰڴ�.
//		 */
////		testFieldTestBookmark("http://" + serverIp + "/media/auto/player5.asp", 5);
//
		
		
		
		/*
		 * 
		 * ���⼭���� �ٿ�ε� ���� Test �� �����մϴ�. case number : ���� 
		 */
//		testDownload("http://" + serverIp + "/media/auto/down1.asp", "download");	
		
		/*
		 * 
		 * ���⼭���� �󼼺��� �� content ��� �� UI �� �޴� Ȯ�� ���� Test �� �����մϴ�. case number : ����
		 */		
		//testContentInfoAndUI("videoContent");
		
		/*
		 * 
		 * ���⼭���� �ϸ�ũ ���� Test �� �����մϴ�. case number : ���� ( bookmark )
		 */
		//testBookmarks("bookmark");
		
		/*
		 * 
		 * ���⼭���� ��� ���� ���� Test �� �����մϴ�. case number : ���� ( lock ) 
		 */
//		testLock("http://" + serverIp + "/media/auto/player5.asp", "lock");
		
		/*
		 * 
		 * ���⼭���� >>, <<, || ������ ���� Test �� �����մϴ�. case number : ���� ( iconClick )
		 */		
		//testIconClick("http://" + serverIp + "/media/auto/player5.asp", "iconClick");
		

		//��� �÷��̸���Ʈ ���� Test �� �����մϴ�.
		//testPlaylist("playlist");
		
		//���� �Ұ� testwatermarkText("http://" + serverIp + "/media/auto/wm_text.asp", 49);	
		//testwatermarkImage("http://" + serverIp + "/media/auto/wm_image.asp", 50);
		//���� �Ұ� testwatermarkTextColor("http://" + serverIp + "/media/auto/wm_textColor.asp", 51);		
		//testclosebutton("http://" + serverIp + "/media/auto/player15.asp", 52);
		//���� �Ұ� testPopUpPlaybutton("http://" + serverIp + "/media/auto/player2.asp", 53);
		//���� �Ұ� testPopUpCloseIcon("http://" + serverIp + "/media/auto/player2.asp", 54);
		//testStreamingContentsPlay("http://" + serverIp + "/media/auto/player2.asp", 55);
		//testStreamingContentsNoReplay("http://" + serverIp + "/media/auto/player2.asp", 56);
		//testDownloadProgressBar("http://" + serverIp + "/media/auto/download2.asp", 57);
		testVideoUserNameSorting(58);
		testVideoContentNameSorting(59);
		testVideoFolderUserSorting(60);
		testVideoFolderNameSorting(61);

		solo.waitForActivity("AquaContent", 5000);
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
	
	public void testFieldTestSmi(String uri, int caseNumber) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		log("Field Test case " + caseNumber + " opened");
		instrumentationContext.startActivity(browserIntent);
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
		solo.sleep(3000);

		final TextView playlist_tv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_PLAY_LIST);
		if (playlist_tv != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 15 �÷��̸���Ʈ �ؽ�Ʈ�� Ŭ��");
						playlist_tv.callOnClick();
						solo.sleep(3000);
					}
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
		solo.sleep(3000);
		if (solo.waitForView(android.R.id.button1, 1, 2000)) {
			final Button button_ok = (Button) solo.getView(android.R.id.button1);
			button_ok.callOnClick();
			log("case 15 �÷��̸���Ʈ off Ŭ�� �õ�");
			solo.sleep(3000);
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

		solo.sleep(5000);
		final ImageButton bookmark_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 5 �ϸ�ũ ��ư Ŭ��");
						bookmark_bt.callOnClick();
						solo.sleep(5000);
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
						solo.takeScreenshot("Field+Test+case5_1" + "+" + testDate);
						log("case 5 �ϸ�ũ ����Ʈ�� ã��");
						
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
		final TextView bookmark_mv = (TextView) bookmark_row.findViewById(com.cdn.aquanmanager.R.id.tv_bookmark1); //bookmark_mv : �ϸ�ũ �̵� 
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
		
		solo.sleep(5000);
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
		final ImageButton bookmarkMenu=(ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
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
		ListView bookmarkList=(ListView) solo.getView(com.cdn.aquanmanager.R.id.bookmark_dialog_listview);

		//�ϸ�ũ �߰�
		if(solo.waitForView(com.cdn.aquanmanager.R.id.bookmarktitle,1,2000)){
			final View bookAdd=solo.getView(com.cdn.aquanmanager.R.id.bookmarktitle);
			boolean loopout=false;
			
			
			for(int k=0;k<32;k++){
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
				log("AquaWebPlayer bookmark ==="+bookmarkList.getAdapter().getCount()); //getAdapter() �޼ҵ带 ����ϸ� �� �ڿ� ī��Ʈ �޼ҵ带 ����� �� ����.
				if(bookmarkList.getAdapter().getCount()==30){ //30�� ������ ����� �ǰ�
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
					loopout=true;	//�� ���Ŀ��� true �� �����Ͽ� 				
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
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + serverIp + "/media/auto/down2.asp"));
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
		
		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_PLAY);
		final IconTextView play_bt = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_PLAY);
		if (play_bt != null) {
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Pause+" + testDate);	//������ || Ŭ�� ��, �Ͻ������� �۵��ϴ��� Ȯ��
			solo.sleep(2000);
		}
		
//		solo.waitForView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_TOGGLE);
//		final IconTextView toggle_bt = (IconTextView)solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_TOGGLE);
//		if (toggle_bt != null) {
//			try {
//				runTestOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						toggle_bt.callOnClick();
//					}					
//				});
//			} catch (Throwable e) {
//				e.printStackTrace();
//			}
//			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Fill+" + testDate);	//������ Ŭ�� ��, ȭ���� Fill ��µǴ��� Ȯ��
//			solo.sleep(2000);
//		}
		
		solo.goBack();
	}
	
	public void testPlaylist(String caseNumber) {
		solo.waitForActivity("AquaPlaylist", 5000);
		log("AquaPlaylist wait end");
		solo.sleep(5000);
		solo.waitForView(com.cdn.aquanmanager.R.id.playlist);
		final ImageButton playlistTab_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.playlist);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					log("playlistTab button click");
					playlistTab_bt.callOnClick();
					log("case playlist playlistTab opened");
					solo.sleep(3000);
				}
				
			});
		} catch(Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		
		solo.assertCurrentActivity("message", AquaPlaylist.class);
		solo.waitForActivity("AquaPlaylist");
		if (solo.waitForActivity("AquaPlaylist")) {
			log("case playlist �÷��̸���Ʈ ��Ƽ��Ƽ�� wait �߽��ϴ�.");
			
			solo.waitForView(com.cdn.aquanmanager.R.id.edit);
			if (solo.waitForView(com.cdn.aquanmanager.R.id.edit)) {			
				log("case playlist ���� ��ư ã����!!");
			}
			solo.sleep(2000);
			
			solo.getCurrentActivity();
			solo.assertCurrentActivity("message", AquaPlaylist.class);
			
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {			
				try {
					runTestOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							edit_bt.callOnClick();
							log("case playlist ���� ��ư Ŭ��!!");
							solo.sleep(2000);
						}
						
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if(solo.waitForText("�� ������")) {
				solo.clickOnText("�� ������");
				solo.sleep(2000);
			}
			solo.sleep(20000);
			
		}
		
		
		
		//���� ���⼭����, �κ�Ƽ���� �̿��� ������ ĥ �� �ֳ�......?
		//�ƴϸ� �Է�ĭ���ٰ� ���� ���� �ڵ� ������ �������� �̸� "!@34�ѱ���eng" �� ���� �� ������?
		
		solo.sleep(2000);
	}
	
		public void testwatermarkText(String uri, int caseNumber) {
		//ȭ�鿡 ���� ���ڵ��� ����־ �ؽ�Ʈ�� �� �������� Ȯ�� ���̽�(������)		
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			
			solo.sleep(5000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 18 ���͸�ũ �ؽ�Ʈ�� �ѱ۰� ���� Ư�����ڰ� ���Եǵ� �� ������");
				solo.sleep(3000);
			}
		}
 
		public void testwatermarkImage(String uri, int caseNumber) {
		//ȭ�鿡 ���͸�ũ�� �̹����� �̹��� �� �������� Ȯ���ϴ� �Լ�
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			
			solo.sleep(5000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 19 ���͸�ũ �̹����� �̹����� �� ������");
				solo.sleep(3000);
			}
		}	
		
		public void testwatermarkTextColor(String uri, int caseNumber) {
		//ȭ�鿡 ���͸�ũ �ؽ�Ʈ�� Į�� �����ص� �� �����°�? (������)	
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			
			solo.sleep(5000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 20 ���͸�ũ �ؽ�Ʈ ������ ������ ���.");
				solo.sleep(3000);
			}
		}	
		
		public void testclosebutton(String uri, int caseNumber) {
		//���ȭ�� ���� ��ưŬ���ϱ� 
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			final IconTextView close_bt = (IconTextView) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_CLOSE);
			if (close_bt != null) {
				try {
					runTestOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							log("case 21 ���� ��ư ���� �� �� �Ǵ�");
							close_bt.callOnClick();
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 21 ���� ��ư �� �κ�Ƽ�� ����.");
				solo.sleep(3000);
			}

		}
		
		public void testPopUpPlaybutton(String uri, int caseNumber) {
		//�˾�â ���� ��ư Ŭ���ϱ� 
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			final ImageButton popup_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_POPUP);
			if (popup_bt != null) {
				try {
					runTestOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							popup_bt.callOnClick();
							log("case 23 �˾� �÷��� ��ư�� ���");
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			solo.sleep(5000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 23 �˾��÷��� ��� ĸ��.");
				solo.sleep(3000);
			}

		}
		
		public void testPopUpCloseIcon(String uri, int caseNumber) {
		//�˾�â �ݱ� ������ Ŭ���ϱ� 
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			final ImageButton popup_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_POPUP);
			if (popup_bt != null) {
				try {
					runTestOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							popup_bt.callOnClick();
							log("case 24 �˾��÷��� ���");
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}			
			
			final ImageButton popup_close_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.btn_close);
			if (popup_close_bt != null) {
				try {
					runTestOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							popup_close_bt.callOnClick();
							log("case 24 �˾��÷��� X��ư���� �����ϱ�");
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			solo.sleep(5000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(3000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 24 �˾��÷��� X��ư���� �����ϱ�");
				solo.sleep(3000);
			}

		}		
	
		public void testStreamingContentsPlay(String uri, int caseNumber) {
		//��Ʈ���� ������ ���� ���Ȯ���ϱ� 
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			solo.sleep(8000);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(5000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 25 ��Ʈ���� ������ ������� Ȯ��.");
				solo.sleep(3000);
			}

		}
		
		public void replayStreamingContent(String url, int caseNum){
		//��Ʈ���� ����ϴ� ������ 
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNum + " reopened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			solo.sleep(2000);
		}		

		public void testStreamingContentsNoReplay(String uri, int caseNumber) {
		//��Ʈ���� �������� �̾�Ⱑ ���� �ʴ��� Ȯ���ϴ� ���̽�.  
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			solo.assertCurrentActivity("message", AquaWebPlayer.class);

			solo.sleep(2000);
			
			final IconTextView close_bt = (IconTextView) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BTN_CLOSE);
			if (close_bt != null) {
				try {
					runTestOnUiThread(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							log("case 26 ��Ʈ���� ������ ���� ��ư Ŭ��");
							close_bt.callOnClick();
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//�Լ� ���� ���� �� ���� ���� �ѹ� �� ��Ʈ���� ����
			replayStreamingContent("http://" + serverIp + "/media/auto/player2.asp", 56);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(4000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 26 ��Ʈ���� �������� �ٽ� �����ϸ� �̾�� �ȵǴ��� Ȯ��.");
				solo.sleep(3000);
			}			
		}
		
		public void testDownloadProgressBar(String uri, int caseNumber) {
		//�ٿ�ε��� �� �������ٳ� ���ϸ� ���� ��Ȯ�ϰ� �������� Ȯ��.			
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			
			if (solo.waitForText("Ȯ��")) {
				solo.clickOnText("Ȯ��");
				log("case 27 �ٿ�ε� �� �� ���α׷��� �� ���������� �ö󰡴°� Ȯ��.");
				solo.sleep(4000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				
				if (solo.waitForText("��")) {
					solo.clickOnText("��");
					solo.sleep(2000);
				}	
			}			
		}		

		public void testVideoUserNameSorting(int caseNumber) {
		//������ ��������� ���. 
			
			//���� video tab�� �����Ѵ�.
			solo.sleep(2000);
			solo.waitForActivity("AquaContent", 5000);
			log("case 28 AquaContent wait end");
			
			solo.sleep(3000);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			if(solo.waitForText("crs2")) {
				solo.clickOnText("crs2");
				solo.sleep(2000);
			}
			
			//���� ��ư�� ã�Ƽ� Ŭ���ϴ� ����.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 28 edit ��ư�� ã��.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 28 edit ��ư�� Ŭ��.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//���Ǹ� ���� ������ư�� Ŭ���ϴ� ����. 
			if(solo.waitForText("����� ����")) {
				solo.clickOnText("����� ����");
				log("case 28 ����� ���ĵ� ������� ����� Ȯ��.");
				solo.sleep(500);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			}
		}				
		
		public void testVideoContentNameSorting(int caseNumber) {
		//������ ���Ǹ����� ���. 
			
			//���� video tab�� �����Ѵ�.
			solo.sleep(1000);
			solo.waitForActivity("AquaContent", 1000);
			log("case 29 AquaContent wait end");
			
			solo.sleep(500);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			if(solo.waitForText("crs2")) {
				solo.clickOnText("crs2");
				solo.sleep(2000);
			}
			
			//���� ��ư�� ã�Ƽ� Ŭ���ϴ� ����.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 29 edit ��ư�� ã��.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 29 edit ��ư�� Ŭ��.");
								solo.sleep(500);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//���Ǹ� ���� ������ư�� Ŭ���ϴ� ����. 
			if(solo.waitForText("���Ǹ� ����")) {
				solo.clickOnText("���Ǹ� ����");
				log("case 29 ���Ǹ����ĵ� ������� ����� Ȯ��.");
				solo.sleep(2000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				solo.sleep(1000);
			}
			
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
                final Button button_ok = (Button) solo.getView(android.R.id.button1);
                button_ok.callOnClick();
                solo.sleep(1000);
          }
		}	
		
		public void testVideoFolderUserSorting(int caseNumber) {
		//������ ���� ��������� ���. 
			
			//���� video tab�� �����Ѵ�.
			solo.sleep(2000);
			solo.waitForActivity("AquaContent", 5000);
			log("case 28 AquaContent wait end");
			
			solo.sleep(3000);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			
			//���� ��ư�� ã�Ƽ� Ŭ���ϴ� ����.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 30 edit ��ư�� ã��.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 30 edit ��ư�� Ŭ��.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//����� ���� ������ư�� Ŭ���ϴ� ����. 
			if(solo.waitForText("����� ����")) {
				solo.clickOnText("����� ����");
				log("case 30 ����� ���ĵ� ������� ����� Ȯ��.");
				solo.sleep(4000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				solo.sleep(1000);
			}
		}		

		public void testVideoFolderNameSorting(int caseNumber) {
		//������ ���� �������� ���. 
			
			//���� video tab�� �����Ѵ�.
			solo.sleep(2000);
			solo.waitForActivity("AquaContent", 2000);
			log("case 31 AquaContent wait end");
			
			solo.sleep(1000);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			
			//���� ��ư�� ã�Ƽ� Ŭ���ϴ� ����.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 31 edit ��ư�� ã��.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 31 edit ��ư�� Ŭ��.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//���Ǹ� ���� ������ư�� Ŭ���ϴ� ����. 
			if(solo.waitForText("���Ǹ� ����")) {
				solo.clickOnText("���Ǹ� ����");
				log("case 31 ���Ǹ� ���ĵ� ������� ����� Ȯ��.");
				solo.sleep(4000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				solo.sleep(1000);
			}
			
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
                final Button button_ok = (Button) solo.getView(android.R.id.button1);
                button_ok.callOnClick();
                solo.sleep(1000);
			}			
		}				
		
	public void main(String[] args) throws Exception {
		testPlayerTest_1();	
	}
}