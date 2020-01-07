package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.bottomSheetDialog.BottomSheetActivity
import id.co.iconpln.controlflowapp.fragmentBottomNav.BottomNavActivity
import id.co.iconpln.controlflowapp.fragmentNavDrawer.NavDrawerActivity
import id.co.iconpln.controlflowapp.fragments.DemoFragmentActivity
import id.co.iconpln.controlflowapp.hero.ListHeroActivity
import id.co.iconpln.controlflowapp.fragmentTab.TabActivity
import id.co.iconpln.controlflowapp.fragmentViewPager.ScrollActivity
import id.co.iconpln.controlflowapp.sharedPreference.SharedPreferenceActivity
import id.co.iconpln.controlflowapp.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setClickListener()
    }

    private fun setClickListener() {
        btnCalculation.setOnClickListener(this)
        btnClassification.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnOperation.setOnClickListener(this)
        btnStyle.setOnClickListener(this)
        btnActivity.setOnClickListener(this)
        btnVolumeActivity.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnConstraint.setOnClickListener(this)
        btnComplexConstraint.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)
        btnFragment.setOnClickListener(this)
        btnTab.setOnClickListener(this)
        btnBottomNav.setOnClickListener(this)
        btnNavDrawer.setOnClickListener(this)
        btnBottomSheetDemo.setOnClickListener(this)
        btnViewPager.setOnClickListener(this)
        btnLocalization.setOnClickListener(this)
        btnSharedPreference.setOnClickListener(this)
        btnWeather.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCalculation -> {
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }
            R.id.btnClassification -> {
                val classificationIntent = Intent(this, ClassificationActivity::class.java)
                startActivity(classificationIntent)
            }
            R.id.btnLogin -> {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }
            R.id.btnOperation -> {
                val operationIntent = Intent(this, OperationActivity::class.java)
                startActivity(operationIntent)
            }
            R.id.btnStyle -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }
            R.id.btnActivity -> {
                val demoIntent = Intent(this, DemoActivity::class.java)
                startActivity(demoIntent)
            }
            R.id.btnVolumeActivity -> {
                val volumeIntent = Intent(this, VolumeActivity::class.java)
                startActivity(volumeIntent)
            }
            R.id.btnIntent -> {
                val intent = Intent(this, IntentActivity::class.java)
                startActivity(intent)
            }
            R.id.btnConstraint -> {
                val constraintIntent = Intent(this, ConstraintActivity::class.java)
                startActivity(constraintIntent)
            }
            R.id.btnComplexConstraint -> {
                val complexConstraintIntent = Intent(this, ComplexConstraintActivity::class.java)
                startActivity(complexConstraintIntent)
            }
            R.id.btnRecyclerView -> {
                val listHeroIntent = Intent(this, ListHeroActivity::class.java)
                startActivity(listHeroIntent)
            }
            R.id.btnFragment -> {
                val demoFragment = Intent(this, DemoFragmentActivity::class.java)
                startActivity(demoFragment)
            }
            R.id.btnTab -> {
                val tabIntent = Intent(this, TabActivity::class.java)
                startActivity(tabIntent)
            }
            R.id.btnBottomNav -> {
                val bottomNavIntent = Intent(this, BottomNavActivity::class.java)
                startActivity(bottomNavIntent)
            }
            R.id.btnNavDrawer -> {
                val navDrawerIntent = Intent(this, NavDrawerActivity::class.java)
                startActivity(navDrawerIntent)
            }
            R.id.btnBottomSheetDemo -> {
                val bottomSheetIntent = Intent(this, BottomSheetActivity::class.java)
                startActivity(bottomSheetIntent)
            }
            R.id.btnViewPager -> {
                val viewPagerIntent = Intent(this, ScrollActivity::class.java)
                startActivity(viewPagerIntent)
            }
            R.id.btnLocalization -> {
                val localizationIntent = Intent(this, LocalizationActivity::class.java)
                startActivity(localizationIntent)
            }
            R.id.btnSharedPreference -> {
                val sharedPrefIntent = Intent(this, SharedPreferenceActivity::class.java)
                startActivity(sharedPrefIntent)
            }
            R.id.btnWeather -> {
                val weatherIntent = Intent(this, WeatherActivity::class.java)
                startActivity(weatherIntent)
            }
        }
    }
}
