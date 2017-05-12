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
		 * 여기서부터 플레이리스트 관련 Field Test 를 진행합니다. case number : 15,
		 */
		//testFieldTestPlayList("http://" + serverIp + "/media/auto/player15.asp", 15);
		
		/*
		 *
		 * 여기서부터 스트리밍 관련 Field Test 를 진행합니다. case number : 1, 2, 3, 7, 8, 9, 14, 17, 18
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
//		//잠시 배속 관련 Field Test 를 진행합니다. case number : 없음
////		testFieldTestSpeed("http://" + serverIp + "/media/auto/player_speed.asp", "13_1");
//
//		/*
//		 * 
//		 * 여기서부터 북마크 관련 Field Test 를 진행합니다. case number : 5
//		 *
//		 *더 좋은 통합 북마크 관련 Test가 생겼으므로, 이 함수는 주석 처리해도 되겠다.
//		 */
////		testFieldTestBookmark("http://" + serverIp + "/media/auto/player5.asp", 5);
//
		
		
		
		/*
		 * 
		 * 여기서부터 다운로드 관련 Test 를 진행합니다. case number : 없음 
		 */
//		testDownload("http://" + serverIp + "/media/auto/down1.asp", "download");	
		
		/*
		 * 
		 * 여기서부터 상세보기 및 content 재생 시 UI 및 메뉴 확인 관련 Test 를 진행합니다. case number : 없음
		 */		
		//testContentInfoAndUI("videoContent");
		
		/*
		 * 
		 * 여기서부터 북마크 관련 Test 를 진행합니다. case number : 없음 ( bookmark )
		 */
		//testBookmarks("bookmark");
		
		/*
		 * 
		 * 여기서부터 잠금 상태 관련 Test 를 진행합니다. case number : 없음 ( lock ) 
		 */
//		testLock("http://" + serverIp + "/media/auto/player5.asp", "lock");
		
		/*
		 * 
		 * 여기서부터 >>, <<, || 아이콘 관련 Test 를 진행합니다. case number : 없음 ( iconClick )
		 */		
		//testIconClick("http://" + serverIp + "/media/auto/player5.asp", "iconClick");
		

		//잠깐 플레이리스트 관련 Test 를 진행합니다.
		//testPlaylist("playlist");
		
		//현재 불가 testwatermarkText("http://" + serverIp + "/media/auto/wm_text.asp", 49);	
		//testwatermarkImage("http://" + serverIp + "/media/auto/wm_image.asp", 50);
		//현재 불가 testwatermarkTextColor("http://" + serverIp + "/media/auto/wm_textColor.asp", 51);		
		//testclosebutton("http://" + serverIp + "/media/auto/player15.asp", 52);
		//현재 불가 testPopUpPlaybutton("http://" + serverIp + "/media/auto/player2.asp", 53);
		//현재 불가 testPopUpCloseIcon("http://" + serverIp + "/media/auto/player2.asp", 54);
		//testStreamingContentsPlay("http://" + serverIp + "/media/auto/player2.asp", 55);
		//testStreamingContentsNoReplay("http://" + serverIp + "/media/auto/player2.asp", 56);
		//testDownloadProgressBar("http://" + serverIp + "/media/auto/download2.asp", 57);
		//testVideoUserNameSorting(58);
		//testVideoContentNameSorting(59);
		//testVideoFolderUserSorting(60);
		//testVideoFolderNameSorting(61);
		//testVideoContentDelete(62);
		//testVideoFolderDelete(63);
		PlaylistContentPlayOne(64);

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
						log("case 15 플레이리스트 텍스트뷰 클릭");
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
			log("case 15 플레이리스트 off 클릭 시도");
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
//						log("case 13_1 배속 버튼 클릭 시도");
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
//		solo.sleep(60000);	//1 분
//		solo.takeScreenshot("Field+Test+case13_1" + "+" + testDate);
//		
//		//배속 버튼을 클릭하여 2.0 x 로 만든 다음에,
//		//10 분 돌려서 ( sleep() )
//		//캡처해본다.
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
						log("case 5 북마크 버튼 클릭");
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
						log("case 5 북마크 리스트뷰 찾음");
						
//						final TextView bookmark_mv = (TextView) solo.getView(com.cdn.aquanmanager.R.id.tv_bookmark1);
//						if (bookmark_mv != null) {
//							try {
//								runTestOnUiThread(new Runnable() {
//
//									@Override
//									public void run() {
//										// TODO Auto-generated method stub
//										log("case 5 북마크 구간 이동");
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
		final TextView bookmark_mv = (TextView) bookmark_row.findViewById(com.cdn.aquanmanager.R.id.tv_bookmark1); //bookmark_mv : 북마크 이동 
