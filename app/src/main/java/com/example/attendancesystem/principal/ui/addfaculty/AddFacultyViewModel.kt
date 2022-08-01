package com.example.attendancesystem.principal.ui.addfaculty

import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attendancesystem.authorization.repository.AuthRepository
import com.example.attendancesystem.data.entity.User
import com.example.attendancesystem.principal.repository.PrincipalRepository
import com.example.attendancesystem.utils.BitmapUtils
import com.example.attendancesystem.utils.Events
import com.example.attendancesystem.utils.Resource
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFacultyViewModel @Inject constructor(
    private val context: Context,
    private val repository: PrincipalRepository
) : ViewModel() {

    private val _registerStatus = MutableLiveData<Events<Resource<User>>>()
    val registerStatus: LiveData<Events<Resource<User>>> = _registerStatus

    private val _curImageUri = MutableLiveData<Uri>()
    val curImageUri: LiveData<Uri> = _curImageUri

    fun setCurrentImageUri(uri: Uri) {
        _curImageUri.postValue(uri)
    }

    fun removeObservers() {
        _registerStatus.value = null
        _registerStatus.postValue(null)
    }

    fun register(
        email: String,
        phone: String,
        name: String,
        enrolNo: String
    ) {
        val error = if (email.isEmpty()) {
            "emptyEmail"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            "email"
        } else if (phone.isEmpty()) {
            "emptyPhone"
        } else if (!Patterns.PHONE.matcher(phone).matches()) {
            "phone"
        } else if (name.isEmpty()) {
            "name"
        } else if (enrolNo.isEmpty()) {
            "emptyEnrol"
        } else if (enrolNo.contains(" ")) {
            "enrol"
        } else if (curImageUri.value == Uri.EMPTY || curImageUri.value == null) {
            "uri"
        } else null

        error?.let {
            _registerStatus.postValue(Events(Resource.Error(error)))
            return
        }

        _registerStatus.postValue(Events(Resource.Loading()))

        val bitmap = BitmapUtils.getBitmapFromUri(context.contentResolver, curImageUri.value!!)

        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.addFaculty(
                context = context,
                profilePicUrl = curImageUri.value!!,
                bitmap = bitmap,
                email = email,
                phone = phone,
                name = name,
                enrolNo = enrolNo
            )
            _registerStatus.postValue(Events(result))
        }
    }

}