package cat.itb.androidquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Dídac Cumelles Cenzano
 */

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder dialog;
    private TextView tv_pregunta, tv_progress;
    private ProgressBar progressBar;
    private Button b_true, b_false;
    QuestionModel q1 = new QuestionModel(false,R.string.p1);
    QuestionModel q2 = new QuestionModel(true,R.string.p2);
    QuestionModel q3 = new QuestionModel(false,R.string.p3);
    QuestionModel q4 = new QuestionModel(true,R.string.p4);
    QuestionModel q5 = new QuestionModel(true,R.string.p5);
    QuestionModel q6 = new QuestionModel(false,R.string.p6);
    QuestionModel q7 = new QuestionModel(true,R.string.p7);
    QuestionModel q8 = new QuestionModel(false,R.string.p8);
    QuestionModel q9 = new QuestionModel(true,R.string.p9);
    QuestionModel q10 = new QuestionModel(false,R.string.p10);
    QuestionModel[] preguntes = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

    private final int MAX_PREGUNTES = 10;
    private int npregunta;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new AlertDialog.Builder(this);
        tv_pregunta = findViewById(R.id.tv_pregunta);
        tv_progress = findViewById(R.id.tv_progress);
        progressBar = findViewById(R.id.progressBar);
        b_true = findViewById(R.id.b_true);
        b_false = findViewById(R.id.b_false);

        npregunta = 0;
        score = 0;
        tv_pregunta.setText(preguntes[0].getPregunta());
        tv_progress.setText("Question " + (npregunta + 1) + " of " + MAX_PREGUNTES);

        b_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(true);
            }
        });

        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprovar(false);
            }
        });
    }

    public void comprovar (Boolean boto){
        if (preguntes[npregunta].isResposta()==boto){
            Toast.makeText(this, "Right choice!", Toast.LENGTH_SHORT).show();
            score++;
        }else{
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }

        if(npregunta!=(MAX_PREGUNTES-1)) {
            npregunta++;
            progressBar.incrementProgressBy(10);
            tv_pregunta.setText(preguntes[npregunta].getPregunta());
            tv_progress.setText("Question " + (npregunta + 1) + " of " + MAX_PREGUNTES);
        }else{
            dialeg();
        }
    }

    public void dialeg(){
        dialog.setTitle("Scored "+score+" out of "+MAX_PREGUNTES+"!");
        dialog.setMessage("Do you want to try again?");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent intent = getIntent();
                finish();
                startActivity(intent);;
            }
        });
        dialog.show();
    }
}