package com.example.ejemplomenu.ui.photo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ejemplomenu.R
import com.example.ejemplomenu.databinding.PhotoFragmentBinding

class PhotoFragment : Fragment(R.layout.photo_fragment) {

    companion object {
        fun newInstance() = PhotoFragment()
    }

    private val viewModel: PhotoViewModel by activityViewModels()

    private var _binding: PhotoFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sirve para aportar items de menú
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = PhotoFragmentBinding.bind(requireView())
        setupViews();
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.photo_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mnuAdd -> addAlgo()
            R.id.mnuSave -> saveAlgo()
            else -> return super.onOptionsItemSelected(item)
        }
        return true;

    }

    private fun addAlgo() {
        Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()
    }

    private fun saveAlgo() {
        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
    }

    private fun setupViews() {

    }

}