package lendkazazi.com.projektifinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import lendkazazi.com.projektifinal.API.ApiInterface;
import lendkazazi.com.projektifinal.API.ApiModel;
import lendkazazi.com.projektifinal.API.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kazazi on 11/01/2018.
 */

public class ListFragment extends Fragment {

    RecyclerView recyclerview;
    ApiListAdapter apiListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listfragment, container, false);

        recyclerview = v.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));


        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        apiInterface.getData().enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                if (response.isSuccessful()) {
                    apiListAdapter = new ApiListAdapter(getContext(), response.body());
                    recyclerview.setAdapter(apiListAdapter);
                } else {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {

            }
        });

        return v;
    }
}
