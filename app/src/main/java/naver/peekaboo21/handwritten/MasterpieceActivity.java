package naver.peekaboo21.handwritten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MasterpieceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterpiece);

        setTitle("명화 선호도 투표");

        //초기값 설정
        final int[] voteCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        //ImageView 위젯 담을 객체 선언
        ImageView[] image = new ImageView[9];
        Integer[] imageID = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String[] imgName = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양",
                "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        //각 이미지뷰의 클릭 정의
        for(int i=0; i<imageID.length; i++){
            //내부 클래스 사용 위해 final 선언
            final int idx = i;
            image[i] = (ImageView)findViewById(imageID[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        voteCount[idx]++;
                        Toast.makeText(getApplicationContext(), imgName[idx]+"총"+voteCount[idx]+"표", Toast.LENGTH_LONG).show();
                }
            });
        }
        //버튼 클릭 정의
        Button btnResult = (Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imgName", imgName);
                startActivity(intent);
            }
        });
    }
}