package cat.itb.androidquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_pregunta;
    private TextView tv_progress;
    private ProgressBar progressBar;
    private Button b_true;
    private Button b_false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_pregunta=findViewById(R.id.tv_pregunta);
        tv_progress=findViewById(R.id.tv_progress);
        progressBar=findViewById(R.id.progressBar);
        b_true=findViewById(R.id.b_true);
        b_false=findViewById(R.id.b_false);

        QuestionModel q1 = new QuestionModel(true,1);

    }
//AlertDialog.Builder dialog
//AlertDialog
}