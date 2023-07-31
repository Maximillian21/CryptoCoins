package com.maximilian.cryptocoins.presentation.detailed

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.maximilian.cryptocoins.adapters.SparklineAdapter
import com.maximilian.cryptocoins.databinding.FragmentDetailedBinding
import com.maximilian.cryptocoins.utils.DateConverter.timestampToDate
import com.maximilian.cryptocoins.utils.PriceConverter.formatCryptoPrice
import com.maximilian.cryptocoins.utils.PriceConverter.formatLargeNumber
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal

@AndroidEntryPoint
class DetailedFragment: Fragment(){
    private var _binding: FragmentDetailedBinding ?= null
    private val binding: FragmentDetailedBinding
        get() = _binding!!
    private val args: DetailedFragmentArgs by navArgs()
    private val viewModel: DetailedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.coinIcon)
            .load(args.coin.iconUrl)
            .circleCrop()
            .into(binding.coinIcon)

        bindItems()
        observeViewModel()

        if(args.coin.color != null) {
            binding.sparkview.setLineColor(Color.parseColor(args.coin.color))
        }

        viewModel.parseSparklineToFloat(args.coin.sparkline)
    }

    private fun observeViewModel() {
        viewModel.sparkData.observe(viewLifecycleOwner) {
            binding.sparkview.setAdapter(
                SparklineAdapter(it)
            )
        }
    }

    private fun bindItems() {
        binding.coinName.text = args.coin.name
        binding.coinSymbol.text = args.coin.symbol
        binding.uuid.text = args.coin.uuid
        binding.marketCap.text = args.coin.marketCap?.toLong()?.let { formatLargeNumber(it) }
        binding.price.text = formatCryptoPrice(BigDecimal(args.coin.price))
        binding.rank.text = args.coin.rank.toString()
        binding.priceToBtc.text = formatCryptoPrice(BigDecimal(args.coin.btcPrice))
        binding.listedAt.text = args.coin.listedAt?.toLong()?.let { timestampToDate(it) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}