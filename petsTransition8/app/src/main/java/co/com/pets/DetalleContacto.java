package co.com.pets;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by xander on 02/04/2017.
 */
public class DetalleContacto extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    //private TextView tvNombre;
    //private TextView tvTelefono;
    //private TextView tvEmail;
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_detalle_contacto_foto);
        //setupWindowAnimations();
        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.perro1)
                .into(imgFotoDetalle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.BOTTOM);
            slide.setDuration(1200);
            getWindow().setEnterTransition(slide);
            slide.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    Toast.makeText(DetalleContacto.this, "Empezando", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    Toast.makeText(DetalleContacto.this, "Termina", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });


            getWindow().setReturnTransition(new Fade());

        } else {

        }


    }
}
