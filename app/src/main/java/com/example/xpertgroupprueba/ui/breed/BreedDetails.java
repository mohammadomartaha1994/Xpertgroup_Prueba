package com.example.xpertgroupprueba.ui.breed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.model_view.BreedViewModel;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BreedDetails extends AppCompatActivity {
    private TextView title,name,description,origin,temperament,imperial;
    private Button wikipedia_url;
    private String id;
    private BreedViewModel breedViewModel;
    private ImageView image;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_details);
        breedViewModel = new ViewModelProvider(this).get(BreedViewModel.class);
        Bundle information = getIntent().getExtras();
        id=information.getString("id");
        definitions();
        breedViewModel.getImageBreed(id);
        setInfo(information);
        Log.d("id",id);
    }
    void definitions(){
        title = findViewById(R.id.title);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        origin = findViewById(R.id.origin);
        progressBar = findViewById(R.id.progressBar2);
        temperament = findViewById(R.id.temperament);
        imperial = findViewById(R.id.imperial);
        wikipedia_url = findViewById(R.id.button);
        image = findViewById(R.id.image);
        image.setClipToOutline(true);
    }
    void setInfo(Bundle information){
        title.setText(information.getString("name"));
        name.setText(information.getString("name"));
        description.setText(information.getString("description"));
        origin.setText(information.getString("origin"));
        temperament.setText(information.getString("temperament"));
        imperial.setText(information.getString("imperial"));
        breedViewModel.breedImageMutableLiveData.observe(this, new Observer<List<ImagesModel>>() {
            @Override
            public void onChanged(List<ImagesModel> s) {
                if (!s.equals("no Image"))
                Picasso.with(BreedDetails.this).load(s.get(0).getUrl()).into(image);
                progressBar.setVisibility(View.GONE);
                Log.d("Image",s+" ");
            }
        });

        wikipedia_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = information.getString("wikipedia_url")+"";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    void getTime(){
        Date currentTime = Calendar.getInstance().getTime();
    }
}