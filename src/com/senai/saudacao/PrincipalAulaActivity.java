package com.senai.saudacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalAulaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal_aula);
	}
	
	@Override
	protected void onResume() {
		EditText etNome = (EditText)findViewById(R.id.et_nome);
		etNome.setText("");
		super.onResume();
	}
	
	public void capturarNome(View view) {
		EditText etNome = (EditText)findViewById(R.id.et_nome);
		String nome = etNome.getText().toString();
		iniciarActivitySaudacao(nome);
	}
	
	private void mostrarMensagem(String mensagem) {
		Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
	}
	
	private void iniciarActivitySaudacao(String nome) {
		Intent intent  = new Intent(this, SaudacaoAulaActivity.class);
		intent.putExtra("nome", nome);
		startActivity(intent);
	}
}
