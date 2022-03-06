package com.example.ejemplomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.ejemplomenu.R
import com.example.ejemplomenu.databinding.MainActivityBinding
import com.example.ejemplomenu.ui.photo.PhotoFragment

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAppBar()
        if (savedInstanceState == null){
            navigateToInitialDestination()
        }
    }

    private fun navigateToInitialDestination() {
        supportFragmentManager.commit {
            replace(R.id.fcContent, PhotoFragment.newInstance())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mnuSettings -> navigateToSettings()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun navigateToSettings() {
        Toast.makeText(this, "Navegar a Settings", Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAppBar() {
        setSupportActionBar(binding.toolbar)
    }
}