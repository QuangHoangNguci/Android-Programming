package hoang.nqh19112002.soict.hust.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hoang.nqh19112002.soict.hust.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip()
    {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null){
            binding.tipResult.text = ""
            return
        }

        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercent = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> {0.15}
        }

        var tip = cost * tipPercent
        val roundUp = binding.roundUpSwitch.isChecked

        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}