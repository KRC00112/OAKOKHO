package www.oakokho.com;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import www.oakokho.com.R;
import www.oakokho.com.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new myCourseFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {


            int itemId = item.getItemId();
            if (itemId == R.id.myCourseBtn) {
                replaceFragment(new myCourseFragment());
            } else if (itemId == R.id.profileBtn) {
                replaceFragment(new ProfileFragment());
            }

            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}