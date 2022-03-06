package com.example.ejemplomenu.ui.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.ejemplomenu.R
import com.example.ejemplomenu.databinding.InfoFragmentBinding
import com.example.ejemplomenu.databinding.PhotoFragmentBinding
import com.example.ejemplomenu.ui.photo.PhotoViewModel

class InfoFragment : Fragment(R.layout.info_fragment) {

    companion object {
        fun newInstance() = InfoFragment()
    }

    private val viewModel: InfoViewModel by activityViewModels()

    private var _binding: InfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAppBar()
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.info_title)
        }
    }



}