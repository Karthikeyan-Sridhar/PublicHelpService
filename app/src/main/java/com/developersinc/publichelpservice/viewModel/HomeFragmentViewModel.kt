package com.developersinc.publichelpservice.viewModel

import android.arch.lifecycle.ViewModel
import android.view.View
import com.developersinc.publichelpservice.Interface.HomeFragmentCallbacks

class HomeFragmentViewModel(var homeFragmentCallbacks: HomeFragmentCallbacks):ViewModel() {

    fun addnewBtnClicked(view: View)
    {
        homeFragmentCallbacks.addNewSpace()
    }
    fun logoutBtn(view: View)
    {
        homeFragmentCallbacks.logout()
    }



}