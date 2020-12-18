package com.jsv.dogapputilkotlin.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jsv.dogapputilkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawer: DrawerLayout
    private lateinit var barTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawer = findViewById(R.id.drawer_layout)
        barTitle = findViewById(R.id.bar_title)

        findViewById<ImageView>(R.id.ham_menu).setOnClickListener {
            mDrawer.openDrawer(GravityCompat.START)
        }

        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(nav, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            barTitle.text = destination.label
        }
    }
}