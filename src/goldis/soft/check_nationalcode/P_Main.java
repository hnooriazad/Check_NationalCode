package goldis.soft.check_nationalcode;

import org.droidparts.widget.ClearableEditText;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
//import org.droidparts.*;

public class P_Main extends Activity {

	int sum = 0;
	int i, j, k;
	TextView TVStatus;
	ClearableEditText ETNationalCode;
	Dialog dialog;
	TextView txt;
	ImageView img;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p__main);
		getActionBar().hide();

		TVStatus = (TextView) findViewById(R.id.TextViewStatus);
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.popupview);
		ETNationalCode = (ClearableEditText) findViewById(R.id.EditTextNationalCode);
		txt = (TextView) dialog.findViewById(R.id.textbox);
		img = (ImageView) dialog.findViewById(R.id.dialogIcon);
		Button btnCheck = (Button) findViewById(R.id.btnCheck);
		btnCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				sum = 0;

				String NationalCode = ETNationalCode.getText().toString();
				if (NationalCode.length() < 10) {

					// txt.setText("Salam1231qwdasd2aw");

					txt.setText("کد ملی نامعتبر است!");
					// txt.setTextColor(Color.parseColor("#D50000"));
					txt.setVisibility(View.VISIBLE);
					img.setBackgroundResource(R.drawable.errorico);

				} else {
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

							txt.setText("کد ملی وارد شده صحیح می باشد.");
							// txt.setTextColor(Color.parseColor("#64DD17"));
							txt.setVisibility(View.VISIBLE);
							img.setBackgroundResource(R.drawable.checkedico);

						} else {

							txt.setText("کد ملی نامعتبر است!");
							// txt.setTextColor(Color.parseColor("#D50000"));
							txt.setVisibility(View.VISIBLE);
							img.setBackgroundResource(R.drawable.errorico);
						}
					} else {
						if ((11 - (sum % 11)) == Integer.parseInt(NationalCode
								.substring(9, 10))) {

							txt.setText("کد ملی وارد شده صحیح می باشد.");
							// txt.setTextColor(Color.parseColor("#64DD17"));
							txt.setVisibility(View.VISIBLE);
							img.setBackgroundResource(R.drawable.checkedico);
						} else {

							txt.setText("کد ملی نامعتبر است!");
							// txt.setTextColor(Color.parseColor("#D50000"));
							txt.setVisibility(View.VISIBLE);
							img.setBackgroundResource(R.drawable.errorico);
						}
					}

				}
				dialog.show();
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
