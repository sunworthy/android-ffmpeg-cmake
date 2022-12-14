package com.joshkryo.ffmpeg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.joshkryo.ffmpeg.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btnSelectMp4?.setOnClickListener {
            openAlbum()
        }
    }

    private fun openAlbum() {
        Toast.makeText(context, "select image", Toast.LENGTH_LONG).show()
        selectPhoto.launch("video/**")
    }

    private val selectPhoto =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            // binding.ivPhoto.setImageURI(uri)
            binding.textPathMp4.text = uri?.path
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}