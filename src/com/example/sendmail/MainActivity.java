package com.example.sendmail;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnOK; 
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = (Button) findViewById(R.id.button);
        btnOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                sendEmail();
            	//耗时操作要起线程...有几个新手都是这个问题
                new Thread(new Runnable() {

            		@Override
            		public void run() {
            			try {
            				EmailSender sender = new EmailSender();
            				//设置服务器地址和端口，网上搜的到
            				sender.setProperties("smtp.163.com", "25");
            				//分别设置发件人，邮件标题和文本内容
            				sender.setMessage("sanyuan808@163.com", "EmailSender", "Java Mail ！");
            				//设置收件人
            				sender.setReceiver(new String[]{"zuyuan.zhang@dianping.com"});
            				//添加附件
            				//这个附件的路径是我手机里的啊，要发你得换成你手机里正确的路径
//            				sender.addAttachment("/sdcard/DCIM/Camera/asd.jpg");
            				//发送邮件
            				sender.sendEmail("smtp.163.com", "sanyuan808@163.com", "2563048");
            			} catch (AddressException e) {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			} catch (MessagingException e) {
            				// TODO Auto-generated catch block
            				e.printStackTrace();
            			}
            		}
            	}).start();
            }
        });

    }
  
}
