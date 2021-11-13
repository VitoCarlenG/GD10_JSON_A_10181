package com.vitocarlengiovanni.gd10_json_a_10181;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.AssetManager;
import android.os.Bundle;

import android.widget.Toast;

import com.google.gson.Gson;
import com.vitocarlengiovanni.gd10_json_a_10181.adapter.RvAdapter;
import com.vitocarlengiovanni.gd10_json_a_10181.databinding.ActivityMainBinding;
import com.vitocarlengiovanni.gd10_json_a_10181.models.Student;
import com.vitocarlengiovanni.gd10_json_a_10181.models.Universitas;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RvAdapter adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // load data
        String json = loadJSON();
        if (json != null) {
            Gson gson = new Gson();
            Universitas uni = gson.fromJson(json, Universitas.class);
            //setup
            setupTitle(uni.getNamaUniversitas());
            setupRecyclerView(uni.getStudents());
        } else {
            Toast.makeText(this, "tidak ada data", Toast.LENGTH_SHORT).show();
        }
        //filter
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    public void setupTitle(String namaUni) {
        binding.title.setText(namaUni);
    }

    public void setupRecyclerView(List<Student> listData) {
        adapter = new RvAdapter(listData);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public String loadJSON() {
        String json = null;
        try {
            AssetManager am = this.getAssets();

            InputStream is = am.open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}