package goldis.soft.check_nationalcode;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class P_Main extends Activity {

	int sum = 0;
	int i, j, k;
	TextView TVStatus;
	EditText ETNationalCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p__main);

		TVStatus = (TextView) findViewById(R.id.TextViewStatus);
		ETNationalCode = (EditText) findViewById(R.id.EditTextNationalCode);
		Button btnCheck = (Button) findViewById(R.id.btnCheck);
		btnCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				sum = 0;

				String NationalCode = ETNationalCode.getText().toString();
				Log.d("NationalCode", NationalCode);
				Log.d("Int", NationalCode.substring(7, 8));
				for (i = 0, j = 10; j > 1;) {
					k = i + 1;
					// Integer.parseInt(NationalCode.substring(i, k));
					Log.d("Int", NationalCode.substring(i, k));
					sum += Integer.parseInt(NationalCode.substring(i, k)
							.toString()) * j;
					Log.d("sum", sum + "");
					j--;
					i++;
				}
				if (sum % 11 < 2) {

					if (Integer.parseInt(NationalCode.substring(9, 10)) == sum % 11) {

						TVStatus.setText("صحیح می باشد");
						TVStatus.setTextColor(Color.parseColor("#00ff00"));
						TVStatus.setVisibility(View.VISIBLE);
					} else {

						TVStatus.setText("صحیح نمی باشد");
						TVStatus.setTextColor(Color.parseColor("#ff0000"));
						TVStatus.setVisibility(View.VISIBLE);
					}
				} else {
					if ((11 - (sum % 11)) == Integer.parseInt(NationalCode
							.substring(9, 10))) {

						TVStatus.setText("صحیح می باشد");
						TVStatus.setTextColor(Color.parseColor("#00ff00"));
						TVStatus.setVisibility(View.VISIBLE);
					} else {

						TVStatus.setText("صحیح نمی باشد");
						TVStatus.setTextColor(Color.parseColor("#ff0000"));
						TVStatus.setVisibility(View.VISIBLE);
					}
				}

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.p__main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
