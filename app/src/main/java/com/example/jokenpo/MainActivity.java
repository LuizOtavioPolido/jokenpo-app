package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText inputPlayer1;
    private EditText inputPlayer2;
    private TextView error;
    private TextView winnerText;
    private Button btnStart;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPlayer1 = findViewById(R.id.inputPlayer1);
        inputPlayer2 = findViewById(R.id.inputPlayer2);
        error = findViewById(R.id.error);
        winnerText = findViewById(R.id.winnerText);
        btnStart = findViewById(R.id.button);

        btnStart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startGame();
            }
        });
    }
    private void startGame() {
        String inputValuePlayer1 = inputPlayer1.getText().toString();
        String inputValuePlayer2 = inputPlayer2.getText().toString();

        if (inputValuePlayer1.isEmpty() && inputValuePlayer2.isEmpty()) {
            error.setText("Preencha os campos");
        } else if (inputValuePlayer1.isEmpty()) {
            error.setText("Campo jogador 1 está vazio");
        } else if (inputValuePlayer2.isEmpty()) {
            error.setText("Campo jogador 2 está vazio");
        } else {
            error.setText("");
            btnStart.setText("Jogar novamente");
            inputPlayer1.setVisibility(View.GONE);
            inputPlayer2.setVisibility(View.GONE);

            Random random = new Random();
            int randomPlay1 = random.nextInt(3);
            int randomPlay2 = random.nextInt(3);
            responseJokenpo(randomPlay1, randomPlay2, inputValuePlayer1, inputValuePlayer2);


        }
    }

    private void responseJokenpo(int randomPlay1, int randomPlay2, String inputValuePlayer1, String inputValuePlayer2){
        // 0 = pedra
        // 1 = papel
        // 2 = tesoura

        imageView = findViewById(R.id.imageView2);
        imageView.setMaxHeight(20);
        imageView.setMaxWidth(20);
        imageView.setVisibility(View.VISIBLE);
        if((randomPlay1 == 0 && randomPlay2 == 0) || (randomPlay1 == 1 && randomPlay2 == 1) || (randomPlay1 == 2 && randomPlay2 == 2)){
            winnerText.setText("Empate!");
            imageView.setVisibility(View.GONE);
        } else if (
                randomPlay1 == 0 && randomPlay2 == 2
        ){
            winnerText.setText("Jogador " + inputValuePlayer1 + " venceu jogando pedra!");
            imageView.setImageResource(R.drawable.images);
        } else if (
                randomPlay2 == 0 && randomPlay1 == 2
        ){
            winnerText.setText("Jogador " + inputValuePlayer2 + " venceu jogando pedra!");
            imageView.setImageResource(R.drawable.images);
        } else if (
                randomPlay1 == 1 && randomPlay2 == 0
        ){
            winnerText.setText("Jogador " + inputValuePlayer1 + " venceu jogando papel!");
            imageView.setImageResource(R.drawable.a6003745blankpapercartooncharacter);
        } else if (
                randomPlay2 == 1 && randomPlay1 == 0
        ){
            winnerText.setText("Jogador " + inputValuePlayer2 + " venceu jogando papel!");
            imageView.setImageResource(R.drawable.a6003745blankpapercartooncharacter);
        } else if (
                randomPlay1 == 2 && randomPlay2 == 1
        ){
            winnerText.setText("Jogador " + inputValuePlayer1 + " venceu jogando tesoura!");
            imageView.setImageResource(R.drawable.f86970f04e4090cf851882a9e0309c42);
        } else if (
                randomPlay2 == 2 && randomPlay1 == 1
        ){
            winnerText.setText("Jogador " + inputValuePlayer2 + " venceu jogando tesoura!");
            imageView.setImageResource(R.drawable.f86970f04e4090cf851882a9e0309c42);
        }
    }

}
