package com.example.mytp4.ui.main;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mytp4.MainActivity;
import com.example.mytp4.R;

public class NatureFragment extends Fragment
{
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    private  int image;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";
    private static final String ARG_SECTION_IMAGE = "image_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title, int image) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        args.putInt(ARG_SECTION_IMAGE, image);


        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
        image = getArguments().getInt(ARG_SECTION_IMAGE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);
        ImageView imageView = view.findViewById(R.id.imageView);
        ImageView imageView1 = view.findViewById(R.id.imageView1);
        ImageView imageView2 = view.findViewById(R.id.imageView2);
        ImageView imageView3 = view.findViewById(R.id.imageView3);
        ImageView imageView4 = view.findViewById(R.id.imageView4);

        if (page==0||page==1|| page==2||page==3){

            imageView.setImageResource(image);
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.GONE);
            imageView3.setVisibility(View.GONE);
            imageView4.setVisibility(View.GONE);
        }
        if(page==4) {
            MainActivity activity = (MainActivity) getActivity();
            imageView.setVisibility(View.GONE);
            imageView1.setImageResource(R.drawable.autone);
            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.viewPager.setCurrentItem(1);
                }
            });
            imageView2.setImageResource(R.drawable.ete);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.viewPager.setCurrentItem(0);
                }
            });
            imageView3.setImageResource(R.drawable.printemps);
            imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.viewPager.setCurrentItem(2);
                }
            });
            imageView4.setImageResource(R.drawable.hiver);
            imageView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.viewPager.setCurrentItem(3);
                }
            });
        }

        return view;
    }

}
