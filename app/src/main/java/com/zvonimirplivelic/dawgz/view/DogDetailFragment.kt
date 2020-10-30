package com.zvonimirplivelic.dawgz.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.zvonimirplivelic.dawgz.R
import com.zvonimirplivelic.dawgz.databinding.FragmentDogDetailBinding
import com.zvonimirplivelic.dawgz.databinding.ItemDogListBinding
import com.zvonimirplivelic.dawgz.model.DogBreed
import com.zvonimirplivelic.dawgz.model.DogPalette
import com.zvonimirplivelic.dawgz.util.getProgressDrawable
import com.zvonimirplivelic.dawgz.util.loadImage
import com.zvonimirplivelic.dawgz.viewmodel.DogDetailViewModel
import kotlinx.android.synthetic.main.fragment_dog_detail.*

class DogDetailFragment : Fragment() {

    private lateinit var viewModel: DogDetailViewModel
    private var dogUuid = 0

    private lateinit var dataBinding : FragmentDogDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate<FragmentDogDetailBinding>(
            inflater,
            R.layout.fragment_dog_detail,
            container,
            false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            dogUuid = DogDetailFragmentArgs.fromBundle(it).dogUuid
        }

        viewModel = ViewModelProviders.of(this).get(DogDetailViewModel::class.java)
        viewModel.fetch(dogUuid)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogLiveData.observe(viewLifecycleOwner, { dog ->
            dog.let { it ->
                dataBinding.dog = dog

                it.imageUrl?.let {
                    setupBackgroundColor(it)
                }
            }
        })
    }

    private fun setupBackgroundColor(url: String) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Palette.from(resource)
                        .generate {palette ->
                            val intColor = palette?.dominantSwatch?.rgb ?: 0
                            val myPalette = DogPalette(intColor)

                            dataBinding.palette = myPalette
                        }

                }
                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }
}