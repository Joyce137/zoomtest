package com.zoom.accessibility;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
import com.zoom.utils.DebugLog;
import com.zoom.utils.Version;

public class PlayText {
	public static void play(String text){
		//初始化（使用科大讯飞开发者id）
		SpeechUtility.createUtility("appid=" + Version.getAppid());
		
		//语音合成对象
		SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer();
		
		//语音监听器
		SynthesizerListener mSynListener = new SynthesizerListener() {			
			@Override
			public void onSpeakResumed() {
				
			}
			
			@Override
			public void onSpeakProgress(int arg0, int arg1, int arg2) {
				DebugLog.Log("--onBufferProgress--progress:" + arg0
						+ ",beginPos:" + arg1 + ",endPos:" + arg2);
			}
			
			@Override
			public void onSpeakPaused() {
				
			}
			
			@Override
			public void onSpeakBegin() {
				
			}
			
			@Override
			public void onCompleted(SpeechError arg0) {
				if (null != arg0)
					DebugLog.Log("onCompleted Code：" + arg0.getErrorCode());
			}
			
			@Override
			public void onBufferProgress(int arg0, int arg1, int arg2, String arg3) {
				DebugLog.Log("--onBufferProgress--progress:" + arg0
						+ ",beginPos:" + arg1 + ",endPos:" + arg2);
			}
		};
		// 设置发音人为小燕
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
		// 设置朗读速度为50
		mTts.setParameter(SpeechConstant.SPEED, "50");
		// 设置语调为50，范围0~100
		mTts.setParameter(SpeechConstant.PITCH, "50");
		// 设置音量为50，范围0~100
		mTts.setParameter(SpeechConstant.VOLUME, "50");
		// 设置合成音频保存位置（可自定义保存位置），保存在“./iflytek.pcm”
		mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
		// 合成文本为TEXT_CONTENT的句子，设置监听器为mSynListener
		mTts.startSpeaking(text, mSynListener);
	}
}
