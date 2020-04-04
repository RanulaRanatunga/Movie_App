package com.example.movieapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.movieapp.R;
import com.example.movieapp.adapters.RecyclerViewAdapter;
import com.example.movieapp.model.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieList extends AppCompatActivity {

    private  final  String JSON_URL = "http://www.omdbapi.com/?i=tt3896198&apikey=ae7325ce";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Movies> lstMovies;
    private RecyclerView recyclerView;

    Button Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

       Logout = findViewById(R.id.logout);

       Logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MovieList.this, LoginActivity.class);
               startActivity(intent);
               finish();
           }
       });

        lstMovies = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0 ; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Movies movies = new Movies();
                        movies.setTitle(jsonObject.getString("Title"));
                        movies.setYear(jsonObject.getString("Year"));
                        movies.setImdb_rating(jsonObject.getString("imdbRating"));
                        movies.setReleased_Date(jsonObject.getString("Released"));
                        movies.setDirector(jsonObject.getString("Director"));
                        movies.setRuntime(jsonObject.getString("Runtime"));
                        movies.setLanguage(jsonObject.getString("Language"));
                        movies.setPoster_url(jsonObject.getString("Poster"));

                        lstMovies.add(movies);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstMovies);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MovieList.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Movies> lstMovies) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}
