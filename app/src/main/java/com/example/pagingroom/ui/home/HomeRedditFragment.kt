package com.example.pagingroom.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pagingroom.databinding.FragmentHomeRedditBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeRedditFragment : Fragment() {

    private var _binding: FragmentHomeRedditBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeRedditViewModel by viewModel()
    private val adapter: RedditAdapter by lazy {
        RedditAdapter {
            Toast.makeText(requireContext(), "Open Message", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeRedditBinding.inflate(inflater, container, false)
        binding.recyclerReddit.adapter = adapter
        viewModel.getData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}