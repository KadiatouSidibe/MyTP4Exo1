package com.example.mytp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mytp4.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NatureFragment.newInstance(0,"Eté",R.drawable.ete);
            case 1:
                return NatureFragment.newInstance(1, "Autone",R.drawable.autone);
            case 2:
                return NatureFragment.newInstance(2, "printemps",R.drawable.printemps);
            case 3:
                return NatureFragment.newInstance(3, "Hiver",R.drawable.hiver);
            case 4:
                return NatureFragment.newInstance(4, "Saison",R.drawable.hiver);
        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        switch (position) {
            case 0:
                titre = "ete".toUpperCase(l);

                break;
            case 1:
                titre = "autone".toUpperCase(l);
                break;
            case 2:
                titre = "printemps".toUpperCase(l);
                break;
            case 3:
                titre = "hiver".toUpperCase(l);
                break;
            case 4:
                titre = "Saison".toUpperCase(l);
                break;
        }
        SpannableString sb = new SpannableString(" " + titre);
        // un espace est ajouté pour séparer le texte de l'image

        return sb;
    }



    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}