package com.maximilian.cryptocoins.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximilian.cryptocoins.data.models.Coins
import com.maximilian.cryptocoins.databinding.ItemCoinBinding
import com.maximilian.cryptocoins.utils.PriceConverter.formatCryptoPrice
import java.math.BigDecimal

class CoinsAdapter(
    private val itemCallback: (Coins) -> Unit
): RecyclerView.Adapter<CoinsViewHolder>() {

    private val coinsList: MutableList<Coins> = mutableListOf()
    private val originalCoinsList: MutableList<Coins> = mutableListOf()

    fun submitList(newList: List<Coins>) {
        coinsList.clear()
        coinsList.addAll(newList)
        notifyDataSetChanged()
    }

    fun submitOriginalList(newList: List<Coins>) {
        originalCoinsList.clear()
        originalCoinsList.addAll(newList)
    }

    fun filterList(query: String?) {
        Log.d("Adapter", query.toString())
        if (query != null) {
            val filteredList = ArrayList<Coins>()
            for(i in originalCoinsList) {
                if(i.name!!.lowercase().contains(query)) {
                    filteredList.add(i)
                }
            }
            Log.d("Adapter", filteredList.toString())
            submitList(filteredList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCoinBinding.inflate(inflater, parent, false)
        return CoinsViewHolder(binding, itemCallback)
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        holder.bindItem(coinsList[position])
    }
}

class CoinsViewHolder(
    val binding: ItemCoinBinding,
    private val itemCallback: (Coins) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: Coins

    init {
        itemView.setOnClickListener {
            itemCallback(item)
        }
    }

    fun bindItem(coin: Coins) {
        item = coin
        binding.coinName.text = coin.name
        binding.coinPrice.text = formatCryptoPrice(BigDecimal(coin.price))
        Glide.with(binding.coinIcon)
            .load(coin.iconUrl)
            .circleCrop()
            .into(binding.coinIcon)


    }

}