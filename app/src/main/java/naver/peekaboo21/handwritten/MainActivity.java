package naver.peekaboo21.handwritten;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //이미지 파일을 이름으로 초기화
    Integer[] posterID = {
            R.drawable.abouttime, R.drawable.anotheryear, R.drawable.beforesunrise,
            R.drawable.benjaminbutton, R.drawable.bigfish, R.drawable.cinemaparadico,
            R.drawable.cmbyn, R.drawable.coco, R.drawable.forrestgump,
            R.drawable.her, R.drawable.inception, R.drawable.ironman,
            R.drawable.jojorabbit, R.drawable.lifeiebautiful, R.drawable.logan,
            R.drawable.lordoftherings, R.drawable.lovingvincent, R.drawable.midnight,
            R.drawable.nttl, R.drawable.romanholiday, R.drawable.scentofawoman,
            R.drawable.silverlinings, R.drawable.slumdogmillionaire, R.drawable.toystory3,
            R.drawable.war1917, R.drawable.whiplash, R.drawable.wonder
    };

    //영화제목을 문자 배열로 초기화
    String[] posterTitle={"About Time", "Another Year", "Before Sunrise",
    "The Curious Case of Benjamin Button", "Big Fish", "Cinema Paradiso",
    "Call Me by Your Name", "Coco", "Forrest Gump", "Her", "Inception",
    "Avengers: Endgame", "Jojo Rabbit", "Life Is Beautiful", "Logan",
    "The Lord of the Rings: The Two Towers","Loving Vincent", "Midnight in Paris",
    "Night Train to Lisbon", "Roman Holiday", "Scent of a Woman", "Silver Linings Playbook",
    "Slumdog Millionaire", "Toy Story 3", "1917", "Whiplash", "Wonder"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My favorite movies");

        final GridView gridView = (GridView)findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c){
            this.context = c;
        }

        @Override
        public int getCount(){
            return posterID.length;
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5,5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView)dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("Close", null);
                    dlg.show();
                }
            });
            return imageview;
        }
    }
}