package com.github.tuvy.vendingmachine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.github.tuvy.vendingmachine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.onCreate()

        setupToolbar()

        setupSample1()
        setupSample2()
        setupSample3()
        setupSample4()

        setupCoin10()
        setupCoin50()
        setupCoin100()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.logo = getDrawable(R.drawable.logo_coca_cola)
    }

    private fun setupSample1() {
        binding.sample1ImageView.setImageResource(viewModel.cocaCola.image)
        binding.sample1Button.apply {
            text = viewModel.cocaCola.priceLabel
            setOnClickListener {
                selectProduct(viewModel.cocaCola)
            }
        }
    }

    private fun setupSample2() {
        binding.sample2ImageView.setImageResource(viewModel.cocaCola.image)
        binding.sample2Button.apply {
            text = viewModel.cocaCola.priceLabel
            setOnClickListener {
                selectProduct(viewModel.cocaCola)
            }
        }
    }

    private fun setupSample3() {
        binding.sample3ImageView.setImageResource(viewModel.cocaColaPlusZero.image)
        binding.sample3Button.apply {
            text = viewModel.cocaColaPlusZero.priceLabel
            setOnClickListener {
                selectProduct(viewModel.cocaColaPlusZero)
            }
        }
    }

    private fun setupSample4() {
        binding.sample4ImageView.setImageResource(viewModel.cocaColaPlusZero.image)
        binding.sample4Button.apply {
            text = viewModel.cocaColaPlusZero.priceLabel
            setOnClickListener {
                selectProduct(viewModel.cocaColaPlusZero)
            }
        }
    }

    private fun setupCoin10() {
        binding.coin10.apply {
            text = viewModel.coin10.label
            setOnClickListener {
                updateTotalFee(viewModel.coin10.value)
            }
        }
    }

    private fun setupCoin50() {
        binding.coin50.apply {
            text = viewModel.coin50.label
            setOnClickListener {
                updateTotalFee(viewModel.coin50.value)
            }
        }
    }

    private fun setupCoin100() {
        binding.coin100.apply {
            text = viewModel.coin100.label
            setOnClickListener {
                updateTotalFee(viewModel.coin100.value)
            }
        }
    }

    private fun updateTotalFee(value: Int) {
        viewModel.updateTotalFee(value)
        binding.totalFeeTextView.text = getString(R.string.total_fee, viewModel.total)
    }

    private fun selectProduct(drink: Drink) {
        viewModel.selectProduct(drink)
        purchase()
    }

    private fun purchase() {
        if (viewModel.purchase()) {
            Toast.makeText(this, viewModel.selectedProduct.name, Toast.LENGTH_SHORT).show()
            updateTotalFee(-viewModel.selectedProduct.price)
        }
    }
}
