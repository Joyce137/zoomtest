package com.iflytek.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.util.DrawableUtils;
import com.iflytek.util.JsonParser;

public class IatSpeechView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel labelWav;

	private JButton jbtnRecognizer;
	private JButton jbtnCancel;
	private JButton jbtnStop;
	private JButton jbtnHome;

	JTextArea resultArea;

	// 语音听写对象
	private SpeechRecognizer mIat;

	/**
	 * 初始化按钮对象. 设置按钮背景图片、大小、鼠标点击事件 初始化文本框，设置字体类型、大小
	 */
	public IatSpeechView() {
		jbtnRecognizer = addButton("res/button.png", "开始听写", 0, 320, 330, -1,
				"res/button");

		ImageIcon img = new ImageIcon("res/mic_01.png");
		labelWav = new JLabel(img);
		labelWav.setBounds(0, 0, img.getIconWidth(),
				img.getIconHeight() * 4 / 5);
		jbtnRecognizer.add(labelWav, BorderLayout.WEST);

		jbtnStop = addButton("res/button.png", "停止", 330, 320, 135, -1,
				"res/button");
		jbtnCancel = addButton("res/button.png", "取消", 465, 320, 135, -1,
				"res/button");
		jbtnHome = addButton("res/home.png", "", 20, 20, 1, 1, "res/home");

		resultArea = new JTextArea("");
		resultArea.setBounds(30, 100, 540, 400);
		resultArea.setOpaque(false);
		resultArea.setEditable(false);
		resultArea.setLineWrap(true);
		resultArea.setForeground(Color.BLACK);
		Font font = new Font("宋体", Font.BOLD, 30);
		resultArea.setFont(font);

		setOpaque(false);

		setLayout(null);
		add(jbtnRecognizer);
		add(jbtnStop);
		add(jbtnCancel);
		add(resultArea);
		add(jbtnHome);

		// 初始化听写对象
		mIat=SpeechRecognizer.createRecognizer();

		jbtnRecognizer.addActionListener(this);
		jbtnHome.addActionListener(this);
		jbtnStop.addActionListener(this);
		jbtnCancel.addActionListener(this);
	}

	public JButton addButton(String imgName, String btnName, int x, int y,
			int imgWidth, int imgHeight, String iconPath) {

		JButton btn = null;
		ImageIcon img = new ImageIcon(imgName);
		btn = DrawableUtils.createImageButton(btnName, img, "center");
		int width = imgWidth, height = imgHeight;
		if (width == 1)
			width = img.getIconWidth();
		else if (width == -1)
			width = img.getIconHeight() * 4 / 5;

		if (height == 1)
			height = img.getIconWidth();
		else if (height == -1)
			height = img.getIconHeight() * 4 / 5;

		btn.setBounds(x, y, width, height);

		DrawableUtils.setMouseListener(btn, iconPath);

		return btn;
	}

	/***
	 * 监听器实现. 按钮按下动作实现
	 */
	public void actionPerformed(ActionEvent e) {
		mIat.setParameter(SpeechConstant.DOMAIN, "iat");
		mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
		mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, "./iflytek.pcm");
		if (e.getSource() == jbtnRecognizer) {
			if (!mIat.isListening())
				mIat.startListening(recognizerListener);
			else
				mIat.stopListening();
		} else if (e.getSource() == jbtnStop) {
			mIat.stopListening();
			iatSpeechInitUI();
		} else if (e.getSource() == jbtnCancel) {
			mIat.cancel();
			iatSpeechInitUI();
		} else if (e.getSource() == jbtnHome) {
			if (null != mIat ) {
				mIat.cancel();
				mIat.destroy();
			}
			JFrame frame = MainView.getFrame();
			frame.getContentPane().remove(this);
			JPanel panel = ((MainView) frame).getMainJpanel();
			frame.getContentPane().add(panel);
			frame.getContentPane().validate();
			frame.getContentPane().repaint();
		}

	}

	/**
	 * 听写监听器
	 */
	private RecognizerListener recognizerListener = new RecognizerListener() {

		@Override
		public void onBeginOfSpeech() {
			((JLabel) jbtnRecognizer.getComponent(0)).setText("听写中...");
			jbtnRecognizer.setEnabled(false);
		}

		@Override
		public void onEndOfSpeech() {
			iatSpeechInitUI();
		}

		/**
		 * 获取听写结果. 获取RecognizerResult类型的识别结果，并对结果进行累加，显示到Area里
		 */
		@Override
		public void onResult(RecognizerResult results, boolean islast) {
			if (resultArea.getText().length() >= 100)
				resultArea.setText("");
			String text = JsonParser.parseIatResult(results.getResultString());
			resultArea.append(text);

		}

		@Override
		public void onVolumeChanged(int volume) {
			if (volume == 0)
				volume = 1;
			else if (volume >= 6)
				volume = 6;
			labelWav.setIcon(new ImageIcon("res/mic_0" + volume + ".png"));
		}

		@Override
		public void onError(SpeechError error) {
			if (null != error)
				DebugLog.Log("onError Code：" + error.getErrorCode());
		}

		@Override
		public void onEvent(int eventType, int arg1, int agr2, String msg) {

		}
	};

	/**
	 * 听写结束，恢复初始状态
	 */
	public void iatSpeechInitUI() {

		labelWav.setIcon(new ImageIcon("res/mic_01.png"));
		jbtnRecognizer.setEnabled(true);
		((JLabel) jbtnRecognizer.getComponent(0)).setText("开始听写");
	}
}
