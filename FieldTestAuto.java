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
		testFieldTestPlayList("http://" + serverIp + "/media/auto/player15.asp", 15);
		
		/*
		 *
		 * 여기서부터 스트리밍 관련 Field Test 를 진행합니다. case number : 1, 2, 3, 7, 8, 9, 14, 17, 18
		 */
		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player1.asp", 1);
		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player2.asp", 2);
		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player3.asp", 3);
		 testFieldTestSmi("http://" + serverIp + "/media/auto/player6.asp", 6);
		 testFieldTestStreaming("http://" + serverIp + "/media/auto/player7.asp", 7);
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
////		 testFieldTestBookmark("http://" + serverIp + "/media/auto/player5.asp", 5);
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
//		testContentInfoAndUI("notyet");
		
		/*
		 * 
		 * 여기서부터 북마크 관련 Test 를 진행합니다. case number : 없음 ( bookmark )
		 */
//		testBookmarks("bookmark");
		
		/*
		 * 
		 * 여기서부터 잠금 상태 관련 Test 를 진행합니다. case number : 없음 ( lock ) 
		 */
//		testLock("http://" + serverIp + "/media/auto/player5.asp", "lock");
		
		/*
		 * 
		 * 여기서부터 >>, <<, || 아이콘 관련 Test 를 진행합니다. case number : 없음 ( iconClick )
		 */
//		testIconClick("http://" + serverIp + "/media/auto/player5.asp", "iconClick");
		
		//잠깐 플레이리스트 관련 Test 를 진행합니다.
		testPlaylist("playlist");

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
						solo.takeScreenshot("Field+Test+case5_1" + "+" + testDate);
						
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
		solo.waitForActivity("AquaContent", 5000);
		log("AquaContent wait end");
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
					log("case notyet playlistTab opened");
				}
				
			});
		} catch(Throwable e) {
			e.printStackTrace();
		}
		solo.sleep(3000);
		
		solo.waitForView(com.cdn.aquanmanager.R.id.edit);
		final Button edit_bt = (Button)solo.getView(com.cdn.aquanmanager.R.id.edit);
		try {
			runTestOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					edit_bt.callOnClick();
				}
				
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if(solo.waitForText("새 재생목록")) {
			solo.clickOnText("새 재생목록");
			solo.sleep(2000);
		}
		
		//이제 여기서부터, 로보티움을 이용해 자판을 칠 수 있나......?
		//아니면 입력칸에다가 내가 직접 코드 상으로 재생목록의 이름 "!@34한국어eng" 을 넣을 수 있을까?
		
		solo.sleep(2000);
		
	}
	
	
	
	
	public void main(String[] args) throws Exception {
		testPlayerTest_1();
		
	}

}
