package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cashifygames.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class CricketHomeBannerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private  Context context;
    int [] imageResource = new int[]{
                R.drawable.ad_banner,
                R.drawable.ad_banner,
                R.drawable.ad_banner
    };
    public CricketHomeBannerAdapter(Context context) {
        this.context=context;


    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
       // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imageResource[position]);
        ((ViewPager) container).addView(imageView);
        return imageView;
    }
    @Override
    public int getCount() {
        return imageResource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ImageView) object;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
