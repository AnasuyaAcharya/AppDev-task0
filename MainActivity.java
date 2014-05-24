package com.test.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {
	
	private Button mJumble;
	private TextView mText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mText = (TextView) findViewById(R.id.display);
        mJumble =(Button) findViewById(R.id.jumbleB);
        
        mText.setText(R.string.hello_world);
        
        mJumble.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String displayText= (String) mText.getText();
				String newText=rearrange(displayText);
				
				mText.setText(newText);
			}
		});
    }

    public String rearrange(String displayText)
    {
    	StringBuffer p = new StringBuffer();
		int l = displayText.length();
		Random r = new Random();
		for(int i = 0; i < l; i++)
		{
			int x =r.nextInt(l-i);
			char alpha = displayText.charAt(x);
			p.append(alpha);
			StringBuffer b = new StringBuffer("");
			for(int j = 0; j <l-i-1; j++)
			{
				if(j >= x)
					b.append(displayText.charAt(j+1));
				else
					b.append(displayText.charAt(j));
			}
			displayText = b.toString();
		}	
		return p.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
