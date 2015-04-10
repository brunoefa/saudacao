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

public class SaudacaoActivity extends Activity {
	
	public static final int BOM_DIA = 1;
	public static final int BOA_TARDE = 2;
	public static final int BOA_NOITE = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saudacao);
		
		Intent intent = getIntent();
		String nome = intent.getStringExtra("nome");
		
		TextView tvSaudacao = (TextView)findViewById(R.id.tv_saudacao);
		tvSaudacao.setText(getSaudacao() + " " + nome);
		
		ImageView imagemSaudacao = (ImageView)findViewById(R.id.iv_img_saudacao);
		imagemSaudacao.setImageResource(getImagem());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.saudacao, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_voltar) {
			Intent intent = new Intent(this, PrincipalActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	
	private String getSaudacao() {
		String saudacao = "";
		int periodo = getPeriodo();
		switch (periodo) {
			case BOM_DIA: saudacao = "Bom dia"; break;
			case BOA_TARDE: saudacao = "Bom tarde"; break;
			case BOA_NOITE: saudacao = "Bom noite"; break;
		}
		return saudacao;
	}
	
	private int getImagem() {
		int idImagem = 0;
		int periodo = getPeriodo();
		switch (periodo) {
			case BOM_DIA: idImagem = R.drawable.bom_dia; break;
			case BOA_TARDE: idImagem = R.drawable.boa_tarde; break;
			case BOA_NOITE: idImagem = R.drawable.boa_noite; break;
		}
		return idImagem;
	}
	
	private int getPeriodo() {
		Calendar c = Calendar.getInstance(); 
		int hora = c.get(Calendar.HOUR_OF_DAY);
		
		int periodo = BOA_NOITE;
		if (hora < 12 && hora >= 5) { periodo = BOM_DIA; } 
		else if (hora >= 12 && hora < 18) { periodo = BOA_TARDE; }
		return periodo;
	}
	
	@SuppressWarnings("unused")
	private void mensagem(String mensagem) {
		Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
	}
}
