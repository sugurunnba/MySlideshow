package com.example.myslideshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myslideshow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    FragmentStateAdapterを継承したMyAdapterクラスを作成する
//    FragmentStateAdapterのコンストラクタ引数にはアクティビティ(FragmentActivity)を渡す必要がある
    class MyAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){
        private val resources = listOf(
            R.drawable.slide00, R.drawable.slide01,
            R.drawable.slide02, R.drawable.slide03,
            R.drawable.slide04, R.drawable.slide05,
            R.drawable.slide06, R.drawable.slide07,
            R.drawable.slide08, R.drawable.slide09,
        )

        override fun getItemCount(): Int = resources.size

        override fun createFragment(position: Int): Fragment
                = ImageFragment.newInstance(resources[position])
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = MyAdapter(this)
    }
}