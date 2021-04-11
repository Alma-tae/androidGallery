package naver.peekaboo21.handwritten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        setTitle("My movie Gallery");

        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        Integer[] posterID = {
                R.drawable.abouttime, R.drawable.anotheryear, R.drawable.beforesunrise,
                R.drawable.benjaminbutton, R.drawable.bigfish, R.drawable.cinemaparadico,
                R.drawable.cmbyn, R.drawable.coco, R.drawable.forrestgump,
                R.drawable.her, R.drawable.inception, R.drawable.ironman,
                R.drawable.jojorabbit, R.drawable.lifeiebautiful, R.drawable.logan,
                R.drawable.lordoftherings, R.drawable.lovingvincent, R.drawable.midnight,
                R.drawable.nttl, R.drawable.romanholiday, R.drawable.scentofawoman,
                R.drawable.silverlinings, R.drawable.slumdogmillionaire, R.drawable.toystory3,
                R.drawable.war1917, R.drawable.whiplash, R.drawable.wonder};

        String[] posterTitle={"About Time", "Another Year", "Before Sunrise",
                "The Curious Case of Benjamin Button", "Big Fish", "Cinema Paradiso",
                "Call Me by Your Name", "Coco", "Forrest Gump", "Her", "Inception",
                "Avengers: Endgame", "Jojo Rabbit", "Life Is Beautiful", "Logan",
                "The Lord of the Rings: The Two Towers","Loving Vincent", "Midnight in Paris",
                "Night Train to Lisbon", "Roman Holiday", "Scent of a Woman", "Silver Linings Playbook",
                "Slumdog Millionaire", "Toy Story 3", "1917", "Whiplash", "Wonder"};

        public MyGalleryAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView poster = (ImageView)findViewById(R.id.poster);
                    poster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    poster.setImageResource(posterID[pos]);

                    LayoutInflater inflater = getLayoutInflater();
                    View toastView = inflater.inflate(R.layout.toast, (ViewGroup)findViewById(R.id.toast_layout_root));

                    TextView txtView1 = (TextView)toastView.findViewById(R.id.txtView1);
                    txtView1.setText(posterTitle[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });
            return imageView;
        }
    }
}