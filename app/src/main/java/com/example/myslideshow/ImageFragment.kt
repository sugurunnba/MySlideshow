package com.example.myslideshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myslideshow.databinding.FragmentImageBinding

private const val IMG_RES_ID = "IMG_RES_ID"

class ImageFragment : Fragment() {

//    アーギュメンツから取り出した画像のリソースIDを保持する変数
    private var imageResId: Int? = null

//    フラグメントが作成・再作成された時に呼び出すメソッド
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        アーギュメンツの中身がnullではないかを確認
        arguments?.let {
//            アーギュメンツを取り出す
            imageResId = it.getInt(IMG_RES_ID)
        }
    }


//    バインディング処理
    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    →バインディング処理


//    アーギュメンツを設定
//    companion object = javaのstaticメソッドの働きをするものを作りたい時に宣言するもの
    companion object {
//        ＠JvmStatic = javaのコードからKotlinを呼び出した時にstaticメソッドとして使用できるようになる。今回はKotlinだけ使うのでこの機能は使わないため省略可。
        @JvmStatic
        fun newInstance(imageResId: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMG_RES_ID, imageResId)
                }
            }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        imageResId?.let{
            binding.imageView.setImageResource(it)
        }
    }
}