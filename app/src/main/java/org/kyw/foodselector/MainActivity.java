package org.kyw.foodselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    RadioGroup radioGroup;
    RadioButton radioButton_kor,radioButton_cen,radioButton_amr,radioButton_jpn;
    TextView textView_this, textView_sans;
    Button button_1,botton_cl,botton_end;
    ImageView ImageView;

    //출력 메뉴 저장소(배열로)
    String[] korMeun = {"김치찌개","백반","비빔밥","짜장면","육포","떡볶이"};
    String[] amrMeun = {"햄버거","피자","치킨","도넛","비프로프","비프부르기뇽"};
    String[] jpnMeun = {"스시","카츠동","소바","아구간조림","와규","라멘"};
    String[] cenMeun = {"짬뽕","마라탕","마라샹궈","난자완스","라조기","탕수육"};

    //메뉴에 따른 이미지를 매칭하기! (배열)
    int[] kor ={R.drawable.kor_gimchijjigae,R.drawable.kor_baegban,R.drawable.kor_bibimbab,R.drawable.kor_jajanmen,R.drawable.kor_yugpo,R.drawable.kor_tteokbokki};
    int[] amr ={R.drawable.amr_hamburger,R.drawable.amr_pizza,R.drawable.amr_chicken,R.drawable.amr_donut,R.drawable.amr_beprof,R.drawable.amr_beefbourguignon};
    int[] jpn ={R.drawable.jpn_sushi,R.drawable.jpn_kacheudong,R.drawable.jpn_soba,R.drawable.jpn_agwiganjolim,R.drawable.jpn_wagyu,R.drawable.jpn_ramen};
    int[] cen ={R.drawable.cen_jjamppong,R.drawable.cen_malatang,R.drawable.cen_malasyanggwo,R.drawable.cen_nanjawanseu,R.drawable.cen_rajogi,R.drawable.cen_sweetandsourpork};

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //각 변수들에 따른 변수 매칭
        radioGroup = findViewById(R.id.radioGroup);
        radioButton_kor = findViewById(R.id.radioButton_kor);
        radioButton_cen = findViewById(R.id.radioButton_cen);
        radioButton_amr = findViewById(R.id.radioButton_amr);
        radioButton_jpn = findViewById(R.id.radioButton_jpn);
        textView_this = findViewById(R.id.textView_this);
        textView_sans = findViewById(R.id.textView_sans);
        button_1 = findViewById(R.id.button_1);
        ImageView = findViewById(R.id.ImageView);
        botton_cl = findViewById(R.id.botton_cl);
        botton_end = findViewById(R.id.botton_end);

        //my 인스턴스 생성
        mtmt mt = new mtmt();
        radioButton_kor.setOnClickListener(mt);
        radioButton_jpn.setOnClickListener(mt);
        radioButton_cen.setOnClickListener(mt);
        radioButton_amr.setOnClickListener(mt);

        botton_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                ImageView.setImageResource(0);
                textView_sans.setVisibility(View.INVISIBLE);
                
                Toast.makeText(getApplicationContext(),"초기화 완료!",Toast.LENGTH_SHORT).show();
            }//onClick
        });//setOnClickListener

        botton_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(getApplicationContext(),"종료 완료!",Toast.LENGTH_SHORT).show();
            }//onClick
        });//setOnClickListener

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택 된 라디오 버튼의 id 를 구한다...!
                int sel = radioGroup.getCheckedRadioButtonId();
                if ( sel== -1 ){
                    Toast.makeText(getApplicationContext(),"아무거나는 없는 음식입니다",Toast.LENGTH_SHORT).show();
                    return;
                }

                //0~ 3 까지의 랜던수 생성
                Random ran = new Random();
                int rma = ran.nextInt(6);//0~5까지 생성




                textView_sans.setVisibility(View.VISIBLE);
                textView_this.setVisibility(View.VISIBLE);
                ImageView.setVisibility(View.VISIBLE);

            }
        });

    }//onCreate

    //카테고리 선택시 출력용 메시지 리스너 클래스 생성
    public class mtmt implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String strr = "";

            switch (v.getId()){
                case R.id.radioButton_kor:
                    strr = radioButton_kor.getText().toString();
                    break;
                case R.id.radioButton_jpn:
                    strr = radioButton_jpn.getText().toString();
                    break;
                case R.id.radioButton_cen:
                    strr = radioButton_cen.getText().toString();
                    break;
                case R.id.radioButton_amr:
                    strr = radioButton_amr.getText().toString();
                    break;
            }

            Toast.makeText(getApplicationContext(), strr + "를 (을)선택하셧습니다..!", Toast.LENGTH_SHORT).show();

        }
    }

}//class