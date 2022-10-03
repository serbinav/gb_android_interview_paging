package com.example.pagingroom

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pagingroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    Напишите приложение, которое умеет работать с бесконечным списком. В
//    качестве API используйте запросы популярных постов с
//    https://www.reddit.com/r/aww/hot.json
//    ● В приложении единственный экран, который отображает список популярных
//    постов на Реддите;
//    ● Промотка списка идет не постранично, а динамически: новые посты
//    подгружаются, пока пользователь проматывает список.
//    Выбор архитектуры и библиотек остается за вами, но желательно использовать
//    Paging 3.0, Room в связке с Paging. Room использовать как локальный кэш
//    данных.

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}