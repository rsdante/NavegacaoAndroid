package com.example.navegacaotelas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.navegacaotelas.R;

import java.util.Random;

public class QuartaTela extends AppCompatActivity {

    Button buttonbackward, buttonforward, buttonred, buttongreen, buttonblue, buttonrandom, buttonreset;
    LinearLayout layout1;
    Random rnd;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // -- basico criacao
        //abre na pagina
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta_tela);
        setTitle("Tela 4");

        //ligar todos os objetos
        buttonbackward = (Button) findViewById(R.id.backward);
        buttonforward  = (Button) findViewById(R.id.forward);
        buttonred      = (Button) findViewById(R.id.red);
        buttongreen    = (Button) findViewById(R.id.green);
        buttonblue     = (Button) findViewById(R.id.blue);
        buttonrandom   = (Button) findViewById(R.id.random);
        buttonreset    = (Button) findViewById(R.id.reset);

        layout1        = (LinearLayout) findViewById(R.id.mainlayout);
        rnd            = new Random();

        // -- funcionalidade
        //mudanca de pagina
        buttonforward.setEnabled(false); //nao ha pagina seguinte, desativa botao

        buttonbackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent de ir pra outra pagina, inicia a outra pagina e termina essa
                Intent in = new Intent(QuartaTela.this, TerceiraTela.class);
                startActivity(in);
                finish();
            }
        });

        //mudar cor de fundo
        //vermelho
        buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setBackgroundResource(R.color.lred);
            }
        });

        //verde
        buttongreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setBackgroundResource(R.color.lgreen);
            }
        });

        //azul
        buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setBackgroundResource(R.color.lblue);
            }
        });

        //cor randomica
        buttonrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aleatorio = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                layout1.setBackgroundColor(aleatorio);
            }
        });

        //branco ou reset
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setBackgroundResource(R.color.white);
            }
        });

    }
}