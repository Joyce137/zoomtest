package com.iflytek.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
import com.iflytek.util.DrawableUtils;
import com.iflytek.util.Version;

public class TtsSpeechView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	// 合成的文本内容
	private final static String TEXT_CONTENT = "我们都是好孩子";

	private JButton jbtnPlay;
	private JButton jbtnCancel;
	private JButton jbtnHome;
	private JButton jbtnResume;
	private JButton jbtnPause;

	private JTextArea resultArea;

	// 语音合成对象
	private SpeechSynthesizer mTts;

	/**
	 * 初始化按钮. 初始化按钮图片背景、大小、鼠标点击事件
	 */
	public TtsSpeechView() {

		// 初始化
		SpeechUtility.createUtility("appid=" + Version.getAppid());
		jbtnPlay = addButton("res/btn.png", "合成", 0, 320, 150, "res/btn");
		jbtnPause = addButton("res/btn.png", "暂停", 150, 320, 150, "res/btn");
		jbtnResume = addButton("res/btn.png", "恢复", 300, 320, 150, "res/btn");
		jbtnCancel = addButton("res/btn.png", "取消", 450, 320, 150, "res/btn");
		jbtnHome = addButton("res/home.png", "", 20, 20, -1, "res/home");

		resultArea = new JTextArea("");
		resultArea.setBounds(30, 100, 540, 400);
		resultArea.setOpaque(false);
		resultArea.setEditable(false);
		resultArea.setLineWrap(true);
		resultArea.setForeground(Color.BLACK);
		Font font = new Font("宋体", Font.BOLD, 30);
		resultArea.setFont(font);
		resultArea.setText(TEXT_CONTENT);

		setOpaque(false);
		setLayout(null);
		add(jbtnPlay);
		add(jbtnCancel);
		add(jbtnResume);
		add(jbtnPause);
		add(resultArea);
		add(jbtnHome);

		if (SpeechSynthesizer.getSynthesizer() == null)
			SpeechSynthesizer.createSynthesizer();

		jbtnPlay.addActionListener(this);
		jbtnCancel.addActionListener(this);
		jbtnHome.addActionListener(this);
		jbtnResume.addActionListener(this);
		jbtnPause.addActionListener(this);

		// 初始化合成对象
		mTts = SpeechSynthesizer.createSynthesizer();
	}

	public JButton addButton(String imgName, String btnName, int x, int y,
			int imgWidth, String iconPath) {

		JButton btn = null;
		ImageIcon img = new ImageIcon(imgName);
		btn = DrawableUtils.createImageButton(btnName, img, "center");
		int width = imgWidth, height = img.getIconHeight();
		if (width == -1)
			width = img.getIconWidth();
		else
			height = img.getIconHeight() * 3 / 4;
		btn.setBounds(x, y, width, height);
		DrawableUtils.setMouseListener(btn, iconPath);

		return btn;
	}

	/**
	 * 按钮监听器实现
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtnPlay) {
			// 设置发音人为小燕
			mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
			// 设置朗读速度为50
			mTts.setParameter(SpeechConstant.SPEED, "50");
			// 设置语调，范围0~100
			mTts.setParameter(SpeechConstant.PITCH, "50");
			// 设置音量，范围0~100
			mTts.setParameter(SpeechConstant.VOLUME, "50");
			// 设置合成音频保存位置（可自定义保存位置），保存在“./iflytek.pcm”
			// 如果不需要保存合成音频，注释该行代码
			mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
			// 合成文本为TEXT_CONTENT的句子，设置监听器为mSynListener
			mTts.startSpeaking(resultArea.getText().trim(), mSynListener);
		} else if (e.getSource() == jbtnCancel) {
			mTts.stopSpeaking();
		} else if (e.getSource() == jbtnPause) {
			mTts.pauseSpeaking();
		} else if (e.getSource() == jbtnResume) {
			mTts.resumeSpeaking();
		} else if (e.getSource() == jbtnHome) {
			if (null != mTts) {
				mTts.stopSpeaking();
				mTts.destroy();
			}

			JFrame frame = MainView.getFrame();
			frame.getContentPane().remove(this);
			JPanel panel = ((MainView) frame).getMainJpanel();
			frame.getContentPane().add(panel);
			frame.getContentPane().validate();
			frame.getContentPane().repaint();
		}
	}

	private SynthesizerListener mSynListener = new SynthesizerListener() {

		@Override
		public void onSpeakBegin() {
		}

		@Override
		public void onBufferProgress(int progress, int beginPos, int endPos,
				String info) {
			DebugLog.Log("--onBufferProgress--progress:" + progress
					+ ",beginPos:" + beginPos + ",endPos:" + endPos);
		}

		@Override
		public void onSpeakPaused() {

		}

		@Override
		public void onSpeakResumed() {

		}

		@Override
		public void onSpeakProgress(int progress, int beginPos, int endPos) {
			DebugLog.Log("--onSpeakProgress--progress:" + progress
					+ ",beginPos:" + beginPos + ",endPos:" + endPos);

		}

		@Override
		public void onCompleted(SpeechError error) {
			if (null != error)
				DebugLog.Log("onCompleted Code：" + error.getErrorCode());
		}
	};
}
