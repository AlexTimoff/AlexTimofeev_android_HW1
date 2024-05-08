package com.example.hw1_geekbrains_android

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hw1_geekbrains_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter=0
        binding.counterOfPassangers.text=counter.toString()
        binding.remove.isEnabled=false
        var freeSeats=getText(R.string.number_of_available_seats)


        binding.add.setOnClickListener(){
            counter++
            binding.counterOfPassangers.text=counter.toString()
            if (counter in 1..49){
                binding.remove.isEnabled = true
                binding.numberOfAvailableSeats.text="$freeSeats ${49 - counter}"
                binding.numberOfAvailableSeats.setTextColor(Color.rgb(0,0,140))
            }
            else if (counter >= 50){
                binding.reset.visibility = View.VISIBLE
                binding.reset.isEnabled = true
                binding.numberOfAvailableSeats.text=getText(R.string.too_much_passengers)
                binding.numberOfAvailableSeats.setTextColor(Color.rgb(140,0,0))
            }

        }

        binding.remove.setOnClickListener(){
            counter--
            binding.numberOfAvailableSeats.text="$freeSeats ${49 - counter}"
            binding.counterOfPassangers.text=counter.toString()
            if (counter == 0) {
                binding.remove.isEnabled = false
                binding.numberOfAvailableSeats.text = getText(R.string.all_seats_available)
                binding.numberOfAvailableSeats.setTextColor(Color.rgb(0, 140, 0))
            }
            else if (counter in 1..49) {
                binding.remove.isEnabled = true
                binding.numberOfAvailableSeats.text="$freeSeats ${49 - counter}"
                binding.numberOfAvailableSeats.setTextColor(Color.rgb(0,0,140))
            }
            else if (counter >= 50){
                binding.reset.visibility = View.VISIBLE
                binding.reset.isEnabled = true
                binding.numberOfAvailableSeats.text=getText(R.string.too_much_passengers)
                binding.numberOfAvailableSeats.setTextColor(Color.rgb(140,0,0))
            }

        }

        binding.reset.setOnClickListener{
            counter=0
            binding.counterOfPassangers.text=counter.toString()
            binding.reset.isEnabled = false
            binding.reset.visibility = View.INVISIBLE
            binding.remove.isEnabled = false
            binding.numberOfAvailableSeats.text=getText(R.string.all_seats_available)
            binding.numberOfAvailableSeats.setTextColor(Color.rgb(0, 140, 0))
        }

    }
}