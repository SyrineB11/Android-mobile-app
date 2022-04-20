package com.example.aggricus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Transformers.ZoomOutTransformer;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import android.content.Intent;
import android.graphics.fonts.FontFamily;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

public class verify extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{ SliderLayout sliderLayout; HashMap<String,String> Hash_file_maps ;

    String numb="(216) 50 606 136";
    private ViewPager viewPager;
    private static final int numpage=3;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        viewPager2 =findViewById(R.id.viewpagerhethalasleni);
        pagerAdapter= new ScreenSlid(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer((ViewPager2.PageTransformer) new ZoomOutTransformer());


    






























        Toolbar toolbar = findViewById(R.id.tt);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.Darkgreen));
        Hash_file_maps = new HashMap<String, String>();
        sliderLayout = (SliderLayout)findViewById(R.id.slider);
        Hash_file_maps.put("Consulter nos catégories","https://aggricus.com/images/slider-pic-1.jpg");
        Hash_file_maps.put("Consulter  nos catégories", "https://aggricus.com/images/slider-pic-2.jpg");
        Hash_file_maps.put("Consulter nos  catégories","https://aggricus.com/images/b-3.png" );

        for(String name : Hash_file_maps.keySet()){ TextSliderView textSliderView = new TextSliderView(verify.this);
            textSliderView .description(name) .image(Hash_file_maps.get(name)) .setScaleType(BaseSliderView.ScaleType.Fit) .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle()); textSliderView.getBundle() .putString("extra",name); sliderLayout.addSlider(textSliderView); } sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000); sliderLayout.addOnPageChangeListener(this); }
    @Override protected void onStop() { sliderLayout.stopAutoCycle(); super.onStop(); }
    @Override public void onSliderClick(BaseSliderView slider) { Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show(); }
    @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
    @Override public void onPageSelected(int position) { Log.d("Slider Demo", "Page Changed: " + position); }
    @Override public void onPageScrollStateChanged(int state) {}

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.examplemenu, menu);
        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(verify.this, "la barre recherche est ouverte pour vous !", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(verify.this, "la barre recherche ne s'ouvere pas pour vous !", Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        menu.findItem(R.id.item1).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.item1).getActionView();
        searchView.setQueryHint("chercher ici nos catégories");
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.item2)
        {
            Intent intent = new Intent(verify.this, who_is_aggricus.class);
            startActivity(intent);

            return true;
        }
        else if(id==R.id.item3)
        {  Intent emailIntent = new Intent(Intent.ACTION_DIAL);
            emailIntent.setData(Uri.parse("tel:23 121 302"));

            startActivity(emailIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ScreenSlid extends FragmentStateAdapter {
        public ScreenSlid(verify verify) {
            super(verify);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position)
            {
                case 0:
                    return new fragment1();
                case 1:
                    return new fragment2();
                case 2:
                    return new fragment3();
                default:
                    return  null;
            }
        }

        @Override
        public int getItemCount() {
            return numpage;
        }
    }

    private class ZoomOutTransformer implements ViewPager2.PageTransformer {
        private static final float minscale=0.85f;
        private static final float minalpha=0.5f;
        @Override
        public void transformPage(@NonNull View page, float position) {
            int pageWidth=page.getWidth();
            int pageHeight=page.getHeight();
            if (position<-1)
            {
                page.setAlpha(0f);
            }
            else if
            (position<=1) {
                float scaleFactor = Math.max(minscale, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;

                if (position <= 0) {
                    page.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    page.setTranslationX(-horzMargin + vertMargin / 2);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(minalpha + (scaleFactor - minscale) / (1 - minscale) * (1 - minscale));
            }
            else
            {
                page.setAlpha(0f);
            }

        }

    }
}