package com.example.graduiation.ui.StoryDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.graduiation.ui.Data.FirebaseQueryHelper;
import com.example.graduiation.ui.Data.FoodModel;
import com.example.graduiation.ui.Data.UserParentModel;

import java.util.ArrayList;

public class StoryDetailsViewModel extends ViewModel {

    private String uid, category;
    private FirebaseQueryHelper firebaseQueryHelper;
    private MutableLiveData<UserParentModel> userParentModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<ArrayList<FoodModel>> listMutableLiveData= new MutableLiveData<>();
    private MutableLiveData<Boolean> mutableFlag=new MutableLiveData<>();
    public void setCategoryAndId(String uid, String category) {
        this.uid = uid;
        this.category = category;
        firebaseQueryHelper = new FirebaseQueryHelper();

    }

    public MutableLiveData<ArrayList<FoodModel>> getListMutableLiveData() {
        FirebaseQueryHelper.getListOfFood(listMutableLiveData,uid,category);
        return listMutableLiveData;
    }

    public MutableLiveData<UserParentModel> getUserParentModelMutableLiveData() {
        firebaseQueryHelper.getSingleUserData(userParentModelMutableLiveData,uid);
        return userParentModelMutableLiveData;
    }

    public MutableLiveData<Boolean> isFollowed(String myId , String userId ){
         firebaseQueryHelper.isFollowed(myId,userId,mutableFlag);
        return mutableFlag;
    }

    public void follow(String myId , String userId ){
        firebaseQueryHelper.follow( myId ,  userId );
    }

    public void unFollow(String myId , String userId ){
        firebaseQueryHelper.unFollow( myId ,  userId );
    }


}
