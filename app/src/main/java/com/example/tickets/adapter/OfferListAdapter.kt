package com.example.tickets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tickets.R
import com.example.tickets.databinding.ItemOfferBinding
import com.example.tickets.model.entity.Offer

class OfferListAdapter : ListAdapter<Offer, OfferListAdapter.ViewHolder>(OfferDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOfferBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemOfferBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            with(binding) {
                departureTime.text = offer.flight.departureTimeInfo
                arrivalTime.text = offer.flight.arrivalTimeInfo
                route.text = "${offer.flight.departureLocation.code} - ${offer.flight.arrivalLocation.code}"
                duration.text = formatDuration(offer.flight.duration)
                direct.text = itemView.context.getString(R.string.direct)
                price.text = "${offer.price} ₸"
            }
        }

        private fun formatDuration(minutes: Int): String {
            val hours = minutes / 60
            val mins = minutes % 60
            return "${hours}ч ${mins}мин"
        }
    }

    class OfferDiffCallback : DiffUtil.ItemCallback<Offer>() {
        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem == newItem
        }
    }
}