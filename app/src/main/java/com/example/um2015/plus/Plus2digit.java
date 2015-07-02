package com.example.um2015.plus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public
class Plus2digit extends ActionBarActivity {

EditText operand1, operand2;
TextView tvResult;
EditText operandGroup[]={operand1,operand2};
@Override
protected
void onCreate ( Bundle savedInstanceState ) {
	super.onCreate ( savedInstanceState );
	setContentView ( R.layout.activity_plus2digit );

	registComponent ();
}

String operation(EditText operand1, EditText operand2,String operater){

	int op1,op2;
try{
	 op1 = Integer.valueOf ( operand1.getText ().toString ()  ) ;
	 op2 = Integer.valueOf ( operand2.getText ().toString () ) ;
}catch ( NumberFormatException e ){
	Log.d ("firstPage","wrong int format");
	return tvResult.getText ().toString ();
}


	String result=tvResult.getText ().toString ();
	switch ( operater ){
		case Constant.PLUS:result = String.valueOf ( op1+op2);break;
		default:Log.e ( "firstPage","Unknown operator" );
	}

	return result;
}

boolean setEditTextListener ( EditText operand, final String OPERATOR) {

	operand.addTextChangedListener ( new TextWatcher () {

		public
		void afterTextChanged ( Editable s ) {

			// you can call or do what you want with your EditText here

			tvResult.setText ( operation ( operand1, operand2 ,OPERATOR) );
		}

		public
		void beforeTextChanged ( CharSequence s, int start, int count, int after ) {}

		public
		void onTextChanged ( CharSequence s, int start, int before, int count ) {}
	} );

	return true;
}


		boolean registComponent(){
//just map the xml to java
		operand1=(EditText)findViewById(R.id.operand1);
		operand2=(EditText)findViewById(R.id.operand2);
		tvResult=(TextView)findViewById(R.id.tv_result);

		setEditTextListener ( operand1,Constant.PLUS );
		setEditTextListener ( operand2,Constant.PLUS );
		return true;
		}

@Override
public
boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_plus2digit,menu);
		return true;
		}

@Override
public
boolean onOptionsItemSelected(MenuItem item){
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id=item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id==R.id.action_settings){
		return true;
		}

		return super.onOptionsItemSelected(item);
		}
		}
