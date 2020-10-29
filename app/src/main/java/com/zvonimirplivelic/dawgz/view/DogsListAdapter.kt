package com.zvonimirplivelic.dawgz.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.zvonimirplivelic.dawgz.R
import com.zvonimirplivelic.dawgz.databinding.ItemDogListBinding
import com.zvonimirplivelic.dawgz.model.DogBreed
import com.zvonimirplivelic.dawgz.util.getProgressDrawable
import com.zvonimirplivelic.dawgz.util.loadImage
import kotlinx.android.synthetic.main.item_dog_list.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.item_dog_list, parent, false)
        val view = DataBindingUtil.inflate<ItemDogListBinding>(
            inflater,
            R.layout.item_dog_list,
            parent,
            false
        )
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogsList[position]
        holder.view.listener = this
//        holder.view.name.text = dogsList[position].dogBreed
//        holder.view.lifespan.text = dogsList[position].lifeSpan
//        0
//        holder.view.setOnClickListener {

//        }
//        holder.view.imageView.loadImage(
//            dogsList[position].imageUrl,
//            getProgressDrawable(holder.view.imageView.context)
//        )
    }

    override fun onDogClicked(v: View) {
        val uuid = v.dogId.text.toString().toInt()
        val action = DogListFragmentDirections.actionDetailFragment()
        action.dogUuid = uuid
        Navigation.findNavController(v)
            .navigate(action)
    }

    override fun getItemCount() = dogsList.size

    class DogViewHolder(var view: ItemDogListBinding) : RecyclerView.ViewHolder(view.root)
}