//		if (bookmark_row != null) {
//			try {
//				runTestOnUiThread(new Runnable() {
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						log("case 5 북마크 구간 이동");
//						log("case 5 북마크 구간 이름 : " + bookmark_row.toString());
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
					log("case 5 북마크 구간 이동");
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
//						log("case 5 북마크 구간 이동");
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
		solo.takeScreenshot("Field+Test+case+" + caseNumber + "+" + testDate);	//Mb 나 파일명 등의 텍스트가 잘림없이 표시되는지 확인
		solo.waitForView(com.cdn.aquanmanager.R.id.content_list);
		
		final ImageButton downstop_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.download);
		if (downstop_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 다운로드 일시정지 버튼 클릭 시도");
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
			solo.takeScreenshot("Field+Test+case+contentInfo_1+" + testDate);	//파일 정보 텍스트가 잘림없이 표시되는지 확인
			//이전 함수에서 막 다운받은 content 이므로, 캡처 파일에는 재생정보가 비어있어야함 
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
		solo.takeScreenshot("Field+Test+case+contentInfo_2+" + testDate);	//상세보기 재생 버튼으로 content 재생되는지 확인. 11 초 쯤이 캡쳐되어야 함.
		//&& UI 에서 잘림 몇 겹침 현상이 없는지 확인
		solo.sleep(2000);
		
		solo.goBack();
		solo.sleep(2000);
		solo.takeScreenshot("Field+Test+case+contentInfo_3+" + testDate);	//상세보기에서 재생정보가 들어갔는지 확인. 13 초 쯤이 캡쳐되어야 함.
		//&& 뒤로가기 키 클릭 시 재생 종료되는지 확인
		solo.sleep(2000);
		
		solo.goBack();
		solo.sleep(2000);
		solo.takeScreenshot("Field+Test+case+contentInfo_4+" + testDate);	//상세보기에서 빠져나올 수 있는지, 카테고리 화면이 캡쳐되었는지 확인.	
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
		solo.takeScreenshot("Field+Test+case+contentInfo_5+" + testDate);	//기존 재생정보가 남아 있던 영상은 이어보기 되는지 확인.
		//&& 상세보기 내에서 영상 재생 후, content 목록에서 재생해도 이어보기가 되는지 확인.
		solo.sleep(3000);
		
		if(solo.waitForText("예")) {
			solo.clickOnText("예");
			solo.sleep(3000);
		}
		solo.takeScreenshot("Field+Test+case+contentInfo_6+" + testDate);	//&& 이어보기 시 시작 재생시간이 재생정보와 동일한지 확인. 15 초 쯤이 캡쳐되어야 함.
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
		solo.takeScreenshot("Field+Test+case+closeBT+" + testDate);	//전원 버튼을 클릭 시 재생 종료되는지 확인
		
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
		if(solo.waitForText("예")) {
			solo.clickOnText("예");
			log("case 이어보기 예 클릭");
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

		//북마크 추가
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
				log("AquaWebPlayer bookmark ==="+bookmarkList.getAdapter().getCount()); //getAdapter() 메소드를 사용하면 그 뒤에 카운트 메소드를 사용할 수 있음.
				if(bookmarkList.getAdapter().getCount()==30){ //30개 까지만 출력이 되고
					solo.takeScreenshot("Field+Test+case+bookmarkOrder+" + testDate);	//북마크들이 시간 순으로 정렬되는지 확인						
					
					//북마크 구간으로 이동하고 싶다.
//					final View bookmark_row = bookmark_lv.getChildAt(0);
//					final TextView bookmark_mv = (TextView) bookmark_row.findViewById(com.cdn.aquanmanager.R.id.tv_bookmark1);
//					if(solo.waitForText("확인")) {
//						solo.clickOnText("확인");
//						log("북마크 30 개 초과 알림 창 닫기");
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
					loopout=true;	//그 이후에는 true 로 변경하여 				
				}				
			}
			
			
		}
		
