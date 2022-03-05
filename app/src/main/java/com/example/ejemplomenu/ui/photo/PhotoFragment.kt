package com.example.ejemplomenu.ui.photo

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.ejemplomenu.R
import com.example.ejemplomenu.databinding.PhotoFragmentBinding
import com.example.ejemplomenu.ui.info.InfoFragment

class PhotoFragment : Fragment(R.layout.photo_fragment) {

    companion object {
        fun newInstance() = PhotoFragment()
    }

    private lateinit var visibleMenuItem: MenuItem

    private val viewModel: PhotoViewModel by activityViewModels()

    private var _binding: PhotoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sirve para aportar items de menú
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = PhotoFragmentBinding.bind(requireView())
        setupViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.isVisible.observe(viewLifecycleOwner){
            binding.lblPhoto.post{
                visibleMenuItem.isChecked = it
            }
        }
        viewModel.lblPhotoVisibility.observe(viewLifecycleOwner){
            binding.lblPhoto.visibility = it
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.photo_fragment, menu)
        visibleMenuItem = menu.findItem(R.id.mnuVisible)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mnuInfo -> navigateToInfo()
            R.id.mnuVisible -> viewModel.toggleVisibility()
            else -> return super.onOptionsItemSelected(item)
        }
        return true;
    }

    private fun navigateToInfo() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcContent, InfoFragment.newInstance())
            addToBackStack("")
        }
    }


    private fun setupViews() {

    }

}