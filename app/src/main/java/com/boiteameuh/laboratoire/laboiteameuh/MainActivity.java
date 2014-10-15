package com.boiteameuh.laboratoire.laboiteameuh;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLecture = (Button)this.findViewById(R.id.btn_lecture);
        btnLecture.setOnClickListener(
                new OnClickListener(){
                    public void onClick(View viewParam) {
                        mediaPlayer =
                                MediaPlayer.create(MainActivity.this, R.raw.lambert);
// Planifier une action à la fin de la lecture du fichier.
                        mediaPlayer.setOnCompletionListener(new OnCompletionListener(){
                            public void onCompletion(MediaPlayer mediaPlayerParam) {
// Reste à coder l’action à réaliser.
                            }
                        });
                        mediaPlayer.start();
                    }
                });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
// Libération des ressources si nécessaire
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
