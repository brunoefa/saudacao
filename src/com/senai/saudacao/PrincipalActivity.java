package com.senai.saudacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PrincipalActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
	}
	
	@Override
	protected void onResume() {
		EditText etNome = (EditText)findViewById(R.id.et_nome);
		etNome.setText("");
		super.onResume();
	}
	
	public void entrar(View view) {
		EditText etNome = (EditText)findViewById(R.id.et_nome);
		String nome = etNome.getText().toString();
		
		Intent intent = new Intent(this, SaudacaoActivity.class);
		intent.putExtra("nome", nome);
		startActivity(intent);
	}
}