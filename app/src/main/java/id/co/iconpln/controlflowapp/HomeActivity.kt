package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.MyProfile.MyProfileActivity
import id.co.iconpln.controlflowapp.bottomNav.BottomNavigationActivity
import id.co.iconpln.controlflowapp.bottomSheetDialog.BottomSheetActivity
import id.co.iconpln.controlflowapp.contact.ContactActivity
import id.co.iconpln.controlflowapp.contactFragment.ContactTabActivity
import id.co.iconpln.controlflowapp.databinding.ActivityHomeBinding
import id.co.iconpln.controlflowapp.fragmentBottomNav.BottomNavActivity
import id.co.iconpln.controlflowapp.fragmentNavDrawer.NavDrawerActivity
import id.co.iconpln.controlflowapp.fragments.DemoFragmentActivity
import id.co.iconpln.controlflowapp.hero.ListHeroActivity
import id.co.iconpln.controlflowapp.fragmentTab.TabActivity
import id.co.iconpln.controlflowapp.fragmentViewPager.ScrollActivity
import id.co.iconpln.controlflowapp.fragmentsNavComponent.HomeNavActivity
import id.co.iconpln.controlflowapp.myContact.MyContactActivity
import id.co.iconpln.controlflowapp.myUser.MyUserActivity
import id.co.iconpln.controlflowapp.restaurant.RestaurantActivity
import id.co.iconpln.controlflowapp.sharedPreference.SharedPreferenceActivity
import id.co.iconpln.controlflowapp.weather.WeatherActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding.btnCalculation.setOnClickListener(this)
        binding.btnClassification.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
        binding.btnOperation.setOnClickListener(this)
        binding.btnStyle.setOnClickListener(this)
        binding.btnActivity.setOnClickListener(this)
        binding.btnVolumeActivity.setOnClickListener(this)
        binding.btnIntent.setOnClickListener(this)
        binding.btnConstraint.setOnClickListener(this)
        binding.btnComplexConstraint.setOnClickListener(this)
        binding.btnRecyclerView.setOnClickListener(this)
        binding.btnFragment.setOnClickListener(this)
        binding.btnNavFragment.setOnClickListener(this)
        binding.btnTab.setOnClickListener(this)
        binding.btnBottomNavNew.setOnClickListener(this)
        binding.btnBottomNav.setOnClickListener(this)
        binding.btnNavDrawer.setOnClickListener(this)
        binding.btnBottomSheetDemo.setOnClickListener(this)
        binding.btnViewPager.setOnClickListener(this)
        binding.btnLocalization.setOnClickListener(this)
        binding.btnSharedPreference.setOnClickListener(this)
        binding.btnRestaurant.setOnClickListener(this)
        binding.btnWeather.setOnClickListener(this)
        binding.btnContact.setOnClickListener(this)
        binding.btnThread.setOnClickListener(this)
        binding.btnContactFragment.setOnClickListener(this)
        binding.btnMyContact.setOnClickListener(this)
        binding.btnMyUser.setOnClickListener(this)
        binding.btnMyProfile.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnCalculation -> {
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }

            binding.btnClassification -> {
                val classificationIntent = Intent(this, ClassificationActivity::class.java)
                startActivity(classificationIntent)
            }

            binding.btnLogin -> {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }

            binding.btnOperation -> {
                val operationIntent = Intent(this, OperationActivity::class.java)
                startActivity(operationIntent)
            }

            binding.btnStyle -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }

            binding.btnActivity -> {
                val demoIntent = Intent(this, DemoActivity::class.java)
                startActivity(demoIntent)
            }

            binding.btnVolumeActivity -> {
                val volumeIntent = Intent(this, VolumeActivity::class.java)
                startActivity(volumeIntent)
            }

            binding.btnIntent -> {
                val intent = Intent(this, IntentActivity::class.java)
                startActivity(intent)
            }

            binding.btnConstraint -> {
                val constraintIntent = Intent(this, ConstraintActivity::class.java)
                startActivity(constraintIntent)
            }

            binding.btnComplexConstraint -> {
                val complexConstraintIntent = Intent(this, ComplexConstraintActivity::class.java)
                startActivity(complexConstraintIntent)
            }

            binding.btnRecyclerView -> {
                val listHeroIntent = Intent(this, ListHeroActivity::class.java)
                startActivity(listHeroIntent)
            }

            binding.btnFragment -> {
                val demoFragment = Intent(this, DemoFragmentActivity::class.java)
                startActivity(demoFragment)
            }

            binding.btnNavFragment -> {
                val navFragment = Intent(this, HomeNavActivity::class.java)
                startActivity(navFragment)
            }

            binding.btnTab -> {
                val tabIntent = Intent(this, TabActivity::class.java)
                startActivity(tabIntent)
            }

            binding.btnBottomNavNew -> {
                val bottomNavNewIntent = Intent(this, BottomNavigationActivity::class.java)
                startActivity(bottomNavNewIntent)
            }

            binding.btnBottomNav -> {
                val bottomNavIntent = Intent(this, BottomNavActivity::class.java)
                startActivity(bottomNavIntent)
            }

            binding.btnNavDrawer -> {
                val navDrawerIntent = Intent(this, NavDrawerActivity::class.java)
                startActivity(navDrawerIntent)
            }

            binding.btnBottomSheetDemo -> {
                val bottomSheetIntent = Intent(this, BottomSheetActivity::class.java)
                startActivity(bottomSheetIntent)
            }

            binding.btnViewPager -> {
                val viewPagerIntent = Intent(this, ScrollActivity::class.java)
                startActivity(viewPagerIntent)
            }

            binding.btnLocalization -> {
                val localizationIntent = Intent(this, LocalizationActivity::class.java)
                startActivity(localizationIntent)
            }

            binding.btnSharedPreference -> {
                val sharedPrefIntent = Intent(this, SharedPreferenceActivity::class.java)
                startActivity(sharedPrefIntent)
            }

            binding.btnRestaurant -> {
                val restaurantIntent = Intent(this, RestaurantActivity::class.java)
                startActivity(restaurantIntent)
            }

            binding.btnWeather -> {
                val weatherIntent = Intent(this, WeatherActivity::class.java)
                startActivity(weatherIntent)
            }

            binding.btnContact -> {
                val contactIntent = Intent(this, ContactActivity::class.java)
                startActivity(contactIntent)
            }

            binding.btnThread -> {
                val backgroundThreadIntent = Intent(this, BackgroundThreadActivity::class.java)
                startActivity(backgroundThreadIntent)
            }

            binding.btnContactFragment -> {
                val contactFragmentIntent = Intent(this, ContactTabActivity::class.java)
                startActivity(contactFragmentIntent)
            }

            binding.btnMyContact -> {
                val myContactIntent = Intent(this, MyContactActivity::class.java)
                startActivity(myContactIntent)
            }

            binding.btnMyUser -> {
                val myUserIntent = Intent(this, MyUserActivity::class.java)
                startActivity(myUserIntent)
            }

            binding.btnMyProfile -> {
                val myProfileIntent = Intent(this, MyProfileActivity::class.java)
                startActivity(myProfileIntent)
            }
        }
    }
}
