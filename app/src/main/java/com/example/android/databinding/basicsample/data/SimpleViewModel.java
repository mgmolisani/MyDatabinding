package com.example.android.databinding.basicsample.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SimpleViewModel
        extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>("Grace");
    private MutableLiveData<String> lastName = new MutableLiveData<>("Hopper");
    private MutableLiveData<Integer> likes = new MutableLiveData<>(0);

    public LiveData<String> getName() {
        return name;
    }

    public LiveData<String> getLastName() {
        return lastName;
    }

    public LiveData<Integer> getLikes() {
        return likes;
    }

    public void onLike() {
        Integer prevLikes = this.likes.getValue();
        if (prevLikes != null) {
            this.likes.setValue(prevLikes + 1);
        }
    }

    public LiveData<Popularity> getPopularity() {
        return Transformations.map(this.likes,
                                   input -> {
                                       if (input > 9) return Popularity.STAR;
                                       else if (input > 4)
                                           return Popularity.POPULAR;
                                       else return Popularity.NORMAL;
                                   });
    }

    public enum Popularity {
        NORMAL, POPULAR, STAR
    }
}
