package com.zoom.accessibility;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
import com.zoom.utils.DebugLog;
import com.zoom.utils.Version;

public class PlayText {
	public void play(String text){
		//��ʼ����ʹ�ÿƴ�Ѷ�ɿ�����id��
		SpeechUtility.createUtility("appid=" + Version.getAppid());
		
		//�����ϳɶ���
		SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer();
		
		//����������
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
					DebugLog.Log("onCompleted Code��" + arg0.getErrorCode());
			}
			
			@Override
			public void onBufferProgress(int arg0, int arg1, int arg2, String arg3) {
				DebugLog.Log("--onBufferProgress--progress:" + arg0
						+ ",beginPos:" + arg1 + ",endPos:" + arg2);
			}
		};
		// ���÷�����ΪС��
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
		// �����ʶ��ٶ�Ϊ50
		mTts.setParameter(SpeechConstant.SPEED, "50");
		// �������Ϊ50����Χ0~100
		mTts.setParameter(SpeechConstant.PITCH, "50");
		// ��������Ϊ50����Χ0~100
		mTts.setParameter(SpeechConstant.VOLUME, "50");
		// ���úϳ���Ƶ����λ�ã����Զ��屣��λ�ã��������ڡ�./iflytek.pcm��
		mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
		// �ϳ��ı�ΪTEXT_CONTENT�ľ��ӣ����ü�����ΪmSynListener
		mTts.startSpeaking(text, mSynListener);
	}
}
