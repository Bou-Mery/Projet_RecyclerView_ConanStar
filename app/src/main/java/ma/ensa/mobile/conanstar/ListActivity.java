package ma.ensa.mobile.conanstar;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ma.ensa.mobile.conanstar.adapter.StarAdapter;
import ma.ensa.mobile.conanstar.bean.Star;
import ma.ensa.mobile.conanstar.service.StarService;

public class ListActivity extends AppCompatActivity {

    private StarService service;
    private StarAdapter adapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.rc);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable overflowIcon = toolbar.getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        service = StarService.getInstance();


        service.create(new Star("Conan Edogawa", "https://th.bing.com/th/id/OIP.gFM1TD9LEvbotNqSlPGrmQHaFY?rs=1&pid=ImgDetMain", 5f));
        service.create(new Star("Shinichi Kudo", "https://th.bing.com/th/id/R.9eebbeb17df0d0e9f3fb047d35903129?rik=vf22HaU%2f%2bsQjZA&riu=http%3a%2f%2fwww.detectiveconanworld.com%2fwiki%2fimages%2f3%2f3b%2fShinichi_Kudo_Profile.jpg&ehk=QJT174CwmEWGVzxkVYcsnxKPfVhiBinmeEnoKsIqrf4%3d&risl=&pid=ImgRaw&r=0", 4.8f));
        service.create(new Star("Ran Mouri", "https://th.bing.com/th/id/R.2f0492b8286278b3545d88d9ba0caad9?rik=0Zhx2F1PZCQubQ&riu=http%3a%2f%2fpm1.narvii.com%2f6373%2fd63e5b68aae893f4b7de48ce37a354851010f476_hq.jpg&ehk=sAmQpx0rkTDk7CecKWB6LjxU%2fMgB2Nk%2fQDkt%2buRq5e4%3d&risl=&pid=ImgRaw&r=0", 4.4f));
        service.create(new Star("Kogoro Mouri", "https://i.pinimg.com/736x/25/6f/41/256f417c16716860c2b855d4baa38612.jpg", 3.8f));
        service.create(new Star("Heiji Hattori", "https://th.bing.com/th/id/R.f23138eb9443892f34e0e4c1f35a4a99?rik=eyDRAfv4k9Wd%2fQ&riu=http%3a%2f%2fimg.mp.sohu.com%2fupload%2f20180416%2f08f8cff23ed44627859157f31f4fa602_th.jpeg&ehk=4KygpGPKKE1UbMdmN%2fGe6PABeW85sya09fRzICuSU7w%3d&risl=&pid=ImgRaw&r=0", 4.5f));
        service.create(new Star("Kazuha Toyama", "https://pbs.twimg.com/profile_images/465323203766677504/sGIORb3S_400x400.jpeg", 4f));
        service.create(new Star("Sonoko Suzuki", "https://th.bing.com/th/id/OIP.31xrFnyAbDsw_gHQYjaSBQAAAA?rs=1&pid=ImgDetMain", 2f));
        service.create(new Star("Ayumi Yoshida", "https://vignette.wikia.nocookie.net/detectiveconan96/images/7/74/Ayumi_Yoshida_Profile.jpg/revision/latest/scale-to-width-down/285?cb=20140603195355", 3.9f));
        service.create(new Star("Mitsuhiko Tsuburaya", "https://th.bing.com/th/id/R.0731847f6fa548e0074c4bcd7fe843cf?rik=Hgws3OGQ3ZA9Aw&riu=http%3a%2f%2fvignette2.wikia.nocookie.net%2fdetectiveconan96%2fimages%2f7%2f7e%2fMitsuhiko_Tsuburaya_Profile.jpg%2frevision%2flatest%3fcb%3d20140603200329&ehk=Ks2F2euROpaS8ZkNG2kJscVZ%2fwGgAc2hu0bU9bQ%2bQcs%3d&risl=&pid=ImgRaw&r=0", 3.2f));
        service.create(new Star("Genta Kojima", "https://i.pinimg.com/736x/c4/df/7a/c4df7a326e40987e57fe94da70a9f349.jpg", 1f));
        service.create(new Star("Ai Haibara", "https://th.bing.com/th/id/OIP.0-UL9rX37JofuquE90BSjgHaGI?w=1084&h=898&rs=1&pid=ImgDetMain", 1.3f));
        service.create(new Star("Kaito Kid", "https://th.bing.com/th/id/OIP.6mijwznq5J6ZTOYeMwFjIgHaFH?w=882&h=610&rs=1&pid=ImgDetMain", 5f));
        service.create(new Star("Akai Shuichi", "https://animeanime.global/wp-content/uploads/2019/12/286678.jpg", 4.8f));
        service.create(new Star("Hiroshi Agasa", "https://vignette.wikia.nocookie.net/detektifconan/images/d/d5/Hiroshi_Agasa_Profile.jpg/revision/latest?cb=20180503094358&path-prefix=id", 3.8f));
        service.create(new Star("Velmont", "https://th.bing.com/th/id/OIP.nSAtMqyfob7bkKcUind2GQAAAA?rs=1&pid=ImgDetMain", 4.7f));
        service.create(new Star("Gin", "https://th.bing.com/th/id/R.60295d3ec813684a7a7047e28c38bb7d?rik=f5CPZ1d5229LRQ&riu=http%3a%2f%2fwww.detectiveconanworld.com%2fwiki%2fimages%2f8%2f82%2fGin-Middle-Appearance.png&ehk=32bSZPVTeoR2NQX7EPllcLswvJ%2bDJi0M3aM818BFPR8%3d&risl=&pid=ImgRaw&r=0", 5f));
        service.create(new Star("Tooru Amuro", "https://th.bing.com/th/id/OIP.0a9eEsCqVi__Ads9t4wYqQAAAA?rs=1&pid=ImgDetMain", 2.8f));
        service.create(new Star("Juzo Megure", "https://th.bing.com/th/id/OIP.0Z8XI9cnAuVP_dK6JMbxUwHaFj?w=600&h=450&rs=1&pid=ImgDetMain", 3.8f));
        service.create(new Star("Wataru Takagi", "https://th.bing.com/th/id/R.5aff85d3b53967a6543f6fc6b7a7f12e?rik=HKl5Cljb7y0yKg&riu=http%3a%2f%2fwww.detectiveconanworld.com%2fwiki%2fimages%2farchive%2f0%2f00%2f20180909184946!Wataru_Takagi_Profile.jpg&ehk=AWEw1I4ieaNelUSV7DesXy8kOfDF9Lz64Z4z4nDZkDQ%3d&risl=&pid=ImgRaw&r=0", 2.5f));
        service.create(new Star("Sato Miwako", "https://conanwiki.org/images/thumb/9/9d/Miwako_Sato.jpg/700px-Miwako_Sato.jpg", 3.1f));
        service.create(new Star("Jodie", "https://pm1.narvii.com/6598/7eb05a82a9105ea29a585f1495a40eef416e4c5a_hq.jpg", 3.2f));


        adapter = new StarAdapter(service.findAll(), ListActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }




    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setBackgroundResource(R.drawable.searchview_bg);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search submit
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if( adapter != null ){
                    adapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Stars";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }
}
