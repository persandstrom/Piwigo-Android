package org.piwigo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.service.dreams.DreamService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import org.piwigo.data.model.VariantWithImage;
import org.piwigo.ui.photoviewer.TouchImageView;

import java.io.File;
import java.util.List;

public class PiwigoDream extends DreamService {

    private Context context;
    private List<VariantWithImage> images;
    private LayoutInflater inflater;
    private Picasso picasso;

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        setContentView(R.layout.item_fullscreen_image);
        context = getApplicationContext();
        picasso = new Picasso.Builder(context)
                .indicatorsEnabled(BuildConfig.DEBUG) // We may not want this for production build..
                .build();
        viewImage();
    }

    public void viewImage()
    {
        Resources res = getResources();

        TouchImageView view = findViewById(R.id.imgDisplay);
        picasso.load(R.drawable.piwigo_logo)
                .into(view);
    }
}