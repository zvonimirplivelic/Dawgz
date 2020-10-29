package com.zvonimirplivelic.dawgz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zvonimirplivelic.dawgz.R
import com.zvonimirplivelic.dawgz.viewmodel.DogDetailViewModel
import kotlinx.android.synthetic.main.fragment_dog_detail.*

class DogDetailFragment : Fragment() {

    private lateinit var viewModel: DogDetailViewModel
    private var dogUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DogDetailViewModel::class.java)
        viewModel.fetch()

        arguments?.let {
            dogUuid = DogDetailFragmentArgs.fromBundle(it).dogUuid
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.dogLiveData.observe(viewLifecycleOwner, { dog ->
            dog?.let {
                dogName.text = dog.dogBreed
                dogPurpose.text = dog.bredFor
                dogTemperament.text = dog.temperament
                dogLifespan.text = dog.lifeSpan
            }
        })
    }
}