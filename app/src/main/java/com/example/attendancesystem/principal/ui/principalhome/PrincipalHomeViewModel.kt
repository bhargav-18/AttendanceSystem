package com.example.attendancesystem.principal.ui.principalhome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attendancesystem.data.entity.User
import com.example.attendancesystem.principal.repository.PrincipalRepository
import com.example.attendancesystem.utils.Events
import com.example.attendancesystem.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrincipalHomeViewModel @Inject constructor(
    private val repository: PrincipalRepository
) : ViewModel() {

    private val _userStatus = MutableLiveData<Events<Resource<User>>>()
    val userStatus: LiveData<Events<Resource<User>>> = _userStatus

    fun getUser() {
        _userStatus.postValue(Events(Resource.Loading()))

        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getUser()
            _userStatus.postValue(Events(user))
        }

    }

    private val _userDetailStatus = MutableLiveData<Events<Resource<User>>>()
    val userDetailStatus: LiveData<Events<Resource<User>>> = _userDetailStatus

    fun getUserDetails() {
        _userDetailStatus.postValue(Events(Resource.Loading()))

        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getUser()
            _userDetailStatus.postValue(Events(user))
        }

    }
}