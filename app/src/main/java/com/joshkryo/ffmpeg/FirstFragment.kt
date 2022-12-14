package com.joshkryo.ffmpeg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joshkryo.ffmpeg.adapter.FuncHolderItem
import com.joshkryo.ffmpeg.adapter.FuncListAdapter
import com.joshkryo.ffmpeg.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding.recyclerView.layoutManager = linearLayoutManager

        val mData = mutableListOf<FuncHolderItem>()
        mData.add(FuncHolderItem("Mp4 -> Gif"))

        binding.recyclerView.adapter = FuncListAdapter(
            context, mData
        ) { _: AdapterView<*>?, _: View?, position: Int, _: Long ->

            when (mData[position].funName) {
                "Mp4 -> Gif" -> {
                    val bundle = Bundle()
                    bundle.putInt("id", 1)
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )
                }
            }
        }

        binding.recyclerView.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}