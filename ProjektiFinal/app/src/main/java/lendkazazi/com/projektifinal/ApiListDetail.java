package lendkazazi.com.projektifinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import lendkazazi.com.projektifinal.API.ApiModel;

/**
 * Created by kazazi on 11/01/2018.
 */

public class ApiListDetail extends AppCompatActivity {

    ImageView imageDetail;
    TextView titleDetail, descriptionDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apilistdetail);

        imageDetail = (ImageView) findViewById(R.id.image_detail);
        titleDetail = (TextView) findViewById(R.id.title_detail);
        descriptionDetail = (TextView) findViewById(R.id.description_detail);

        ApiModel apiModel = (ApiModel) getIntent().getSerializableExtra("objekti");

        Glide.with(this).load(apiModel.getImage()).into(imageDetail);
        titleDetail.setText(apiModel.getTitle());
        descriptionDetail.setText(apiModel.getDescription());

    }
}
