package in.paperwrk.udacityandroid;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Kartik on 15-2-18.
 */

public class ViewPagerAdapter  extends PagerAdapter {

    private LayoutInflater inflater;

    private ArrayList<Integer> images;;


    ViewPagerAdapter(Context context, ArrayList<Integer> images) {
        this.images = images;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {

        View imageLayout = inflater.inflate(R.layout.home_viewpager_item, view, false);

        assert imageLayout != null;

        final ImageView imageView = imageLayout
                .findViewById(R.id.image);

        imageView.setImageResource(images.get(position));

        view.addView(imageLayout, 0);

        return imageLayout;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
