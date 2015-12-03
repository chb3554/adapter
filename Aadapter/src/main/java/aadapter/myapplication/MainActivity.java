package aadapter.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID =
            {R.drawable.mov01, R.drawable.mov02,
             R.drawable.mov03, R.drawable.mov04,
             R.drawable.mov05, R.drawable.mov06,
             R.drawable.mov07, R.drawable.mov08,
             R.drawable.mov09, R.drawable.mov10};

    String[] Name = {"신세계", "괴물", "하울링", "구르믈버서난달처럼",
            "슈퍼맨 리턴즈", "타이타닉", "감시자들", "파파로티",
            "저수지 치타", "완득이"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        @Override
        public int getCount() {
            return 10;
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

            View row = convertView;
            ImageView imageViewIte;
            TextView textViewTitle;
            if(row == null) {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(R.layout.grid, parent, false);
            }

            textViewTitle = (TextView) row.findViewById(R.id.gTextView);
            imageViewIte = (ImageView) row.findViewById(R.id.gImageView);

            imageViewIte.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageViewIte.setImageResource(posterID[position]);
            textViewTitle.setText(Name[position]);

            final int pos = position;
            imageViewIte.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(Name[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return row;
        }

        public MyGridAdapter(Context c) {
            context = c;
        }
    }

}