package com.zoom.accessibility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

import com.zoom.tasks.MeetingTask;
import com.zoom.utils.AccessibilityFrame;

public class HostAccessibilty {
	private String text = "现在您将要开一个会,请输入会议类型，1表示视频会议，0表示音频会议。";
	public void host(){
		PlayText.play(text);
		AccessibilityFrame frame = new AccessibilityFrame();
		JTextField jt = frame.getJt();
		jt.setText(null);
		jt.addKeyListener(new KeyAdapter(){ 
            public void keyPressed(KeyEvent e){ 
                char ch=e.getKeyChar(); 
                if(ch>='0'&&ch<='1'){
                	PlayText.play("你按了"+ ch +",正在开会");
                	MeetingTask task = new MeetingTask();
                	task.host(ch -'0');
                }
                if(ch == 'x'){
                	PlayText.play("你按了"+ch+",窗口已关闭。");
                	frame.setVisible(false);
                }
            } 
        }); 	
	}
}
