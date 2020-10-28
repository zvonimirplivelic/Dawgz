package com.zvonimirplivelic.dawgz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.zvonimirplivelic.dawgz.R
import kotlinx.android.synthetic.main.fragment_dog_list.*

class DogListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonDetails.setOnClickListener{
            val action = DogListFragmentDirections.actionDetailFragment()
            action.dogUuid = 5
            Navigation.findNavController(it).navigate(action)
        }
    }
}