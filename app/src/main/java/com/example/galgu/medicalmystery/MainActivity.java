package com.example.galgu.medicalmystery;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.ImageClickableAreasAnswerFormat;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalRangeQuestionStep;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalIntractionStep;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Task.JumpStepTask;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

import org.researchstack.backbone.StorageAccess;
import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.model.ConsentDocument;
import org.researchstack.backbone.step.InstructionStep;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.storage.database.AppDatabase;
import org.researchstack.backbone.storage.database.sqlite.DatabaseHelper;
import org.researchstack.backbone.storage.file.EncryptionProvider;
import org.researchstack.backbone.storage.file.FileAccess;
import org.researchstack.backbone.storage.file.PinCodeConfig;
import org.researchstack.backbone.storage.file.SimpleFileAccess;
import org.researchstack.backbone.storage.file.UnencryptedProvider;
import org.researchstack.backbone.task.OrderedTask;
import org.researchstack.backbone.ui.ViewTaskActivity;



public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SURVEY  = 1;
    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PinCodeConfig pinCodeConfig = new PinCodeConfig();

        EncryptionProvider encryptionProvider = new UnencryptedProvider();

        FileAccess fileAccess = new SimpleFileAccess();

        AppDatabase database = new DatabaseHelper(this,
                DatabaseHelper.DEFAULT_NAME,
                null,
                DatabaseHelper.DEFAULT_VERSION);

        StorageAccess.getInstance().init(pinCodeConfig, encryptionProvider, fileAccess, database);


        Intent intent = new Intent(this, GoogleFitIntagration.class);
        startActivity(intent);


        //Thread ggg=(new Thread(gfi));
        //ggg.start();
//        try {
//            ggg.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //String msg = gfi.results();

        int x = 50505;
    }





    public void firstSurveyClick(View v){
        showFirstSurvey();
    }

    private ConsentDocument createConsentDocument(String name) {

        ConsentDocument document = new ConsentDocument();

        document.setTitle(name);
        document.setSignaturePageTitle(R.string.rsb_consent);

        return document;
    }

    private void showFirstSurvey(){

        OrderedTask task = new JumpStepTask("survey_task",FirstSurvey.getSteps(this.getApplicationContext()),1);
        Intent intent = ViewTaskActivity.newIntent(this, task);
        startActivityForResult(intent, 0);

    }
}
