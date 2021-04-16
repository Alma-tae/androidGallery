package naver.peekaboo21.handwritten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        setTitle("투표 결과");

        //데이터 수령
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imageName = intent.getStringArrayExtra("imgName");

        //초기값 설정
        TextView[] tv = new TextView[imageName.length];
        RatingBar[] rbar = new RatingBar[imageName.length];

        Integer[] tvID = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer[] rbarID = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        for(int i=0; i<voteResult.length; i++){
            tv[i] = (TextView)findViewById(tvID[i]);
            rbar[i] = (RatingBar)findViewById(rbarID[i]);
        }
        for(int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float)voteResult[i]);
        }
        TextView rtv1 = findViewById(R.id.rtv1);
        ImageView riv1 = findViewById(R.id.riv1);
        int max = -1;

        //이미지명, 최대 득표수 설정
        for(int i=0; i<voteResult.length; i++){
            if(max < voteResult[i]){
                max = voteResult[i];
            }
            //최대 득표된 이미지 출력
            if(voteResult[i] == max){
                if(i == 0){riv1.setImageResource(R.drawable.pic1);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic2);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic3);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic4);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic5);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic6);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic7);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic8);}
                else if(i == 1){riv1.setImageResource(R.drawable.pic9);}
                rtv1.setText(imageName[i]);
            }
        }
        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}