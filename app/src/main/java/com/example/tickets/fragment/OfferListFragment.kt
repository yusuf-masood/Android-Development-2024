package com.example.tickets.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tickets.adapter.OfferListAdapter
import com.example.tickets.databinding.FragmentOfferListBinding
import com.example.tickets.model.service.FakeService

class OfferListFragment : Fragment() {
    private var _binding: FragmentOfferListBinding? = null
    private val binding get() = _binding!!
    private val adapter = OfferListAdapter()

    companion object {
        fun newInstance() = OfferListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfferListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSorting()
        loadOffers()
    }

    private fun setupRecyclerView() {
        binding.offerList.adapter = adapter
    }

    private fun setupSorting() {
        binding.sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.sortByPrice.id -> {
                    val sortedList = FakeService.offerList.sortedBy { it.price }
                    adapter.submitList(sortedList)
                }
                binding.sortByDuration.id -> {
                    val sortedList = FakeService.offerList.sortedBy { it.flight.duration }
                    adapter.submitList(sortedList)
                }
            }
        }
    }

    private fun loadOffers() {
        adapter.submitList(FakeService.offerList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}