//		solo.takeScreenshot("여기가 대체 어디야?" + testDate);	//여기 위치 : " 확인 " 뜨는 알림 창
//		if (solo.waitForText("확인")) {
//			solo.clickOnText("확인");
//			log("북마크 30 개 초과 알림 창 닫기");
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
		
		
		//북마크 구간으로 이동하고 싶다.	
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
		
		if (solo.waitForText("확인")) {
			solo.takeScreenshot("Field+Test+case+bookmarkLimit+" + testDate);	//북마크가 한도값인 30개까지 추가되는지 확인
			solo.clickOnText("확인");
			log("북마크 30 개 초과 알림 창 닫기");
			solo.sleep(1000);
		}
		solo.goBack();
		solo.sleep(2000);
		solo.goBack();
		solo.sleep(2000);
//		solo.takeScreenshot("여기 위치는?" + testDate);	//여기 위치 : 상세보기
		
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
		if(solo.waitForText("예")) {
			solo.clickOnText("예");
			log("case 이어보기 예 클릭");
			solo.sleep(3000);
		}
		   
		final ImageButton bookmark_bt = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 5 북마크 버튼 클릭");
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
						solo.takeScreenshot("Field+Test+case+bookmarkRemain_1+" + testDate);	//북마크 정보가 재생 종료 이후에도 유지되는지 확인
					}
					
				});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} 
		
		//북마크를 삭제
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
			solo.takeScreenshot("Field+Test+case+bookmarkRemove+" + testDate);	//북마크 삭제가 가능한지 확인
			solo.sleep(2000);
		}
		
		//새로운 영상을 다운로드
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + serverIp + "/media/auto/down2.asp"));
		browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Context instrumentationContext = getInstrumentation().getContext();
		instrumentationContext.startActivity(browserIntent);
		solo.sleep(5000);
		if (solo.waitForText("확인")) {
			solo.clickOnText("확인");
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
		if(solo.waitForText("가")) {
			solo.clickOnText("가");
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
		
		if(solo.waitForText("예")) {
			solo.clickOnText("예");
			log("case 이어보기 예 클릭");
			solo.sleep(3000);
		}
		   
		final ImageButton bookmark_bt2 = (ImageButton) solo.getView(com.cdn.aquanmanager.R.id.CDN_TEST_BOOKMARK);
		if (bookmark_bt2 != null) {
			try {
				runTestOnUiThread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						log("case 북마크 버튼 클릭");
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
						solo.takeScreenshot("Field+Test+case+bookmarkNotSame+" + testDate);	//북마크 정보가 재생 종료 이후에도 유지되는지 확인
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "+" + testDate);	//잠금 아이콘을 클릭 후, 화면이 잠금되는지 확인
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "End+" + testDate);	//잠금 해제가 오로지 잠금 아이콘 클릭 시에만 일어나는지 확인
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Forward+" + testDate);	//아이콘 >> 클릭 후, 빨리감기가 이동하는지 확인
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Backward+" + testDate);	//아이콘 << 클릭 후, 되감기가 이동하는지 확인
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
			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Pause+" + testDate);	//아이콘 || 클릭 후, 일시정지가 작동하는지 확인
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
//			solo.takeScreenshot("Field+Test+case+" + caseNumber + "Fill+" + testDate);	//아이콘 클릭 후, 화면이 Fill 출력되는지 확인
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
			log("case playlist 플레이리스트 액티비티를 wait 했습니다.");
			
			solo.waitForView(com.cdn.aquanmanager.R.id.edit);
			if (solo.waitForView(com.cdn.aquanmanager.R.id.edit)) {			
				log("case playlist 편집 버튼 찾았음!!");
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
							log("case playlist 편집 버튼 클릭!!");
							solo.sleep(2000);
						}
						
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if(solo.waitForText("새 재생목록")) {
				solo.clickOnText("새 재생목록");
				solo.sleep(2000);
			}
			solo.sleep(20000);
			
		}
		
		//이제 여기서부터, 로보티움을 이용해 자판을 칠 수 있나......?
		//아니면 입력칸에다가 내가 직접 코드 상으로 재생목록의 이름 "!@34한국어eng" 을 넣을 수 있을까?
		
		solo.sleep(2000);
	}
	
		/* 워터마크의 텍스트 및 이미지화 그리고 기타 옵션을 주었을 때 잘 적용되는지 테스트하는 함수 (현재 워터마크 이미지만 가능하고 텍스트에서 process crushed가 남 
		 * 2017-05-10
		 * jihyepark */			
	
		public void testwatermarkText(String uri, int caseNumber) {
		//화면에 여러 문자들이 들어있어도 텍스트가 잘 나오는지 확인 케이스(오류남)		
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
				log("case 18 워터마크 텍스트에 한글과 영문 특수문자가 포함되도 잘 나오는");
				solo.sleep(3000);
			}
		}
 
		public void testwatermarkImage(String uri, int caseNumber) {
		//화면에 워터마크가 이미지면 이미지 잘 나오는지 확인하는 함수
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
				log("case 19 워터마크 이미지면 이미지가 잘 나오는");
				solo.sleep(3000);
			}
		}	
		
		public void testwatermarkTextColor(String uri, int caseNumber) {
		//화면에 워터마크 텍스트에 칼라를 적용해도 잘 나오는가? (오류남)	
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
				log("case 20 워터마크 텍스트 색상을 적용한 경우.");
				solo.sleep(3000);
			}
		}	
		
		/* 재생화면에 있는 X표시를 통해 재생화면 종료가 가능한지 여부를 판단. 
		 * 2017-05-10
		 * jihyepark */			
		
		public void testclosebutton(String uri, int caseNumber) {
		//재생화면 종료 버튼클릭하기 
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
							log("case 21 종료 버튼 누를 때 잘 되는");
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
				log("case 21 종료 버튼 후 로보티움 종료.");
				solo.sleep(3000);
			}

		}
	
		/* 팝업플레이 버튼 실행 및 그 안에 있는 여러 버튼을 누르는동작들 (현재 되지 않음) 
		 * 2017-05-11 
		 * jihyepark */			
		
		public void testPopUpPlaybutton(String uri, int caseNumber) {
		//팝업창 띄우는 버튼 클릭하기 
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
							log("case 23 팝업 플레이 버튼을 사용");
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
				log("case 23 팝업플레이 결과 캡쳐.");
				solo.sleep(3000);
			}

		}
		
		public void testPopUpCloseIcon(String uri, int caseNumber) {
		//팝업창 닫기 아이콘 클릭하기 
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
							log("case 24 팝업플레이 사용");
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
							log("case 24 팝업플레이 X버튼으로 종료하기");
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
				log("case 24 팝업플레이 X버튼으로 종료하기");
				solo.sleep(3000);
			}

		}	
		
		
		/* 스트리밍 콘텐츠의 재생 유무 (기본 재생 및 다시 재생해도 이어보기가 되지 않는가 확인.)	
		 * 2017-05-11 
		 * jihyepark */			
	
		public void testStreamingContentsPlay(String uri, int caseNumber) {
		//스트리밍 콘텐츠 정상 재생확인하기 
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
				log("case 25 스트리밍 콘텐츠 정상재생 확인.");
				solo.sleep(3000);
			}

		}
		
		public void replayStreamingContent(String url, int caseNum){
		//스트리밍 재생하는 콘텐츠 
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
		//스트리밍 콘텐츠는 이어보기가 되지 않는지 확인하는 케이스.  
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
							log("case 26 스트리밍 콘텐츠 종료 버튼 클릭");
							close_bt.callOnClick();
							solo.sleep(3000);
						}
					});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//함수 실행 종료 후 동일 컨텐 한번 더 스트리밍 실행
			replayStreamingContent("http://" + serverIp + "/media/auto/player2.asp", 56);
			solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			solo.sleep(4000);
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
				final Button button_ok = (Button) solo.getView(android.R.id.button1);
				button_ok.callOnClick();
				log("case 26 스트리밍 콘텐츠를 다시 실행하면 이어보기 안되는지 확인.");
				solo.sleep(3000);
			}			
		}
		
		/* 다운로드할 때 게이지바나 파일명 등이 정확하게 나오는지 확인.	
		 * 2017-05-11 
		 * jihyepark */				
		
		public void testDownloadProgressBar(String uri, int caseNumber) {		
			solo = new Solo(getInstrumentation(), getActivity());
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			Context instrumentationContext = getInstrumentation().getContext();
			log("Field Test case " + caseNumber + " opened");
			instrumentationContext.startActivity(browserIntent);
			
			if (solo.waitForText("확인")) {
				solo.clickOnText("확인");
				log("case 27 다운로드 할 때 프로그레스 바 정상적으로 올라가는가 확인.");
				solo.sleep(4000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				
				if (solo.waitForText("예")) {
					solo.clickOnText("예");
					solo.sleep(2000);
				}	
			}			
		}
		
//		public void testDownloadSuccesslyPlay(String uri, int caseNumber) {	
//		//다운로드된 콘텐츠가 정상적으로 재생되는지 
//			solo = new Solo(getInstrumentation(), getActivity());
//			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//			browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			Context instrumentationContext = getInstrumentation().getContext();
//			log("Field Test case " + caseNumber + " opened");
//			instrumentationContext.startActivity(browserIntent);
//			
//			if (solo.waitForText("확인")) {
//				solo.clickOnText("확인");
//				log("case 27 다운로드 할 때 프로그레스 바 정상적으로 올라가는가 확인.");
//				solo.sleep(4000);
//				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
//				
//				if (solo.waitForText("예")) {
//					solo.clickOnText("예");
//					solo.sleep(2000);
//				}	
//			}			
//		}				

		/* 비디오 탭 비디오들 소팅 기능 
		 * 2017-05-11 
		 * jihyepark */		
		
		public void testVideoUserNameSorting(int caseNumber) {
		//비디오탭 사용자정렬 기능. 
			
			//먼저 video tab을 진입한다.
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
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 28 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 28 edit 버튼을 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//강의명 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("사용자 정렬")) {
				solo.clickOnText("사용자 정렬");
				log("case 28 사용자 정렬된 영상들의 모습을 확인.");
				solo.sleep(500);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
			}
		}				
		
		public void testVideoContentNameSorting(int caseNumber) {
		//비디오탭 강의명정렬 기능. 
			
			//먼저 video tab을 진입한다.
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
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 29 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 29 edit 버튼을 클릭.");
								solo.sleep(500);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//강의명 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("강의명 정렬")) {
				solo.clickOnText("강의명 정렬");
				log("case 29 강의명정렬된 영상들의 모습을 확인.");
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
		
		/* 비디오 탭 폴더 소팅 기능
		 * 앞에 비디오 파일 소팅 함수를 실행하고서 실행해야함! 
		 * 2017-05-12 
		 * jihyepark */
		
		public void testVideoFolderUserSorting(int caseNumber) {
		//비디오탭 폴더 사용자정렬 기능. 
			
			//먼저 video tab을 진입한다.
			solo.sleep(2000);

			if(solo.waitForText("뒤로")) {
				solo.clickOnText("뒤로");
				solo.sleep(2000);
				log("case 30 뒤로 버튼을 클릭.");
			}
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 30 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 30 edit 버튼을 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//사용자 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("사용자 정렬")) {
				solo.clickOnText("사용자 정렬");
				log("case 30 사용자 정렬된 영상들의 모습을 확인.");
				solo.sleep(4000);
				solo.takeScreenshot("Field+Test+case" + caseNumber + "+" + testDate);
				solo.sleep(1000);
			}
		}		

		public void testVideoFolderNameSorting(int caseNumber) {
		//비디오탭 폴더 강의명정렬 기능. 
			
			//먼저 video tab을 진입한다.
			solo.sleep(2000);
			log("case 31 AquaContent wait end");
			
			solo.sleep(1000);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 31 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 31 edit 버튼을 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//강의명 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("강의명 정렬")) {
				solo.clickOnText("강의명 정렬");
				log("case 31 원하는 목록대로 편집됨을 확인.");
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
		
		/* 비디오 탭 삭제(편집) 기능 
		 * 폴더 및 파일 삭제가 자유롭게 가능해야
		 * 2017-05-12 
		 * jihyepark */
		
		public void testVideoContentDelete(int caseNumber) {
		//비디오 탭 파일 삭제 기능.
			//먼저 video tab을 진입한다.
			
			solo.sleep(2000);
			solo.waitForActivity("AquaContent", 5000);
			log("case 32 AquaContent wait end");
			
			solo.sleep(3000);
			if(solo.waitForText("jihyetest")) {
				solo.clickOnText("jihyetest");
				solo.sleep(2000);
			}
			if(solo.waitForText("crs2")) {
				solo.clickOnText("crs2");
				solo.sleep(2000);
			}
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 32 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 32 edit 버튼을 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			//강의명 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("편집")) {
				solo.clickOnText("편집");
				log("case 32 편집 클");
				solo.sleep(500);
			}

			//편집 버튼을 찾아서 클릭하는 구문.
			final ImageButton delete_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.delete_btn);
			if (delete_bt != null) {	
				log("case 32 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								delete_bt.callOnClick();
								log("case 32 delete 버튼 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
                final Button button_ok = (Button) solo.getView(android.R.id.button1);
                solo.takeScreenshot("Field+Test+case" + "32-1" + "+" + testDate);
                button_ok.callOnClick();
                solo.sleep(1000);
			}			
			solo.takeScreenshot("Field+Test+case" + "32-2" + "+" + testDate);
			
		}
		
		public void testVideoFolderDelete(int caseNumber) {
		//비디오 탭 폴더 삭제 기능.
			solo.sleep(2000);

			if(solo.waitForText("뒤로")) {
				solo.clickOnText("뒤로");
				solo.sleep(2000);
				log("case 33 뒤로 버튼을 클릭.");
			}
			
			//편집 버튼을 찾아서 클릭하는 구문.
			final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
			if (edit_bt != null) {	
				log("case 33 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								edit_bt.callOnClick();
								log("case 33 edit 버튼을 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			//강의명 정렬 라디오버튼을 클릭하는 구문. 
			if(solo.waitForText("편집")) {
				solo.clickOnText("편집");
				log("case 33 편집 클");
				solo.sleep(500);
			}

			//편집 버튼을 찾아서 클릭하는 구문.
			final ImageButton delete_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.delete_btn);
			if (delete_bt != null) {	
				log("case 33 edit 버튼을 찾음.");
				try {
						runTestOnUiThread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								delete_bt.callOnClick();
								log("case 33 delete 버튼 클릭.");
								solo.sleep(2000);
							}		
						});
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
                final Button button_ok = (Button) solo.getView(android.R.id.button1);
                solo.takeScreenshot("Field+Test+case" + "33-1" + "+" + testDate);
                button_ok.callOnClick();
                solo.sleep(1000);
			}			
			solo.takeScreenshot("Field+Test+case" + "33-2" + "+" + testDate);
			
			if (solo.waitForView(android.R.id.button1, 1, 2000)) {
                final Button button_ok = (Button) solo.getView(android.R.id.button1);
                button_ok.callOnClick();
                solo.sleep(1000);
			}			
		}		
	
		/* 재생목록 단일 및 전체 재생 
		 * 재생목록에 있는 콘텐츠 단일 재생 및 전체 재생 가능하도록 함수를 만들기. 
		 * 2017-05-12 
		 * jihyepark */
		
		public void PlaylistContentPlayOne(int caseNumber) { 
		//재생 목록에 있는 단일 콘텐츠 재생하기 
			   solo.waitForActivity("AquaPlaylist", 3000);
               log("case 34 AquaPlaylist wait end");
               solo.sleep(500);
               solo.waitForView(com.cdn.aquanmanager.R.id.playlist);
               final ImageButton playlistTab_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.playlist);
               try {
                      runTestOnUiThread(new Runnable() {
                      @Override
                      public void run() {
	                           // TODO Auto-generated method stub
	                           log("case 34 playlistTab button click");
	                           playlistTab_bt.callOnClick();
	                           log("case 34 playlist playlistTab opened");
	                           solo.sleep(3000);
                           }        
                      });
               } catch(Throwable e) {
                          e.printStackTrace();
               }
               solo.sleep(1000);  ////여기까지가 재생목록 탭으로 이동
              
               solo.assertCurrentActivity("message", AquaPlaylist.class);
               solo.waitForActivity("AquaPlaylist");
               if (solo.waitForActivity("AquaPlaylist")) {
                          log("case 34 playlist 플레이리스트 액티비티를 wait 했습니다.");
                          solo.waitForView(com.cdn.aquanmanager.R.id.edit);
                          if (solo.waitForView(com.cdn.aquanmanager.R.id.edit)) {                             
                                     log("case 34 playlist 현재 액티비티는 : " + solo.getCurrentActivity());
                                    
                          }
                          solo.sleep(1000);	      
               }
               
            //해당 재생목록으로 들어가기 
   			if(solo.waitForText("기본 재생 목록")) {
   				solo.clickOnText("기본 재생 목록");
   				log("case 34 기본 재생 목록 클릭.");
   				solo.sleep(500);
   				
   				//콘텐츠 재생 버튼 클릭하는 구문.
   				final ImageButton contentplay_bt = (ImageButton)solo.getView(com.cdn.aquanmanager.R.id.content_play);
   				if (contentplay_bt != null) {	
   					log("case 34 content play 버튼을 찾음.");
   					try {
   							runTestOnUiThread(new Runnable() {
   								@Override
   								public void run() {
   									// TODO Auto-generated method stub
   									contentplay_bt.callOnClick();
   									log("case 34 content play 버튼 클릭.");
   									solo.sleep(1000);
   								}		
   							});
   					} catch (Throwable e) {
   						e.printStackTrace();
   					}
   				}
   			}		
		}
		
		public void PlaylistContentAllPlay(int caseNumber) {
		//재생 목록에 있는 콘텐츠 전부 재생하기 	
		}
		
	public void main(String[] args) throws Exception {
		testPlayerTest_1();	
	}
}