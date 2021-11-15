package com.example.fragment_prajna_26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_prajna_26.fragment.HomeFragment
import com.example.fragment_prajna_26.fragment.NotifikasiFragment
import com.example.fragment_prajna_26.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //di iniliasisakan dulu
        val homeFragment = HomeFragment()
        val notifikasiFragment = NotifikasiFragment()
        val profilFragment = ProfilFragment()

        //ini biar pas pertama kali dibuka yang kebuka homenya
        makeCurrentFragment(homeFragment)

        //buat bottom navigation

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homenav -> makeCurrentFragment(homeFragment)
                R.id.notif -> makeCurrentFragment(notifikasiFragment)
                R.id.profilnav -> makeCurrentFragment(profilFragment)
            }
            true

    }



    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameNav, fragment)
            commit()
        }

    }
}