package com.senai.saudacao;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SaudacaoAulaActivity extends Activity {
	
	private static final int DIA = 1;
	private static final int TARDE = 2;
	private static final int NOITE = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saudacao_aula);
		
		Intent intent = getIntent();
		String nome = intent.getStringExtra("nome");
		
		TextView tvSaudacao = (TextView)findViewById(R.id.tv_saudacao);
		tvSaudacao.setText(getSaudacao() + " " + nome);
		
		ImageView imageView = (ImageView)findViewById(R.id.iv_img_saudacao);
		imageView.setImageResource(getImagemId());
	}
	
	private int getImagemId() {
		int imagemId = 0;
		switch (getPeriodo()) {
		case DIA: imagemId = R.drawable.bom_dia; break;
		case TARDE: imagemId = R.drawable.boa_tarde; break;
		case NOITE: imagemId = R.drawable.boa_noite; break;
		}
		return imagemId;
	}
	
	private String getSaudacao() {
		String saudacao = "";
		switch (getPeriodo()) {
		case DIA: saudacao = "Bom dia"; break;
		case TARDE: saudacao = "Boa tarde"; break;
		case NOITE: saudacao = "Boa noite"; break;
		}
		return saudacao;
	}
	
	private int getPeriodo() {
		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);
		
		int periodo = NOITE;
		if (hora < 12 && hora >= 5) {
			periodo = DIA;
		} else if (hora >= 12 && hora < 18) {
			periodo = TARDE;
		}
		
		return periodo;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.saudacao_aula, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menu_voltar) {
			voltar();
		}
		return super.onOptionsItemSelected(item);
	}

	private void voltar() {
		Intent intent = new Intent(this, PrincipalAulaActivity.class);
		startActivity(intent);
	}

	@SuppressWarnings("unused")
	private void mostrarMensagem(String mensagem) {
		Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
	}
}
