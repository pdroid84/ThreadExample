package com.debashis.threadexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	ProgressBar pbar;
	TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbar = (ProgressBar) findViewById(R.id.progressBar1);
        tview = (TextView) findViewById(R.id.textView1);
    }
    public void startProgress(View view) {
        
    	Runnable rble = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<10;i++){
					final int value = i;
					doFakeWork();
					pbar.post(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							tview.setText("Updating..");
							pbar.setProgress(value);
						}
					});
				}
			}};
			new Thread(rble).start();
        }
    private void doFakeWork(){
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
class MyRun implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j=0;j<11;j++){
			final int val = j;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
